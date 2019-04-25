package memberDB;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberDB/memberProcServlet")
public class MemberProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String message = "", name = "", address = "", password = "";
		int id = 0, birth = 0;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		MemberDTO member = null;
		MemberDAO mDao = new MemberDAO();
		RequestDispatcher rd = null;
		List<MemberDTO> memberlist = null;
		
		switch(action) {
			///////////////////////////////////////////////////////////////////////////////
		case "login":	// 로그인
			if (!request.getParameter("id").equals(""))
				id = Integer.parseInt(request.getParameter("id").trim());
			password = request.getParameter("password");
			int result = mDao.verifyLogin(id, password);
			String errorMessage = null;
			
			switch (result) {
			case MemberDAO.ID_PASSWORD_MATCH:
				errorMessage = "";
				break;
			case MemberDAO.ID_DOES_NOT_EXIST:
				errorMessage = "없는 아이디";
				break;
			case MemberDAO.PASSWORD_IS_WRONG:
				errorMessage = "패스워드 오류";
				break;
			case MemberDAO.DATABASE_ERROR:
				errorMessage = "DB 오류";
				break;
			default:
				errorMessage = "";
			}
			
			if (result == MemberDAO.ID_PASSWORD_MATCH) {
				member = mDao.selectOne(id);
				session.setAttribute("memberId", id);
				session.setAttribute("memberName", member.getMemberName());
							
				mDao = new MemberDAO();
				memberlist = mDao.selectMembersAll();
				request.setAttribute("memberlist", memberlist);
				
				rd = request.getRequestDispatcher("loginMain.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", errorMessage);
				request.setAttribute("url", "login.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
			}
			
			break;
			///////////////////////////////////////////////////////////////////////////////
		case "goBackloginMain": 	// 글 게시판에서 회원 명단 화면으로 되돌아오기 

			member = mDao.selectOne(id);
						
			mDao = new MemberDAO();
			memberlist = mDao.selectMembersAll();
			request.setAttribute("memberlist", memberlist);
			
			rd = request.getRequestDispatcher("loginMain.jsp");
			rd.forward(request, response);
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "logout":	// 로그아웃
			session.removeAttribute("memberId");
			session.removeAttribute("memberName");
			response.sendRedirect("login.jsp");			
			break;
		
			///////////////////////////////////////////////////////////////////////////////
		case "register":	// 회원 가입
			password = request.getParameter("memberPassword");
			name = request.getParameter("memberName");
			String strBirth = request.getParameter("memberBirth");
			birth = Integer.parseInt(strBirth);
			address = request.getParameter("memberAddress");
			
			mDao.insertMember(new MemberDTO(password, name, birth, address));
			mDao.close();	
			
			message = "회원 가입 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "login.jsp");
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "update":	// 수정 버튼 클릭
			if (!request.getParameter("id").equals(""))
				id = Integer.parseInt(request.getParameter("id").trim());
			
			if(id != (Integer) session.getAttribute("memberId")) {
				message = "본인 계정이 아닙니다.";
				request.setAttribute("message", message);
				request.setAttribute("url", "loginMain.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			}
			
			member = mDao.selectOne(id);
			mDao.close();			
			
			request.setAttribute("member", member);
			rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
					
			System.out.println(action + " id " + id + " 완료");
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "execute":	// 수정 후 완료 버튼
			
			if (!request.getParameter("id").equals(""))
				id = Integer.parseInt(request.getParameter("id").trim());

			name = request.getParameter("name");
			birth = Integer.parseInt(request.getParameter("birth").trim());
			address = request.getParameter("address");
			
			member = new MemberDTO(id, "*", name, birth, address);
			request.setAttribute("member", member);
			System.out.println(member.toString());
			
			mDao.updateMember(member);
	
			mDao = new MemberDAO();
			memberlist = mDao.selectMembersAll();
			request.setAttribute("memberlist", memberlist);
					
			rd = request.getRequestDispatcher("loginMain.jsp");
			rd.forward(request, response);			
			
//			mDao.close();
//			
//			message = "아래와 같이 수정됨\\n" + member.toString();
//			request.setAttribute("message", message);
//			request.setAttribute("url", "loginMain.jsp");
//			rd = request.getRequestDispatcher("alertMsg.jsp");
//			rd.forward(request, response);
//			
//			response.sendRedirect("loginMain.jsp");
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "delete":	// 삭제 버튼 클릭
			if (!request.getParameter("id").equals(""))
				id = Integer.parseInt(request.getParameter("id").trim());
			
			if(id != (Integer) session.getAttribute("memberId")) {
				message = "본인 계정이 아닙니다.";
				request.setAttribute("message", message);
				request.setAttribute("url", "loginMain.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			}
			
			mDao.deleteMember(id);
			mDao.close();
			
			mDao = new MemberDAO();
			memberlist = mDao.selectMembersAll();
			request.setAttribute("memberlist", memberlist);
			
			rd = request.getRequestDispatcher("loginMain.jsp");
			rd.forward(request, response);
			
//			message = "id = " + id + " 삭제 완료";
//			String url = "loginMain.jsp";
//			request.setAttribute("message", message);
//			request.setAttribute("url", url);
//			
//			rd = request.getRequestDispatcher("alertMsg.jsp");
//			rd.forward(request, response);
//			
//			System.out.println(action + " id " + id + " 완료");
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "tweet":	// 트윗

			message = request.getParameter("msg");
			String username = (String) session.getAttribute("memberName");
			ServletContext application = request.getServletContext();

			// 메시지 저장을 위해 application 에서 msgs 로 저장된 ArrayList 가지고 옴
			List<String> msgs = (ArrayList<String>) application.getAttribute("msgs");

			// null 인 경우 새로운 ArrayList 객체를 생성
			if (msgs == null) {
				msgs = new ArrayList<String>();
				// application 에 ArrayList 저장
				application.setAttribute("msgs", msgs);
			}

			// 사용자 이름, 메시지, 날짜 정보를 포함하여 ArrayList에 추가
			Date date = new Date();
			SimpleDateFormat f = new SimpleDateFormat("MM월 dd일(E) HH:mm", Locale.KOREA);
			msgs.add(username + " :: " + message + "  [" + f.format(date) + "]");

			// 톰캣 콘솔을 통한 로깅
			application.log(message + ", " + username);

			// 목록 화면으로 리다이렉팅
			response.sendRedirect("twitter_list.jsp");

			break;
		default:
			
		}
	
	}

}

package memberDB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
				errorMessage = null;
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
			}
			
			if (result == MemberDAO.ID_PASSWORD_MATCH) {
				member = mDao.selectOne(id);
				session.setAttribute("memberId", id);
				session.setAttribute("memberName", member.getMemberName());
				response.sendRedirect("loginMain.jsp");
			} else {
				// 방법 1 - 상대방이 getParameter("error")로 받을 때
				String url = "login.jsp?error=" + errorMessage;
				rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				
				// 방법 2 - 상대방이 getAttribute("error")로 받을 때
//				request.setAttribute("error", errorMessage);
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//				rd.forward(request, response);
			}
			
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
			System.out.println(member.toString());
			
			mDao.updateMember(member);
			mDao.close();
			
			message = "아래와 같이 수정됨\\n" + member.toString();
			request.setAttribute("message", message);
			request.setAttribute("url", "loginMain.jsp");
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			response.sendRedirect("loginMain.jsp");
			
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
			
			message = "id = " + id + " 삭제 완료";
			String url = "loginMain.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			System.out.println(action + " id " + id + " 완료");
			break;
			
		default:
			
		}
	
	}

}

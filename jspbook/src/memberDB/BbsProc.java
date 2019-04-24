package memberDB;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberDB/bbsProcServlet")
public class BbsProc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public BbsProc() {
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
		String message = "", title = "", context = "", mWritterName = "";
		int mId = 0, bId = 0, mWritterId = 0;
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		BbsDTO bbs = null;
		BbsDAO bDao = new BbsDAO();
		RequestDispatcher rd = null;

		switch (action) {
			///////////////////////////////////////////////////////////////////////////////
		case "update":	// 게시글 수정
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());
			
			if(mId != (Integer) session.getAttribute("memberId")) {
				message = "본인이 작성한 글이 아닙니다.";
				request.setAttribute("message", message);
				request.setAttribute("url", "bbs_list.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			}
			
			bbs = bDao.selectOne(bId);
			bDao.close();	
			
			request.setAttribute("bbs", bbs);
			rd = request.getRequestDispatcher("updateBbs.jsp");
			rd.forward(request, response);
					
			System.out.println(action + " 완료");
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "delete":	// 게시글 삭제
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());
			
			if(mId != (Integer) session.getAttribute("memberId")) {
				message = "본인이 작성한 글이 아닙니다.";
				request.setAttribute("message", message);
				request.setAttribute("url", "bbs_list.jsp");
				rd = request.getRequestDispatcher("alertMsg.jsp");
				rd.forward(request, response);
				break;
			}
			
			bDao.deleteBbs(bId, mId);
			bDao.close();
			
			message = "bId = " + bId + " 삭제 완료";
			String url = "bbs_list.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			System.out.println(action + " 완료");

			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "execute":	// 게시글 수정 완료 버튼 클릭
			
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());

			title = request.getParameter("title");
			context = request.getParameter("context");
			
			bbs = new BbsDTO(bId, title, context);
			System.out.println(bbs.toString());
			
			bDao.updateBbs(bbs, mId, bId);
			bDao.close();
			
			message = "수정 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "bbs_list.jsp");
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			response.sendRedirect("loginMain.jsp");
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "register":	// 새로운 글 작성
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			
			//request.setAttribute("bbs", bbs);
			session.setAttribute("memberId", mId);
			response.sendRedirect("bbs_register.jsp");
			//rd = request.getRequestDispatcher("bbs_register.jsp");
			//rd.forward(request, response);
			
			break;
			
			///////////////////////////////////////////////////////////////////////////////
		case "registerBtn":	// 새로운 글 작성 완료 버튼 클릭
			if (!request.getParameter("mId").equals(""))
				mId = Integer.parseInt(request.getParameter("mId").trim());
			
			title = request.getParameter("bbsTitle");
			context = request.getParameter("bbsContext");
			
			bDao.insertBbs(new BbsDTO(mId, title, context), mId);
			bDao.close();	
			
			message = "글 작성 완료";
			request.setAttribute("message", message);
			request.setAttribute("url", "bbs_list.jsp");
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			break;
			
				///////////////////////////////////////////////////////////////////////////////
			case "detail":	// 글 제목 클릭 - 상세보기 화면으로 전환
			if (!request.getParameter("mId").equals(""))
				mWritterId = Integer.parseInt(request.getParameter("mId").trim());
			if (!request.getParameter("bId").equals(""))
				bId = Integer.parseInt(request.getParameter("bId").trim());
			if (!request.getParameter("mName").equals(""))
				mWritterName = (String) request.getParameter("mName").trim();
			
			//System.out.println(mWritterName);
			session.setAttribute("bId", bId);
			session.setAttribute("mWritterId", mWritterId);
			session.setAttribute("mWritterName", mWritterName);
			response.sendRedirect("bbs_list_content.jsp");
			
			break;

		default:

		}
	}
}

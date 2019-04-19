package memberDB;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberDB/memberProcServlet")
public class MemberProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String strId = request.getParameter("id");
		MemberDAO mDao = new MemberDAO();
		RequestDispatcher rd = null;
		
		switch(action) {
		case "update":
			MemberDTO member = mDao.selectOne(Integer.parseInt(strId));
			mDao.close();	
			
			request.setAttribute("member", member);
			rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
					
			System.out.println(action + " id " + strId + " 완료");
			break;
		case "delete":
			mDao.deleteMember(Integer.parseInt(strId));
			mDao.close();
			
			String message = "id = " + strId + " 삭제 완료";
			String url = "loginMain.jsp";
			request.setAttribute("message", message);
			request.setAttribute("url", url);
			
			rd = request.getRequestDispatcher("alertMsg.jsp");
			rd.forward(request, response);
			
			System.out.println(action + " id " + strId + " 완료");
			break;
		default:
			
		}
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

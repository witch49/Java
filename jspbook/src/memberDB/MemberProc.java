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
		
		switch(action) {
		case "update":
			MemberDAO mDao = new MemberDAO();
			MemberDTO member = mDao.selectOne(Integer.parseInt(strId));
			
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
			mDao.close();			
			System.out.println(action + " " + strId + " 완료");
			break;
		case "delete":
			System.out.println(action + " " + strId + " 완료");
			break;
		default:
			
		}
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

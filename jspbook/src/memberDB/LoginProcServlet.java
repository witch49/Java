package memberDB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberDB/loginProcServlet")
public class LoginProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginProcServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDAO mDao = new MemberDAO();
		String strId = request.getParameter("id");
		int id = 0;
		if (strId.matches("\\d+"))
			id = Integer.parseInt(strId);
		String password = request.getParameter("password");
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
		mDao.close();
		
		if (result == MemberDAO.ID_PASSWORD_MATCH) {
			response.sendRedirect("loginMain.jsp");
		} else {
			// 방법 1 - 상대방이 getParameter("error")로 받을 때
			String url = "login.jsp?error=" + errorMessage;
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
			// 방법 2 - 상대방이 getAttribute("error")로 받을 때
//			request.setAttribute("error", errorMessage);
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.forward(request, response);
			
		}
	}

}

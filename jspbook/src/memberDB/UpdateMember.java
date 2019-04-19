package memberDB;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberDB/UpdateMemberServlet")
public class UpdateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name");
		int birth = Integer.parseInt(request.getParameter("birth").trim());
		String address = request.getParameter("address");
		
		MemberDTO member = new MemberDTO(id, "*", name, birth, address);
		System.out.println(member.toString());
		
		MemberDAO mDao = new MemberDAO();
		mDao.updateMember(member);
		mDao.close();
		
		String message = "아래와 같이 수정됨\\n" + member.toString();
		request.setAttribute("message", message);
		request.setAttribute("url", "loginMain.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("alertMsg.jsp");
		rd.forward(request, response);
		
		response.sendRedirect("loginMain.jsp");
	}

}

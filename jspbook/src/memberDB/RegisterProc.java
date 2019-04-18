package memberDB;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberDB/registerProcServlet")
public class RegisterProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterProc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("memberPassword");
		String name = request.getParameter("memberName");
		String strBirth = request.getParameter("memberBirth");
		int birth = Integer.parseInt(strBirth);
		String address = request.getParameter("memberAddress");
		
		MemberDAO mDao = new MemberDAO();
		mDao.insertMember(new MemberDTO(password, name, birth, address));
		mDao.close();	
		
	}

}

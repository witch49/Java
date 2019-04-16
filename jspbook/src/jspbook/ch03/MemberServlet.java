package jspbook.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/ch03/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNo = request.getParameter("phoneNo");

		Member2 member = new Member2();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=\"text/css\">");
		out.println("body{text-align:center;}");
		out.println("table{border:1px solid black; padding:10px; border-collapse:collapse; text-align:center; margin:auto;}");
		out.println("tr,td{border:1px solid black;}</style>");
		out.println("<title>회원정보</title></head>");
		out.println("<body>");
		out.println("<h3>회원 상세보기</h3>");
		out.println("<hr>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>아이디</td><td>이름</td><td>이메일</td><td>전화번호</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+member.createId(name, email, phoneNo)+"</td>");
		out.println("<td>"+name+"</td>");
		out.println("<td>"+email+"</td>");
		out.println("<td>"+phoneNo+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

}

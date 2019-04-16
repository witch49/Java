package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ch04/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 응답 시 전달될 컨텐츠에 대한 mime type과 charset 지정
		response.setContentType("text/html;charset=UTF-8");

		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		
		// html 폼을 통해 전달된 num1, num2 매개변수 값을 변수에 할당
		int scoreKor = Integer.parseInt(request.getParameter("scoreKor"));
		int scoreEng = Integer.parseInt(request.getParameter("scoreEng"));
		int scoreMath = Integer.parseInt(request.getParameter("scoreMath"));
		
		Score score = new Score();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=\"text/css\">");
		out.println("body{text-align:center;}");
		out.println("table{border:1px solid black; padding:10px; border-collapse:collapse; text-align:center; margin:auto;}");
		out.println("tr,td{border:1px solid black;}</style>");
		out.println("<title>성적</title></head>");
		out.println("<body>");
		out.println("<h3>성적 정보</h3>");
		out.println("<hr>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>국어</td><td>영어</td><td>수학</td><td>합계</td><td>평균</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+scoreKor+"</td>");
		out.println("<td>"+scoreEng+"</td>");
		out.println("<td>"+scoreMath+"</td>");
		out.println("<td>"+score.calcSum(scoreKor, scoreEng, scoreMath)+"</td>");
		out.println("<td>"+score.calcAvg(scoreKor, scoreEng, scoreMath)+"</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

	}

}

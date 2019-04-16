package jspbook.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/ch04/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Get 요청 처리 메소드
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost()로 포워딩
		doPost(request, response);
	}

	/**
	 * Post 요청 처리 메소드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1, num2;
		int result;
		String op;
		
		// 클라이언트 응답 시 전달될 컨텐츠에 대한 mime type과 charset 지정
		response.setContentType("text/html;charset=UTF-8");
		
		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		
		// html 폼을 통해 전달된 num1, num2 매개변수 값을 변수에 할당
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
		
		// 메소드 호출해 결과 받아오기
		Calc calculate = new Calc();
		result = calculate.calc(num1, num2, op);
		
		// 출력 스트림을 통해 화면 구성
		out.println("<html>");
		out.println("<head><title>계산기</title></head>");
		out.println("<body><center>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
		out.println(num1 + " " + op + " " + num2 + " = " + result);
		out.println("</body>");
		out.println("</html>");
	}
	
}

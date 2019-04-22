<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request test result</title>
</head>
<body>
<center>
	<h2>request test result 1</h2>
	<hr>
	<table border="1" cellspacing="1" cellpadding="5">
		<tr>
			<td>이름</td>
			<td><%= request.getParameter("username") %></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%= request.getParameter("job") %></td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td>
			<% String favorites[] = request.getParameterValues("favorite");
				for(String favorite : favorites)
					out.println(favorite + "<br>");
			%>
			</td>
		</tr>
	</table>
	<hr>
	<h2>request test result 2</h2>
	<table border="0">
		<tr>
			<td>
			1. 클라이언트 IP 주소 : <%= request.getRemoteAddr() %><br>
			2. 요청 메소드 : <%= request.getMethod() %><br>
			<% Cookie cookie[] = request.getCookies(); %>
			3. <%= cookie[0].getName() %>에 설정된 쿠키 값 : <%= cookie[0].getValue() %><br>
			4. 프로토콜 : <%= request.getProtocol() %>
			</td>
		</tr>
	</table>
	
</center>
</body>
</html>
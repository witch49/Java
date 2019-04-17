<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// request.setCharacterEncoding("UTF-8");
	String error = request.getParameter("error");
	System.out.println(error);
	if (error != null)
		out.println("<script>alert('" + error + "')</script>");
%>
	<center>
		<h2>Member Login</h2>
		<hr>
	<form name="loginForm" action="/jspbook/memberDB/loginProc.jsp" method="post">
		<label><span>ID:</span>
			<input type="text" name="id" size="10">
		</label>
		<label><span>Password:</span>
			<input type="password" name="password" size="10">
		</label>
		<br><br>
		<label>
			<input type="submit" value="로그인" name="B1">&nbsp;&nbsp;
			<button onclick="location.href='loginRegister.html'">회원 가입</button>
			<!-- <input type="reset" value="회원 가입" name="B2"> -->
		</label>
	</form>
	</center>
</body>
</html>
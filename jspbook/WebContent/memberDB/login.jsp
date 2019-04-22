<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<style>
input[type=text] { /* text 창에만 적용 */
	color: red;
}

input:hover, textarea:hover { /* 마우스 올라 올 때 */
	background: aliceblue;
}

label {
	display: block; /* 새 라인에서 시작 */
	padding: 5px;
}

label span {
	display: inline-block;
	width: 90px;
	text-align: right;
	padding: 10px;
}
</style>
</head>
<body>
<%
	// request.setCharacterEncoding("UTF-8");
	String error = (String) request.getParameter("error");
	if (error != null) {
		System.out.println(error);
		out.println("<script>alert('" + error + "')</script>");
	}
%>
	<div align="center">
		<h2>Member Login</h2>
		<hr>
	<form name="loginForm" action="/jspbook/memberDB/memberProcServlet?action=login" method="post">
		<label><span>ID:</span>
			<input type="text" name="id" size="10">
		</label>
		<label><span>Password:</span>
			<input type="password" name="password" size="10">
		</label>
		<br>
		<label>
			<input type="submit" value="로그인" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2">
		</label>
	</form>
	<br>
	<button onclick="location.href='loginRegister.html'">회원 가입</button>
	</div>
</body>
</html>
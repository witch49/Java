<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<!-- 표현식 -->
	<%= "안녕하세요?" %><br>
	<!-- 스크립트릿 표시 -->
	<% out.println("안녕하세요?"); %><br>
	<!--  -->
	${"안녕하세요?"}<br> --%>
	
	<!-- <form method="get" action="add07.jsp"> -->
	<form method="get" action="AdditionServlet">
		숫자1 : <input type="text" name="num1" /><br>
		숫자2 : <input type="text" name="num2" /><br>
		<input type="submit" value="전송" />
	</form>
</body>
</html>
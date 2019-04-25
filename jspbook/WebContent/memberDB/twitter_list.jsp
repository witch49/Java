<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twitter</title>
</head>
<body>
<div align="center">
	<h2>My Simple Twitter</h2>
	<a href="/jspbook/memberDB/memberProcServlet?action=goBackloginMain">회원 목록으로</a>
	<hr>
	<!-- <form action="/jspbook/memberDB/TwitterProc" method="post"> -->
	<form action="/jspbook/memberDB/memberProcServlet?action=tweet" method="post">
		<!-- session에 저장된 이름 출력 -->
		@${memberName}&nbsp;
		<input type="text" name="msg" size="40">&nbsp;
		<input type="submit" value="Tweet">
	</form>
	<hr>
</div>
<div align="left">
	<ul>
	<!-- application 내장 객체를 통해 msgs 이름으로 저장된 Arraylist를 가지고 옴 -->
	<c:set var="msgs" value="${applicationScope.msgs}" />
	<!-- msgs가 null이 아닌 경우에만 목록 출력 -->
	<c:if test="${not empty msgs}">
		<c:forEach var="msg" items="${msgs}">
			<li>${msg}</li>
		</c:forEach>
	
	</c:if>
	</ul>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginMain</title>
</head>
<body>
<div align="center">
	<hr>
	현재 접속중인 고객ID: ${ sessionScope.memberId } / 이름: ${ sessionScope.memberName }<br>
	<a href="/jspbook/memberDB/bbsProcServlet?action=gotoBbsList&page=1">게시판</a>&nbsp;&nbsp;
	<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
	<a href="/jspbook/memberDB/memberProcServlet?action=logout">로그아웃</a>
	<hr>

	<h3>회원 명단</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="lightskyblue">
		<th width="80">아이디</th>
		<th width="80">이름</th>
		<th width="80">생년월일</th>
		<th width="300">주소</th>
		<th colspan=2 width="100">액션</th>
	</tr>
	<c:set var="memberlist" value="${requestScope.memberlist}"/>
	<c:forEach var="m" items="${memberlist}">
		<tr>
			<td>${m.memberId}</td>
			<td>${m.memberName}</td>
			<td>${m.memberBirth}</td>
			<td>${m.memberAddress}</td>
			<td><button onclick="location.href='memberProcServlet?action=update&id=${m.memberId}'">수정</button></td>
			<td><button onclick="location.href='memberProcServlet?action=delete&id=${m.memberId}'">삭제</button></td>
		</tr>
	</c:forEach>
	</table>	
</div>
</body>
</html>
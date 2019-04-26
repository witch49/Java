<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsList</title>
</head>
<body>
<div align="center">
<hr>
	현재 접속중인 고객ID: ${ sessionScope.memberId } / 이름: ${ sessionScope.memberName }<br>
	<a href="/jspbook/memberDB/memberProcServlet?action=goBackloginMain">회원 명단</a>&nbsp;&nbsp;
	<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
	<a href="/jspbook/memberDB/memberProcServlet?action=logout">로그아웃</a>
	<hr>
	
	<h3>게시판</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="pink">
		<th width="40">번호</th>
		<th width="80">회원ID</th>
		<th width="300">제목</th>
		<th width="200">작성/수정일</th>
	</tr>
		
	<c:if test="${ requestScope.curPageNo != null }">   <%-- 페이지 번호가 있을 경우 --%>
		<c:set var="curPageNo" value="${ requestScope.curPageNo }"/>
	</c:if>
	
	<c:set var="bbslist" value="${ requestScope.bbsPostList }"/>
	<c:forEach var="b" items="${ bbslist }">
		<tr>
		<td>${ b.bbsId }</td>
		<td>${ b.bbsMemberId }</td>
		<c:set var="urlDetail" value="/jspbook/memberDB/bbsProcServlet?action=detail&mId=${ b.bbsMemberId }&bId=${ b.bbsId }"/>
		<td><a href="${ urlDetail }">${ b.bbsTitle }</a></td>
		<td>${ b.bbsDate }</td>
		</tr>	
	</c:forEach>
	</table>
	
	<c:set var="pageList" value="${requestScope.pageList}"/>
	<c:forEach var="pageNo" items="${pageList}">
		${pageNo}
	</c:forEach>
	<br>
	
	<button onclick="location.href='bbsProcServlet?action=register&mId=${ sessionScope.memberId }'" style="float:right; margin-right:5em;">
	글 작성</button><br>
	<p style="float:right; margin-right:5em;"><a href="fileServlet?action=bbs">download</a></p>

</div>
</body>
</html>
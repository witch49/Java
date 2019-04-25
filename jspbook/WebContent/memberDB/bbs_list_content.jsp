<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세화면</title>
<style>
td {
	width:500px;
	text-align:left;
}
</style>
</head>
<body>
<div align="center">
	<h3>게시판</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
		<tr>
			<th width="150" bgcolor="pink">글 번호</th>
			<td>&nbsp;${requestScope.bId}</td>
		</tr>
		<tr>
			<th bgcolor="pink">작성자(회원ID)</th>
			<td>&nbsp;${requestScope.mWritterName}(${requestScope.mWritterId})</td>
		</tr>
		<tr>
			<th bgcolor="pink">제목</th>
			<td>&nbsp;
				<c:set var="bbslist" value="${ requestScope.bbslist }"/>
				<c:forEach var="b" items="${bbslist}">
					<c:if test="${b.bbsId == requestScope.bId}">
						${b.bbsTitle}
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th bgcolor="pink" style="height:200px">내용</th>
			<td>
			<c:forEach var="b" items="${bbslist}">
				<c:if test="${b.bbsId == requestScope.bId}">
					${b.bbsContent}
				</c:if>
			</c:forEach>
			<%-- b.getBbsContent().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;") --%>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<a href="/jspbook/memberDB/bbsProcServlet?action=gotoBbsList&page=${currentBbsPage}">이전화면</a>&nbsp;&nbsp;
				<c:if test="${mWritterId.equals(memberId)}">
					<button onclick="location.href='bbsProcServlet?action=update&mId=${ requestScope.mWritterId }&bId=${ requestScope.bId }'">수정</button>&nbsp;&nbsp;
					<button onclick="location.href='bbsProcServlet?action=delete&mId=${ requestScope.mWritterId }&bId=${ requestScope.bId }&page=${currentBbsPage}'">삭제</button>
				</c:if>
			</td>
		</tr>
	</table>

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="memberDB.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	BbsDAO bDao = new BbsDAO();
	List<BbsDTO> bbslist = bDao.selectPostsAll();
	bDao.close();	
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
	현재 접속중인 고객ID: <%= session.getAttribute("memberId") %> / 이름: <%= session.getAttribute("memberName") %><br>
	<a href="loginMain.jsp">회원 명단</a>&nbsp;&nbsp;
	<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
	<a href="/jspbook/memberDB/memberProcServlet?action=logout">로그아웃</a>
	<hr>
	
	<h3>게시판</h3>
	<%	String dd = "bbsProcServlet?action=register&mId=" +session.getAttribute("memberId"); %>
	<button onclick="location.href='<%=dd%>'" style="float:right">글 작성</button><br>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="pink">
		<th width="40">번호</th>
		<th width="80">회원ID</th>
		<th width="200">글제목</th>
		<th width="500">글내용</th>
		<th width="200">작성일</th>
		<th colspan=2 width="100">액션</th>
	</tr>
	
	
	<% for(BbsDTO b : bbslist) { %>
	<tr>
		<td><%= b.getBbsId() %></td>
		<td><%= b.getBbsMemberId() %></td>
		<td><%= b.getBbsTitle() %></td>
		<td><%= b.getBbsContent() %></td>
		<td><%= b.getBbsDate() %></td>
		<%	String urlUp = "bbsProcServlet?action=update&mId=" + b.getBbsMemberId() + "&bId=" + b.getBbsId(); 
			String urlDel = "bbsProcServlet?action=delete&mId=" + b.getBbsMemberId() + "&bId=" + b.getBbsId(); %>
		<td><button onclick="location.href='<%=urlUp%>'">수정</button></td>
		<td><button onclick="location.href='<%=urlDel%>'">삭제</button></td>
	</tr>
	<% } %>
	</table>
	<p>pageNo 1 2 3 4 5</p>
	
</div>
</body>
</html>
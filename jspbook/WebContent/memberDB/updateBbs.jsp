<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberDB.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
</head>
<body>
<%
	BbsDTO bbs = (BbsDTO) request.getAttribute("bbs");
%>
<div align="center">
<h3>작성한 글 수정</h3>
	<hr>
	<form name="registerForm" action="/jspbook/memberDB/bbsProcServlet?action=execute" method="post">
	
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
		<tr>
			<th bgcolor="pink" style="width:100px">회원 ID</th>
			<td style="width:550px; text-align:left;">&nbsp;
				<input type="hidden" id="mId" name="mId" value="<%= bbs.getBbsMemberId() %>">
				<%= bbs.getBbsMemberId() %>
			</td>
		</tr>
		<tr>
			<th bgcolor="pink">글번호</th>
			<td style="text-align:left">&nbsp;
				<input type="hidden" id="bId" name="bId" value="<%= bbs.getBbsId() %>">
				<%= bbs.getBbsId() %>
			</td>
		</tr>
		<tr>
			<th bgcolor="pink">제목</th>
			<td><input type="text" name="title" value="<%= bbs.getBbsTitle() %>" size="75"></td>
		</tr>
		<tr>
			<th bgcolor="pink">내용</th>
			<td><textarea name="context" cols="77" rows="20" ><%= bbs.getBbsContent() %></textarea></td>
		</tr>
	</table>
	<br><br>
		<input type="submit" value="수정" name="B1">&nbsp;&nbsp;
		<input type="reset" value="재작성" name="B2">
	</form>
</div>
</body>
</html>
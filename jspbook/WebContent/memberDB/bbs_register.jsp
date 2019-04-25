<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberDB.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새로운 글 작성</title>
</head>
<body>
<div align="center">
<h3>글 작성 폼</h3>
	<hr>
	<form name="registerForm" action="/jspbook/memberDB/bbsProcServlet?action=registerBtn&mId=${memberId}&page=${currentBbsPage}" method="post">
	
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
		<tr>
			<th bgcolor="pink" style="width:100px">회원 ID</th>
			<td style="width:550px">&nbsp;${memberId}</td>
		</tr>
		<tr>
			<th bgcolor="pink">제목</th>
			<td><input type="text" name="bbsTitle" size="75"></td>
		</tr>
		<tr>
			<th bgcolor="pink">내용</th>
			<td><textarea name="bbsContext" cols="77" rows="20" ></textarea></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="등록" name="B1">&nbsp;&nbsp;
	<input type="reset" value="재작성" name="B2">

	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberDB.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>새로운 글 작성</title>
<style>
label {
	display: block; /* 새 라인에서 시작 */
	padding: 5px;
}

label span {
	display: inline-block;
	width: 150px;
	text-align: right;
	padding: 10px;
}
</style>
</head>
<body>
<%
	//BbsDTO bbs = (BbsDTO) request.getAttribute("bbs");
%>
<h3>글 작성 폼</h3>
	<hr>
	<% String uu = "/jspbook/memberDB/bbsProcServlet?action=registerBtn&mId=" + session.getAttribute("memberId"); %>
	<form name="registerForm" action="<%= uu %>" method="post">
		<input type="hidden" id="mId" name="mId" value="">
		<label><span>회원 아이디:</span>
		<%= session.getAttribute("memberId") %>
		</label><br>
		<label><span>제목:</span>
			<input type="text" name="bbsTitle" size="35">
		</label><br>
		<label><span>내용:</span>
			<textarea name="bbsContext" cols="40" rows="8" ></textarea>
		</label><br>
		<label>
			<span></span><input type="submit" value="등록" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2"></label>
	</form>
</body>
</html>
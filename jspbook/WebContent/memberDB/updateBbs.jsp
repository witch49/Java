<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberDB.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 수정</title>
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
	BbsDTO bbs = (BbsDTO) request.getAttribute("bbs");
%>
<h3>작성한 글 수정</h3>
	<hr>
	<form name="registerForm" action="/jspbook/memberDB/bbsProcServlet?action=execute" method="post">
		<!--  <label><span>패스워드:</span>
			<input type="text" name="memberPassword" size="20">
		</label><br> -->
		<input type="hidden" id="mId" name="mId" value="<%= bbs.getBbsMemberId() %>">
		<label><span>회원 아이디:</span>
			<%= bbs.getBbsMemberId() %>
		</label><br>
		<input type="hidden" id="bId" name="bId" value="<%= bbs.getBbsId() %>">
		<label><span>글번호:</span>
			<%= bbs.getBbsId() %>
		</label><br>
		<label><span>글제목:</span>
			<input type=text name="title" value="<%= bbs.getBbsTitle() %>" size="35">
		</label><br>
		<label><span>글내용:</span>
			<textarea name="context" cols="40" rows="8" ><%= bbs.getBbsContent() %></textarea>
		</label><br>
		<br><br>
		<label>
			<span></span><input type="submit" value="수정" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2"></label>
	</form>

</body>
</html>
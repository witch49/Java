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
	MemberDTO member = (MemberDTO) request.getAttribute("member");
	
%>

<h3>회원 정보 수정</h3>
	<hr>
	<form name="registerForm" action="/jspbook/memberDB/memberProcServlet?action=execute" method="post">
		<!--  <label><span>패스워드:</span>
			<input type="text" name="memberPassword" size="20">
		</label><br> -->
		<input type="hidden" id="id" name="id" value="<%= member.getMemberId() %>">
		<label><span>아이디:</span>
			<%= member.getMemberId() %>
		</label><br>
		<label><span>이름:</span>
			<input type=text name="name" value="<%= member.getMemberName() %>" size="20">
		</label><br>
		<label><span>생년월일:</span>
			<input type="text" name="birth" value="<%= member.getMemberBirth() %>" size="20">
			<br>(입력 형식 : 910101)
		</label><br>
		<label><span>주소:</span>
			<input type="text" name="address" value="<%= member.getMemberAddress() %>" size="30">
		</label><br><br>
		<label>
			<span></span><input type="submit" value="수정" name="B1">&nbsp;&nbsp;
			<input type="reset" value="재작성" name="B2"></label>
	</form>

</body>
</html>
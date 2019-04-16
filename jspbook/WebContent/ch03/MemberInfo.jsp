<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="info" scope="page" class="jspbook.ch03.Member" />
<jsp:setProperty name="info" property="*" />
<%info.createId(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보 입력</title>
</head>
<body>
	<form name="form1" method="post">
		<table>
			<tr>
				<td>이름:</td>
				<td><input type="text" name="name" width="600" size="20"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" name="email" width="600" size="20"></td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="phoneNo" width="600" size="20"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<input type="submit" value="제출" name="B1">
				</td>
			</tr>
		</table>
		<br>
	</form>
	<hr>
	해당 회원의 아이디는: <jsp:getProperty name="info" property="id" />

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
label {
  cursor: default;
}
</style>
<title>로그인 폼</title>
</head>
<body>
	<form action="loginResult.jsp">
		아이디: <input type="text" name="userId" /><br>
		비밀번호: <input type="password" name="userPwd"/><br>
		<label for="user"><input type="radio" name="userType" id="user" value="사용자" />사용자</label>
		<label for="admin"><input type="radio" name="userType" id="admin" value="관리자" />관리자</label><br>
		<input type="submit" value="제출" />
	</form>
</body>
</html>
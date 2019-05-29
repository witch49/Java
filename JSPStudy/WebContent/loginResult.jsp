<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<h2>환영합니다</h2>
	<hr>
	
	<c:choose>
		<c:when test="${(param.userId == 'root') && (param.userType == '관리자')}">
			<c:choose>
				<c:when test="${param.userPwd == '1234'}" >
					<p>어서오세요, 관리자님</p>
				</c:when>
				<c:otherwise>
					<% out.println("<script>alert('비밀번호 오류');window.history.back();</script>"); %>
					<%-- <c:redirect url="loginForm.jsp" /> --%>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>어서오세요, 일반 사용자님</p>
		</c:otherwise>
	</c:choose>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include</title>
</head>
<body>
	<h2>include_action.jsp에서 footer.jsp 호출</h2>
	<hr>
	include_action.jsp에서 포출한 메시지입니다.<br>
	<jsp:include page="footer.jsp">
		<jsp:param name="email" value="test@gmail.com" />
		<jsp:param name="tel" value="010-1234-1234" />
	</jsp:include>
</body>
</html>
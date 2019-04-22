<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application</title>
</head>
<body>
	<div align="center">
	<h2>application 예제</h2>
	<hr>
	1. 서버 정보 : <%= application.getServerInfo() %><br>
	2. 서블릿 API 버전 정보 : <%= application.getMajorVersion() + "." + application.getMinorVersion() %><br>
	3. application.jsp 파일의 실제 경로 : <%= application.getRealPath("application.jsp") %><br>
	<hr>
	setAttribute로 username 변수에 "홍길동" 설정<br>
	<% 
		application.setAttribute("username", "홍길동");
		application.log("username=홍길동"); // console에 출력
		application.setAttribute("count", 0);
	%>
	
	<a href="application_result.jsp"> 확인하기 </a>
	</div>
</body>
</html>
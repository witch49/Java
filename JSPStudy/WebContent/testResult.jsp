<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] season = request.getParameterValues("season");
	%>
	<label>이름: </label><%= name %><br>
	<label>성별: </label><%= gender %><br>
	<label>좋아하는 계절: </label>
	<%
		for(String s : season)
			out.print(s + " ");
		// value가 '봄' 이 아닌 숫자 '1'로 받아온다면
		// int n = Integer.parseInt(s);
		// switch(n) case "1": out.println("봄입니다.");
	%>
	<br>
</body>
</html>
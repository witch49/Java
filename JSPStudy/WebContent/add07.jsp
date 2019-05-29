<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		고전적인 방식 :
		<%-- 스크립트릿을 사용한 자바 코드 --%>
	</p>
	<%
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");

		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
	%>
	<%=num1 %> + <%=num2 %> = <%=num1 + num2 %> <br><br>
	
	<p>
		EL 방식 :
		<%-- 표현 언어를 사용하면 깔끔하고 코드가 간결 --%>
	</p>
	<!-- 자동 형변환 해줌 -->
	${param.num1} + ${param.num2} = ${param.num1 + param.num2}
</body>
</html>
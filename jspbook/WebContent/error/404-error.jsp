<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch14:404-error.jsp</title>
</head>
<jsp:useBean id="now" class="java.util.Date"/>
<body>
<div align="center">
	<h2>ch14 : 404-error.jsp [web.xml 지정]</h2>
	<hr>
	<table border="1" style="border:1px solid pink; border-collapse:collapse; margin:auto;">
		<tr style="width:100%" bgcolor="pink">
			<td>요청하신 파일을 찾을 수 없습니다.<br>URL 주소를 다시 한 번 확인해주세요!</td>
		</tr>
		<tr>
			<td>
				${now}
				<p>요청 실패 URI : ${pageContext.errorData.requestURI}</p>
				<p>상태 코드 : ${pageContext.errorData.statusCode}</p>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
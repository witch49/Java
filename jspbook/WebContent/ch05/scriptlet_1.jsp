<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scriptlet_1</title>
</head>
<body>
	<center>
		<h2>스크립트릿_1</h2>
		<hr>
		<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;" >
			<tr bgcolor="lightskyblue">
				<th width="40">X</th>
				<th width="80">Y(=X*X)</th>
			</tr>
			<% for(int i=1; i<=10; i++) {%>
			<tr>
				<td><%= i %></td>
				<td><%= i*i  %> </td>
			</tr>
			<% } %>
		</table>
	</center>
</body>
</html>
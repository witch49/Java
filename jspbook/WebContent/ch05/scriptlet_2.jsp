<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>scriptlet_2</title>
</head>
<body>
	<center>
		<h2>스크립트릿_2</h2>
		<hr>
		<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;" >
			<tr bgcolor="lightskyblue">
				<th width="40"> * </th>
				<% for(int k=3; k<=9; k+=2) { %>
				<th width="40"><%= k %></th>
				<% } %>
			</tr>
			<% for(int i=3; i<=9; i+=2) { %>
			<tr>
				<th bgcolor="lightskyblue"><%= i %></th>
				<% for(int k=3; k<=9; k+=2) { %>
				<td width="40"><%= i*k %></td>
				<% } %>
			</tr>
			<% } %>
		</table>
	</center>
</body>
</html>
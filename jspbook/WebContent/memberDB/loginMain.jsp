<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="memberDB.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO mDao = new MemberDAO();
	List<MemberDTO> memberlist = mDao.selectMembersAll();
	mDao.close();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loginMain</title>
</head>
<body>
<center>
	<h3>회원 명단</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="lightskyblue">
		<th width="80">아이디</th>
		<th width="80">이름</th>
		<th width="80">생년월일</th>
		<th width="200">주소</th>
	</tr>
	<% for(MemberDTO m : memberlist) { %>
	<tr>
		<td><%= m.getMemberId() %></td>
		<td><%= m.getMemberName() %></td>
		<td><%= m.getMemberBirth() %></td>
		<td><%= m.getMemberAddress() %></td>
	</tr>
	<% } %>
	</table>	
</center>
</body>
</html>
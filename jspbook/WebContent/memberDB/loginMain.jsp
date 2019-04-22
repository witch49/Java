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
<div align="center">
	<h3>회원 명단</h3>
	<hr>
	현재 접속중인 고객ID: <%= session.getAttribute("memberId") %>, 이름: <%= session.getAttribute("memberName") %><br>
	<a href="/jspbook/memberDB/memberProcServlet?action=logout">로그아웃</a>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="lightskyblue">
		<th width="80">아이디</th>
		<th width="80">이름</th>
		<th width="80">생년월일</th>
		<th width="300">주소</th>
		<th colspan=2 width="100">액션</th>
		
	</tr>
	<% for(MemberDTO m : memberlist) { %>
	<tr>
		<td><%= m.getMemberId() %></td>
		<td><%= m.getMemberName() %></td>
		<td><%= m.getMemberBirth() %></td>
		<td><%= m.getMemberAddress() %></td>
		<%	String urlUp = "memberProcServlet?action=update&id=" + m.getMemberId(); 
			String urlDel = "memberProcServlet?action=delete&id=" + m.getMemberId(); %>
		<td><button onclick="location.href='<%=urlUp%>'">수정</button></td>
		<td><button onclick="location.href='<%=urlDel%>'">삭제</button></td>
	</tr>
	<% } %>
	</table>	
</div>
</body>
</html>
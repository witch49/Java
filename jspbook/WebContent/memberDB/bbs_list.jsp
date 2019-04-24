<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ page import="memberDB.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbsList</title>
</head>
<body>
<div align="center">
<hr>
	현재 접속중인 고객ID: <%= session.getAttribute("memberId") %> / 이름: <%= session.getAttribute("memberName") %><br>
	<a href="loginMain.jsp">회원 명단</a>&nbsp;&nbsp;
	<a href="twitter_list.jsp">트윗</a>&nbsp;&nbsp;
	<a href="/jspbook/memberDB/memberProcServlet?action=logout">로그아웃</a>
	<hr>
	
	<h3>게시판</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
	<tr bgcolor="pink">
		<th width="40">번호</th>
		<th width="80">회원ID</th>
		<th width="300">제목</th>
		<th width="200">작성/수정일</th>
		<%-- <th colspan=2 width="100">액션</th>--%>
	</tr>
	
	<% 
	int pageNumber = 1; // 기본 페이지 번호
	
	// 페이지 번호가 있을 경우
	if(request.getParameter("pageNumber") != null)
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	
	BbsDAO bDao = new BbsDAO();
	List<BbsDTO> bbslist = bDao.getList(pageNumber);
	
	for(BbsDTO b : bbslist) { %>
	<tr>
		<td><%= b.getBbsId() %></td>
		<td><%= b.getBbsMemberId() %></td>
		<% String urlDetail = "/jspbook/memberDB/bbsProcServlet?action=detail&mId=" + b.getBbsMemberId() + "&bId=" + b.getBbsId(); %>
		<td><a href="<%= urlDetail %>"><%= b.getBbsTitle() %></a></td>
		<td><%= b.getBbsDate().substring(0,16) %></td>
		<%-- 
		<%	String urlUp = "bbsProcServlet?action=update&mId=" + b.getBbsMemberId() + "&bId=" + b.getBbsId(); 
			String urlDel = "bbsProcServlet?action=delete&mId=" + b.getBbsMemberId() + "&bId=" + b.getBbsId(); %>
		<td><button onclick="location.href='<%=urlUp%>'">수정</button></td>
		<td><button onclick="location.href='<%=urlDel%>'">삭제</button></td>
		--%>
	</tr>
	<% } %>
	</table>
	<br>
	<!-- 페이지 넘기기 -->
	<%	if (pageNumber != 1) { %>
	<a href="bbs_list.jsp?pageNumber=<%=pageNumber - 1%>" class="btn btn-success btn-arrow-left">이전</a>
	<%	}
	if (pageNumber*10 < bDao.getListCount()) {
	%>
	<a href="bbs_list.jsp?pageNumber=<%=pageNumber + 1%>" class="btn btn-success btn-arrow-left">다음</a>
	<%	} %>
	<br>
	<%	String dd = "bbsProcServlet?action=register&mId=" +session.getAttribute("memberId"); %>
	<button onclick="location.href='<%=dd%>'" style="float:right; margin-right:5em;">글 작성</button><br>
	
</div>
</body>
</html>
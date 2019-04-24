<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="memberDB.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 상세화면</title>
<style>
td {
	width:500px;
	text-align:left;
}
</style>
</head>
<body>
<div align="center">
	<h3>게시판</h3>
	<hr>
	<table border="1" style="border:1px solid black; text-align:center; border-collapse:collapse; margin:auto;">
		<tr>
			<th width="150" bgcolor="pink">글 번호</th>
			<td>&nbsp;<%= session.getAttribute("bId") %></td>
		</tr>
		<tr>
			<th bgcolor="pink">작성자(회원ID)</th>
			<td>&nbsp;<%= session.getAttribute("mWritterName") %>(<%= session.getAttribute("mWritterId") %>)</td>
		</tr>
		<tr>
			<th bgcolor="pink">제목</th>
			<td>&nbsp;
				<%
				BbsDAO bDao = new BbsDAO();
				List<BbsDTO> bbslist = bDao.selectPostsAll();
			
				for(BbsDTO b : bbslist) { 
					if(b.getBbsId() == (Integer) session.getAttribute("bId")){%>
					<%= b.getBbsTitle() %>
				<%	break;
					}
				}	%>
			</td>
		</tr>
		<tr>
			<th bgcolor="pink" style="height:200px">내용</th>
			<td>
				<%
				for(BbsDTO b : bbslist) { 
					if(b.getBbsId() == (Integer) session.getAttribute("bId")){%>
					<%-- <%= b.getBbsContent().replaceAll("\n", "<br>").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(" ", "&nbsp;") %> --%>
					<%-- <%= b.getBbsContent() %> --%>
					<%= b.getBbsContent().replaceAll("\n", "<br>").replaceAll(" ", "&nbsp;") %>
				<%	break;
					}
				}	%>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:center">
				<a href="bbs_list.jsp">이전화면</a>&nbsp;&nbsp;
				
				<%	String urlUp = "bbsProcServlet?action=update&mId=" + session.getAttribute("mWritterId") + "&bId=" + session.getAttribute("bId"); 
					String urlDel = "bbsProcServlet?action=delete&mId=" + session.getAttribute("mWritterId") + "&bId=" + session.getAttribute("bId");
					if(session.getAttribute("mWritterId").equals(session.getAttribute("memberId"))) {	
				%>
					
				<button onclick="location.href='<%=urlUp%>'">수정</button>&nbsp;&nbsp;
				<button onclick="location.href='<%=urlDel%>'">삭제</button>
				<% } %>
			</td>
		</tr>
	</table>

</div>
</body>
</html>
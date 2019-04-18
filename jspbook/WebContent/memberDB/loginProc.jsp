<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberDB.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO mDao = new MemberDAO();
	String strId = request.getParameter("id");
	int id = 0;
	if (strId.matches("\\d+"))
		id = Integer.parseInt(strId);
	String password = request.getParameter("password");
	int result = mDao.verifyLogin(id, password);
	String errorMessage = null;
	
	switch(result) {
	case MemberDAO.ID_PASSWORD_MATCH:
		break;
	case MemberDAO.PASSWORD_IS_WRONG:
		errorMessage = "아이디 없음";
		break;
	case MemberDAO.DATABASE_ERROR:
		errorMessage = "패스워드 오류";
		break;
	case MemberDAO.ID_DOES_NOT_EXIST:
		errorMessage = "DB 오류";
		break;
	}
	mDao.close();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<%
	if(result == MemberDAO.ID_PASSWORD_MATCH)
		response.sendRedirect("loginMain.jsp");
	else	{
%>
	<jsp:forward page="login.jsp">
		<jsp:param name="error" value="<%= errorMessage %>" />
	</jsp:forward>

<% } %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ch10: EL 예제</title>
</head>
<body>
<div align="center">
	<h3>ch10 : EL 예제 - 상품 목록</h3>
	<hr>
	<form name="form1" method="post" action="ProductSel.jsp">
		<jsp:useBean id="product" class="jspbook.ch10.Product" scope="session" />
		<select name="sel">
			<%
				for (String item : product.getProductList()) 
					out.println("<option>" + item + "</option>");
			%>
		</select>
		<input type="submit" value="선택" />
	</form>
</div>
</body>
</html>
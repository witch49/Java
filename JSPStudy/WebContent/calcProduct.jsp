<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
label {
  cursor: default;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h2> 물품을 선택하세요. </h2>
	<hr>
	<form method="post" action="calcProductResult.jsp">
		<label for="hat"><input type="checkbox" name="product" id="hat" value="1" />모자</label>
		<label for="television"><input type="checkbox" name="product" id="television" value="2"/>텔레비젼</label>
		<label for="shoes"><input type="checkbox" name="product" id="shoes" value="3"/>신발</label><br>
		<input type="submit" value="제출"/>
	</form>

</body>
</html>
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
<title>설문 조사</title>
</head>
<body>

<% 
	// 스크립트릿 : java 코드 작성
	// 변수 선언 : 지역변수
	int local_cnt = 0;
	out.println("local_cnt : ");
	out.println(++local_cnt + "<br>");
	out.println("global_cnt : ");
	out.println(++global_cnt);
%>
<%!
	//변수 선언 : 전역변수
	int global_cnt = 0;
%>
<!-- html 주석 -->
<%-- jsp 주석 --%>
	<hr>
	<h2>설문 조사</h2>
	<form method="post" action="testResult.jsp">
		이름: &nbsp;<input type="text" name="name"/><br>
		성별: &nbsp;<label for="male"><input type="radio" name="gender" id="male" value="남자"/> 남자</label> 
		<label for="female"><input type="radio" name="gender" id="female" value="여자"/> 여자</label><br>
		좋아하는 계절:&nbsp;
		<label for="spring"><input type="checkbox" name="season" id="spring" value="봄"/> 봄</label>
		<label for="summer"><input type="checkbox" name="season" id="summer" value="여름"/> 여름</label>
		<label for="fall"><input type="checkbox" name="season" id="fall" value="가을"/> 가을</label>
		<label for="winter"><input type="checkbox" name="season" id="winter" value="겨울"/> 겨울</label><br>
		<input type="submit" value="제출"/>
	</form>
</body>
</html>
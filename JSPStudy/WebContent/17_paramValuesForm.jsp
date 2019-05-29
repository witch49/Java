<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>물품 선택 폼</title>
</head>
<body>
<!-- 
동일한 이름의 체크박스가 여러개 존재하는 html 문서에서 여러 항목을 선택하여 전송된 정보를 표현하기 위해서
표현 언어에서는 paramValues를 사용 

paramValues는 지정한 이름을 가진 파라미터의 모든 값을 배열 형태로 얻어오기 때문에
동일한 이름으로 여러번 값이 전송되어도 이를 처리할 수 있음
 -->
	<h2>악세사리</h2>
	<hr>
	<p>관심 항목을 선택하세요.</p>
	<form method="get" action="17_paramValuesResult.jsp">
		<label for="shoes"><input type="checkbox" name="item" id="shoes" value="신발" /> 신발</label>
		<label for="bag"><input type="checkbox" name="item" id="bag" value="가방" /> 가방</label>
		<label for="balt"><input type="checkbox" name="item" id="balt" value="벨트" /> 벨트</label>
		<label for="hat"><input type="checkbox" name="item" id="hat" value="모자" /> 모자</label>
		<label for="watch"><input type="checkbox" name="item" id="watch" value="시계" /> 시계</label>
		<label for="jewelry"><input type="checkbox" name="item" id="jewelry" value="쥬얼리" /> 쥬얼리</label><br><br>
		<input type="submit" value="전송" />
	</form>
</body>
</html>
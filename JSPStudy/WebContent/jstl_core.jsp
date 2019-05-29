<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>core</title>
</head>
<body>
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:set -->
	<!-- ---------------------------------------------------------------------------- -->
	<!-- set 방법 1 -->
	<c:set var="msg" value="hello" />
	Msg : ${msg}<br>
	
	<!-- set 방법 2 -->
	<c:set var="age">30</c:set>
	Age : ${age}<br>
	<hr>
	<!-- ---------------------------------------------------------------------------- -->
	<c:set var="member" value="<%=new com.saeyan.javabean.MemberBeans()%>" />
	<c:set target="${member}" property="name" value="이병일" />
	<c:set target="${member}" property="userId" value="dlquddlf5320" />
	\${member} : ${member}<br>
	Name : ${member.name}<br>
	ID : ${member.userId}<br>
	<hr>
	
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:forEach -->
	<!-- ---------------------------------------------------------------------------- -->
	<%
		String[] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
		pageContext.setAttribute("movieList", movieList);
	%>
	<c:forEach var="movie" items="${movieList}">
		${movie}<br>
	</c:forEach>
	<br>
	<table border="1" style="width: 100%; text-align: center;">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>title</th>
		</tr>
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${movie}</td>
			</tr>
		</c:forEach>
	</table>
	
	<ul>
		<c:forEach var="movie" items="${movieList}" varStatus="status">
			<c:choose>
				<c:when test="${status.first}" >
					<li style="font-weight: bold; color: red;">${movie}</li>
				</c:when>
				<c:otherwise>
					<li>${movie}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		${movie} <c:if test="${not status.last}">, </c:if>
	</c:forEach>
	<hr>
	
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:forTokens -->
	<!-- ---------------------------------------------------------------------------- -->
	<c:forTokens var="city" items="서울.인천,대구.부산" delims=",">
		${city}<br>
	</c:forTokens>
	<br>
	<c:forTokens var="city" items="서울.인천,대구.부산" delims=".,">
		${city}<br>
	</c:forTokens>
	<hr>
	
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:import -->
	<!-- ---------------------------------------------------------------------------- -->
	<c:import url="http://localhost:8080/JSPStudy/13_fruitSelectForm.jsp" var="data" />
	${data}
	<hr>
	
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:url -->
	<!-- ---------------------------------------------------------------------------- -->
	<c:url value="images/Yoshi.png" var="imgData" />
	<p>${imgData}</p>
	<img src="${imgData}" width="300" height="300" >
	<hr>
	
	<!-- ---------------------------------------------------------------------------- -->
	<!-- c:out -->
	<!-- ---------------------------------------------------------------------------- -->
	<c:set var="ageTest" value="30" scope="page" />
	나이 : <c:out value="${ageTest}">10</c:out><br>
	<c:remove var="ageTest" scope="page" />
	나이 : <c:out value="${ageTest}">10</c:out><br>	<!-- ageTest의 default값이 10 -->
	
	<c:catch var="errorMsg">
		예외 발생 전<br>
		<%= 1 / 0 %>
		예외 발생 후<br>
	</c:catch>
	<c:out value="${errorMsg}" />
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>format</title>
</head>
<body>

	<!-- ---------------------------------------------------------------------------- -->
	<!-- fmt:formatDate -->
	<!-- ---------------------------------------------------------------------------- -->
	<pre>
		<c:set var="now" value="<%=new java.util.Date()%>" />
		\${now} : ${now}
		<fmt:formatDate value="${now}"/>
		date : <fmt:formatDate value="${now}" type="date"/>
		time : <fmt:formatDate value="${now}" type="time"/>
		both : <fmt:formatDate value="${now}" type="both"/>
		default : <fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default" />
		short : <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" />
		medium : <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" />
		long : <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" />
		full : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
		pattern = "yyyy년 MM월 dd일 hh시 mm분 ss초" : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" />
	</pre>
	<hr>
	<!-- ---------------------------------------------------------------------------- -->
	<!-- fmt:timeZone -->
	<!-- ---------------------------------------------------------------------------- -->
	<jsp:useBean id="now" class="java.util.Date" />
	<pre>
		default : <c:out value="${now}" />
		Korea KST : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
		<fmt:timeZone value="GMT">
		Swiss GMT : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
		</fmt:timeZone>
		<fmt:timeZone value="GMT-8">
		NewYork GMT-8 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />
		</fmt:timeZone>
	</pre>
	<hr>
	<!-- ---------------------------------------------------------------------------- -->
	<!-- fmt:setLocale -->
	<!-- ---------------------------------------------------------------------------- -->
	<pre>
		톰캣 서버의 기본 로케일 : <%=response.getLocale()%>
		<fmt:setLocale value="ko_kr"/>
		로케일을 한국어로 설정한 후 로케일 확인 : <%=response.getLocale()%>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" />
		날짜 : <fmt:formatDate value="${now}" />
		<fmt:setLocale value="ja_JP" />
		로케일을 일본어로 설정 후 로케일 확인 : <%=response.getLocale()%>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" />
		날짜 : <fmt:formatDate value="${now}" />
		<fmt:setLocale value="en_US" />
		로케일을 영어로 설정 후 로케일 확인 : <%=response.getLocale()%>
		통화(currency) : <fmt:formatNumber value="10000" type="currency" />
		날짜 : <fmt:formatDate value="${now}" />
	</pre>
	<hr>
	<!-- ---------------------------------------------------------------------------- -->
	<!-- fmt: -->
	<!-- ---------------------------------------------------------------------------- -->
	
	
</body>
</html>
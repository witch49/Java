<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>계산서</h2>
	<hr>
	<%
		String[] product = request.getParameterValues("product"); 
	%>
	<%! int costHat = 0, costTelevision = 0, costShoes = 0; %>
	
	<%
		int sum = 0;
		for (String p : product) {
			int temp = Integer.parseInt(p);
			switch (temp) {
			case 1:
				costHat = 11000;
				out.println("모자의 가격은 " + costHat + "원<br>");
				sum += costHat;
				break;
			case 2:
				costTelevision = 200000;
				out.println("텔레비젼의 가격은 " + costTelevision + "원<br>");
				sum += costTelevision;
				break;
			case 3:
				costShoes = 23000;
				out.println("신발의 가격은 " + costShoes + "원<br>");
				sum += costShoes;
				break;
			default:
				out.println("잘못된 값");
			}
		}
		out.println("<br>물품 총 가격은 " + sum + "원");
	%>
	
</body>
</html>
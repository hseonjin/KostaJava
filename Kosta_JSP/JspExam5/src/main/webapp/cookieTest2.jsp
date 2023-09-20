<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name="";
	String value="";
	String age="";
	String cookie = request.getHeader("Cookie");
	if(cookie!=null) { // 쿠키가 있다면
		Cookie[] cookies = request.getCookies();
		for(Cookie c : cookies) {
			if(c.getName().equals("name")) {
				name = c.getName();
				value = c.getValue();
			} else if (c.getName().equals("age")) {
				age = c.getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 이름 = <%=name %></h2>
	<h2>쿠키 값 = <%=value %></h2>
	<h2>나이 = <%=age %></h2>
</body>
</html>
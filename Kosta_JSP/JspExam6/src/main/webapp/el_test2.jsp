<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); 
    	request.setAttribute("nickname", "홍ㅋ큌큌키ㅜ키ㅜㅋ키ㅜ");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--     <h3>${session.getAttribute("test") %></h3> --%>
    <h3>${sessionScope.test}</h3>
    <h3>${requestScope.test}</h3>
    <h3>${test}</h3>
    <h3>${nickname}</h3>    
    <h3>${param.name}</h3>
</body>
</html>
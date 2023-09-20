<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>pageContextTest1.jsp임</h1> <!-- pageContextTest2.jsp로 forward 시켰기 때문에 출력되지 않는다 -->
<%pageContext.forward("pageContextTest2.jsp"); %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--  	Calendar c = Calendar.getInstance(); -->
<!--  	int hour = c.get(Calendar.HOUR_OF_DAY); -->
<!--  	int minute = c.get(Calendar.MINUTE); -->
<!--  	int second = c.get(Calendar.SECOND); -->


</head>
<body>
<%-- <h1>현재 시간은 <%=hour %>시 <%=minute %>분 <%=second %>초입니다.</h1> --%>
<h1>현재 시간은 <%=request.getAttribute("hour") %>시 <%=request.getAttribute("minute") %>분 <%=request.getAttribute("second") %>초입니다.</h1>
</body>
</html>
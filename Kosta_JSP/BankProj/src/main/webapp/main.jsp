<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KOSTA_BANK</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<style>h3{text-align:center; margin-top: 200px"</style>
</head>
<body>
<% String ipage = (String)request.getAttribute("page"); %>
<% String imem = (String) session.getAttribute("id"); %>

<% 
if(imem == null) { 
	pageContext.include("header.jsp"); 
} else {
	pageContext.include("headerLogin.jsp");
}
%>

<div>
<%
	if(ipage!=null) { // page라는 이름의 속성값을 ipage에 대입하여 page가 존재하는 경우
		pageContext.include(ipage + ".jsp"); // 해당 페이지를 포함한다
	}
%>
<h3>KOSTA BANK MAIN</h3>
</div>

</body>
</html>
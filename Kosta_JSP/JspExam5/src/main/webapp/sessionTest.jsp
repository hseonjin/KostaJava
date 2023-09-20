<!-- 메인페이지 역할 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String nickname = (String) session.getAttribute("nickname");
	if(nickname == null) { // 세션에 값이 없으면 nickname을 세션 값 없음으로 저장
		nickname="세션 값 없음";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 테스트</h2>
	<input type="button" onclick="location.href='sessionSet.jsp'" value="세션 값 저장"/>
	<input type="button" onclick="location.href='sessionDel.jsp'" value="세션 값 삭제"/>
	<input type="button" onclick="location.href='sessionInvalidate.jsp'" value="세션 초기화"/>
	<h3><%=nickname %></h3>
</body>
</html>
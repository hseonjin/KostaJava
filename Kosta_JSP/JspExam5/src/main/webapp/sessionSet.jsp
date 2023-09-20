<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("nickname", "firefox"); %> <!-- 내장 객체에 nickname이라는 이름으로 으로 저장된 값 얻기 -->
<script>
	location.href="sessionTest.jsp"; // sendRedirect와 유사한 방법
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
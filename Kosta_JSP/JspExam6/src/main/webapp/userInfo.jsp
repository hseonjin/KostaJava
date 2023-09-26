<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h3>${id}님 환영합니다.</h3>
    <table border="1">
        <tr>
            <td>아이디</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td>이름</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td>주소</td>
            <td>${user.address}</td>
        </tr>
        <tr>
            <td>이메일</td>
            <td>${user.email}</td>
        </tr>
    </table>
</body>
</html>
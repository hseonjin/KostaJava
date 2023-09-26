<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!-- prefix : 태그 라이브러리에 짧은 이름이나 접두사 할당 -->
<!-- uri : 태그 라이브러리의 위치 또는 네임스페이스를 고유하게 식별하는 url 지정 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="test" value="Hello JSTL!!"/> <!-- 지정된 변수에 값을 설정하는 태그 -->
<h3>set 사용 후: <c:out value="${test}"/></h3> <!-- 출력 태그 -->
<c:remove var="test"/> <!-- 설정된 속성 제거 -->
<h3>remove 사용 후: <c:out value="${test}"/></h3>

<!-- catch: 블록 내에서 코드를 실행하는 동안 발생할 수 있는 예외를 잡는 데 사용, "err" 변수에 모든 예외가 저장 -->
<c:catch var="err">
	<%=10/0 %>
</c:catch>

<!-- out:  "err" 변수에 저장된 값을 출력 -->
<c:out value = "${err}"/>

<!-- if: 조건부 블록을 시작, test 내부의 값이 true인지 확인, true이면 블록 내부의 내용이 출력됨 -->
<c:if test="${5<10 }">
	<h3>5는 10보다 작다</h3>
</c:if>

<c:if test="${6+3==9 }">
	<h3>6+3은 9이다</h3>
</c:if>

<!-- choose: 조건부 분기에 사용 -->
<!-- when: test 내부 값이 true인지 확인, true인 경우 출력 -->
<!-- otherwise: when 블록의 조건이 거짓인 경우 출력 -->
<c:choose>
	<c:when test="${5+10==50 }">
		<h3>5+10은 50이다</h3>
	</c:when>
	<c:otherwise>
		<h3>5+10은 50이 아니다</h3>
	</c:otherwise>
</c:choose>
</body>
</html>
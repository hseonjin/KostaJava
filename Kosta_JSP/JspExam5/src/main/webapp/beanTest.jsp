<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
// 	String name = request.getParameter("name");
// 	Integer age = Integer.parseInt(request.getParameter("age"));
// 	bean.Person person = new bean.Person();
// 	person.setName(name);
// 	person.setAge(age);
--%>

<!-- useBean 사용하는 방법 -->
<jsp:useBean id="person" class="bean.Person">
	<jsp:setProperty name="person" property="*"/> <!-- name으로 받은 것과 param에 받는 것을 일치 -->
<%-- 	<jsp:setProperty name="person" property="name" param="name"/> <!-- name으로 받은 것과 param에 받는 것을 일치 --> --%>
<%-- 	<jsp:setProperty name="person" property="age" param="age"/> <!-- property="*"하면 이름이 같은 것을 알아서 가져옴 --> --%>
</jsp:useBean>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<h3><%=person.getName() %></h3> --%>
<%-- 	<h3><%=person.getAge() %></h3> --%>

<!-- useBean 사용하는 방법 -->
<h3><jsp:getProperty property="name" name="person"/></h3>
<h3><jsp:getProperty property="age" name="person"/></h3>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#label {
	text-align: center;
	padding-right: 10px;
}
p {
	text-align: center;
	margin: 20px 0 10px 0;
}
form {
    border: 1px solid gray;
    width: 300px;
    margin: 0 auto;
    padding: 20px;
}
</style>

<div class="container">
<jsp:include page="header.jsp"/>

	<h3>계좌조회</h3>
	<table>
		<tr>
			<td id="label">계좌번호</td>
			<td><input type="text" name="id" id="id" value="${acc.id}" disabled></td>
		</tr>
		<tr>
			<td id="label">이름</td>
			<td><input type="text" name="name" id="name" value="${acc.name }" disabled></td>
		</tr>
		<tr>
			<td id="label">입금액</td>
			<td><input type="text" name="money" id="money" value="${acc.balance }" disabled></td>
		</tr>
		<tr>
			<td id="label">종류</td>
			<td><input type="text" name="type" id="type" value="${acc.type }" disabled></td>
		</tr>
		<tr>
			<td id="label">등급</td>
			<td><input type="text" name="type" id="type" value="${acc.grade }" disabled></td>
		</tr>
	</table>	
</div>
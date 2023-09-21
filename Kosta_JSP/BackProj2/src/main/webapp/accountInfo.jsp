<%@page import="dto.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<% Account acc = (Account) request.getAttribute("acc"); %> <!-- getAttribute는 Object type이므로 캐스팅 요구 -->
<% pageContext.include("header.jsp"); %>
<div class="container">
	<h3>계좌조회</h3>
	<table>
		<tr>
			<td id="label">계좌번호</td>
			<td><input type="text" name="id" id="id" value=<%=acc.getId() %> disabled></td>
		</tr>
		<tr>
			<td id="label">이름</td>
			<td><input type="text" name="name" id="name" value=<%=acc.getName() %> disabled></td>
		</tr>
		<tr>
			<td id="label">입금액</td>
			<td><input type="text" name="money" id="money" value=<%=acc.getBalance() %> disabled></td>
		</tr>
		<tr>
			<td id="label">종류</td>
			<td><input type="text" name="type" id="type" value=<%=acc.getType() %> disabled></td>
		</tr>
		<tr>
			<td id="label">등급</td>
			<td><input type="text" name="type" id="type" value=<%=acc.getGrade() %> disabled></td>
		</tr>
	</table>
</div>
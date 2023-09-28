<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#tbl_top {
	background: lightgrey;
}

table {
	margin: 0 auto;
	width: 800px;
	border: 1px solid lightgrey;
	border-bottom: none;
}

tr, td {
	text-align: center;
	padding: 10px;
}
</style>

<jsp:include page="header.jsp" />
<div class="container">
	<h3>전체 계좌 조회</h3>
	<table>
		<tr id="tbl_top">
			<th>순서</th>
			<th>계좌번호</th>
			<th>이름</th>
			<th>잔액</th>
			<th>계좌종류</th>
			<th>등급</th>
		</tr>
		<c:set var="i" value="1" />
		<c:forEach var="acc" items="${accs }">
			<tr>
				<td>${i }</td>
				<td>${acc.id }</td>
				<td>${acc.name }</td>
				<td>${acc.balance }</td>
				<td>${acc.type}</td>
				<td>${acc.grade}</td>
				<c:set var="i" value="${i+1 }" />
			</tr>
		</c:forEach>
	</table>
</div>
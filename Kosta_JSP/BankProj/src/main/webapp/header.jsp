<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	* {margin:0 auto;}
	a {
		text-decoration:none;
		color: black;	
	}
	.outerDiv {
		width:100%;
		height:100px;
		background-color: lightblue;
		padding: 20px 0;
		margin-bottom: 5rem;
	}
</style>
<div class="outerDiv">
	<i><h1 style="text-align:center;"><a href="/bank/main">kosta bank</a></h1></i><br>
	<div class ="innerDiv">
	<div style="float:left; margin-left:30px;">
			<!-- 메인에 요청해서(mapping) 파라미터 makeaccount.jsp을 
            doget 함수의 request에 (K:V) 형식으로 (page : makeaccount)를 요청하는 것, 
            그 응답을 main.jsp에 응답을 위임(forward) -->
		<a href="main?page=makeaccount">계좌개설 |</a> <!-- .jsp 확장자까지 붙여서 사용 가능 -->
		<a href="main?page=deposit">입금 |</a>
		<a href="main?page=withdraw">출금 |</a>
		<a href="main?page=accountinfoform">계좌조회 |</a>
		<a href="main?page=allAccountInfo">전체계좌조회</a>
	</div>
	<div style="float:right; margin-right:30px;">
	
		<a href="main?page=login">로그인 |</a>
		<a href="main?page=signup">회원가입</a>
	</div>
	</div>	
</div>
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
<script>
	$(function() { // 선택 불가능하게 만드는 설정
		$("input[name='type']").change(function() {
			var test = $("input[name='type']:checked").val();
			if (test == 'normal') {
				$("select[name=grade]").attr("disabled", true);
			} else {
				$("select[name=grade]").attr("disabled", false);
			}
		})
	});
</script>
<div class="container">
	<h3>계좌개설</h3>
	<form action="makeAccount" method="post">
		<table>
			<tr>
				<td id="label">계좌번호</td>
				<td><input type="text" name="id" id="id"></td>
			</tr>
			<tr>
				<td id="label">이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td id="label">입금액</td>
				<td><input type="text" name="money" id="money"></td>
			</tr>
			<tr>
				<td id="label">종류</td>
				<td>
					<input type="radio" name="type" value="normal" checked>일반
                    <input type="radio" name="type" value="special">특수
				</td>
			</tr>
			<tr>
				<td id="label">등급</td>
				<td>
					<select name="grade" id="grade" disabled="disabled">
                       <option value="vip">VIP</option>
                       <option value="gold">GOLD</option>
                       <option value="silver">SILVER</option>
                       <option value="normal">NORMAL</option>
                   	</select> 
				</td>
			</tr>
		</table>
		<p><input type="submit" value="개설"></p>
	</form>
</div>
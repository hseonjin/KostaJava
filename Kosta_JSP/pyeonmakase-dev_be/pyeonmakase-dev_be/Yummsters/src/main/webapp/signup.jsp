<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 


    <style>
        /* form 전체 틀 */
        .join-box {
            border-radius: 20px;
            border: 5px solid #EEC595;
            background: #FFF;
            width: 800px;
            margin: 100px auto;
            text-align: center;
        }

        /* form 제목 */
        .title {
            font-size: 20px;
            color: #524434;
            font-weight: bold;
            margin: 20px auto;
        }

        /* input 태그 */
        .input-with-button {
            width: 80%; 
            padding: 13px 10px;
            margin: 15px auto;
            border-bottom: 3px solid #EEC595;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        .input-with-button > input {
            border: none;
            font-size: 16px;
            width: 65%;
        }
        .input-with-button > button {
            border-radius: 5px;
            border: 1px solid #EEC595;
            background: #EEC595;
            font-size: 15px;
            cursor: pointer; 
        }

        /* 가입하기 버튼 */
        .join-form > input[type="submit"] {
            display:inline-block;
            margin: 30px auto;
            width: 75%;
            height: 30px;
            border-radius: 5px;
            border: 1px solid #EEC595;
            background: #EEC595;
            color: #FFF;
            text-align: center;
            font-size: 17px;
        }

        /* input 태그 클릭 시 테두리 표시되지 않도록 설정 */
        .join-form > input:focus {outline: none;}
        
        /* 중복확인 */
        #nicknameErr, #emailErr, #idErr, #pwErr {
        	font-size: small;
        }
    </style>
    
<body>
<jsp:include page="header.jsp" />
    <div class="join-box">
        <div class="title">회원가입</div>

        <form class="join-form" method="post" action="signup">
            <div class="input-with-button">
            <input type="text" id="name" name="name" required placeholder="이름을 입력하세요"></div>

            <div class="input-with-button">
                <input type="text" id="nickname" name="nickname" required placeholder="닉네임을 입력하세요">
                <p id="nicknameErr"></p>
                <button type="button" id="checkDuplicate" data-type="nickname">중복확인</button>
            </div>

            <div class="input-with-button">
                <input type="email" id="email" name="email" required placeholder="이메일을 입력하세요">
                <p id="emailErr"></p>
                <button type="button" id="checkDuplicate" data-type="email">중복확인</button>
            </div>

            <div class="input-with-button">
	            <input type="text" id="id" name="id" required placeholder="아이디를 입력하세요">
	            <p id="idErr"></p>
	            <button type="button" id="checkDuplicate" data-type="id">중복확인</button>
            </div>
            
            <div class="input-with-button">
            <input type="password" id="password" name="password" required placeholder="비밀번호를 입력하세요 (숫자, 영문, 특수기호 포함 10자리 이상)"></div>

            <div class="input-with-button">
            	<input type="password" id="check_password" name="check_password" required placeholder="비밀번호를 다시 입력하세요"> 
            	<p id="pwErr"></p>
            </div>  

            <input type="submit" name="signup" value="가입하기">
            <div id="signupErr"></div>
        </form>
        
    </div>

<jsp:include page="footer.jsp" />
</body>

<script>

$(function() {
	// 중복체크 여부
	let nicknameCheck = false;
	let emailCheck = false;
	let idCheck = false;
	
	$("#checkDuplicate").click(function() {
		var dataType = $(this).data("type");
		var inputValue = $("#" + dataType).val();
		
		$.ajax({
			url: "duplicateCheck", // 서블릿 주소
			type: "post", // method 타입
			data: {
                type: dataType,
                value: inputValue
			}
			data: {nickname: $("#nickname").val()}, // 서버로 보낼 데이터
			dataType: "json", // JSON 형식의 응답을 받기 위해 dataType을 설정
			success: function(res) {
				if(res.nickname == "notexist") { // 사용 가능한 경우
					nicknameCheck = true;
					$("#nicknameErr").text("사용 가능한 닉네임입니다").css("color", "green");
				} else {
					$("#nicknameErr").text("이미 사용중인 닉네임입니다").css("color", "red");
				}
				
				if(res.email == "notexist") { // 사용 가능한 경우
					emailCheck = true;
					$("#nicknameErr").text("사용 가능한 이메일입니다").css("color", "green");
				} else {
					$("#nicknameErr").text("이미 사용중인 이메일입니다").css("color", "red");
				}
				
				if(res.id == "notexist") { // 사용 가능한 경우
					idCheck = true;
					$("#nicknameErr").text("사용 가능한 아이디입니다").css("color", "green");
				} else {
					$("#nicknameErr").text("이미 사용중인 아이디입니다").css("color", "red");
				}
			},
			error: function(err) {
				console.log(err);
			}
		})
	})
})

    
 // 비밀번호 유효성 검사
    function validatePassword() {
        var password = $("#password").val();
        var checkPassword = $("#check_password").val();
        var passwordErr = $("#pwErr");

        if(password !== "") { // 비밀번호를 입력한 경우에만 확인
	        if (password !== checkPassword) {
	        	$("#pwErr").text("비밀번호를 확인해주세요").css("color", "red");
	            return false;
	        } else {
	        	$("#pwErr").text("비밀번호가 일치합니다").css("color", "green");
	            return true;
	        }
        } else {
        	$("#pwErr").text("");
        	return false;
        }
    }

    // 비밀번호 확인 필드가 변경될 때 함수 호출
    $("#check_password").on("input", validatePassword);

    
    // 수정 필요
// 	// 폼 제출 이벤트 핸들러
// 	$("form.join-form").submit(function (e) {
// 	    // 중복 검사, 유효성 검사
// 	    var isNicknameValid = checkNickname();
// 	    var isEmailValid = checkEmail();
// 	    var isIdValid = checkId();
// 	    var isPasswordValid = validatePassword();
	    
// 	    if (!isNicknameValid || !isEmailValid || !isIdValid || !isPasswordValid) {
// 	        e.preventDefault(); // 어떤 검사가 실패한 경우 폼 제출 방지
// 	        $("#signupErr").text("입력한 정보를 확인해주세요").css("color", "red");
// 	    } else {
// 	    	$("form.join-form").submit(); // 모든 검사가 성공한 경우 폼 제출
// 	    }
// 	});
</script>

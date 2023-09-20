<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <style>
        h3 {
            text-align: center;
        }
        form {
            border: 1px solid black;
            width: 300px;
            margin: 0 auto;
        }
        table {
            margin: 10px auto;
        }
        #left {
            font-weight: bold;
            text-align: center;
        }

        #right {
            padding-left: 10px;
        }

        p {
            margin: 10px auto;
            text-align: center;
        }

        #ok {
            padding: 0 30px 0 30px;
            background-color: lightgray;
            font-weight: bold;
        }
        

    </style>
</head>
<body>
    <div class="container">
        <h3>로그인</h3>

        <form action="login" method="post">
            <table>
                <tr>
                    <td id="left"><label for="memid">아이디</label></td>
                    <td id="right"><input type="text" name="memid" id="memid"></td>
                </tr>
                <tr>
                    <td id="left"><label for="password">비밀번호</label></td>
                    <td id="right"><input type="password" name="password" id="password"></td>
                </tr>  
            </table>
            <p><input type="submit" value="로그인"> </p>
        </form>
    </div>
</body>
</html>
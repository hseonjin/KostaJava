<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MVC게시판</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js""></script>
    <style>

        h3 {
            text-align: center;
        }

        table {
            margin: 0 auto;
            width: 800px;
            border: 1px solid black;
            border-bottom: none;
        }
        tbody {
            background: lightgrey;
            padding: 0;
        }

        #tbl_top {
            text-align: center;
            border: 1px solid black;
        }
    </style>
</head>

<body>
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
        </table> 
    </div>
</body>

</html>
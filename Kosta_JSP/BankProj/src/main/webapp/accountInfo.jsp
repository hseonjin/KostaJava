<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account" %>
<%
	Account acc = (Account) request.getAttribute("acc"); 
	// request.setAttribute("acc", acc)에서 "acc"으로 받아왔으니 get하는 것도 동일하게
%>
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
        

    </style>
</head>
<body>
    <div class="container">
        <h3>계좌조회</h3>

        <form action="">
            <table>
                <tr>
                    <td id="left"><label for="account">계좌번호</label></td>
                    <td id="right"><input type="text" name="id" id="id" value=<%=acc.getId() %>></td>
                </tr>
                <tr>
                    <td id="left"><label for="name">이름</label></td>
                    <td id="right"><input type="text" name="name" id="name"  value=<%=acc.getName() %> ></td>
                </tr>  
                <tr>
                    <td id="left"><label for="deposit">입금액</label></td>
                    <td id="right"><input type="text" name="money" id="money" value=<%=acc.getBalance() %>  ></td>
                </tr> 
                <tr>
                    <td id="left"><label for="cate">종류</label></td>
                    <td id="right"><input type="text" name="type" id="type" value=<%=acc.getType() %> ></td>
                </tr>  
                <tr>
                    <td id="left"><label for="grade">등급</label></td>
                    <td id="right"><input type="text" name="grade" id="grade" value=<%=acc.getGrade() %> ></td>
                </tr>  
            </table>
        </form>
    </div>
</body>
</html>
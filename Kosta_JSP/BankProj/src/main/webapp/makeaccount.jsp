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

        #makeAcc {
            padding: 0 30px 0 30px;
            background-color: lightgray;
            font-weight: bold;
        }

    </style>

    <script>
    // $(document).ready(function(){ // 아예 보이지 않게 만드는 설정
    //     $('#specialAcc').hide();	// 초깃값 설정
    //     $("input[name='grade']").change(function(){
    //         if($("input[name='grade']:checked").val() == '2'){
    //             $('#specialAcc').show();
    //         } else {
    //             $('#specialAcc').hide();
    //         }
    //     });
    // });
    $(function() { // 선택 불가능하게 만드는 설정
        $("select[name=grade]").attr("disabled", true); // 초기값
        $("input[name='type']").change(function(){
            var test = $("input[name='type']:checked").val();
            if(test=='normal'){
                $("select[name=grade]").attr("disabled", true);
                    // $('#grade').attr("disabled",true);
            } else {
                $("select[name=grade]").attr("disabled", false);
                //$('#grade').attr("disabled", false);
            }
        })
    });

    </script>
</head>
<body>
    <div class="container">
        <h3>계좌개설</h3>

        <form action="makeAccount" method="post">
            <table>
                <tr>
                    <td id="left"><label for="account">계좌번호</label></td>
                    <td id="right"><input type="text" name="id" id="id"></td>
                </tr>
                <tr>
                    <td id="left"><label for="name">이름</label></td>
                    <td id="right"><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td id="left"><label for="deposit">입급액</label></td>
                    <td id="right"><input type="text" name="money" id="money"></td>
                </tr>
                <tr>
                    <td id="left"><label for="cate">종류</label></td>
                    <td id="right">
                        <input type="radio" name="type" value="normal" checked>일반
                        <input type="radio" name="type" value="special">특수
                    </td>
                </tr>
                <tr id="specialAcc">
                    <td id="left"><label for="deposit">등급</label></td>
                    <td id="right">
                        <select name="grade" id="grade">
                            <option value="vip">VIP</option>
                            <option value="gold">GOLD</option>
                            <option value="silver">SILVER</option>
                            <option value="normal">NORMAL</option>
                        </select>                    
                    </td>
                </tr>    
            </table>
            <p><input type="submit" value="개설" id="makeAcc"></p>
        </form>
    </div>
</body>
</html>
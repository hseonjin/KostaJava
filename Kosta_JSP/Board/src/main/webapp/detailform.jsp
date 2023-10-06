<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판글상세</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js""></script>
    <script src=" jquery.lightbox-0.5.js"></script>
    <style>
        h2 {
            text-align: center;
        }

        table {
            margin: 0 auto;
            /* width: 450px; */
        }

        #left {
            width: 150px;
            background: orange;
        }

        #right {
            width: 300px;
            background: skyblue;
        }

        #btn {
            margin-top: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<jsp:include page="main.jsp"/>
    <div class="container">
        <h2>게시판글상세</h2>
        <form action="/boardmodify" method="post">
            <table>
                <tr>
                    <td id="left"><label for="writer">글쓴이</label></td>
                    <td id="right"><input type="text" name="writer" id="writer" readonly="readonly" value="${board.writer }"></td>
                </tr>
                <tr>
                    <td id="left"><label for="title">제 목</label></td>
                    <td id="right"><input type="text" name="title" id="title" readonly="readonly" value="${board.subject }"></td>
                </tr>
                <tr>
                    <td id="left"><label for="content">내 용</label></td>
                    <td><textarea id="content" name="content" cols="40" rows="15" readonly="readonly" >${board.content }</textarea></td>
                </tr>
                <c:if test="${board.fileurl ne null }">
                <tr>
                    <td id="left"><label for="writer">이미지</label></td>
                    <td><img src="image?file=${board.fileurl }" alt="" width="100" height="100" ></td>
                </tr>
                </c:if>
            </table>
        </form>
        <div id="btn">
        	<c:if test="${user.id eq board.writer }">
            	<a href="boardmodify?num=${board.num }">수정</a>&nbsp;&nbsp;
           	</c:if>
            <a href="boardlist">목록</a>
        </div>

    </div>
</body>

</html>
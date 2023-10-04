<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판글목록</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js""></script>
    <style>
        h3, h5 {
            text-align: center;
        }

        table {
            margin: 0 auto;
            width: 800px
        }

        #tbl_top {
            background: orange;
            text-align: center;
        }
        #emptyArea { margin: auto; width: 800px; text-align: center; }
    </style>

</head>

<body>
<jsp:include page="main.jsp"></jsp:include>
    <div class="container">
        <h3>글 목록 &nbsp; 
        <c:if test="${user ne Empty }">
        <a href="boardwrite">글쓰기</a>
        </c:if>
        </h3>
        
        <h5>
            <select name="type">
                <option value="subject">제목</option>
                <option value="writer">작성자</option>
                <option value="content">내용</option>
            </select>
            <input type="text" name="text" />
            <input type="submit" value="검색" />
        </h5>
        <table>
            <tr id="tbl_top">
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>날짜</th>
                <th>조회수</th>
                <th>삭제</th>
     
                <c:forEach items="${res.boardList }" var="board">
                	<tr>
                		<td>${board.num }</td>
                		<td><a href="boarddetail?num=${board.num }">${board.subject}</a></td>
                		<td>${board.writer }</td>
                		<td>${board.writedate }</td>
                		<td>${board.viewcount }</td>
                		<td>
	                		<c:if test="${user.id == board.writer }">
	                			<a href="boarddelete?num=${board.num }">삭제</a>
	                		</c:if>
                		</td>
                	</tr>
                
                </c:forEach>
        </table> 
        <div id="emptyArea">
        	<c:choose> 
        		<c:when test="${res.pageInfo.curPage>1}">
        			<a href="boardlist?page=${res.pageInfo.curPage-1}">&lt;</a>
       			</c:when>
       			<c:otherwise>
       				<a href="#">&lt;</a>
       			</c:otherwise>
        	</c:choose>
        	
        	<c:forEach begin="${res.pageInfo.startPage }" end="${res.pageInfo.endPage }" var="i">
        		<a href="boardlist?page=${i}">${i}</a>&nbsp;&nbsp;
        	</c:forEach>
        	
        	<c:choose> 
        		<c:when test="${res.pageInfo.curPage<res.pageInfo.allPage}">
        			<a href="boardlist?page=${res.pageInfo.curPage-1}">&gt;</a>
       			</c:when>
       			<c:otherwise>
       				<a href="#">&gt;</a>
       			</c:otherwise>
        	</c:choose>
        </div>
    </div>
</body>

</html>
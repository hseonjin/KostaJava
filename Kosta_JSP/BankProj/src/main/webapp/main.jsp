<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	String ipage = (String)request.getAttribute("page"); // page """"getAttribute"""" parameter가 아님
%>
    <% pageContext.include("header.jsp"); %>
    <table style="width:100%;">
<!--         <thead> -->
<!--             <tr> -->
<!--                 <td> -->
<%--                     <%@ include file = "header.jsp" %> --%>
<!--                 </td> -->
<!--             </tr> -->
<!--         </thead> -->
        <tbody>
            <tr>
                <td>
                	<% // 페이지가 존재할 때만 (!=null)일 때만 파라미터로 받아온 페이지(ipage의 값) 출력
                		if(ipage!=null) {
                			pageContext.include(ipage + ".jsp"); /* 가져올 페이지(header)의 확장자를 입력하지 않았기 때문에 + 해줌 */
                		}
                	%>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
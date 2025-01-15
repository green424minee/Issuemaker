<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area</title>
<style>
	.area-button {
		width: calc(15% - 10px); 
        margin: 5px;
        padding: 5px;
        font-size: 16px;
        cursor: pointer;
        border: 3px solid #ccc;
        border-radius: 5px;
        text-align: center;
        transition: background-color 0.3s, color 0.3s; /* 부드러운 전환 효과 */
	}
	.area-button:hover {
		border-color: #528f62; /* hover 시 테두리 색 변경 */
	}
</style>
</head>
<body>
    <h1>지역별</h1>
    <form action="/areaDetail" method="get">
		<div><c:forEach var="areaName" items="${areaName}">
			
	    	<input type="submit" class="area-button" name="area" value="${ areaName }">       
	    </c:forEach></div>
	</form>
</body>
</html>


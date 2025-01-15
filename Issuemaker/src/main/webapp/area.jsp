<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Area</title>
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h1>지역별</h1>
    <ul>
	    <c:forEach var="areaName" items="${area}">
	        <li>
	            <a href="/area?areaName=${areaName}">${areaName}</a>
	        </li>
	    </c:forEach>
	</ul>

</body>
</html>


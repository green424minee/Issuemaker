<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 선택</title>
</head>
<body>
	<h1>이력서 선택</h1>
	
	<form>
		<c:forEach var="resume" items="${ resume }">
			<p>${ resume.title }</p>
		</c:forEach>
	</form>
</body>
</html>
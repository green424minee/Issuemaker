<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 선택</title>
</head>
<body>
	<h1>이력서 선택</h1>
	<form method="post">
		<c:if test="${not empty resume}">
			<c:forEach var="resume" items="${resume}">
				<input type="radio" name="resumeNo" value="${ resume.no }">${resume.title}<br>
			</c:forEach>
			<input type="hidden" name="noticeNo" value="${ noticeNo }">
			<input type="submit" value="지원하기">
		</c:if>
		<c:if test="${empty resume}">
			<p>이력서가 없습니다.</p>
			<a href="/writeResume">이력서 작성</a>
		</c:if>
	</form>
</body>
</html>
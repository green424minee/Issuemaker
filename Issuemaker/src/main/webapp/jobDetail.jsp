<%@page import="search.JobService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <h1>${job} 공고</h1>
    <form>
		<c:forEach var="notice" items="${ noticeList }">
			<div>
				<a href="/noticeDetail?noticeNo=${ notice.no }">${ notice.title } ${notice.postDate} ~ ${ notice.deadLine }</a>
			</div>
		</c:forEach>
	</form>
   
</body>
</html>

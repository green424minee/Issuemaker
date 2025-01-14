<%@page import="myPage.Resume"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
	<form>
		<h2>나의 이력서</h2>
		<c:set var="count" value="0"/>
		<c:forEach var="resume" items="${resume}">
			<c:set var="count" value="${ count + 1 }"/>
       		<div>
            	<a href="/resume?resumeNo=${resume.no}">${count} ${resume.title} ${resume.postDate}</a>
       		</div>
    	</c:forEach>
	</form>
</body>
</html>
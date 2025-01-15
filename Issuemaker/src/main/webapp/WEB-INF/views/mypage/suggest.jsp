<%@page import="myPage.Resume"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
	<h2>받은 제안</h2>
	<c:if test="${ not empty sugList }">
		<c:forEach var="sug" items="${ sugList }">
			<p> ${ sug }</p>
			<form method="post">
				<input type="submit" value="공고 리스트">
				<input type="hidden" name = "comId" value="${ sug.getCompany() }">
			</form>
		</c:forEach>
		
	</c:if>
	<c:if test="${ empty sugList }">
		<label>받은 제안이 없습니다.</label>
	</c:if>
</body>
</html>

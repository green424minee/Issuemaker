<%@page import="matching.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="companyPageHeader.jsp" />
<!DOCTYPE html>
	<form>
		<h2>나의 공고</h2>
		<c:set var="count" value="0"/>
		<c:forEach var="notice" items="${notice}">
			<c:set var="count" value="${ count + 1 }"/>
       		<div>
            	<a href="/noticeDetail?noticeNo=${notice.no}">${count} ${notice.title} ${notice.postDate} ~ ${notice.deadLine}</a>
       		</div>
    	</c:forEach>
	</form>
	<form action="/noticeNew">
        <input type="submit" value="공고등록">
    </form>
</body>
</html>
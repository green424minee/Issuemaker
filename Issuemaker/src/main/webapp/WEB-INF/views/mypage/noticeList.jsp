<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
	<h2>지원 내역</h2>
	<form>
	<c:if test="${ not empty noticeList }">
		<c:forEach var="notice" items="${ noticeList }">
			<div>
			<%-- 공고 상세보기 --%>
			<a href="/noticeDetail?noticeNo=${ notice.no }">${notice.jobType} ${notice.getComName()} ${ notice.title } ${ notice.postDate }~${ notice.deadLine }</a> 
			<%-- 결과 --%>
			</div>
			<%-- 미열람 / 열람 (서류 검토중 / 합격 / 불합격) --%>
		
		</c:forEach>
	</c:if>
	<c:if test="${ empty noticeList }">
		<label>지원 내역이 없습니다.</label>
	</c:if>
	</form>
</body>
</html>
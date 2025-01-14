<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
	<form>
		<c:forEach var="notice" items="${ noticeList }">
			<div>
			<%-- 공고 상세보기 --%>
			<a href="/noticeDetail?noticeNo=${ notice.no }">${ notice.title } ${ notice.postDate }~${ notice.deadLine }</a> 
			<%-- 결과 --%>
			</div>
			<%-- 미열람 / 열람 (서류 검토중 / 합격 / 불합격) --%>
		
		</c:forEach>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
	<form>
		<c:forEach var="notice" items="${ noticeList }">
			<a href="#">${ notice.title } ${ notice.postDate }~${ notice.deadLine }</a>
			<%-- 공고 상세보기 --%>
		</c:forEach>
	</form>
</body>
</html>
<%@page import="myPage.Resume"%>
<%@page import="java.io.OutputStream"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="myPageHeader.jsp" />
	<form>
		<h2>${ resume.title }</h2>
		<p>
			<c:if test="${not empty photo}">
    			<img src="data:image/png;base64,${photo}" alt="이력서 사진"/>
			</c:if>
			<c:if test="${empty photo}">
    			<label>사진이 없습니다.</label>
			</c:if>
		</p>
		<p>이름 : ${ userName }</p>
		<p>경력
			<c:forEach var="his" items="${ history }">
				 <p>${ his }년</p>
			</c:forEach>
		</p>
		<p>최종 학력 : ${ school }	</p>
		<p>자격증 
			<c:forEach var="li" items="${ listLi }">
				<p>${ li }</p>
			</c:forEach>
		</p>
	</form>
	<a href="/userPage">홈으로 돌아가기</a>
</body>
</html>
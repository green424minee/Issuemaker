<%@page import="myPage.Resume"%>
<%@page import="java.io.OutputStream"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="myPageHeader.jsp" />
		<h2>${ resume.title }</h2>
		<p>
			<c:if test="${not empty photo}">
    			<img src="data:image/png;base64,${photo}" alt="이력서 사진"/>
			</c:if>
			<c:if test="${empty photo}">
    			<label>사진이 없습니다.</label>
			</c:if>
		</p>
		<p>${ userName } ${ user.userBirth }</p>
		<p>${ user.userPhone }</p>
		<p>${ user.userEmail }</p>
		<p>${ user.userAddress }</p>
		<hr>
		<p>희망 직무 : ${ type }</p>
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
			<%-- 자기소개서 다운로드 --%>
			<form action="/cover" method="GET">
			<label>자기소개서 </label>
				<input type="hidden" name="resumeNo" value="${ resume.no }">
				<input type="submit" value="다운로드">
				<p>${ errorcover }</p>
				<% session.removeAttribute("errorcover"); %>
			</form>

			<%-- 포트폴리오 다운로드 --%>
			<form action="/port" method="GET">
			<label>포트폴리오 </label>
				<input type="hidden" name="resumeNo" value="${ resume.no }">
				<input type="submit" value="다운로드">
				<p>${ errorport }</p>
				<% session.removeAttribute("errorport"); %>
			</form>

			<form method="post">
				<c:if test="${ currentUserId == resume.userId }">
					<input type="submit" name="action" value="삭제">
					<input type="hidden" name="no" value="${ resume.no }">
				</c:if>
			</form>
	<button onclick="window.history.back()">뒤로가기</button>
</body>
</html>
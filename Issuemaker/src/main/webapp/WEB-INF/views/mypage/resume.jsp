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
		<p>
			<%-- 자기소개서 보기 --%>
		</p>
		<p>
			<%-- 포트폴리오 보기 --%>
		</p>
	</form>
	<a href="#">수정</a>
	<a href="/userPage">목록으로 돌아가기</a>
</body>
</html>
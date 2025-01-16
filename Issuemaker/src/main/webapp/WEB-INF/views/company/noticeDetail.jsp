<%@page import="util.GetCookie"%>
<%@page import="matching.NoticeService"%>
<%@page import="member.Company"%>
<%@ page import="matching.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 상세보기</title>
</head>
<body>

<div class="notice-details">
	<form method="post">
		<c:set var="noticeNo" value="${notice.no}" scope="session" />
	    <div class="notice-header">
	        ${company.comName} / ${notice.title}
	    </div>
	    <div class="notice-info">
	        공고시작기간: ${notice.postDate} ~ 공고마감기간: ${notice.deadLine} <br>
	    </div>
    
    <div class="notice-info">
        경력: ${notice.exTermStr} <br>
        급여: ${notice.salaryStr} <br>
        학력: ${notice.schoolLevelStr}<br>
        전공: ${notice.major} <br>
        
    </div>
    <div class="notice-info">
        근무요일 ${notice.workday} <br>
        직무 ${notice.jobType} <br>
        근무지역 ${company.comAddress} <br>
        자격증
        <c:forEach var="list" items="${ liList }">
        	${ list }<br>
        </c:forEach>
    </div>
    	<%
		// 사용자 아이디 종류 확인
		GetCookie co = new GetCookie();
		request.setAttribute("type", co.getCookieUserType(request));
		%>
	<c:if test="${ type == 1 }">
    	<a href="/noticeSetting" class="button">수정</a>
	    <button type="button" class="button" onclick="window.history.back()">취소</button>
	</c:if>
	<c:if test="${ type != 1 }">
		<a href="/selectResume" class="button">지원하기</a>
	</c:if>
    </form>
</div>

<div class="notice-content">
    <h3>공고내용</h3>
    <p>${notice.context} </p>
</div>
</body>
</html>

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
	<form action="/noticeSetting">
	    <div class="notice-header">
	        ${company.comName} / ${notice.title}
	    </div>
	    <div class="notice-info">
	        공고시작기간: ${notice.postDate} ~ 공고마감기간: ${notice.deadLine} <br>
	    </div>
	    <input type="submit" value="수정">
	    <input type="hidden" name="no" value="${ notice.no }">
	    <button type="button" onclick="window.location.href='noticeSetting.jsp'">취소</button>
    </form>
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
</div>

<div class="notice-content">
    <h3>공고내용</h3>
    <p>${notice.context} </p>
</div>
<form method="post">
	<input type="hidden" name="no" value="${ notice.no }">
</form>
</body>
</html>

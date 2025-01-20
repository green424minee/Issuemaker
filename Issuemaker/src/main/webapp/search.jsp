<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
</head>
<body>
    <form action="search" method="get">
        <select name="findType">
            <option value="">검색유형</option>
            <option value="1">직업별</option>
            <option value="2">지역별</option> 
        </select>
        <input type="search" id="keyword" name="keyword" placeholder="검색어를 입력하세요">
        <input type="submit" value="검색">
    </form>

    <div>
        <h2>검색 결과</h2>

        <!-- 직업별 검색 결과 출력 -->
        <c:if test="${not empty jobNotices}">
            <h3>직업별 검색 결과</h3>
            <ul>
                <c:forEach var="notice" items="${jobNotices}">
                    <li>${notice.jobType}<br>
                    <a href="/noticeDetail?noticeNo=${ notice.no }">${notice.getComName()} ${ notice.title } ${ notice.postDate }~${ notice.deadLine }</a> 
                    </li> 
                </c:forEach>
            </ul>
        </c:if>

        <!-- 지역별 검색 결과 출력 -->
        <c:if test="${not empty areaNotices}">
            <h3>지역별 검색 결과</h3>
            <ul>
                <c:forEach var="notice" items="${areaNotices}">
                    <li>
                    <a href="/noticeDetail?noticeNo=${ notice.no }">${ notice.jobType } ${notice.getComName()} ${ notice.title } ${notice.postDate} ~ ${notice.deadLine}</a>
                    </li> 
                </c:forEach>
            </ul>
        </c:if>

        <!-- 검색 결과가 없는 경우 출력 -->
        <c:if test="${empty jobNotices and empty areaNotices}">
            <p>검색 결과가 없습니다.</p>
        </c:if>
    </div>
</body>
</html>
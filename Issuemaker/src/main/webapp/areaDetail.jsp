<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${areaName} 해당지역 공고</title>
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h1>${areaName} 해당지역 공고</h1>
    
    <c:choose>
        <c:when test="${not empty notice}">
            <ul>
                <c:forEach var="notice" items="${notice}">
                    <c:if test="${fn:substring(notice.comAddress, 0, 2) == fn:substring(areaName, 0, 2)}">
                        <li>
                            <a href="/noticeDetail?noticeNo=${notice.no}">${fn:escapeXml(notice.title)} ${notice.postDate} ${notice.deadLine}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </c:when>
        <c:otherwise>
            <p>해당 지역에 공고가 없습니다.</p>
        </c:otherwise>
    </c:choose>
    
    <a href="/area">다른 지역 보기</a>
</body>
</html>

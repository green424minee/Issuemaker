<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>지원 내역</title>
    <style>
        table {
            width: 800px;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>지원 내역</h2>
    <form>
        <c:if test="${ not empty list }">
            <table>
                <thead>
                    <tr>
                        <th>직무 유형</th>
                        <th>회사 이름</th>
                        <th>공고</th>
                        <th>마감일</th>
                        <th>지원일</th>
                        <th>결과</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="list" items="${ list }">
                        <tr>
                            <td>${ list.getNoticeDetail().jobType }</td>
                            <td>${ list.getNoticeDetail().getComName() }</td>
                            <td><a href="/noticeDetail?noticeNo=${ list.getNoticeDetail().no }">${ list.getNoticeDetail().title }</a></td>
                            <td>${ list.getNoticeDetail().deadLine }</td>
                            <td>${ list.applicationDate }</td>
                            <td>${ list.strResult() }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${ empty list }">
            <label>지원 내역이 없습니다.</label>
        </c:if>
    </form>
</body>
</html>

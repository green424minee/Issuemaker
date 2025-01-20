<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>지원 내역</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #7DA5E1;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            color: #4a6a9a;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .no-data {
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
            color: #777;
        }
    </style>
</head>
<body>
<h2>지원 내역</h2>
    <div class="container">
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
                    <c:forEach var="item" items="${ list }">
                        <tr>
                            <td>${ item.getNoticeDetail().jobType }</td>
                            <td>${ item.getNoticeDetail().getComName() }</td>
                            <td><a href="/noticeDetail?noticeNo=${ item.getNoticeDetail().no }">${ item.getNoticeDetail().title }</a></td>
                            <td>${ item.getNoticeDetail().deadLine }</td>
                            <td>${ item.applicationDate }</td>
                            <td>${ item.strResult() }</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${ empty list }">
            <div class="no-data">지원 내역이 없습니다.</div>
        </c:if>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공지사항</title>
    <link href="/css/main.css" rel="stylesheet">
    <style>
        body {
            background-color: #f9f9f9;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 20px;
        }
        .content {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            margin: 20px;
        }
        .card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 15px;
            width: 300px;
            transition: transform 0.2s;
        }
        .card:hover {
            transform: scale(1.05);
        }
        .card-title {
            font-size: 1.2em;
            margin-bottom: 10px;
            color: #007bff;
        }
        .card-title a {
            text-decoration: none;
            font-weight: 700;
            color: #6482B9;
        }
        .card-company, .card-date, .card-deadline {
            font-size: 0.9em;
            color: #555;
        }
        .card-date, .card-deadline {
            margin-top: 5px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #218838; /* 호버 시 배경색 변경 */
        }
    </style>
</head>
<body>
    <c:set var="count" value="0"/>
    <div class="content">
        <c:forEach var="notice" items="${notice}">
            <c:set var="count" value="${count + 1}"/>
            <div class="card">
                <div class="card-title">
                    <a class="card-link" href="/noticeDetail?noticeNo=${notice.no}">${count}. ${notice.title}</a>
                </div>
                <div class="card-company">${notice.getComName()}</div>
                <div class="card-date">게시일: ${notice.postDate}</div>
                <div class="card-deadline">마감일: ${notice.deadLine}</div>
            </div>
        </c:forEach>
    </div>
</body>
</html>

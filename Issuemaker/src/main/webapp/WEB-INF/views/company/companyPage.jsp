<%@page import="matching.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="companyPageHeader.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>나의 공고</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: black;
            margin-bottom: 20px;
        }
        .notice-list {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 0 auto;
            max-width: 600px;
        }
        .notice-item {
            padding: 10px;
            border-bottom: 1px solid #e0e0e0;
            transition: background-color 0.3s;
        }
        .notice-item:last-child {
            border-bottom: none; /* 마지막 항목의 경계선 제거 */
        }
        .notice-item:hover {
            background-color: #f0f8ff; /* 호버 시 배경색 변경 */
        }
        .notice-link {
            text-decoration: none;
            color: #333;
            font-size: 16px;
        }
        .notice-link:hover {
            color: #007BFF; /* 호버 시 글자색 변경 */
        }
        .submit-button {
            display: inline-block;
            padding: 5px 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
            transition: background-color 0.3s;
        }
        .submit-button:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
        .button-container {
            text-align: center; /* 버튼을 중앙 정렬 */
            margin-top: 20px; /* 위쪽 여백 추가 */
        }
    </style>
</head>
<body>
    <form>
        <h2>나의 공고</h2>
        <div class="notice-list">
            <c:set var="count" value="0"/>
            <c:forEach var="notice" items="${notice}">
                <c:set var="count" value="${count + 1}"/>
                <div class="notice-item">
                    <a class="notice-link" href="/noticeDetail?noticeNo=${notice.no}">
                        ${count} ${notice.title} ${notice.postDate} ~ ${notice.deadLine}
                    </a>
                </div>
            </c:forEach>
        </div>
    </form>
    <div class="button-container">
    <form action="/noticeNew">
        <input type="submit" value="공고등록" class="submit-button">
    </form>
    </div>
</body>
</html>

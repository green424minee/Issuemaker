<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>${area} 공고</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f9f9f9;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .notice-container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        a {
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        .btn {
            display: block;
            margin: 20px auto;
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .title {
            font-weight: 700;
        }
    </style>
</head>
<body>
    <h1>${area}</h1>
    <div class="notice-container">
        <table>
            <thead>
                <tr>
                    <th scope="col">직무 유형</th>
                    <th scope="col">회사명</th>
                    <th scope="col" class="title">제목</th>
                    <th scope="col">게시일</th>
                    <th scope="col">마감일</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty noticeList}">
                    <c:forEach var="notice" items="${noticeList}">
                        <tr>
                            <td>${notice.jobType}</td>
                            <td>${notice.getComName()}</td>
                            <td><a href="/noticeDetail?noticeNo=${notice.no}">${notice.title}</a></td>
                            <td>${notice.postDate}</td>
                            <td>${notice.deadLine}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty noticeList}">
                    <tr>
                        <td colspan="5">게시된 공고가 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
        <button class="btn" onclick="history.back()" aria-label="이전 페이지로 돌아가기">뒤로가기</button>
    </div>
</body>
</html>

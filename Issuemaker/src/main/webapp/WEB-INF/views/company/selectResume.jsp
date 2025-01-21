<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>이력서 선택</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .resume-option {
            display: flex;
            align-items: center;
            margin: 10px 0;
        }
        input[type="radio"] {
            margin-right: 10px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
            font-weight: bold;
            margin-top: 20px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007BFF;
            text-decoration: none;
        }
        .link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>이력서 선택</h1>
        <form method="post">
            <c:if test="${not empty resume}">
                <c:forEach var="resume" items="${resume}">
                    <div class="resume-option">
                        <input type="radio" name="resumeNo" value="${resume.no}" id="resume${resume.no}">
                        <label for="resume${resume.no}">${resume.title}</label>
                    </div>
                </c:forEach>
                <input type="hidden" name="noticeNo" value="${noticeNo}">
                <input type="submit" class="btn" value="지원하기">
            </c:if>
            <c:if test="${empty resume}">
                <p>이력서가 없습니다.</p>
                <a class="link" href="/writeResume">이력서 작성</a>
            </c:if>
        </form>
    </div>
</body>
</html>

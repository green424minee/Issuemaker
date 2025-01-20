<%@page import="matching.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="companyPageHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>합격자 관리</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%; /* 전체 너비 사용 */
            max-width: 1000px; /* 최대 너비 설정 */
            border-collapse: collapse;
            margin: 20px auto; /* 중앙 정렬 */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
            background-color: white; /* 배경색 */
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px; /* 패딩 증가 */
            text-align: left;
            max-width: 200px; /* 최대 너비 설정 */
            overflow: hidden; /* 넘치는 내용 숨기기 */
            text-overflow: ellipsis; /* 생략 기호 추가 */
            white-space: nowrap; /* 줄 바꿈 방지 */
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f1f1f1; /* 마우스 오버 시 배경색 변경 */
        }
        a {
            color: #007bff; /* 링크 색상 */
            text-decoration: none; /* 밑줄 제거 */
        }
        a:hover {
            text-decoration: underline; /* 마우스 오버 시 밑줄 추가 */
        }
    </style>
</head>
<body>
    <h2>합격자 관리</h2>
    <table>
        <thead>
            <tr>
                <th>직무 유형</th>
                <th>이름</th>
                <th>생년월일</th>
                <th>전화번호</th>
                <th>이메일</th>
                <th>합격일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="apply" items="${apply}">
                <tr>
                    <td>${apply.getResumeDetail().jobType}</td>
                    <td>${apply.getResumeDetail().getUser().userName}</td>
                    <td>${apply.getResumeDetail().getUser().userBirth}</td>
                    <td>${apply.getResumeDetail().getUser().userPhone}</td>
                    <td>${apply.getResumeDetail().getUser().userEmail}</td>
                    <td>${apply.passingDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

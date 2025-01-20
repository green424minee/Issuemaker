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
        table {
            width: 1000px;
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

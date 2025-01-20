<%@page import="matching.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="companyPageHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
    <title>지원자 관리</title>
    <style>
        table {
            width: 900px; /* 고정된 너비 설정 */
            border-collapse: collapse;
            table-layout: fixed; /* 고정된 레이아웃 */
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            max-width: 100px; /* 최대 너비 설정 */
            overflow: hidden; /* 넘치는 내용 숨기기 */
            text-overflow: ellipsis; /* 생략 기호 추가 */
            white-space: nowrap; /* 줄 바꿈 방지 */
        }
        th {
            background-color: #f2f2f2;
            text-align: center;
        }
        tr:hover {
            background-color: #f1f1f1;
            text-align: left; /* 왼쪽 정렬 */
        }
    </style>
</head>
<body>
    <h2>지원자 관리</h2>
    <table>
        <thead>
            <tr>
                <th>공고명</th>
                <th>직무</th>
                <th>이력서</th>
                <th>지원 날짜</th>
                <th>결과</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="notice" items="${ notice }">
                <tr>
                    <td>${ notice.getNoticeDetail().title }</td>
                    <td>${ notice.getNoticeDetail().jobType }</td>
                    <td><a href="/resume?resumeNo=${notice.resume}">${ notice.getResumeDetail().title }</a></td>
                    <td>${ notice.applicationDate }</td>
                    <td>
                    	<c:if test="${ notice.result == 0 }">
                    		<a href="/accepted?notice=${notice.notice}&resume=${notice.resume}">합격</a> / 
                    		<a href="/rejected?notice=${notice.notice}&resume=${notice.resume}">불합격</a>
                    	</c:if>
                    	<c:if test="${ notice. result != 0 }">
	                    	<c:if test="${ notice.result == 1 }">
	                    		합격
	                    	</c:if>
	                    	<c:if test="${ notice.result == 2 }">
	                    		불합격
	                    	</c:if>
                    	</c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

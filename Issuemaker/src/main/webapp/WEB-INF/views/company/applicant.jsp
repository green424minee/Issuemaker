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
            max-width: 900px; /* 최대 너비 설정 */
            border-collapse: collapse;
            margin: 20px auto; /* 중앙 정렬 */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
            background-color: white; /* 배경색 */
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px; /* 패딩 증가 */
            max-width: 100px; /* 최대 너비 설정 */
            overflow: hidden; /* 넘치는 내용 숨기기 */
            text-overflow: ellipsis; /* 생략 기호 추가 */
            white-space: nowrap; /* 줄 바꿈 방지 */
            text-align: center; /* 중앙 정렬 */
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
            min-width: 120px; /* 최소 너비 설정 */
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
        .result-links {
            display: flex;
            justify-content: center; /* 중앙 정렬 */
            gap: 10px; /* 버튼 간격 */
        }
        .result-links a {
            padding: 5px 10px; /* 버튼 패딩 */
            border: 1px solid #007bff; /* 테두리 색상 */
            border-radius: 4px; /* 모서리 둥글게 */
            background-color: white; /* 배경색 */
            color: #007bff; /* 텍스트 색상 */
            transition: background-color 0.3s, color 0.3s; /* 부드러운 전환 효과 */
        }
        .result-links a:hover {
            background-color: #007bff; /* 마우스 오버 시 배경색 변경 */
            color: white; /* 마우스 오버 시 텍스트 색상 변경 */
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
                    		<div class="result-links">
                    			<a href="/accepted?notice=${notice.notice}&resume=${notice.resume}">합격</a>
                    			<a href="/rejected?notice=${notice.notice}&resume=${notice.resume}">불합격</a>
                    		</div>
                    	</c:if>
                    	<c:if test="${ notice.result != 0 }">
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

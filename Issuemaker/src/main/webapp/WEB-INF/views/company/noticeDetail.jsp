<%@page import="matching.ApplyService"%>
<%@page import="util.GetCookie"%>
<%@page import="matching.NoticeService"%>
<%@page import="member.Company"%>
<%@ page import="matching.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공고 상세보기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .notice-details {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }
        .notice-header {
            font-size: 20px;
            font-weight: bold;
            color: #333;
            margin-bottom: 10px;
        }
        .notice-info {
            margin-bottom: 15px;
            color: #555;
        }
        .notice-info p {
            margin: 0; /* 기본 마진 제거 */
            display: inline; /* 인라인으로 표시하여 빈틈 없애기 */
        }
        .button {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            text-decoration: none;
            margin-right: 10px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
        .notice-content {
            background-color: #f9f9f9;
            border-radius: 8px;
            padding: 15px;
            margin-top: 20px;
        }
        hr {
            border: 1px solid #e0e0e0;
            margin: 20px 0;
        }
        .back-button {
            background-color: #6c757d;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .back-button:hover {
            background-color: #5a6268; /* 호버 시 배경색 변경 */
        }
    </style>
</head>
<body>

<div class="notice-details">
    <form method="post">
        <c:set var="noticeNo" value="${notice.no}" scope="session" />
        <div class="notice-header">
            ${company.comName} / ${notice.title} <br>
            연락처: ${company.comPhone} 담당자: ${company.managerEmail} <br>
            위치: ${company.comAddress} ${' '} ${company.otherAddress} 사원수: ${company.comSize} <br>
            사이트: ${company.comWeb}
        </div>
    
        <div class="notice-info">
            공고시작기간: ${notice.postDate} ~ 공고마감기간: ${notice.deadLine} <br>
        </div>
        
        <hr>
    
        <div class="notice-info">
            경력: ${notice.getExTermStr()} <br>
            급여: ${notice.getSalaryStr()} <br>
            학력: ${notice.getSchoolLevelStr()}<br>
            전공: ${notice.major} <br>
        </div>
        <div class="notice-info">
            근무요일: ${notice.workday} <br>
            직무: ${notice.jobType} <br>
            근무지역: ${company.comAddress} <br>
            자격증:
            <c:forEach var="license" items="${licenses}">
                <p>${license}</p>
            </c:forEach>
        </div>

        <c:if test="${ currentComId == notice.comId }">
            <a href="/noticeSetting?no=${notice.no}" class="button">수정</a>
            <button type="button" class="button" onclick="window.history.back()">취소</button>
        </c:if>
        
        <%
            // 사용자 아이디 종류 확인
            GetCookie co = GetCookie.getInstance();
            request.setAttribute("type", co.getCookieUserType(request));
            request.setAttribute("user", co.getCookieUserId(request));
        %>
        <c:if test="${ type == 0 || empty type }">
            <a href="/selectResume?noticeNo=${notice.no}" class="button">지원하기</a>
        </c:if>
        <c:if test="${ check }">
            <a href="/cancelApply?noticeNo=${notice.no}" class="button">지원 취소</a>
        </c:if>
    </form>
</div>

<hr>

<div class="notice-content">
    <p>${notice.context}</p>
    
    <hr>
    
    사업자등록번호: ${company.comNo} 대표자: ${company.comCeo} <br>
    개설일자: ${company.comBirth}
</div>
<button type="button" class="back-button" onclick="window.history.back()">리스트로 돌아가기</button>
</body>
</html>

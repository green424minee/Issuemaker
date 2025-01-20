<%@page import="matching.ApplyService"%>
<%@page import="util.GetCookie"%>
<%@page import="matching.NoticeService"%>
<%@page import="member.Company"%>
<%@ page import="matching.Notice" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공고 상세보기</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        .card {
            background: #fff;
            max-width: 600px;
            margin: 0 auto;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 10px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        a.button, button.button {
            background-color: #6482B9;
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            border-radius: 5px;
            margin: 5px;
            display: inline-block;
            border: none;
        }
        a.button:hover, button.button:hover {
            background-color: #4a6a9a;
        }
        hr {
            margin: 20px 0;
        }
        .notice-content {
            background: #f9f9f9;
            padding: 15px;
            border-radius: 5px;
        }
    	.centered-title {
        	text-align: center; /* 텍스트를 중앙 정렬 */
        	margin: 20px 0; /* 위아래 여백 추가 */
    	}
    </style>
</head>
<body>
<div class="centered-title"><h2>${ notice.title }</h2></div>
<div class="card notice-details">
    <form method="post">
        <c:set var="noticeNo" value="${notice.no}" scope="session" />
        <table>
            <thead>
                <tr>
                    <th colspan="2">${company.comName} </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>연락처</td>
                    <td>${company.comPhone}</td>
                </tr>
                <tr>
                    <td>담당자</td>
                    <td>${company.managerEmail}</td>
                </tr>
                <tr>
                    <td>위치</td>
                    <td>${company.comAddress} ${' '} ${company.otherAddress}</td>
                </tr>
                <tr>
                    <td>사원수</td>
                    <td>${company.comSize}</td>
                </tr>
                <tr>
                    <td>사이트</td>
                    <td><a href="${company.comWeb}" target="_blank">${company.comWeb}</a></td>
                </tr>
                <tr>
                    <td>공고 기간</td>
                    <td>${notice.postDate} ~ ${notice.deadLine}</td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<div class="card">
    <table>
        <thead>
            <tr>
                <th>경력</th>
                <th>급여</th>
                <th>학력</th>
                <th>전공</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${notice.getExTermStr()}</td>
                <td>${notice.getSalaryStr()}</td>
                <td>${notice.getSchoolLevelStr()}</td>
                <td>${notice.major}</td>
            </tr>
        </tbody>
    </table>
    <table>
        <thead>
            <tr>
                <th>근무요일</th>
                <th>직무</th>
                <th>근무지역</th>
                <th>자격증</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${notice.workday}</td>
                <td>${notice.jobType}</td>
                <td>${company.comAddress}</td>
                <td>
                    <c:forEach var="license" items="${licenses}">
                        <p>${license}</p>
                    </c:forEach>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<div class="card notice-content">
    <p>${notice.context}</p>
    <hr>
    <p>사업자등록번호 : ${company.comNo} <br> 대표자 : ${company.comCeo} <br>
    설립일 : ${company.comBirth }</p>
</div>

<c:if test="${ currentComId == notice.comId }">
    <div class="card">
        <a href="/noticeSetting?no=${notice.no}" class="button">수정</a>
        <button type="button" class="button" onclick="window.history.back()">취소</button>
    </div>
</c:if>

<div class="card">
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
    <button type="button" onclick="window.history.back()" class="button">리스트로 돌아가기</button>
</div>

</body>
</html>

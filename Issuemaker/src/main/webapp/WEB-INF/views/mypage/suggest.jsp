<%@page import="myPage.Resume"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="myPageHeader.jsp" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>받은 제안</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 20px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        .suggestion {
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin: 10px 0;
            background-color: #fdfdfd;
        }
        .no-data {
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
            color: #777;
        }
        input[type="submit"] {
            background-color: #6482B9; /* 버튼 배경색 */
            color: white; /* 버튼 텍스트 색상 */
            border: none;
            padding: 10px 20px; /* 버튼 패딩 */
            border-radius: 5px; /* 모서리 둥글게 */
            cursor: pointer; /* 마우스 커서 변경 */
            text-align: center; /* 텍스트 중앙 정렬 */
            text-decoration: none; /* 링크 밑줄 제거 */
            transition: background-color 0.3s; /* 호버 애니메이션 */
            margin-left: 10px; /* 버튼 간격 */
        }
        input[type="submit"]:hover {
            background-color: #4a6a9a;
        }
    </style>
</head>
<body>
	<div><h2>받은 제안</h2></div>
    <div class="container">
        
        <c:if test="${ not empty sugList }">
            <c:forEach var="sug" items="${ sugList }">
                <div class="suggestion">
                    <p>${ sug }</p>
                    <form method="post">
                        <input type="hidden" name="comId" value="${ sug.getCompany() }">
                        <input type="submit" value="공고 리스트">
                    </form>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${ empty sugList }">
            <div class="no-data">받은 제안이 없습니다.</div>
        </c:if>
    </div>
</body>
</html>

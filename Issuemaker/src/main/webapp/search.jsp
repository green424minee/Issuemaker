<%@page import="matching.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
 <style>
    	.link {
    		margin-right: 8em;  /* 오른쪽 여백 8em */
    	}
    	.logout-button {
    		padding: 10px 0;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    	}
    	.title {
    		flex-grow: 1;
    		text-align: center;
    	}
    	.logout {
    		background-color: #ffd677;
    		border: none;
    		padding: 10px 20px;
    		cursor: pointer;
    		transition: background-color 0.3s;
    	}
    	.class {
    		padding: 10px 0;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    	}
    </style>
</head>
<body>
<a href="/">
		<img src="${pageContext.request.contextPath}/images/logo.png" class="logo" alt="로고" />
	</a>
	<%
		// 쿠키 확인
		NoticeService ser = NoticeService.getInstance();
		int check = 0;
		boolean isLogIn = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("user".equals(c.getName())) {
					isLogIn = true;
					check = ser.getType(c.getValue());
					break;
				} 
			}
		} 
		request.setAttribute("check", check);
		request.setAttribute("isLogIn", isLogIn);
	%>
		<c:if test="${ !isLogIn }">
			<form class="login-button" action="/login">
	    		<input type="submit" value="로그인" class="login"> <%-- 메인 화면으로- --%>
	    	</form>
    	</c:if>
		<c:if test="${isLogIn}">
   			<form class="logout-button" action="/logout">
        		<input type="submit" value="로그아웃" class="logout">
    		</form>
    		<form action="${check == 0 ? '/userPage' : '/companyPage'}">
        		<input type="submit" value="마이페이지">
    		</form>
    		</c:if>
    <form action="search" method="get">
        <select name="findType">
            <option value="">검색유형</option>
            <option value="1">직업별</option>
            <option value="2">지역별</option> 
        </select>
        <input type="search" id="keyword" name="keyword" placeholder="검색어를 입력하세요">
        <input type="submit" value="검색">
    </form>

    <div>
        <h2>검색 결과</h2>

        <!-- 직업별 검색 결과 출력 -->
        <c:if test="${not empty jobNotices}">
            <h3>직업별 검색 결과</h3>
            <ul>
                <c:forEach var="notice" items="${jobNotices}">
                    <li>${notice.jobType}<br>
                    <a href="/noticeDetail?noticeNo=${ notice.no }">${notice.getComName()} ${ notice.title } ${ notice.postDate }~${ notice.deadLine }</a> 
                    </li> 
                </c:forEach>
            </ul>
        </c:if>

        <!-- 지역별 검색 결과 출력 -->
        <c:if test="${not empty areaNotices}">
            <h3>지역별 검색 결과</h3>
            <ul>
                <c:forEach var="notice" items="${areaNotices}">
                    <li>
                    <a href="/noticeDetail?noticeNo=${ notice.no }">${ notice.jobType } ${notice.getComName()} ${ notice.title } ${notice.postDate} ~ ${notice.deadLine}</a>
                    </li> 
                </c:forEach>
            </ul>
        </c:if>

        <!-- 검색 결과가 없는 경우 출력 -->
        <c:if test="${empty jobNotices and empty areaNotices}">
            <p>검색 결과가 없습니다.</p>
        </c:if>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp -->
<html>
<head>
    <title>시작페이지</title>
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
    </style>
</head>
<body>
	<header>
	<img src="${pageContext.request.contextPath}/images/logo.png" alt="로고" />
		<form class="login-button" action="/login" method="post">
    		<input type="submit" value="개인회원 로그인" class="login"> <%-- 메인 화면으로- --%>
    	</form>
    	<form class="login-button" action="/login" method="post">
    		<input type="submit" value="기업으로 전환" class="login" > <%-- 메인 화면으로- --%>
    	</form>
        <nav>
            <a href="/index" class="link">채용정보</a>
            <a href="/area" class="link">지역별</a>
            <a href="/job" class="link">직업별</a>
        </nav>
    </header>

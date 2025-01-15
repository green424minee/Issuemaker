<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp -->
<html>
<head>
    <title>마이페이지</title>
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
		<form class="logout-button" action="/logout" >
			<h1 class="title">마이페이지</h1>
    		<input type="submit" value="로그아웃" class="logout"> <%-- 메인 화면으로- --%>
    	</form>
        <nav>
            <a href="/userPage" class="link">이력서 관리</a>
            <a href="/noticeList" class="link">지원 내역</a>
            <a href="/suggest" class="link">받은 제안</a>
            <a href="#" class="link">스크랩/관심 기업</a>
        </nav>
    </header>

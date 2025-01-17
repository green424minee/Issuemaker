<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp -->
<html>
<head>
    <title>공고관리</title>
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
		<a href="/">
			<img src="${pageContext.request.contextPath}/images/logo.png" alt="로고" />
		</a>
		<form class="logout-button" action="/logout" >
			<h1 class="title">기업</h1>
			<a href="/changeCompanyInfo">기업정보 수정</a>
    		<input type="submit" value="로그아웃" class="logout"> <%-- 메인 화면으로- --%>
    	</form>
        <nav>
            <a href="/companyPage" class="link">공고관리</a>
            
        </nav>
    </header>

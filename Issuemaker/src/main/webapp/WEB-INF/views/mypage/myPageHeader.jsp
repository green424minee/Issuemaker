<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header.jsp -->
<html>
<head>
    <title>마이페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #f4f4f4; /* 헤더 배경색 */
            display: flex;
            align-items: center; /* 수직 정렬 */
            padding: 10px 20px;
        }
        .logo {
            height: 50px; /* 로고 크기 조정 */
            margin-right: 20px; /* 로고와 제목 간격 */
        }
        .title {
            flex-grow: 1; /* 제목이 남은 공간을 차지하도록 */
            text-align: center; /* 제목 중앙 정렬 */
        }
        .logout-button {
            display: flex;
            align-items: center;
        }
        .logout, .user {
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
        .logout:hover, .user:hover {
            background-color: #4a6a9a; /* 호버 시 색상 변경 */
        }
        .link {
            margin: 0 15px; /* 링크 간격 조정 */
            text-decoration: none; /* 링크 밑줄 제거 */
            color: black; /* 링크 색상 */
        }
        .link:hover {
            text-decoration: underline; /* 호버 시 밑줄 추가 */
        }
        nav {
            display: flex; /* 가로 배치 */
            margin-left: auto; /* 우측 정렬 */
        }
    </style>
</head>
<body>
    <header>
        <a href="/">
            <img src="${pageContext.request.contextPath}/images/logo.png" alt="로고" class="logo" />
        </a>
        <h1 class="title">마이페이지</h1>
        <nav>
            <a href="/userPage" class="link">이력서 관리</a>
            <a href="/noticeList" class="link">지원 내역</a>
            <a href="/suggest" class="link">받은 제안</a>
        </nav>
        <form class="logout-button" action="/logout">
            <a href="/changeUserInfo" class="user">회원정보 수정</a>
            <input type="submit" value="로그아웃" class="logout"> 
        </form>
    </header>
</body>
</html>

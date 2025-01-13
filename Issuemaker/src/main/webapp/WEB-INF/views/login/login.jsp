<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div><h2>로그인</h2></div>
	<p>${ error }</p>
	<form method="post">
		<label for="id">아이디</label>
		<input type="text" id="id" name="id">
		<br>
		<label for="pw">비밀번호</label>
		<input type="password" id="pw" name="pw">
		<br>
		<input type="submit" value="로그인">
	</form>
	<form action="/join">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>
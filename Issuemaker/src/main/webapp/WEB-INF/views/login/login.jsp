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
		<label><input type="radio" name="type" value="0">개인</label>
		<label><input type="radio" name="type" value="1">기업</label>
		<br>
		<label for="id">아이디</label>
		<input type="text" id="id" name="id" required>
		<br>
		<label for="pw">비밀번호</label>
		<input type="password" id="pw" name="pw" required>
		<br>
		<input type="submit" value="로그인">
	</form>
	<form action="/join">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>
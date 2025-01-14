<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 회원가입</title>


</head>
<body>
	<p>${ errorMessage }</p>
	<form method="post">
	
	    <label for="userId">아이디:</label>
	    <input type="text" id="userId" name="userId" required>
	    
	    <label for="userPw">비밀번호:</label>
	    <input type="password" id="userPw" name="userPw" required>
	
	    <label for="userPwOK">비밀번호 확인:</label>
	    <input type="password" id="userPwOK" name="userPwOK" required>
	
	    <label for="userName">이름:</label>
	    <input type="text" id="userName" name="userName" required>
	
	    <label for="userBirth">생년월일:</label>
	    <input type="date" id="userBirth" name="userBirth" required>
	
	    <label for="userPhone">전화번호:</label>
	    <input type="tel" id="userPhone" name="userPhone" required>
	
	    <label for="userEmail">이메일:</label>
	    <input type="email" id="userEmail" name="userEmail" required>
	
	    <label for="userAddress">주소:</label>
	    <input type="text" id="userAddress" name="userAddress" required>
	
	    <input type="submit" value="가입하기">
	</form>
</body>
</html>
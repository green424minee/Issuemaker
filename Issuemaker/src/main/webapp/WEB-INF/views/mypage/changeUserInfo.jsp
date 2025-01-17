<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<p>${ errorMessage }</p>
	<form method="post">    
	    <label for="userPw">비밀번호:</label>
	    <input type="password" id="userPw" name="userPw" required>
	
	    <label for="userPwOK">비밀번호 확인:</label>
	    <input type="password" id="userPwOK" name="userPwOK" required>
	
	    <label for="userName">이름:</label>
	    <input type="text" id="userName" name="userName" value="${ userInfo.getUserName() }" requeired>
	
	    <label for="userBirth">생년월일:</label>
	    <input type="date" id="userBirth" name="userBirth" value="${ userInfo.getUserBirth() }" required>
	
	    <label for="userPhone">전화번호:</label>
	    <input type="tel" id="userPhone" name="userPhone" value="${ userInfo.getUserPhone() }" required>
	
	    <label for="userEmail">이메일:</label>
	    <input type="email" id="userEmail" name="userEmail" value="${ userInfo.getUserEmail() }" required>
	
	    <label for="userAddress">주소:</label>
	    <input type="text" id="userAddress" name="userAddress" value="${ userInfo.getUserAddress() }" required>
	
	    <input type="submit" value="수정하기">
	</form>
</body>
</html>
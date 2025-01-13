<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 회원가입</title>
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
	<form method="post">
    <h1>기업 회원가입</h1>
    
    <div>
        <label for="comId">아이디</label>
        <input type="text" name="comId" id="comId"><br>
    </div>
    
    <div>
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw"><br>
    </div>
    
    <div>
        <label for="pwAgain">비밀번호 확인:</label>
        <input type="password" name="pwAgain" id="pwAgain"><br>
    </div>
    
    <div>
        <label for="comName">기업명</label>
        <input type="text" name="comName" id="comName"><br>
    </div>
    
    <div>
        <label for="comNo">사업자 등록번호</label>
        <input type="text" name="comNo" id="comNo"><br>
    </div>
    
    <div>
        <label for="comPhone">전화번호</label>
        <input type="text" name="comPhone" id="comPhone"><br>
    </div>
    
    <div>
        <label for="comCeo">대표자 이름</label>
        <input type="text" name="comCeo" id="comCeo"><br>
    </div>
    
    <div>
        <label for="managerEmail">담당자 이메일</label>
        <input type="text" name="managerEmail" id="managerEmail"><br>
    </div>
    
    <div>
        <label for="comAddress">주소</label>
        <input type="text" name="comAddress" id="comAddress"><br>
    </div>
    
    <div>
    	<label for="comBirth">설립일</label>
    	<input type="date" name="comBirth" id="comBirth"><br>
    </div>
    
    <div>
    	<label for="comSize">사원수</label>
    	<input type="comSize" name="comSize" id="comSize"><br>
    </div>
    
    <div>
    	<lable for="="comWeb">홈페이지</lable>
    	<input type="comWeb" name="comWeb" id="comWeb"><br>
    </div>
    <div>
        <input type="submit" value="가입">
        <button type="button">취소</button>
    </div>
</form>

</body>
</html>
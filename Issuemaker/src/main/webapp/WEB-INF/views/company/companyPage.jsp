<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 정보 수정</title>
</head>
<body>
	<p>${ errorMessage }</p>
	<form method="post" >
	
    
    <div>
        <label for="comPhone">전화번호</label>
        <input type="text" name="comPhone" id="comPhone" value="${company.comPhone}" ><br>
    </div>
    
    <div>
        <label for="managerEmail">담당자 이메일</label>
        <input type="email" name="managerEmail" id="managerEmail" value="${company.managerEmail}" ><br>
    </div>
    
    <div>
        <label for="comAddress">주소</label>
        <input type="text" name="comAddress" id="comAddress" value="${company.comAddress}" ><br>
    </div>
    
    <div>
        <label for="comSize">사원수</label>
        <input type="text" name="comSize" id="comSize" value="${company.comSize}"><br>
    </div>
    
    <div>
        <label for="comWeb">홈페이지</label>
        <input type="text" name="comWeb" id="comWeb" value="${company.comWeb}"><br>
    </div>
    
    <div>
        <input type="submit" value="수정">
        <button type="button" onclick="window.location.href='companyPage.jsp'">취소</button>
    </div>
</form>
</body>
</html>
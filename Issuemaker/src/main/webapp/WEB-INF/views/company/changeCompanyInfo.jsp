<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>${ errorMessage }</p>
	<form method="post">
    <h1>기업 정보 수정</h1>
   
    <div>
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw" required><br>
    </div>
    
    <div>
        <label for="pwAgain">비밀번호 확인:</label>
        <input type="password" name="pwAgain" id="pwAgain" required><br>
    </div>
    
    <div>
        <label for="comName">기업명</label>
        <input type="text" name="comName" id="comName" value="${ comInfo.getComName() }" required><br>
    </div>
    
    <div>
        <label for="comNo">사업자 등록번호</label>
        <input type="text" name="comNo" id="comNo" value="${ comInfo.getComNo() }" requeired><br>
    </div>
    
    <div>
        <label for="comPhone">전화번호</label>
        <input type="tel" name="comPhone" id="comPhone" value="${ comInfo.getComPhone() }" required><br>
    </div>
    
    <div>
        <label for="comCeo">대표자 이름</label>
        <input type="text" name="comCeo" id="comCeo" value="${ comInfo.getComCeo() }" required><br>
    </div>
    
    <div>
        <label for="managerEmail">담당자 이메일</label>
        <input type="email" name="managerEmail" id="managerEmail" value="${ comInfo.getManagerEmail() }" required><br>
    </div>
    
    <div>
        <label for="comAddress">주소</label>
        <input type="text" name="comAddress" id="comAddress" value="${ comInfo.getComAddress() }" required><br>
    </div>
    
    <div>
    	<label for="comBirth">설립일</label>
    	<input type="date" name="comBirth" id="comBirth"  value="${ comInfo.getComBirth() }" required><br>
    </div>
    
    <div>
    	<label for="comSize">사원수</label>
    	<input type="text" name="comSize" id="comSize"  value="${ comInfo.getComSize() }" ><br>
    </div>
    
    <div>
    	<label for="comWeb">홈페이지</label>
    	<input type="text" name="comWeb" id="comWeb" value="${ comInfo.getComWeb() }"><br>
    </div>
    <div>
        <input type="submit" value="수정하기">
    </div>
</form>
</body>
</html>
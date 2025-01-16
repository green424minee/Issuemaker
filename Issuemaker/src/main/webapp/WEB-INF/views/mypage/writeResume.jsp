<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이력서 작성</title>
<script>
	function toggleSchoolLevel() {
    	const typeRadios = document.getElementsByName('type');
    	const schoolLevelDiv = document.getElementById('schoolLevelDiv');
   	 	const majorLabel = document.getElementById('majorLabel');
   		const majorInput = document.getElementById('major');

   		// "대학교"가 선택되었는지 확인
   	    if (typeRadios[2].checked) {
   	        schoolLevelDiv.style.display = 'block'; // 보여주기
   	        majorLabel.style.display = 'block'; // 전공 레이블 보여주기
   	        majorInput.style.display = 'block'; // 전공 입력 필드 보여주기
   	    } 
   	    // "고등학교"가 선택되었는지 확인
   	    else if (typeRadios[1].checked) {
   	        schoolLevelDiv.style.display = 'none'; // 숨기기
   	        majorLabel.style.display = 'block'; // 전공 레이블 보여주기
   	        majorInput.style.display = 'block'; // 전공 입력 필드 보여주기
   	    } 
   	    // "초/중학교"가 선택되었을 때
   	    else {
   	        schoolLevelDiv.style.display = 'none'; // 숨기기
   	        majorLabel.style.display = 'none'; // 전공 레이블 숨기기
   	        majorInput.style.display = 'none'; // 전공 입력 필드 숨기기
   	    }
   	}
		
        function toggleScoreInput(radio) {
        	const licenseEntry = radio.closest('.licenseEntry');
            const scoreLabel = licenseEntry.querySelector('.scoreLabel');
            const scoreInput = licenseEntry.querySelector('.scoreInput');
            
            if (radio.value === "1") { // 어학시험 선택 시
                scoreLabel.style.display = 'block';
                scoreInput.style.display = 'block';
            } else { // 자격증/면허증 선택 시
                scoreLabel.style.display = 'none';
                scoreInput.style.display = 'none';
            }
        }
        
        function addLicenseEntry() {
            const licenseCount = document.getElementById("licenseCount");
            const count = parseInt(licenseCount.value);
            
            const newEntry = document.createElement("div");
            newEntry.className = "licenseEntry";
            newEntry.innerHTML = `
                <label>자격 구분</label><br>
                <input type="radio" name="licenseType${count}" value="0" onclick="toggleScoreInput(this)">
                <label>자격증/면허증</label>
                <input type="radio" name="licenseType${count}" value="1" onclick="toggleScoreInput(this)">
                <label>어학시험</label><br>
                
                <label>자격증 이름</label><br>
                <input type="text" name="license${count}" placeholder="자격증 이름"><br>
                
                <label>취득일</label><br>
                <input type="date" name="acquisition${count}" placeholder="취득일"><br>
                
                <label class="scoreLabel" style="display: none;">점수</label>
                <input type="text" class="scoreInput" name="score${count}" style="display: none;"><br>
            `;
            
            document.getElementById("licenseContainer").appendChild(newEntry);
            licenseCount.value = count + 1; // licenseCount 업데이트
        }

    </script>
</head>
<body>
	<div><h2>이력서 작성</h2></div>
	<form method="post" enctype="multipart/form-data">
	
	<div>
		<label for="title">제목</label>
		<input type="text" name="title" id="title" required><br>
	</div>
	
	<div>
		<label for="userPhoto">사진</label>
        <input type="file" name="userPhoto" id="userPhoto"><br>
	</div><br>
	
	<div>
		<label for="workHistory">경력</label><br>
		
		<label>경력회사</label>
		<input type="text" name="exCom" id="exCom"><br>
		
		<label>경력 시작일</label>
		<input type="date" name="startDate1" id="startDate"><br>
		
		<label>경력 종료일</label>
		<input type="date" name="endDate1" id="endDate"><br>
		
    	<label for="jobType">직무</label>
    	<select id="jobType" name="jobType1">
        <c:forEach var="job" items="${jobList}">
            <option><c:out value="${job}"></c:out></option>
        </c:forEach>
    </select>
	</div><br>
	
	<div>
    <label for="jobType">직무</label>
    <select id="jobType" name="jobType">
        <c:forEach var="job" items="${jobList}">
            <option><c:out value="${job.jobType}"></c:out></option>
        </c:forEach>
    </select>
	</div>
	<div>
		<label for="coverLetter">자기소개서</label>
        <input type="file" name="coverLetter" id="coverLetter" accept=".pdf"><br>
	</div>
	
	 <div>
      <label>학교구분</label><br>
      <input type="radio" id="type0" name="type" value="0" <c:if test="${school != null && school.type == 0}">checked</c:if> onclick="toggleSchoolLevel()">
      <label for="type0">초/중학교</label><br>
      <input type="radio" id="type1" name="type" value="1" <c:if test="${school != null && school.type == 1}">checked</c:if> onclick="toggleSchoolLevel()">
      <label for="type1">고등학교</label><br>
      <input type="radio" id="type2" name="type" value="2" <c:if test="${school != null && school.type == 2}">checked</c:if> onclick="toggleSchoolLevel()">
      <label for="type2">대학교</label><br>
      
      <label>상태</label>
      <input type="text" name="level" id="level" value="${school != null ? school.level : ''}" placeholder="졸업/중퇴/휴학/재학"><br>
      
      <label>학교이름</label>
      <input type="text" name="schoolName" id="schoolName" value="${school != null ? school.schoolName : ''}"><br>

      <div id="schoolLevelDiv" style="display: ${school != null && school.level == '대학교' ? 'block' : 'none'};">
          <label>대학구분</label><br>
          <input type="radio" id="schoolLevel0" name="schoolLevel" value="0"><c:if test="${school != null && school.schoolLevel == 0}">checked</c:if>
          <label for="schoolLevel0">석사</label><br>
          <input type="radio" id="schoolLevel1" name="schoolLevel" value="1" ><c:if test="${school != null && school.schoolLevel == 1}">checked</c:if>
          <label for="schoolLevel1">박사</label><br>
          <input type="radio" id="schoolLevel2" name="schoolLevel" value="2" ><c:if test="${school != null && school.schoolLevel == 2}">checked</c:if>
          <label for="schoolLevel2">2, 3년제</label><br>
          <input type="radio" id="schoolLevel3" name="schoolLevel" value="3" ><c:if test="${school != null && school.schoolLevel == 3}">checked</c:if>
          <label for="schoolLevel3">4년제</label><br>
      </div>

      <label id="majorLabel" style="display: ${school != null ? 'block' : 'none'};">전공</label>
      <input type="text" id="major" name="major" style="display: ${school != null ? 'block' : 'none'};" value="${school != null ? school.major : ''}"><br>
      
      <label>학력시작일</label><br>
      <input type="date" id="startDate" name="startDate" value="${school != null ? school.startDate : ''}"><br>
      
      <label>학력종료일</label><br>
      <input type="date" id="endDate" name="endDate" value="${school != null ? school.endDate : ''}"><br>
   </div><br>

	
	<div>
		<label for="portfolio">포토폴리오</label><br>
        <input type="file" name="portfolio" id="portfolio" ><br>
	</div><br>
	
  <div id="licenseContainer">
    <input type="hidden" id="licenseCount" name="licenseCount" value="1">
        <div class="licenseEntry">
        <label for="license">자격증</label><br>
        
        <label>자격 구분</label><br>
        <input type="radio" name="licenseType0" value="0" onclick="toggleScoreInput(this)">
        <label>자격증/면허증</label>
        <input type="radio" name="licenseType0" value="1" onclick="toggleScoreInput(this)">
        <label>어학시험</label><br>
        
        <label>자격증 이름</label><br>
        <input type="text" name="license0" placeholder="자격증 이름"><br> <!-- 수정된 부분 -->
        
        <label>취득일</label><br>
        <input type="date" name="acquisition0" placeholder="취득일"><br> <!-- 수정된 부분 -->
        
        <label class="scoreLabel" style="display: none;">점수</label>
        <input type="text" class="scoreInput" name="score0" style="display: none;"><br> <!-- 수정된 부분 -->
    </div>
    <button type="button" onclick="addLicenseEntry()">+ 자격증 추가</button>
</div>

	<div>
		<label for="salary">희망 연봉</label>
		<input type="text" name="salary"><br>
	</div><br>
	
	<div>
		<label>
           <input type="radio" name="agree" value="0"> 동의
        </label>
        <label>
            <input type="radio" name="agree" value="1"> 비동의
        </label>
        <br>
	</div>
	
	<div>
	 <input type="submit" value="이력서 등록">
	</div>
		
	</form>
</body>
</html>
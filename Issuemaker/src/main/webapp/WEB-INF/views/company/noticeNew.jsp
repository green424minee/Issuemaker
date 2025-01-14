<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 등록</title>
</head>
<body>
	<p>${ errorMessage }</p>
	<form method="post">

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required><br><br>

        <label for="context">내용:</label><br>
        <textarea id="context" name="context" required></textarea><br><br>

        <label for="postDate">공고시작:</label>
        <input type="date" id="postDate" name="postDate" required><br><br>

        <label for="deadLine">공고마감:</label>
        <input type="date" id="deadLine" name="deadLine" required><br><br>

        <label for="salary">연봉:</label>
        <input type="number" id="salary" name="salary" placeholder="협의 후 결정"><br><br>

        <label for="jobType">직무:</label>
        <input type="text" id="jobType" name="jobType" required><br><br>

        <label for="exTerm">경력:</label>
        <input type="text" id="exTerm" name="exTerm" placeholder="무관"><br><br>

        <label for="workday">근무요일:</label>
        <input type="text" id="workday" name="workday" required><br><br>

        <label>학교구분:</label><br>
        <input type="radio" id="type0" name="type" value="0" required>
        <label for="type0">초/중학교</label><br>
        <input type="radio" id="type1" name="type" value="1">
        <label for="type1">고등학교</label><br>
        <input type="radio" id="type2" name="type" value="2">
        <label for="type2">대학교</label><br><br>

        <label>대학구분:</label><br>
        <input type="radio" id="schoolLevel0" name="schoolLevel" value="0" required>
        <label for="schoolLevel0">석사</label><br>
        <input type="radio" id="schoolLevel1" name="schoolLevel" value="1">
        <label for="schoolLevel1">박사</label><br>
        <input type="radio" id="schoolLevel2" name="schoolLevel" value="2">
        <label for="schoolLevel2">2, 3년제</label><br>
        <input type="radio" id="schoolLevel3" name="schoolLevel" value="3">
        <label for="schoolLevel3">4년제</label><br><br>

        <label for="major">전공:</label>
        <input type="text" id="major" name="major"><br><br>

        <label for="comLicense">자격증:</label>
        <input type="text" id="comLicense" name="comLicense" ><br>
        <small>자격증을 여러 개 입력하려면 쉼표로 구분하세요.</small><br><br>

        <input type="submit" value="등록">
    </form>
</body>
</html>

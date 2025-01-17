<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 등록</title>
<script>
    function toggleSchoolLevel() {
        var schoolType = document.querySelector('input[name="type"]:checked').value;
        var universityLevelSection = document.getElementById("universityLevelSection");
        var majorSection = document.getElementById("majorSection");

        if (schoolType === "3") { 
            universityLevelSection.style.display = "block";
            majorSection.style.display = "block"; 
        } else if (schoolType === "2") { 
            universityLevelSection.style.display = "none";
            majorSection.style.display = "block"; 
        } else {
            universityLevelSection.style.display = "none";
            majorSection.style.display = "none"; 
        }
    }

    window.onload = function() {
        var schoolTypeRadios = document.querySelectorAll('input[name="type"]');
        schoolTypeRadios.forEach(function(radio) {
            radio.addEventListener('change', toggleSchoolLevel);
        });
        toggleSchoolLevel();
    };
</script>
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
        <input type="text" id="salary" name="salary" placeholder="공백 시 협의 후 결정">만원<br><br>

        <div>
            <label for="jobType">직무</label>
            <select id="jobType" name="jobType">
                <c:forEach var="job" items="${jobList}">
                    <option><c:out value="${job}"></c:out></option>
                </c:forEach>
            </select>
        </div>

        <label for="exTerm">경력:</label>
        <input type="text" id="exTerm" name="exTerm" placeholder="공백 시 무관">년 이상<br><br>

        <label for="workday">근무요일:</label>
        <input type="text" id="workday" name="workday" required><br><br>

        <label>학교구분:</label><br>
        <input type="radio" id="type0" name="type" value="0" required checked onchange="toggleSchoolLevel()">
        <label for="type0">무관</label><br>
        <input type="radio" id="type1" name="type" value="1" onchange="toggleSchoolLevel()">
        <label for="type1">초/중학교</label><br>
        <input type="radio" id="type2" name="type" value="2" onchange="toggleSchoolLevel()">
        <label for="type2">고등학교</label><br>
        <input type="radio" id="type3" name="type" value="3" onchange="toggleSchoolLevel()">
        <label for="type3">대학교</label><br>

        <div id="universityLevelSection" style="display: none; margin-top: 10px;">
            <label>대학구분:</label><br>
            <input type="radio" id="schoolLevel0" name="schoolLevel" value="0" required checked>
            <label for="schoolLevel0">무관</label><br>
            <input type="radio" id="schoolLevel1" name="schoolLevel" value="1">
            <label for="schoolLevel1">2, 3년제</label><br>
            <input type="radio" id="schoolLevel2" name="schoolLevel" value="2">
            <label for="schoolLevel2">4년제</label><br>
            <input type="radio" id="schoolLevel3" name="schoolLevel" value="3">
            <label for="schoolLevel3">석사</label><br>
            <input type="radio" id="schoolLevel4" name="schoolLevel" value="4">
            <label for="schoolLevel4">박사</label><br>
        </div>

        <div style="margin-top: 10px;" id="majorSection" style="display: none;">
            <label for="major">전공:</label>
            <input type="text" id="major" name="major" ><br><br>
        </div>

        <label for="comLicense">자격증:</label>
        <input type="text" id="comLicense" name="comLicense"><br>
        <small>자격증을 여러 개 입력하려면 쉼표로 구분하세요.</small><br><br>

        <input type="submit" value="등록">
    </form>
</body>
</html>

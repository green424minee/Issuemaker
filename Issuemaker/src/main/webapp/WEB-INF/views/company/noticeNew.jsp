<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>공고 등록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin: 0 auto; /* 중앙 정렬 */
            width: 600px; /* 폼의 가로 길이를 600px로 설정 */
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        input[type="text"],
        input[type="number"],
        input[type="date"],
        select,
        textarea {
            width: calc(100% - 22px);
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            height: 100px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        .button {
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }
        .button:hover {
            background-color: #0056b3; /* 호버 시 배경색 변경 */
        }
         .button-container {
            text-align: center; /* 버튼을 중앙 정렬 */
            margin-top: 20px; /* 위쪽 여백 추가 */
        }
        .error-message {
            color: red;
            margin-bottom: 10px;
        }
        .school-type,
        .university-level {
            display: flex;
            justify-content: space-between; /* 칸을 나누기 위해 공간을 균등하게 배분 */
            margin-top: 10px;
        }
        .school-type label,
        .university-level label {
            flex: 1; /* 각 라벨이 동일한 비율로 공간을 차지하도록 설정 */
            text-align: center; /* 라벨을 중앙 정렬 */
        }
    </style>
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
    <h1>공고 등록</h1>
    <div class="error-message">${ errorMessage }</div>
    <form method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required>

        <label for="context">내용:</label>
        <textarea id="context" name="context" required></textarea>

        <label for="postDate">공고시작:</label>
        <input type="date" id="postDate" name="postDate" required>

        <label for="deadLine">공고마감:</label>
        <input type="date" id="deadLine" name="deadLine" required>

        <label for="salary">연봉:</label>
        <input type="number" id="salary" name="salary" placeholder="공백 시 협의 후 결정">

        <label for="jobType">직무:</label>
        <select id="jobType" name="jobType">
            <c:forEach var="job" items="${jobList}">
                <option><c:out value="${job}"></c:out></option>
            </c:forEach>
        </select>

        <label for="exTerm">경력:</label>
        <input type="text" id="exTerm" name="exTerm" placeholder="공백 시 무관">

        <label for="workday">근무요일:</label>
        <input type="text" id="workday" name="workday" required>

        <label>학교구분:</label>
        <div class="school-type">
            <label>
                <input type="radio" id="type0" name="type" value="0" required checked onchange="toggleSchoolLevel()">
                무관
            </label>
            <label>
                <input type="radio" id="type1" name="type" value="1" onchange="toggleSchoolLevel()">
                초/중학교
            </label>
            <label>
                <input type="radio" id="type2" name="type" value="2" onchange="toggleSchoolLevel()">
                고등학교
            </label>
            <label>
                <input type="radio" id="type3" name="type" value="3" onchange="toggleSchoolLevel()">
                대학교
            </label>
        </div>

        <div id="universityLevelSection" style="display: none; margin-top: 10px;">
            <label>대학구분:</label>
            <div class="university-level">
                <label>
                    <input type="radio" id="schoolLevel0" name="schoolLevel" value="0" required checked>
                    무관
                </label>
                <label>
                    <input type="radio" id="schoolLevel1" name="schoolLevel" value="1">
                    2, 3년제
                </label>
                <label>
                    <input type="radio" id="schoolLevel2" name="schoolLevel" value="2">
                    4년제
                </label>
                <label>
                    <input type="radio" id="schoolLevel3" name="schoolLevel" value="3">
                    석사
                </label>
                <label>
                    <input type="radio" id="schoolLevel4" name="schoolLevel" value="4">
                    박사
                </label>
            </div>
        </div>

        <div id="majorSection" style="display: none; margin-top: 10px;">
            <label for="major">전공:</label>
            <input type="text" id="major" name="major">
        </div>

        <label for="comLicense">자격증:</label>
        <input type="text" id="comLicense" name="comLicense" placeholder="공백 시 무관"><br>
        <small>자격증을 여러 개 입력하려면 쉼표로 구분하세요.</small><br>
		
		<div class="button-container">
        <input type="submit" class="button" value="등록"><br>
        </div>
    </form>
</body>
</html>

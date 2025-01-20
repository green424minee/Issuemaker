<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 수정</title>
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
        background: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        max-width: 600px;
        margin: auto;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    textarea {
        width: calc(100% - 10px); /* 오른쪽 여백을 고려하여 너비 조정 */
        height: 100px;
        margin-bottom: 15px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="date"] {
        width: calc(100% - 10px); /* 오른쪽 여백을 고려하여 너비 조정 */
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .button-container {
        display: flex;
        justify-content: space-between;
    }
    .button-container input[type="submit"],
    .button-container button {
        flex: 1; /* 버튼을 동일한 너비로 설정 */
        padding: 10px; /* 버튼 패딩 */
        margin: 0 5px; /* 버튼 사이에 간격 추가 */
        background-color: #5cb85c; /* 수정 버튼 색상 */
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background-color 0.3s;
    }
    .button-container button {
        background-color: #d9534f; /* 취소 버튼 색상 */
    }
    .button-container input[type="submit"]:hover {
        background-color: #4cae4c; /* 수정 버튼 호버 색상 */
    }
    .button-container button:hover {
        background-color: #c9302c; /* 취소 버튼 호버 색상 */
    }
</style>
</head>
<body>
<h1>공고 수정</h1>
<p>${ errorMessage }</p>
<form method="post">
    <label for="context">내용:</label>
    <textarea id="context" name="context" required>${ notice.context }</textarea>

    <label for="deadLine">공고마감:</label>
    <input type="date" id="deadLine" name="deadLine" value="${ notice.deadLine }" required>

    <div class="button-container">
        <input type="submit" value="수정">
        <button type="button" onclick="window.history.back()">취소</button>
    </div>
</form>
</body>
</html>

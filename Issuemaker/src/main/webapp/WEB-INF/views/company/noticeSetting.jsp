<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 수정</title>
</head>
<body>
<p>${ errorMessage }</p>

        <label for="context">내용:</label><br>
        <textarea id="context" name="context">${ notice.context }</textarea><br><br>

        <label for="deadLine">공고마감:</label>
        <input type="date" id="deadLine" name="deadLine" value="${ notice.deadLine }"><br><br>

	<form method="post">
	<div>
        <input type="submit" value="수정">
        <button type="button" onclick="window.history.back()">취소</button>
    </div>
    </form>
</body>
</html>
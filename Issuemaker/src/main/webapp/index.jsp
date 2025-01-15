<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="indexHeader.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
<form>
      
   <c:set var="count" value="0"/>
   <c:forEach var="notice" items="${notice}">
   <c:set var="count" value="${ count + 1 }"/>
          <div>
            <a href="/noticeDetail?noticeNo=${notice.no}">${count} ${notice.title} ${notice.postDate}</a>
          </div>
    </c:forEach>
</form>

</body>
</html>
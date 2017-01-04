<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 목록</title>
</head>
<body>
	<h3>게시글 목록</h3>
    <a href="writeForm.do"><button>작성</button></a>
    <table border="1" class="table">
        <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성날짜</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="article" items="${list}">
        <tr>
            <td>${article.articleNum}</td>
            <td><a href="/board/${article.articleNum}">${article.title}</a></td>
            <td>${article.writer}</td>
            <td><fmt:formatDate value="${article.writeDate}" pattern="MM/ dd" /></td>
            <td>${article.readCount}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
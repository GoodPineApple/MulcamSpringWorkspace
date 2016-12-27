<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${empty articlePage.articleList}">
			<tr>
				<td colspan="5">
					게시글이 아직 존재하지 않습니다.
				</td>
			</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="article" items="${articlePage.articleList}">
					<tr>
						<td>${article.articleNum}</td>
						<td>
							<c:forEach begin="1" end="${article.depth}">
							&nbsp;
							</c:forEach>
							<c:if test="${article.depth != 0 }">
								ㄴ
							</c:if>
							<a href="read.do?articleNum=${article.articleNum}">
								${article.title}
							</a>
						</td>
						<td>${article.writer}</td>
						<td>${article.writeDate}</td>
						<td>${article.read_count}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="write_form.do"><button>글쓰기</button></a>
</body>
</html>
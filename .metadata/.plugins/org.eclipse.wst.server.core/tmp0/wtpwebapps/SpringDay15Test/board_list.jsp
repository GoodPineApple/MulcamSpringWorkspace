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
			<th>�۹�ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>
			<th>�ۼ���</th>
			<th>��ȸ��</th>
		</tr>
		<c:choose>
			<c:when test="${empty articlePage.articleList}">
			<tr>
				<td colspan="5">
					�Խñ��� ���� �������� �ʽ��ϴ�.
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
								��
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
	<a href="write_form.do"><button>�۾���</button></a>
</body>
</html>
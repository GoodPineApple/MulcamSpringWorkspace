<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>�� �б�ȭ��</title>
</head>
<body>
<table>
	<tr>
		<td>����:</td>
		<td>${article.title}</td>
	</tr>
	<tr>
		<td>�ۼ���:</td>
		<td>${article.writer}</td>
	</tr>
	<tr>
		<td>��ȸ��:</td>
		<td>${article.read_count}</td>
	</tr>
	<tr>
		<td>�ۼ���:</td>
		<td>${article.writeDate}</td>
	</tr>
	<tr>
		<td>����:</td>
		<td>${article.content}</td>
	</tr>
</table>
<a href="boardList.do">[�������]</a>
<a href="writeReplyForm.do?articleNum=${article.articleNum }">��۴ޱ�</a>
<c:if test="${sessionScope.loginId==article.writer}">
	<a href="updateForm.do?articleNum=${article.articleNum }">[�����ϱ�]</a>
	<a href="deleteForm.do?articleNum=${article.articleNum }">[�����ϱ�]</a>
</c:if>

</body>
</html>
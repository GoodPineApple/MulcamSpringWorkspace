<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="update.do" method="post">
<input type="hidden" name="writer" value="${sessionScope.loginId }">
<input type="hidden" name="articleNum" value="${article.articleNum }">
<table border="1">
<tr>
	<th>�� ����</th>
	<td><input type="text" name="title" value="${article.title }"></td>
</tr>
<tr>
	<th>�� ��</th>
	<td><textarea rows="10" cols="20" name="content" placeholder="${article.content }"></textarea></td>
</tr>
</table>
<input type="submit" value="�� ����">
</form>
</body>
</html>
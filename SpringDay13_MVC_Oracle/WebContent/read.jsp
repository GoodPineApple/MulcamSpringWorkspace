<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>å��ȣ</td>
			<td>${book.bookNum}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${book.writer}</td>
		</tr>
		<tr>
			<td>���ǻ�</td>
			<td>${book.publisher}</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${book.price}</td>
		</tr>
	</table>
	<a href="main.do">��������</a> 
	<a href="updateForm.do?bookNum=${book.bookNum}">�����ϱ�</a> 
	<a href="delete.do?bookNum=${book.bookNum}">�����ϱ�</a>
</body>
</html>
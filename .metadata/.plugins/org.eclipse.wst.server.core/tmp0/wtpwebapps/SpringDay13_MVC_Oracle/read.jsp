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
			<td>책번호</td>
			<td>${book.bookNum}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td>저자</td>
			<td>${book.writer}</td>
		</tr>
		<tr>
			<td>출판사</td>
			<td>${book.publisher}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${book.price}</td>
		</tr>
	</table>
	<a href="main.do">메인으로</a> 
	<a href="updateForm.do?bookNum=${book.bookNum}">수정하기</a> 
	<a href="delete.do?bookNum=${book.bookNum}">삭제하기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="addBookResult.do" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="10"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="writer" size="10"></td>
			</tr>
			<tr>
				<td>출판사</td>
				<td><input type="text" name="publisher" size="10"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" size="10"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="제출"></td>
			</tr>
		</table>
	</form>
</body>
</html>
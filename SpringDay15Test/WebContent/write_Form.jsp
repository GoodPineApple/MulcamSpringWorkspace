<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="write.do" method="post">
<input type="hidden" name="writer" value="${sessionScope.loginId }">
<table border="1">
<tr>
	<th>글 제목</th>
	<td><input type="text" name="title"></td>
</tr>
<tr>
	<th>내 용</th>
	<td><textarea rows="10" cols="20" name="content" ></textarea></td>
</tr>
</table>
<input type="submit" value="글 쓰기">
</form>
</body>
</html>
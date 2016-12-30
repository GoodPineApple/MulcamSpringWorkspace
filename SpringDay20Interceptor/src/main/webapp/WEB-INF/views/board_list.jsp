<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>게시판 화면</title>
</head>
<body>
<h2>이곳은 게시판 목록 화면입니다.</h2>
${sessionScope.loginId} 님 입장하셨습니다.<br>
<table border="1">
	<tr>
		<td>게시글</td>
	</tr>
	<tr>
		<td>게시글</td>
	</tr>
	<tr>
		<td>게시글</td>
	</tr>
	<tr>
		<td>게시글</td>
	</tr>
</table>
<a href="writeForm.do"><button>글쓰기</button></a>

</body>
</html>
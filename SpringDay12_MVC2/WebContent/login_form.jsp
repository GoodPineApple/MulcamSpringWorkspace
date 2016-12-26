<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 입력 화면</title>
</head>
<body>

<form action="login.do" method="post">
	ID:<input type="text" name="userId" size="10"><br>
	PW:<input type="password" name="userPw" size="10"><br>
	<input type="submit" value="로그인">
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입창</title>
</head>
<body>
<form action="join.do" method="post">
	<table border="1">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" size="10"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" size="10"></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="email" name="email" size="10"></td>
		</tr>
		<tr>
			<td>Phone</td>
			<td><input type="text" name="phone" size="10"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
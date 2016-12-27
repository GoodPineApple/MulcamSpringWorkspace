<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>로그인 성공!</h3>
<b>${sessionScope.loginId}</b> 님 반갑습니다.
<a href="loginStatus.do">[로그인 상태보기]</a>
<a href="logout.do">[로그아웃]</a>

</body>
</html>
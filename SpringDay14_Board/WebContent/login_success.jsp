<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>로그인 성공</title>
</head>
<body>
로그인 완료 ! <br>
<b>${sessionScope.loginId}</b> 님 반갑습니다.
<a href="loginStatus.do">[로그인 상태보기]</a>
<a href="logout.do">[로그아웃]</a>
<a href="boardList.do">[게시판 입장]</a>
</body>
</html>
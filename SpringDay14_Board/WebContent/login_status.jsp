<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<title>로그인 상태보기</title>
</head>
<body>
	<c:if test="${not empty sessionScope.loginId}">
		${sessionScope.loginId} 님 로그인 상태입니다.
		<a href="logout.do">[로그아웃]</a>
	</c:if>
	<c:if test="${empty sessionScope.loginId}">
		로그인 정보가 없습니다.<br>
		<a href="loginForm.do">[로그인 하러가기]</a>
	</c:if>
	
</body>
</html>
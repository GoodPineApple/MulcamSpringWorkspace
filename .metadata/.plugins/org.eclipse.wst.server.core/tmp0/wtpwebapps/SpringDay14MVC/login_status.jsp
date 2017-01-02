<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>로그인 상태보기</title>
</head>
<body>
<c:choose>
	<c:when test="${not empty sessionScope.loginId}">
		${sessionScope.loginId}님 로그인 상태입니다.
		<a href="logout.do">[로그아웃]</a>
	</c:when>
	<c:otherwise>
		로그인 정보가 없습니다.
		<a href="loginForm.do">[로그인 하러가기]</a>
	</c:otherwise>
</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.warn{
		color : red;
	}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
<h2>파인애플의 게시판</h2>
<h3>본 게시판은 로그인한 회원만 입장할 수 있습니다. :)</h3>
<a href="joinForm.do"><button>회원가입</button></a>
<hr>
<form action="login.do" method="post">
	<table>
		<tr>
			<td>ID:</td>
			<td> <input type="text" name="id" size="10"> </td>
		</tr>
		<tr>
			<td>PW:</td>
			<td> <input type="password" name="password" size="10"> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>
<hr>
<c:if test="${not empty result}">
	<c:if test="${result}">
		<a href="boardList.do"><button>게시판 입장하기</button></a>	
	</c:if>
	<c:if test="${!result}">
		<div id="loginResult" class="warn">잘못된 회원정보입니다.</div>	
	</c:if>
</c:if>

</body>
</html>
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
<h2>���ξ����� �Խ���</h2>
<h3>�� �Խ����� �α����� ȸ���� ������ �� �ֽ��ϴ�. :)</h3>
<a href="joinForm.do"><button>ȸ������</button></a>
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
				<input type="submit" value="�α���">
			</td>
		</tr>
	</table>
</form>
<hr>
<c:if test="${not empty result}">
	<c:if test="${result}">
		<a href="boardList.do"><button>�Խ��� �����ϱ�</button></a>	
	</c:if>
	<c:if test="${!result}">
		<div id="loginResult" class="warn">�߸��� ȸ�������Դϴ�.</div>	
	</c:if>
</c:if>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>ȸ�������� �Ϸ�Ǿ����ϴ�.</h2>
	<table>
		<tr>
			<th>���̵�</th>
			<th>��ȭ��ȣ</th>
			<th>�̸���</th>
		</tr>
		<tr>
			<td>${joinMemberInfo.id}</td>
			<td>${joinMemberInfo.phone}</td>
			<td>${joinMemberInfo.email}</td>
		</tr>
	</table>

</body>
</html>
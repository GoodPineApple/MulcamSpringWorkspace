<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>���Ϲ�ȣ</th>
			<th>�����̸�</th>
			<th>����������</th>
		</tr>
		<c:choose>
			<c:when test="${empty fileList}">
				<tr>
					<td colspan="3">���ε�� ������ �����ϴ�.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fileList}" var="f">
					<tr>
						<td>${f.fileNum}</td>
						<td>${f.originalName}</td>
						<td>${f.savedPath}</td>
					</tr>					
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="uploadForm.do"><button>���ε�</button></a>
</body>
</html>
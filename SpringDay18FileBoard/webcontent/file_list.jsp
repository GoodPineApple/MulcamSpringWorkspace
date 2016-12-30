<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>file_list.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>파일번호</th>
			<th>파일이름</th>
			<th>실제저장경로</th>
		</tr>
		<c:choose>
			<c:when test="${empty fileList}">
				<tr>
					<td colspan="3">
					업로드된 파일이 존재하지 않습니다.
					</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${fileList}" var="f">
					<tr>
						<td>${f.fileNum}</td>
						<td>
						<a href="downloadFile.do?fileNum=${f.fileNum}">
						${f.originalName}
						</a>
						</td>
						<td>${f.savedPath}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<a href="uploadForm.do"><button>업로드</button></a>
</body>
</html>
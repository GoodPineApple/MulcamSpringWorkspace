<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<input type="hidden" id="articleNum" value="${articleNum}">
<script type="text/javascript">
	var articleNum = document.getElementById('articleNum').value;
	alert(articleNum);
	location.href='read.do?articleNum='+articleNum;
</script>
</body>
</html>
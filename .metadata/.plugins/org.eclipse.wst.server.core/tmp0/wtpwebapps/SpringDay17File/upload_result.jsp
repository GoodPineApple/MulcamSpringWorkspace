<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
upload_result.jsp<br>
<h3>업로드가 완료되었습니다.</h3>
원래이름 : <b>${originalName}</b> <br>
서버에 저장된 경로 : <b>${savedPath}</b> <br>
title파라미터 : <b>${title}</b><br>

<a href="uploadForm.do">업로드 한번 더 ?</a><br>
<a href="download.do">[코알라 다운로드]</a>
</body>
</html>
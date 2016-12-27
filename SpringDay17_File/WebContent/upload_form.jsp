<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>업로드폼</title>
</head>
<body>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<input type="text" name="title">
	<input type="file" name="myFile">
	<input type="submit" value="전송">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>파일 여러개 업로드</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var fileCount=1;
		
		$('button').click(function(){
			var inputElement ='첨부파일 : ';
			inputElement += '<input type="file" ';
			inputElement += 'name="myFile['+fileCount+']"><br>';
			fileCount++;
			
			$('input[type="submit"]').before(inputElement);
		})
	})
</script>
</head>
<body>
	<button>파일추가</button><br>
	<hr>	
	<form action="uploadMovie.do" method="post" 
							enctype="multipart/form-data">
		제목:<input type="text" name="title" size="10"><br>
		첨부파일:<input type="file" name="myFile[0]"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		function traverseBookmarks(bookmarkTreeNodes) {
		    for(var i=0;i<bookmarkTreeNodes.length;i++) {
		        console.log(bookmarkTreeNodes[i].title, bookmarkTreeNodes[i].url ? bookmarkTreeNodes[i].url : "[Folder]");

		        if(bookmarkTreeNodes[i].children) {
		            traverseBookmarks(bookmarkTreeNodes[i].children);
		        } 

		    }
		}
	})

</script>
</head>
<body>
북마크 Test


</body>
</html>
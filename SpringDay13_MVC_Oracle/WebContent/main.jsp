<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
// 	$(function(){
// 		$('#btn').on('click',function(){
// 			window.open('write.do', '_blank', 'width=730, height=750, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no')
// 		})
// 	})

</script>


</head>
<body>
	<table border="1">
		<tr>
			<th>å��ȣ</th>
			<th>����</th>
			<th>�۰�</th>
		</tr>
		<c:choose>
			<c:when test="${empty bookList}}">
				<tr>
					<td>��ϵ� å�� �����ϴ�.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.bookNum}</td>
						<td><a href="readBook.do?bookNum=${book.bookNum}">${book.title}</a></td>
						<td>${book.writer}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
<hr>
<a href="addBook.do"><button id="btn">å�߰�</button></a>


</body>
</html>
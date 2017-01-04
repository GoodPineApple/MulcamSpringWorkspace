<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btnIdCheck').click(function(){
			var inputId = $('#id').val();
			$.ajax({
				url:"idCheck.do",
				data:"id="+inputId,
				success:function(result){
					if(result=='true'){
						$('#idCheckResult')
						.text('사용가능한 아이디 입니다.');
						$('#idCheckResult').css('color','green');
					}else{
						$('#idCheckResult')
						.text('중복된 아이디 입니다.');
						$('#idCheckResult').css('color','red');
					}
				},
				error:function(){
					alert('ajax 통신 에러')
				}
			})
			return false;
		})
	})
</script>
</head>
<body>
	<form action="join.do" method="post">
	<table border="1">
		<tr>
			<td>ID:</td>
			<td>
				<input type="text" name="id" id="id">
				<button id="btnIdCheck">아이디 중복체크</button>
				<div id="idCheckResult"></div>
			</td>
		</tr>
		<tr>
			<td>PW:</td>
			<td>
				<input type="password" name="password">
			</td>
		</tr>
			<td>E-MAIL:</td>
			<td>
				<input type="email" name="email">
			</td>
		<tr>
			<td>PHONE:</td>
			<td>
				<input type="tel" name="phone">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="가입">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
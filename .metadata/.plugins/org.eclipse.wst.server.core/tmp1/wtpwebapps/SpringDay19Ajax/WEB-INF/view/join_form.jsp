<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>ȸ������ ��</title>
<script type="text/javascript">
	$(function(){
		$('#btnIdCheck').click(function(){
			var inpuiId = $('#id').val();
			$.ajax({
				url:"idCheck.do",
				data:"id="+inputId,
				success:function(result){
					if(result=='true'){
						$('#idCheckResult').text('��밡���� ���̵��Դϴ�.');
						$('#idCheckResult').css('color','green');
					} else{
						$('#idCheckResult').text('�ߺ��� ���̵��Դϴ�.');
						$('#idCheckResult').css('color','red');
					}
				},
				error:function(){
					alert('ajax ��� ����')	
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
				<button id="btnIdCheck">���̵� �ߺ�üũ</button>
				<div id="idCheckResult"></div>
			</td>
			<td>PW:</td>
			<td>
				<input type="password" name="password">
			</td>
			<td>E-MAIL:</td>
			<td>
				<input type="email" name="email">
			</td>
			<td>PHONE:</td>
			<td>
				<input type="tel" name="phone">
			</td>
			
			<td colspan="2">
				<input type="submit" name="����">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
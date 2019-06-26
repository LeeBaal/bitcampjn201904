<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js">
</script>
<style>
	h1{
		text-align: center;
	}
	
	hr{
		margin-bottom: 30px;
		
	}
	
	table {
		margin: 0 auto;
		border: 1px solid gray;
	}
	
	td{
		border: 1px solid gray;
		padding: 7px;
	}
	
	#submit{
		text-align: center;
	}
	
	input[type=text]{
		height: 21px;
	}
	
	select{
		height: 25px;
	}
</style>
</head>
<body>
<h1>request 테스트 폼</h1>
<hr>
<form action="requestpro.jsp" method="post">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<select name="job">
					<option>무직</option>
					<option>유직</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td>
			<input type="checkbox" name="ch" value="정치">정치 
			<input type="checkbox" name="ch" value="사회">사회 
			<input type="checkbox" name="ch" value="정보통신">정보통신
			</td>
		</tr>
		<tr>
			<td colspan="2" id="submit"><input type="submit" value="확인"><input type="submit" value="취소"></td>
		</tr>
	</table>
</form>



</body>
</html>
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
<%
	request.setCharacterEncoding("utf-8");

	String uName = request.getParameter("uname");
	
%>



<h1>전송햇다</h1>
<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><%= uName %></td>
		</tr>
		<tr>
			<td>직업</td>
			<td><%= request.getParameter("job") %></td>
		</tr>
		<tr>
			<td>관심분야</td>
			<td>
			<%
				String[] favors = request.getParameterValues("ch");
			
				if(favors != null){
					for(int i=0; i<favors.length;i++){
						out.println(favors[i]+"\t");
					}
				}
			
			%>
			</td>
		</tr>
	</table>



</body>
</html>
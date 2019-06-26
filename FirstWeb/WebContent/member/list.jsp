<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js">
</script>
<style>
	img {
	width: 100px;
	}
</style>
</head>
<body>

	<%
 Calendar c = Calendar.getInstance(); 
	%>
<h1>회원 리스트
<%= c.get(Calendar.YEAR) %>년
<%= c.get(Calendar.MONTH)+1 %>월
<%= c.get(Calendar.DATE) %>일
</h1> 
<a href="memberReg.jsp">회원가입</a> 
<br>
<img alt="이미지" src="../images/mickey_mouse.png">
<br>
<a href="file.jsp">파일</a>
<script>
	$(document).ready(function(){
		alert('회원 리스트페이지 입니다.');
	});
</script>
</body>
</html>
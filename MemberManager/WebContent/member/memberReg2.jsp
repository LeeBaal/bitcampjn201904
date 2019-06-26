<%@page import="member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="memberInfo" class="member.MemberInfo" scope="request"/>
<jsp:setProperty property="*" name="memberInfo"/>
<%
	if(memberInfo.getuPhoto()==null){
		memberInfo.setuPhoto("noImg.png");
	}

	// 내장객체에 회원정보 객체를 저장
	application.setAttribute(memberInfo.getuId(), memberInfo);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="/mm/css/default.css" rel="stylesheet" type="text/css">
<style>
	
</style>
</head>
<body>




<!-- 헤더 시작 -->
<%@ include file="../frame/header.jsp" %>
<!-- 헤더 끝 -->


<!-- 네비게이션 시작 -->
<%@ include file="../frame/nav.jsp" %>
<!-- 네비게이션 끝 -->


<!-- 컨텐츠 시작 -->
<div id="contents">
	<h3>회원가입 요청 처리 페이지</h3>
	<hr>
	<%= memberInfo.getuName() %>(<%= memberInfo.getuId() %>) <br>
	<%= memberInfo.getuPw() %><br>
	<%= memberInfo.getReDate() %>
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="../frame/footer.jsp" %>
<!-- 푸터 끝 -->



</body>
</html>
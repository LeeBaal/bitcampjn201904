<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
	<ul>
		
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="<c:url value='/member/loginForm' />">로그인 </a></li>
		<li><a href="<c:url value='/member/memberRegForm' />">회원가입</a></li>
		<li><a href="<c:url value='/write/writeForm' />">방명록</a></li>
		<li><a href="<c:url value='' />">LOGOUT</a></li>
	</ul>
</div>
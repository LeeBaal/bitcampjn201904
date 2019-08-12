<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>
	<c:if test="${chk}">
		${resultCnt} 개 행이 삭제되었습니다.	
	</c:if>
	
	<c:if test="${!chk}">
		${msg} 	
	</c:if>
	
	<a href="<c:url value="/guest/list"/>">리스트</a>
</h1>


</body>
</html>
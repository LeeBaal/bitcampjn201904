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
		${resultCnt} �� ���� �����Ǿ����ϴ�.	
	</c:if>
	
	<c:if test="${!chk}">
		${msg} 	
	</c:if>
	
	<a href="<c:url value="/guest/list"/>">����Ʈ</a>
</h1>


</body>
</html>
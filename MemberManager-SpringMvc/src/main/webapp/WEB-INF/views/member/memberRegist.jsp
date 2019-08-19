<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var chk = ${rCnt};
	
	if(chk == 0){
		alert('땡');
		location.href = "../main";
	}else{
		alert('하위');
		location.href = "../main";
	}
	
</script>
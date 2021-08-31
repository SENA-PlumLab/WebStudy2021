<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "z02_vo.*"
    import = "java.util.*"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var = "path" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript">
	
	//초기화면에 session id가 없으면 로그인 하라고 뜸
	if("${id}"==""){
		alert("로그인이 필요합니다. \n로그인 페이지 이동");
		location.href="a06_login.jsp";
	} else {
		//session 값이 있을 때는 정상 프로세스 처리..
		// ${param.porc} == request.getParameter("proc")
		if("${param.proc}"=="insert") alert("등록처리 수행");
		if("${param.proc}"=="update") alert("수정처리 수행");
	}
	
	$(document).ready(function(){
		//sessio 값은 el로 받아서, 있을 때는 "로그인 중"
		$("h2").text("${id}님 로그인 중");
		//기능 버튼 클릭 시, insert/update 프로세스 처리
		$("#regBtn").click(function(){
			$("[name=proc]").val("insert");
			$("form").submit();
		});
		$("#uptBtn").click(function(){
			$("[name=proc]").val("update");
			$("form").submit();
		});
	});



</script>
<%

%>
<body>
	<h2 align="center"></h2>
	
	<form method="post">
		<input type="hidden" name="proc" />
	</form>
	<br>
	<input type="button" id="regBtn" value="등록" />
	<input type="button" id="uptBtn" value="수정" />
	
	
</body>
</html>
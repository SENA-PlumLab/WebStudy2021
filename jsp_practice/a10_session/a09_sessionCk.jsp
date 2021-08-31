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
	var id = "${id}";
	if(id==""){
		alert("세션이 종료되었습니다. \n다시 로그인");
		location.href="a08_server_ckSession.jsp";
	}
	
	$(document).ready(function(){
		$("h2").text("${id}님 로그인 중!!");
	});

</script>
<%

%>
<body>
	<h2 align="center"></h2>
</body>
</html>
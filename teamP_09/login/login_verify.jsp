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
<script type="text/javascript"></script>
<%

%>
<body>
	<table align="center">
		<tr><th>회원아이디</th><td>${member.memnum }</td></tr>
		<tr><th>회원아이디</th><td>${member.id }</td></tr>
		<tr><th>회원명</th><td>${member.name }</td></tr>
		<tr><th>회원패스워드</th><td>${member.pw }</td></tr>
		<tr><th>회원권한</th><td>${member.birth }</td></tr>
		<tr><th>회원포인트</th><td>${member.tel }</td></tr>
		<tr><th>회원포인트</th><td>${member.mail }</td></tr>
		<tr><th>회원포인트</th><td>${member.joinDate }</td></tr>
		<tr><th>회원포인트</th><td>${member.editDate }</td></tr>
	</table>
</body>
</html>
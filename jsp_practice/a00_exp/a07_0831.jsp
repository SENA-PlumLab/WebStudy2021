<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var = "path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%--


2. JSTL forTokens
	items: 대상 객체
	delims: 구분 기호
	var: 변수 이름
	ex: <c:forTokens items="객체" delims="," var="변수이름">
		<c:out value="${변수이름}" />
		</c:forTokens>
3. JSTL forTokens
--%>
<body>
<c:forTokens items="사과^3000^2@오렌지^2000^3@수박^1200^3" delims="@" var="fruits" >
	<c:forTokens items="${fruits }" delims="^" var="fruits2" >
		<c:out value="${fruits2 }" />
	</c:forTokens>
</c:forTokens>

</body>
</html>
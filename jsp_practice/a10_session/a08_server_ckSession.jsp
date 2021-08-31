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
	String id = request.getParameter("id");
	if(id!=null){
		session.setAttribute("id",id);
		response.sendRedirect("a09_sessionCk.jsp");
	}
%>
<body>
	<h2 align="center"></h2>
	<form>
		아이디: <input type="text" name="id" value=""/>
		<br>
		<input type="submit" value="로그인" />
	
	</form>
</body>
</html>
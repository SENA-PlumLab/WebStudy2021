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
	$(document).ready(function(){
		$("h2").text("로그인");
	});

</script>
<%
	String id = request.getParameter("id");
	if(id!=null){
		session.setAttribute("id", id);
		//session.setMaxInactiveInterval(5);
		response.sendRedirect("a07_show.jsp");
	}
%>
<body>
	<form>
	<p>아이디: <input type="text" name="id" value=""/><br></p>
	<p><input type="submit" value="로그인" />
	</form>
</body>
</html>
<%@page import="teamP_09.SessionMember"%>
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

<!-- main css -->
<link rel="stylesheet" href="${path }/teamP_09/main/main_style.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">

<!-- Bootstrap Scripts -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet" href="${path }/teamP_09/game/game.css" />
<%
SessionMember sm;
String name="방문자";
boolean isLoggedIn = true;
//인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
if (session.getAttribute("login")==null) {
	
 isLoggedIn=false; //==>js에서 redirect
} else {
	sm = (SessionMember)session.getAttribute("login");
	name=sm.getName();
}

/* System.out.println(sm.getMemNum());
System.out.println(sm.getName());
System.out.println(sm.getId()); */
%>

<body>
<%@include file="../mainSupporter/MPHeader.jsp"%>

<section>
	<div class="container">
       <div class="row">
       
       	<div class="profile col col-md-2 col-lg-2">
       	<p>
       		<img alt="" src="${path }/teamP_09/image/apple3.png" class="pf_img">
       		</p>
       		<span id="pf_id"><%=name %></span>
       		<p>포인트: 65942</p>
       		<div id="menu">
       		
       		<p id="menu-item">	▶ 게임1 </p>
       		<p id="menu-item">	▶ 게임2 </p>
       		<p id="menu-item">	▶ 게임3 </p>

       		</div>
       		
       	</div>
       	<div class="game-holder col" >
       		<p>Games here...</p>
       	
       	</div>
       </div>
       
	</div>
</section>

<%@include file="../mainSupporter/MPFooter.jsp"%>
</body>
</html>
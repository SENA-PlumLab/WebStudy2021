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

<!-- Bootstrap Scripts -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- main css -->
<link rel="stylesheet" href="../main/main_style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
 
<!-- form css --> 
<link href="login_css.css" rel="stylesheet">

<%
String id = request.getParameter("id");
%>


<body style=>

<main class="form-join">
  	<form method="post" action="join_verify.jsp" onsubmit="return checkForm();">
    <a href="../main/mainPage.jsp"><img src="../image/logo_.png" alt="" width="50" class="img-logo"></a>
	<h2>회원가입</h2>
    <div class="form-floating">
      <input type="text" class="form-control custom-input mb-1" id="id" name="id" placeholder="id">
      <label for="floatingInput">ID</label>
      <input type="button" class="btn btn-sm btn-outline-success mb-3" value="ID 중복확인"/>
    </div>

    <div class="form-floating">
      <input type="password" class="form-control custom-input" id="pass" name="pass" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>
    <div class="mb-3 form-check remember-holder">
        <input type="checkbox" class="form-check-input custom-input" id="rememberMe" />
        <label class="form-check-label" for="rememberMe">ID 저장</label>
    </div>
    <input class="w-100 btn btn-lg btn-success custom-btn" type="submit" value="Log in">
    <div class="mt-5 text-muted row">
		<p class="col-auto"><a href="#" data-bs-toggle="modal" data-bs-target="#find_id">아이디 찾기</a></p>
		<p class="col-auto"><a href="#" data-bs-toggle="modal" data-bs-target="#find_pw">비밀번호 찾기</a></p>
		<p class="col-auto" ><a href="#">회원가입</a></p>
	</div>
	<p class="mt-3 mb-3">
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
	<div id="naver_id_login" class="img-naver"></div>
	<!-- //네이버아이디로로그인 버튼 노출 영역 -->
	</p>
  </form>
</main>

</body>
</html>
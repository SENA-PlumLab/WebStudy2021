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

<!-- 네이버로 로그인 하기 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<!-- Bootstrap Scripts -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- form css --> 
<link href="${path }/teamP_09/login/login_css.css" rel="stylesheet">


<%

%>
<body>

<main class="form-login">
  	<form method="post" action="${path }/LoginProc.do" onsubmit="return checkForm();">
    <a href="${path }/teamP_09/main/mainPage.jsp">
    	<img src="${path }/teamP_09/image/logo_.png" alt="" width="200" class="mt-3 mb-3 img-logo">
    </a>
    <div class="form-floating">
      <input type="text" class="form-control custom-input mb-1" id="id" name="id" placeholder="id">
      <label for="floatingInput">ID</label>
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
		<p class="col-auto" ><a href="../login/join.jsp">회원가입</a></p>
	</div>
	<p class="mt-3 mb-3">
	<!-- 네이버아이디로로그인 버튼 노출 영역 -->
	<div id="naver_id_login" class="img-naver"></div>
	<!-- //네이버아이디로로그인 버튼 노출 영역 -->
	</p>
  </form>
</main>
 <!-- Click on Modal Button -->
<!--         <button type="button" class="btn btn-primary mx-auto d-block mt-5" data-bs-toggle="modal" data-bs-target="#modalForm">
            Bootstrap Modal popup
        </button>
 -->
 
 
 
 
 
 
        <!-- Modal: Find ID -->
        <div class="modal fade" id="find_id" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">ID 찾기</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" id="email-forID" name="email" 
                                										placeholder="Example@naver.com" />
                            </div>
                            <div class="modal-footer d-block">
                            	<p class="float-start">ID가 없으신가요? <a href="../login/join.jsp">회원가입</a></p>
                                <button type="submit" class="btn btn-warning float-end">확인</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Modal: Find PW -->
        <div class="modal fade" id="find_pw" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">비밀번호 찾기</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="mb-3">
                                <label class="form-label">ID</label>
                                <input type="text" class="form-control" id="id-forPW" name="id" placeholder="ID" />
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Email</label>
                                <input type="email" class="form-control" id="email-forPW" name="email" placeholder="Example@naver.com"/>
                            </div>
                            <div class="modal-footer d-block">
                            	<p class="float-start">ID가 없으신가요? <a href="../login/join.jsp">회원가입</a></p>
                                <button type="submit" class="btn btn-warning float-end">확인</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        

</body>
<!-- Bootstrap JS -->
        <script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>

<script type="text/javascript">
        var naver_id_login = new naver_id_login("3eVzkEaSUIXcPlc6Ru1B", 
        										"http://localhost:7080/jspexp/teamP_09/login/callback.jsp");
    	naver_id_login.setButton("green", 3, 50); //네이버 아이디로 로그인 버튼 설정
    	naver_id_login.setPopup(); //Popup형태의 인증 진행
    	naver_id_login.init_naver_id_login(); 
</script>

</html>
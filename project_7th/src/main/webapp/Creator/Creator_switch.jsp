<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<%
Object sessionChk = session.getAttribute("memnum");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="Creator.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">
</head>
<body>
<%
String memNum = (String) session.getAttribute("memnum");
String creNum = (String) session.getAttribute("creNum");
%>
<header>
		<div class="wrap" style="height: 80px;">
			<div class="header_nav" style="height: 80px;">
				<h3 class="logo" style="position: relative; top:-50px;">
					<a href="../mainPage/mainpage.jsp"><img src="../common/picklogo.png"></a>
				</h3>
				<ul>
					<li><a href="#">Gallery</a></li>
					<li><a href="#">Community</a></li>
					<li><a href="#">Contractor</a></li>
					<li><a href="#">Creator #</a></li>
					<%if (sessionChk == null) {	%>
						<li><a href="#">Be Creator</a></li>
					<%} else {%>
						<li><a href="#">New Artwork</a></li>
					<%} %>
				</ul>
				<div class="utils">
					<div class="account">
						<a href="#">mypage</a>
					</div>
					<div class="login_join">
						<%if (sessionChk == null) {	%>
							<a href="#">Log in</a> <span>|</span> <a href="#">Join</a>
						<%} else {%>
							<a href="#">Log out</a>
						<%}	%>
					</div>
					<div class="search_bar" style="	height: 80px; float: right; ">
						<input type="text" class="search_text1" style="width: 200px; height:20px; font-size: 13px; padding: 18px; position:relative; top:-10px; left:18px; border: none; border-radius: 50px;" placeholder="검색어를 입력해주세요.">
						<button style="	padding: 9px 15px; height: 20px; color: #ffffff; background-color: #10223b; border: none; position:relative; top:-50px; left:18px; 
							border-radius: 50px; cursor: pointer;  font-size: 10pt;"><span style="font-family: Segoe UI Black; position:relative;top:40px; z-index:1; ">Search</span></button>
						<button style=" width: 70px; height: 35px; color: #ffffff; background-color: #10223b; border: none; 
						position:absolute; top:24px; right:260px; border-radius: 50px; z-index:0;"></button>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section>
		<div class="wrap1">
			<div class="myprofile_nav"></div>
			<img class="background" src="image/view.png">
			<article>
				<!-- article에 man-writh:1100px; -->
				<div class="mypage">
					<ul class="nav nav-tabs">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#supporter">서포터</a></li>
						<li class="nav-item"><a class="nav-link" data-toggle="tab"
							href="#creator">크리에이터 </a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade show active" id="supporter">
							<iframe id="mypage" width="100%" height="700px"
								src="Creator_switch_mypage.jsp" frameborder="0"> </iframe>
						</div>
						<div class="tab-pane fade" id="creator">
							<iframe id="mypage" width="100%" height="800px"
								src="Creator_switch_creator.jsp" frameborder="0"> </iframe>
						</div>
					</div>
				</div>
			</article>
		</div>
	</section>
	<footer>
	<div class="wrap">
		<h5>회사정보</h5>
	</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</body>
</html>
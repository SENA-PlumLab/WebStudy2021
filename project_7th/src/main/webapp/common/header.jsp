<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    
    	
import = "model2.vo.*"
import = "model2.login.LoginDao"
import = "model2.myPage.MPDao"
import = "java.util.*"

%>
<%
request.setCharacterEncoding("utf-8");
%>  

<head>
	<link rel="stylesheet" href="../common/loginstyle.css" />
	<link rel="stylesheet" href="../common/style.css" type="text/css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous"> 
	
</head>
<%
// loginM을 넣어야지 작동
Object sessionChk = session.getAttribute("loginM");
%>
<body>
<header>
		
		<form id="login_form" action="../mainPage/mainPage.jsp">
	     <div class="login_popup">
	            <div>
	                <label for="login_popup">x</label>
	                <div> 
	                    <h1>log in</h1>
	                    <div>
	                        <span>ID</span><input type="text" name="email" placeholder="email" value="">
	                    </div>
	                    <div>
	                        <span>PASS</span><input type="text" name="password" placeholder="password" value="">
	                    </div>
	                    <div>
	                        <input id="loginBtn"class="btn_default" type="button" value="log in">
	                        <a href="../signIn/signIn.jsp" class="req">혹시 아이디가 없으신가요?</a>
	                        <a onclick="searchIdPass()">아이디/비밀번호찾기 </a> 
	                    </div>
	                </div>
	            </div>            
	            <label for="login_popup"></label>
	    </div>
	    </form>
    
		<div class="wrap">
			<div class="header_nav">
				<h3 class="logo">
					<a href="../mainPage/mainPage.jsp"><img src="../common/picklogo.png"></a>
				</h3>
				<ul>
					<li><a href="../gallery/Gallery.jsp">Gallery</a></li>
					<li><a href="../community/survey_list.jsp">Community</a></li>
					<li><a href="#">Contractor</a></li>
					<li><a href="../Creator/CreatorShop.jsp">Creator #</a></li>
					<%if (sessionChk == null) {	%>
						<li><a href="#">Be Creator</a></li>
					<%} else {%>
						<li><a href="#">New Artwork</a></li>
					<%} %>
				</ul>
				<div class="utils">
					<%if(sessionChk!=null) { %>
					<div class="account">
						<a href="../Creator/Creator_swich.jsp">mypage</a>
					</div>
					<% } %>
					<div class="login_join">
						<%if (sessionChk == null) {	%>
							<input type="checkbox" id="login_popup">
                            <label for="login_popup"><a>Log in</a></label>
						<%} else {%>
							<span onclick="logOut()"><a>Log out</a></span>
						<%}	%>
					</div>
					<div class="search_bar">
						<input type="text" class="search_text" placeholder="검색어를 입력해주세요.">
						<button>Search</button>
					</div>
				</div>
			</div>
		</div>
	</header> 
	
	<%
	
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email==null){
			email="";
		}
		if(password==null){
			password="";
		}

	%>
	
	<%
			
		boolean loginIs = false;
		LoginDao LoginDao = new LoginDao();
		if(email!=null&&password!=null){
			boolean loginPass = LoginDao.login(email, password);
			if(loginPass){
				loginIs = true;
				ArrayList<Member> loginM = LoginDao.getMember(email, password);
				System.out.println(loginM.get(0).getMemNum());
				session.setAttribute("loginM", loginM.get(0).getMemNum());
			}else{
				loginIs = false;
			}
		}
		
	%>
	<script>
	    window.onload = function(){
	    	var loginInput = document.querySelector("#login_popup");
	    	var loginPopUp = document.querySelector(".login_popup");
	
	    	//click
	    	loginInput.onclick = function(){
	    	    if(loginInput.checked==true){
	    	        loginPopUp.style.display = "block";
	    	    }else{
	    	        loginPopUp.style.display = "none";
	    	    }
	    	};
	    	
	    	
	    	
	    	var email = document.querySelector("[name=email]");
			var password = document.querySelector("[name=password]");
		    
			
	    	
	    	// 로그인 버튼 클릭시
	    	var loginBtn = document.querySelector("#loginBtn");
	    	loginBtn.onclick = function(){
	        	var loginForm = document.querySelector("#login_form");
	    		
	    		// 유효성 검사
	    		if(email.value==null||email.value==""){
	    			alert("아이디를 입력해주세요.");
	    			return false;
	    		}
	    		if(password.value==null||password.value==""){
	    			alert("비밀번호를 입력해주세요.");
	    			return false;
	    		}

	        	loginForm.submit();
	    	}
	    	
	    	
	    	var loginIs = <%=loginIs%>;
			if(email.value!=""&&password.value!=""&&email.value!=null&&password.value!=null){
	        	if(loginIs){
	        		alert("로그인되었습니다.");
	        		location.href="../mainPage/mainpage.jsp";
	        	}else{
	        		// 가져온 dao 정보와 일치하는지의 여부
	            	alert("로그인 실패. 아이디와 비밀번호를 확인해주세요.");
	        	}
			}
	
	    }
	    
	    
		
		
	 // 아이디 찾기 비밀번호 찾기
		// 창사이즈 고정이 안됨 ㅠㅠ 왜지
		function searchIdPass(){
		    window.open("../common/idPassSearch.jsp", "MyOnePick 아이디/비밀번호 찾기", "width=700, height=250, toolbar=no, menubar=no, scrollbars=no, resizable=yes", "_blank");
		}
	 	var loginM = "<%=sessionChk%>";
	 	
	 	function logOut(){
	 		sessionStorage.clear();
	 		location.href="../common/logOut.jsp"
	 	}

	</script>   
</body>
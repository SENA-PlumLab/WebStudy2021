<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All we Can Eat</title>
<link href="join_css.css?ver=2" rel="stylesheet" type="text/css">


</head>
<body>
	<div class="form-structor">
	<div class="signUp slide-up">
		<h2 class="form-title" id="signUp"><span>or</span>Sign up</h2>
		<form method="post" onsubmit="return checkForm_signUp();" action="joinMember_insert.jsp" name="write">
		<div class="form-holder">
			<div class="second-title">필수 입력 항목</div>
			<input type="text" class="input" id="s-memID" name="memID" placeholder="Id" />
			<input type="password" class="input" id="s-memPW" name="memPW" placeholder="Password" />
			<input type="password" class="input" id="memPW2" placeholder="Password 재입력" />
			<div class="email-holder1">
			<input type="text" class="input-mail1" id="mEmail1" name="mEmail1" placeholder="eMail"/>
				<span>@</span>
			</div>
			<div class="email-holder2" id="email-holder2">
				<input type="text" class="input-mail2" name="mEmail2" id="mEmail2" placeholder="domain" value="google.com"/>
				<select name="mEmail2_select" onchange=getEmailSelect(this)>
						<option value="google.com" selected>Google</option>
						<option value="naver.com">Naver</option>
						<option value="daum.net">Daum</option>
						<option value="Other">Other</option>
				</select>
			</div>
			<div class="second-title">기타 입력 항목</div>
			<input type="text" class="input" id="mName" name="mName" placeholder="User name" />
		</div>
		<input type=submit class="submit-btn" value="Sign up">
		</form>
	</div>

	<div class="logIn">
		<div class="center">
			<h2 class="form-title" id="logIn"><span>or</span>Log in</h2>
			<form method="post" onsubmit="return checkForm_logIn();" action="joinMember_logIn.jsp?ver=1" name="write">
			<div class="form-holder">
				<input type="text" class="input" id="l-memID" name="memID" placeholder="Id" />
				<input type="password" class="input" id="l-memPW" name="memPW" placeholder="Password" />
			</div>
			<input type=submit class="submit-btn" value="Log in">
			<div class="form-footer">
				<a href="javascript:openWindowPop('find/find.jsp', 'findMember');">forgot Id/Password?</a>
			</div>
			</form>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">

function openWindowPop(url, name){
    var options = 'top=10, left=10, width=500, height=300, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}
</script>
<script type="text/javascript" src="join_validation.js"></script> 
<script type="text/javascript" src="join_select.js"></script> 
<script type="text/javascript" src="join_animation.js?ver=5"></script> 
</html>
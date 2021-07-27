<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="join_css.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div class="form-structor">
	<div class="signup">
		<h2 class="form-title" id="signUp"><span>or</span>Sign up</h2>
		<div class="form-holder">
			<input type="text" class="input" placeholder="Id" />
			<input type="password" class="input" placeholder="Password" />
			<input type="email" class="input" placeholder="Email" />
		</div>
		<button class="submit-btn">Sign up</button>
	</div>
	<div class="login slide-up">
		<div class="center">
			<h2 class="form-title" id="logIn"><span>or</span>Log in</h2>
			<div class="form-holder">
				<input type="text" class="input" placeholder="Id" />
				<input type="password" class="input" placeholder="Password" />
			</div>
			<button class="submit-btn">Log in</button>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript" src="join_js.js"></script> 
</html>
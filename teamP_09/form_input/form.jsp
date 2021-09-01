<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
    %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>








<!-- Bootstrap Scripts -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- form css --> 
<link href="form_css.css" rel="stylesheet">

<body>
	<main>
		<h2>Form input</h2>
		<div style="margin:20px">
			기본 display:block 입니다..!
			<br>
			<br>display: inline / width: 200px 등으로 조절하셔서 사용하시면 됩니다!
			<br>
			<br><strong>bootstrap link</strong>를 꼭 넣어주세요! (class 이름으로 라이브러리와 연결되는 구조입니다.)
			<br>
			<br>
			<span style="color:#888">
			&lt;!-- Bootstrap Scripts --&gt;
			<br>&lt;link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"&gt;
			</span>
		</div>	
		<br>
		<hr>
		<form style="margin:20px">
			<br>text: <input type="text" class="form-control form-control-sm">
			<br>text: <input type="text" class="form-control form-control-sm" value="disabled" disabled>
			<br>text: <input type="text" class="form-control-plaintext form-control-sm" value="~~readonly plaintext~~" readonly>
			<br>textarea: <textarea class="form-control form-control-sm" row="3"></textarea>
			<br>password: <input type="password" class="form-control form-control-sm"> 
				<span id="passwordHelpInline" class="form-text">
    			  Must be 8-20 characters long.
   				 </span>
			<br>number: <input type="number" class="form-control form-control-sm">
			<br>email: <input type="email" class="form-control form-control-sm" placeholder="name@example.com">
			<br>date: <input type="date" class="form-control form-control-sm">
			<br>file: <input type="file" class="form-control form-control-sm">
			<br>number: <input type="number" class="form-control form-control-sm">
			<br>button(Bootstrap green1): <input type="button" value="button" class="btn btn-success">
			<br>button(Bootstrap green2): <input type="button" value="button" class="btn btn-outline-success">
			<br>button(Custom color): <input type="button" value="button" class="btn btn-success custom-btn">
			<hr>
			<br>radio: 
				<br><input type="radio" class="form-check-input custom-input">
				<label class="form-check-label"> Radio label</label>
        		<br><input type="checkbox" class="form-check-input custom-input" disabled>
				<label class="form-check-label">Disabled radio label</label>
			<hr>
			<br>checkbox: 
				<br><input type="checkbox" class="form-check-input custom-input">
				<label class="form-check-label">Checkbox label</label>
        		<br><input type="checkbox" class="form-check-input custom-input" disabled>
				<label class="form-check-label"> Disabled checkbox label</label>
			<hr>
			<br>checkbox inline:<br>
			<div class="form-check form-check-inline">
				<br><input type="checkbox" class="form-check-input custom-input">
				<label class="form-check-label">Checkbox label</label>
			</div>
			<div class="form-check form-check-inline">
        		<br><input type="checkbox" class="form-check-input custom-input" disabled>
				<label class="form-check-label"> Disabled checkbox label</label>
			</div>
			<hr>
			<br>toggle box style:<br>
			<div class="form-check form-switch">
				<br><input type="checkbox" class="form-check-input custom-input" checked>
				<label class="form-check-label">Checkbox label</label>
        		<br><input type="checkbox" class="form-check-input custom-input" disabled>
				<label class="form-check-label"> Disabled checkbox label</label>
			</div>
			<hr>
			<br>submit: <input type="submit" value="submit" class="btn btn-success custom-btn">
		</form>
		
	
	</main>
</body>
</html>
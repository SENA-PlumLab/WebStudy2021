<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="find_css.css?ver=1" rel="stylesheet" type="text/css">

</head>
<body>
	<table>
	<tr>
	<td >
		<h2>ID 찾기</h2>
	<form method="post" onsubmit="return checkForm_findID();" 
		action="find_Id.jsp?ver=1" name="write">
		<input type="text" name="find1-email" id="find1-email" placeholder="eMail" /> 
		<input type=submit class="submit" value="find Id">
	</form>
	
	</td>
	<td>
		<h2>Password 찾기 </h2>
	<form method="post" onsubmit="return checkForm_findPW();"
			action="find_Pass.jsp?ver=1" name="write">
		<input type="text" name="find2-email" id="find2-email" placeholder="eMail" /> <br>
		<input type="text"  name="find2-id" id="find2-id" placeholder="Id" /><br>
		<input type=submit class="submit" value="find Password">
	</form>
	</td>
	</tr>
	</table>
</body>
<script type="text/javascript" src="find_validation.js"></script> 
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("h3").text("시작");
	});
	$("h3").click(function(){
		console.log("gg");
		$("h3").hide();
	});
	
	
	
	
	
	$("input[type=button]").click(function(){
		var base=$("[name=base]").val();
		console.log(base);
		$("h3").text("타율:"+(base/3).tofixed(3));
	});
</script>
<body>
	<input type="text" name="base" value="0"><br>
	<input type="button" value="확인">
	<hr>
	<h3>h3입니다</h3>
</body>
</html>
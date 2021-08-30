<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%

%>
<body>

	<h2 id="ajax01">get방식/동기처리</h2>
	<h3 id="show01"></h3>
	<h2 id="ajax02">post방식/비동기처리</h2>
	<h3 id="show02"></h3>
</body>

<%-- XMLHttpRequest 객체의 get/post, 동기/비동기 방식의 기본 처리 방식 --%>
<script type="text/javascript">
	$(document).ready(function(){
		var xhr = new XMLHttpRequest();
		$("#ajax01").click(function(){
			//get방식 동기 처리..
			//get방식은 주소에 데이터를 붙여서 전송
			xhr.open("get", "z04_data.jsp?id=himan", false);
			xhr.send();
			$("#show01").text(xhr.responseText);
			console.log(xhr.responseText);
		});
		$("#ajax02").click(function(){
			//post방식 비동기 처리..
			//post방식은 xhr객체에 데이터를 붙여서 전송
			xhr.open("get", "z04_data.jsp", true);
			xhr.send('id=higirl');
			xhr.onreadystatechange=function(){  //폴백
				if(xhr.readyState==4 && xhr.status==200){   //200은 잘넘어왔단 것이다.
					$("#show02").text(xhr.responseText);
					console.log(xhr.responseText);
				}else {
					//console.log("요청오류 : " + xhr.status);
				}
			}
		});
		
		
	});

</script>



</html>
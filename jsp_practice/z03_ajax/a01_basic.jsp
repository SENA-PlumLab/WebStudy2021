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
	<h2>Click Here!</h2>
	<div id="result"></div>

</body>
<script type="text/javascript">
var xhttp;

function createHttpRequest(){
  xhttp = new XMLHttpRequest();  
}

function mySend(){
  createHttpRequest();
  //xhttp.onreadystatechange = callFunction;
  xhttp.open("GET", "z01_data.txt", false);
  xhttp.send();
  
  //아래 코드랑 그냥 합침. state 무시.
  var responseData = xhttp.responseText;
	$("#result").text("받은 데이터: "+responseData);
}

/* function callFunction(){
  if(xhttp.readyState == 4) {
    if(xhttp.status == 200){
      var responseData = xhttp.responseText;
		$("#result").text("받은 데이터: "+responseData);
    }
  }
} */


$("h2").click(mySend());




</script>
</html>
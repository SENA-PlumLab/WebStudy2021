<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../jquery-3.6.0.js"
		type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("h2").text("시작");
	})
	$("th").css("color", "navy");
	$("table input").val("안녕하세요..");
	
	
	$(".myClass").click(function(){
		this.css("border","2px solid blue");
	})
	
	function class04(){
		$(".myClass").css("border","2px solid blue");
	}
	function class05(){
		$(".otherClass").css("color","red");
	}
</script>
</head>
<%--

#선택자(selector)

1. 문서 내에서 원하는 엘리먼트를 쉽게 식별하고 이를 추출하기 위해서 scc/jquery에서 제공하는 기술
2. 기본 css 선택자: css 선택자를 통해서 DOM객체를 선택할 수 있는 것을 말한다.
	1) *: 모든 엘리먼트 일치
	2) E: 태그명이 E인 모든 엘리먼트
	3) E F: 태그명이 E이고 하위 엘리먼트 이름이 F인 엘리먼트

 --%>
<body>
	<h2 align="center"></h2>
	<form id="frm01">
		<table align="center">
		<tr><th>사원명</th><td><input type="text" name="ename" value=""/></td></tr>
		</table>
	</form>
	
	<div class="myClass" onclick="class04()">div class="notMe"</div>
	<div class="otherClass" onclick="class05()">div class="otherClass"</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	window.oncload=function(){
		document.querySelector("h2").innerText="요청시 에러가 발생했습니다."
	}
</script>
</head>
<%
/*
# 에러 페이지 처리

1. 속성 선언
isErrorPage = "true"
2. exception을 참조로하는 여러가지 메서드 활용 가능


*/
%>
<body>
	<h2></h2>
	<table>
	<tr><th>에러타입</th><td><%=exception.getClass().getName() %></td></tr>
	<tr><th>에러메세지지</th><td><%=exception.getMessage() %></td></tr>
	<tr><th colspan="2">잠시 기다리시면 담당자와 통화가 가능합니다.</th></tr>
	<tr><th>담당자</th><td>뭐시기 대리 (010-2929-3030)</td></tr>
	
	
	</table>
		
</body>
</html>
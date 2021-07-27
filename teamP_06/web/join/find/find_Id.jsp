<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.MemberController" %>   
    
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");

String email = request.getParameter("find1-email");

MemberController mCon = new MemberController();
String id = mCon.findIdByEmail(email);
%>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
</head>
<body style="text-align:center;">
	<h2>ID 찾기</h2>
	<hr>
	<div id="result" >
		
	</div>
</body>
<script type="text/javascript">
var result = document.querySelector("#result");
if("<%=id%>"!=null){
	result.innerHTML += "<%=email%>"+"님 아이디 조회 결과: <h2>"+"<%=id%>"+"</h2>";
}
else {
	alert("<%=email%>"+" 님 일치하는 ID가 없습니다!");
	document.location.href="find.jsp"
}
</script>
</html>
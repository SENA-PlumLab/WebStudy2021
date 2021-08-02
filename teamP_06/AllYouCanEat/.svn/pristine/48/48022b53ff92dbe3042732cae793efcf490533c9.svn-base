<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.MemberController" %>   
    
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");

String email = request.getParameter("find2-email");
String id = request.getParameter("find2-id");

MemberController mCon = new MemberController();
String pass = mCon.findPwById(email, id);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Password 찾기</title>
</head>
<body style="text-align:center;">
	<h2>Password 찾기</h2>
	<hr>
	<div id="result" >
		
	</div>
	<div>
		<button onclick="self.close();">닫기</button>
	</div>
</body>
<script type="text/javascript">
var result = document.querySelector("#result");
if("<%=pass%>"){
	result.innerHTML += "<%=id%>"+"님 비밀번호 조회 결과: <h2>"+"<%=pass%>"+"</h2>";
}
else {
	alert("<%=id%>"+" 님 일치하는 Password가 없습니다!");
	document.location.href="find.jsp"
}
</script>
</html>
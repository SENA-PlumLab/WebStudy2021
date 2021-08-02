<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.Member" %>
<%@ page import="teamP_06.MemberController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String memID = request.getParameter("memID");
String memPW = request.getParameter("memPW");

MemberController mCon  = new MemberController();
boolean isLoggedIn;
Member m = new Member();

if(mCon.logInMember(memID, memPW)) {
	isLoggedIn=true;
	m = mCon.findMemberByID(memID);
} else {
	isLoggedIn=false;
}
%>

</body>

<script type="text/javascript">
	if(<%= isLoggedIn %>){
		alert("<%=memID%>님 환영합니다!");
		document.location.href="joinMember.jsp";		
	} else {
		alert("로그인 실패! 아이디와 비밀번호를 확인하세요.");
		document.location.href="joinMember.jsp";
	}
</script>
</html>
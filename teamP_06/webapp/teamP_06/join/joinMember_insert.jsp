<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.MemberController" %>   
<!DOCTYPE html>

<%
request.setCharacterEncoding("UTF-8");

String memID = request.getParameter("memID");
String memPW = request.getParameter("memPW");
String mName = (request.getParameter("mName") != null && request.getParameter("mName") != "")?request.getParameter("mName"):null;
String mEmail = request.getParameter("mEmail1")+"@"+request.getParameter("mEmail2");
//String mImage = (request.getParameter("mImage") != null && request.getParameter("mImage") != "")?request.getParameter("mImage"):null;

MemberController mCon = new MemberController();
String[] result = mCon.joinMember(memID, memPW, mName, mEmail, null);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>MemID: <%=memID %></h3>
	<h3>MemPW: <%=memPW %></h3>
	<h3>MemNick: <%=mName%></h3>
	<h3>MemMail: <%=mEmail %></h3>
	<hr>
	<h2>result: <%=result[0] %>, <%=result[1] %></h2>

</body>
<script type="text/javascript">
	if (typeof window !== 'undefined') { 
		window.alert('('+'<%=result[0] %>'+') '+'<%=result[1] %>'+'님 가입을 환영합니다! ^^');
	} 
	document.location.href="logIn.jsp";	
</script>
</html>
<%@page import="a00_exp.a02_0727"%>
<%@page import="a00_exp.a02_0727_Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

String ID = request.getParameter("id");
String PW = request.getParameter("pass");
String time1 = request.getParameter("time1");
String time2 = request.getParameter("time2");

a02_0727 mem1;
a02_0727_Dao dao1 = new a02_0727_Dao();
mem1 = dao1.verify(ID, PW);


%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="status">
		<h2>ID: <%=mem1.getId() %></h2><h2>PW: <%=mem1.getPw() %></h2>
	</div>
	<div>
	<h2>환영합니다^^</h2>
	<hr>
	로그인 일시: <%=time1 %>, <%=time2 %><br>
	</div>
</body>
<script type="text/javascript">
var status = document.querySelector("#status");

	if(<%= mem1.getPw() %> != null){
		alert("로그인 성공!");
		status.innerHTML="<h2>ID: <%=mem1.getId() %></h2><h2>PW: <%=mem1.getPw() %></h2>";		
	} else {
		alert("로그인 실패!");
		status.innerHTML="";
		//location.href="a02_0727.jsp";
	}
</script>
	
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

Cookie[] c1 = request.getCookies();

for(Cookie c : c1){
	out.println(c.getName()+": "+c.getValue()+"\n");
	//System.out.println(c.getName()+": "+c.getValue());
}
%>
<body>
	<h2>가져온 쿠키 값</h2>
	<table id="cookie">
	<%for(Cookie c:request.getCookies()){ %>
	<tr><td><%=c.getName() %></td><td><%=c.getValue() %></td></tr>
	<%} %>
	</table>
</body>
<script type="text/javascript">
//var cObj  = document.querySelector("#cookie");

</script>
</html>
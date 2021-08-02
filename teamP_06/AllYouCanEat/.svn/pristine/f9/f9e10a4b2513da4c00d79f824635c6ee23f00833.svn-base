<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ page import="teamP_06.BBSController" %>   
    
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

BBSController bCon = new BBSController();

String memNum = request.getParameter("memNum");
String bbsNum = request.getParameter("bbsNum");

String title = request.getParameter("title");
String subTitle = request.getParameter("subtitle");
String contents = request.getParameter("ir1");

bCon.editBBS(bbsNum, contents);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

</body>
<script type="text/javascript">
if (typeof window !== 'undefined') { 
	window.alert("수정 완료!");
} 
document.location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsNum%>";

</script>
</html>
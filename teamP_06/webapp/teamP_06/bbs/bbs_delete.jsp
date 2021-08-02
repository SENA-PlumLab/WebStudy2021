<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.BBSController" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

BBSController bCon = new BBSController();
String memNum = request.getParameter("memNum");
String bbsNum = request.getParameter("bbsNum");

bCon.deleteBBS(bbsNum);

%>

</body>
<script type="text/javascript">
alert("삭제 완료!");
location.href="bbs_list.jsp?memNum=<%=memNum%>&index=1";
</script>
</html>
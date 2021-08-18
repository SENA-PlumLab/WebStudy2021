
<%@page import="teamP_07.FundingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%
request.setCharacterEncoding("UTF-8");
String[] fdNum= request.getParameterValues("update");
int statusNum= Integer.parseInt(request.getParameter("status"));

FundingDao fDao = new FundingDao();

fDao.updateFunding(fdNum, statusNum);

%>
<body>
	
	
</body>
<script type="text/javascript">
alert('반영 완료!');
document.location.href="../funding/entire.jsp";
</script>
</html>
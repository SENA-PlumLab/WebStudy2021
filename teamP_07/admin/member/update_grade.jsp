<%@page import="teamP_07.MemberDao"%>
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
String[] checked= request.getParameterValues("update");

MemberDao mDao = new MemberDao();

mDao.updateToCreator(checked);
mDao.updatePortfolioConfirm(checked);
%>
<body>
	
	
</body>
<script type="text/javascript">
alert('등업 완료!');
document.location.href="../member/entire.jsp";
</script>
</html>
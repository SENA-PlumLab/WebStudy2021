<%@page import="teamP_07.PortfolioDao"%>
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
String[] pfNumList= request.getParameterValues("pfNum");
String[] checked= request.getParameterValues("update");
int status= Integer.parseInt(request.getParameter("status"));

MemberDao mDao = new MemberDao();
PortfolioDao pDao = new PortfolioDao();

if (status == 2 || status == 3){
	mDao.updateMemberGrade(checked, status);
	mDao.updatePortfolioConfirm(checked, status);
	pDao.updatePortfolio(pfNumList, status);
} else {
	mDao.updateMemberGrade(checked, status);
}

%>
<body>
	
</body>
<script type="text/javascript">
alert('변경 완료!');
document.location.href="../member/entire.jsp";
</script>
</html>
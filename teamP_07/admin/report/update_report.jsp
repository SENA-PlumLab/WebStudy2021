
<%@page import="teamP_07.ReportDao"%>
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
String[] rptnum= request.getParameterValues("update");
String[] memnum2= request.getParameterValues("memnum2");
int statusNum= Integer.parseInt(request.getParameter("status"));

ReportDao rDao = new ReportDao();

if(statusNum==1){
	rDao.updateReport((String)session.getAttribute("eeenum"), rptnum, statusNum);
	rDao.updateMemberReport(memnum2);
}
else {
	rDao.updateReport((String)session.getAttribute("eeenum"), rptnum, statusNum);
}

%>
<body>
	
	
</body>
<script type="text/javascript">
alert('반영 완료!');
document.location.href="../report/check_report.jsp";
</script>
</html>
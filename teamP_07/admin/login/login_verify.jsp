<%@page import="teamP_07.Admin"%>
<%@page import="teamP_07.AdminDao"%>
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
String id = request.getParameter("id");
String pass = request.getParameter("pass");

Boolean isLoggedIn=false;

AdminDao aDao = new AdminDao();
Admin a = aDao.getAdminDTO_byID(id);


if(a.getId()==null){
	isLoggedIn=false;
}else if(id.equals(a.getId()) && pass.equals(a.getPass()) ){
	isLoggedIn=true;
	session.setAttribute("eeenum", a.getEeeNum());
	session.setAttribute("name", a.getName());
	session.setAttribute("dept", a.getPos_name());
	session.setAttribute("date", a.getSysdate());
}


%>

</body>

</body>

<script type="text/javascript">

	if(<%= isLoggedIn %>){
		alert("<%=session.getAttribute("name")%>님 환영합니다!");
		document.location.href="../index/admin_index.jsp";		
	} else {
		alert("로그인 실패! 아이디와 비밀번호를 확인하세요.");
		document.location.href="login.jsp";
	}

</script>
</html>
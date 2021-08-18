<%@page import="teamP_07.Member"%>
<%@page import="teamP_07.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
 <!-- Bootstrap Scripts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>

<%
String memNum = request.getParameter("memNum");

MemberDao mDao = new MemberDao();
Member m = mDao.getmemberDTO_num(memNum);

%>
<body style="margin:10px;">
	<div class="table-responsive">
		<table class="table table-hover table-sm">
			<thead style="text-align:center;">
				<tr>
					<th scope="col" width="20%">구분</th>
					<th scope="col">내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">Member</th>
					<td><%=m.getMemNum()%></td>
				</tr>
				<tr>
					<th scope="row">ID</th>
					<td><%=m.getmID()%></td>
				</tr>
				<tr id>
					<th scope="row">Grade</th>
					<td><%=m.getMemgrade()%></td>
				</tr>
				<tr>
					<th scope="row">Join Date</th>
					<td><%=m.getJoinDate()%></td>
				</tr>
				<tr>
					<th scope="row">Mod Date</th>
					<td><%=m.getModDate()%></td>
				</tr>
				<tr>
					<th scope="row">Image</th>
					<td><%=m.getMemImg()%></td>
				</tr>
				<tr>
					<th scope="row">Nick Name</th>
					<td><%=m.getmName()%></td>
				</tr>
				<tr>
					<th scope="row">Text</th>
					<td><%=m.getMemText()%></td>
				</tr>
				<tr>
					<th scope="row">Phone</th>
					<td><%=m.getMemPhone()%></td>
				</tr><tr>
					<th scope="row">Report</th>
					<td><%=m.getReport() %></td>
				</tr>
				
				
			</tbody>
		</table>
	</div>
	<div style="text-align: center;">
		<button id="close">닫기</button>
	</div>
</body>
<script type="text/javascript">

$("#close").click(function(){
	window.close();
});

</script>
</html>
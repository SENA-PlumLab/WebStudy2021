<%@page import="teamP_07.Portfolio"%>
<%@page import="teamP_07.PortfolioDao"%>
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
String pfNum = request.getParameter("pfNum");

PortfolioDao pDao = new PortfolioDao();
Portfolio p = pDao.getPortfolio(pfNum);

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
					<th scope="row">Portfolio</th>
					<td><%=p.getPfNum()%></td>
				</tr>
				<tr>
					<th scope="row">Member</th>
					<td><%=p.getMemNum()%></td>
				</tr>
				<tr>
					<th scope="row">Status</th>
					<td><%=p.getStatus()%></td>
				</tr>
				<tr>
					<th scope="row">Title</th>
					<td><%=p.getTitle()%></td>
				</tr>
				<tr>
					<th scope="row">File</th>
					<td><%=p.getPffile()%></td>
				</tr><tr>
					<th scope="row">Link</th>
					<td><%=p.getPflink() %></td>
				</tr>
				<tr id="contents">
					<th scope="row">Contents</th>
					<td><%=p.getContents()%></td>
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
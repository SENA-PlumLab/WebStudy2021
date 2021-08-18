<%@page import="teamP_07.Funding"%>
<%@page import="teamP_07.FundingDao"%>
<%@page import="teamP_07.Contents"%>
<%@page import="teamP_07.ContentsDao"%>
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
String fdNum = request.getParameter("fdNum");

FundingDao fDao = new FundingDao();
Funding f = fDao.getFunding(fdNum);

float per=0;
int price=f.getPrice();
int price_target=f.getPrice_target();

if(price>0){
	per = ((float)price/(float)price_target)*100;
}


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
					<th scope="row">Funding</th>
					<td><%=f.getFdNum()%></td>
				</tr>
				<tr>
					<th scope="row">Creator</th>
					<td><%=f.getCreName()%> (<%=f.getCreNum() %>)</td>
				</tr>
				<tr>
					<th scope="row">Theme</th>
					<td><%=f.getTheme_name()%> (<%=f.getTheme() %>)</td>
				</tr>
				<tr>
					<th scope="row">Category</th>
					<td><%=f.getCategory_name()%> (<%=f.getCategory() %>)</td>
				</tr>
				<tr>
					<th scope="row">Registered Date</th>
					<td><%=f.getReg_date()%></td>
				</tr>
				<tr>
					<th scope="row">Expire Date</th>
					<td><%=f.getExpire_date()%></td>
				</tr>
				<tr>
					<th scope="row">Status</th>
					<td><%=f.getStatus_name()%> (<%=f.getStatus() %>)</td>
				</tr>
				<tr>
					<th scope="row">Title</th>
					<td><%=f.getFdtitle()%></td>
				</tr>
				<tr>
					<th scope="row">Price</th>
					<td>목표 <%=f.getPrice_target() %>원<br>현재 <%=f.getPrice() %>원 (진행률 <%=per %>%)</td>
				</tr>
				<tr>
					<th scope="row">Funding Image</th>
					<td><%=f.getFdImg()%></td>
				</tr>
				<tr>
					<th scope="row">Tags</th>
					<td><%=f.getTags()%></td>
				</tr>
				<tr>
					<th scope="row">Story Image</th>
					<td><%=f.getStoryImg()%></td>
				</tr>
				<tr>
					<th scope="row">Story Summary</th>
					<td><%=f.getStorySum()%></td>
				</tr>
				<tr>
					<th scope="row">Story</th>
					<td><%=f.getStory()%></td>
				</tr>
				<tr>
					<th scope="row">Refund</th>
					<td><%=f.getRefund()%></td>
				</tr>
				<tr>
					<th scope="row">Policy</th>
					<td><%=f.getPolicy()%></td>
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
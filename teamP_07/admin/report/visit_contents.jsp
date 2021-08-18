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
String cttNum = request.getParameter("cttNum");
String[] cttArray = cttNum.split("-");
ContentsDao cDao = new ContentsDao();
Contents c = new Contents();

boolean isCmt = false;
boolean isBBS = false;
boolean isFud = false;

if(cttArray[0].equals("cmt")){
	c = cDao.getComment(cttNum);
	isCmt = true;
	
}
else if (cttArray[0].equals("bbs")){
	c = cDao.getBBS(cttNum);
	isBBS = true;
} 
else if (cttArray[0].equals("fud")){
	c = cDao.getFunding(cttNum);
	isFud = true;

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
					<th scope="row">Contents</th>
					<td><%=c.getCttNum()%></td>
				</tr>
				<tr>
					<th scope="row">Member</th>
					<td><%=c.getMemNum()%></td>
				</tr>
				<tr>
					<th scope="row">Income Date</th>
					<td><%=c.getIncome()%></td>
				</tr>
				<tr>
					<th scope="row">Status</th>
					<td><%=c.getStatus()%></td>
				</tr>
				
				<!-- bbs -->
				<tr id="bbstitle" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="viewCnt" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				
				<!-- Comment -->
				<tr id="bbsNum" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				
				<!-- funding -->
				<tr id="creNum" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="fdTitle" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="fdImg" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="storyImg" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="storySum" style="display:none;">
					<th scope="row"></th>
					<td></td>
				</tr>
				<tr id="contents">
					<th scope="row">Contents</th>
					<td><%=c.getContents()%></td>
				</tr>

			</tbody>
		</table>
	</div>
	<div style="text-align: center;">
		<button id="close">닫기</button>
	</div>
</body>
<script type="text/javascript">
if(<%=isCmt%>){
	$("#bbsNum").attr('style', "display:");
	$("#bbsNum>th").html("bbsNum");
	$("#bbsNum>td").html("<%=c.getBbsNum()%>");
}
else if (<%=isBBS%>){
	$("#bbsTitle").attr('style', "display:");
	$("#bbsTitle>th").html("bbsTitle");
	$("#bbsTitle>td").html("<%=c.getBbsTitle()%>");
	
	$("#viewCnt").attr('style', "display:");
	$("#viewCnt>th").html("viewCnt");
	$("#viewCnt>td").html("<%=c.getViewCnt()%>");
}
else if (<%=isFud%>){
	$("#fdTitle").attr('style', "display:");
	$("#fdTitle>th").html("fdTitle");
	$("#fdTitle>td").html("<%=c.getFdtitle()%>");
	
	$("#fdImg").attr('style', "display:");
	$("#fdImg>th").html("fdImg");
	$("#fdImg>td").html("<%=c.getFdImg()%>");
	
	$("#storyImg").attr('style', "display:");
	$("#storyImg>th").html("storyImg");
	$("#storyImg>td").html("<%=c.getStoryImg()%>");
	
	$("#storySum").attr('style', "display:");
	$("#storySum>th").html("storySum");
	$("#storySum>td").html("<%=c.getStorySum()%>");
}

$("#close").click(function(){
	window.close();
});

</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="Creator.*"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick</title>
<link rel="stylesheet" href="CreatorShop.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<script src="jquery-3.6.0.js" 
	type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function () {
	var following = 1004;
	var isFollowing = 1;
	$('#following').val('FOLLOWING '+following)
	$('#following').click(function(){
		if (isFollowing++%2==1) {
			$('#following').val('FOLLOWING '+(following++))
		}else {
			$('#following').val('FOLLOWING '+(following--))
		}

	});
});
</script>
</head>
<%
	session.setAttribute("creNum","'crt-0001'");
	String memNum = (String) session.getAttribute("memnum");
	String creNum = (String) session.getAttribute("creNum");
	DAO_MyOnePick dao = new DAO_MyOnePick ();
	dao.getFundingList(creNum);
%>
<body>
	<%@include file="../common/header.jsp"%>
	<div id="title">
		<input type="button" id="following" value="FOLLOWING ">
		<img src="image/creator_logo.png" id="title_img">
	</div>
		<div id="menubar">
			<ul>
				<li>ALL</li>
				<li>CLOTHES</li>
				<li>ACCESSORIES</li>
				<li>OFFICE SUPPLIES</li>
				<li>　　</li>
				<li>　　</li>
				<li>　　</li>
				<li>ABOUT</li>
				<li>　　</li>
			</ul>
		</div>
	<section>
		<div class="wrap">
			<article>
				<!-- article에 man-writh:1100px; -->
				<input type="button" id="fielter" value="최신순">
				<input type="button" id="fielter" value="인기순">
				<br>
				<br>
				<br>
				<br>
				<h3 style="position: relative">
					상품 (<%=dao.getNoofFunding(creNum)%>)
				</h3>
				<%	for (int idx = 0; idx < dao.getFundingList(creNum).size(); idx++) {
					int Percent = dao.getFundingList(creNum).get(idx).getFdTargetPrice();
					if (Percent > 100) Percent = 100;
				%>
				<div id="fund_detail">
					<img src="<%=dao.getFundingList(creNum).get(idx).getFdImg()%>"
						id="fund_img">
					<h3><%=dao.getFundingList(creNum).get(idx).getFdProjectNM()%></h3>
					<h3><%=dao.getFundingList(creNum).get(idx).getFDCATEGORYNM()%>
						<span style="font-weight: bold; color: #138396; font-size: 23px;"> I </span> 
						<span style="color: #138396; font-size: 15px;"><%=dao.getFundingList(creNum).get(idx).getCreNM()%></span>
					</h3>
					<br>
					<div id="percent_num" style="width: <%=Percent * 3%>px;"></div>
					<div id="percent"></div>
					<h3 style="font-weight: bold; color: #138396; font-size: 23px">
						<%=dao.getFundingList(creNum).get(idx).getFdTargetPrice()%>%
						<span style="color: #D5D5D5; font-size: 15px;"><%=dao.getFundingList(creNum).get(idx).getFdingprice()%>
							　　　　　　마감<%=dao.getFundingList(creNum).get(idx).getFdExpDT()%>일전</span>
					</h3>
				</div>
				<%} %>
				
				
			</article>
		</div>
	</section>
	<%@include file="../common/footer.jsp" %>
</body>
</html>
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
<link rel="stylesheet" href="Creator.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
</head>
<body>
<header>
<%
	session.setAttribute("creNum","'crt-0001'");
	String memNum = (String) session.getAttribute("memnum");
	String creNum = (String) session.getAttribute("creNum");
	
	DAO_MyOnePick dao = new DAO_MyOnePick ();
	dao.CreatorList(creNum);
	String creNM = dao.CreatorList(creNum).get(0).getCreNM();
	dao.getFundingList(creNum);
%>
</header>    
	<section style="border;">
		<div id="wrap2" style="border-right: 0.2px solid #DDEEEB; ">
				<div class="profile">
				<div class="profileimg" >
				</div>
				</div>
				<div class="profileimg_edit">
				</div>
				<div class="profile_title"><%=dao.CreatorList(creNum).get(0).getCreNM()%><img src="image/to.png" style="width:15px; height:15px"></div>
				<br>
		        <ui class="mainMenu">
		            <li class="subject">
		                <a href="#account" class="Menu">크리에이터페이지</a>
		                	<%-- Btn ==> Menu로 변경했음 --%>
		                <div class="subMenu">
		                    <a href="Funding_Register.jsp" target="_parent">펀딩등록</a>
		                    <a href="#">펀딩관리</a>
		                    <a href="#">커뮤니티관리</a>
		                </div>
		            </li>
		     	</ui>
		</div>
		<div id="wrap3">
			<h3 class="funing_list">진행중인 펀딩 (<%=dao.getNoofFunding(creNum)%>)</h3>
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
			<div id="funding_register">
				<input type="button" value="새로운 펀딩 신청" id="funding_register_button" onclick="location.href='Funding_Register.jsp'" 
				target="_parent" />
			</div>
			<hr id="inside_line">
			<div id="liner">
				<div id="liner_img">
					<img src="image/community.png">
				</div>
				<div id="liner_text">　커뮤니티</div>
				<div id="liner_img">
					<img src="image/guide.png">
				</div>
				<div id="liner_text">　이용가이드</div>
			</div>
			<hr id="inside_line">
			<div class="event_banner">
				<img src="image/event.png" class="event_banner_img"> 
				<img src="image/event2.png" class="event_banner_img">
			</div>
		</div>
	</section>
<footer>

</footer>
</body>
</html>
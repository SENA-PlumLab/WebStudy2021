<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*"
	import="foodreview.Mydeal"
	import="foodreview.Mydeal_DAO"%>
<%
request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html>
<html>
<head lang="ko">
<meta charset="utf-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="-1">
<title>All You Can Eat</title>
<link rel="stylesheet" href="../include/style.css?ver1" />
<link rel="stylesheet" href="../include/mypage.css">
<link rel="stylesheet" href="../mydeal/myDeal.css?ver2">
<style type="text/css">
.state > a{
	color : orange;
}
.state > a:hover{
	background-color : orange;
	color : white;
}
</style>
</head>
<body>
	<%@include file="../include/header.jsp"%>
	<%
	String memNum = request.getParameter("memnum");
	Mydeal_DAO dao = new Mydeal_DAO();
	ArrayList<Mydeal> availableList = dao.getAvailableDealList(memNum);
	%>
	<section>
		<div class="wrap">
			<article>
				<!-- article에 man-writh:1100px; -->
				<h2>내 셰프딜</h2>
				<div class="mypage_nav">
					<div class="page_nav">
						<ul>
							<li class="page_nav_item"><a href="../profile/profile.jsp?memnum=<%=memNum%>">프로필</a></li>
							<li class="page_nav_item"><a href="../myReview/myReview.jsp?memnum=<%=memNum%>">리뷰</a></li>
							<li class="page_nav_item"><a href="../mydeal/myDeal.jsp?memnum=<%=memNum%>">셰프딜</a></li>
							<li class="page_nav_item"><a href="#">리스트</a></li>
							<li class="page_nav_item"><a href="#">북마크</a></li>
						</ul>
					</div>
				</div>
				<div class="mydeal_nav">
					<div class="inner_nav">
						<ul>
							<li class="inner_nav_item"><a href="../mydeal/myDeal.jsp?memnum=<%=memNum%>">구매내역</a></li>
							<li class="inner_nav_item"><a href="../mydeal/myDealManage.jsp?memnum=<%=memNum%>">구매관리</a></li>
						</ul>
					</div>
				</div>
				<div class="mydeal_container">
					<div class="mydeal_history">
						<div class="history_title"><span>환불하기</span></div>
						<%if(availableList.size()==0){ %>
						<div class="no_list">사용가능한 셰프딜이 없습니다.</div>
						<%} else{ %>
						<%for (Mydeal d : availableList){ %>
						<div class="history_box">
							<div class="history_container">
								<div class="thumbnail">
									<img id="thumb" src="<%=d.getDimage()%>">
								</div>
								<div class="summary">
									<div class="title">
										<a href="#"><%=d.getResttitle()%></a>
										<div class="state">
											<a href="myDealManage_refund.jsp?memnum=<%=memNum%>&cdnum=<%=d.getCdNum()%>">환불하기</a>
										</div>
									</div>
									<div class="deal_name"><a href="#"><%=d.getDname()%></a></div>
									<div class="buy_due">사용기한 : <%=d.getTodate()%></div>
									<div class="info">
										<div class="deal_info"><span id="head">가격</span><%=d.getDpricebf() %>원</div>
										<div class="deal_info"><span id="head">구매가격</span><%=d.getDpriceaf()%>원</div>
										<div class="deal_info"><span id="head">적립포인트</span><%=d.getSpoint() %></div>
										<div class="deal_info"><span id="head">결제방법</span><%=d.getMethodstatus() %></div>
									</div>
								</div>
							</div>
						</div>
						<%} %>
						<%} %>
					</div>
				</div>	
			</article>
		</div>
	</section>
	<%@ include file="../include/footer.jsp"%>

	<script type="text/javascript" src="../include/mypageNav.js?ver1"></script>
</body>
</html>
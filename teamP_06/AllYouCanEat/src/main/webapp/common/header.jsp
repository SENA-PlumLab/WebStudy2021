<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8"); //요청값에 대한 한글 encoding 처리
//기준 경로 설정 \jspexp\src\main\webapp
%>
<header>
	<div class="wrap">
		<div class="header_nav">
			<h1 class="logo">
                    <a href="/AllYouCanEat/main/index_login.html"><img src="../image/FOODlogo.png"></a>
			</h1>
			<ul>
                    <li><a href="/AllYouCanEat/mypage/profile/profile.jsp">프로필</a></li>
                    <li><a href="/AllYouCanEat/bbs/bbs_list.jsp">맛집기행문</a></li>
                    <li><a href="/AllYouCanEat/rest_review/delList/delList.html">맛집리스트</a></li>
                    <li><a href="/AllYouCanEat/ChefDeal/ChefDealList.jsp">쉐프딜</a></li>
			</ul>
		</div>
	</div>
</header>
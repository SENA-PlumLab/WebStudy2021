<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Project_6th.JAVA.z0717_project.*"
    import="Project_6th.JAVA.z02_vo.*"
    import="java.util.ArrayList"
    %>
 <% 
 request.setCharacterEncoding("utf-8"); // 한글 encoding처리
 String path =request.getContextPath(); // 기준경로 설정
	DAO_AllYouCanEat Dao = new DAO_AllYouCanEat ();
	int idx=0; 
	String [] status = {"여름시즌 한정 딜입니다.","방문포장가능 딜입니다.","여름시즌 한정 딜입니다.","방문포장가능 딜입니다.","여름시즌 한정 딜입니다."};
	String [] percent = {"20","30","15","20","20"};
	String [] newly = {"image/new.png","image/new.png","","image/new.png","image/new.png"};
	String [] size = {"","","style='right: -80px;'","",""};
	String [] size2 = {"","","style='right: -150px;'","",""};
	String [] area = {"서울","경기","충청","전라","부산","제주"};
	String loc = request.getParameter("loc");
 %>
<!doctype html>
<html>
 <head lang="ko">
 	<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
     <meta charset="utf-8">
     <title>All You Can Eat</title>
     <link rel="stylesheet" href="style.css?after" />
 </head>
 <body>
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
     <section>
         <div class="wrap">
             <article> <!-- article에 man-width:1100px; -->
					<div>
					<select onchange="Filter()" name="select">
						<option>선택</option>	
						<% for (int cnt=0; cnt<area.length; cnt++) { %>
						<option><%=area[cnt] %></option>
						<%} %>
					</select>
					</div>
					<br>
					<table style="font-family:'Noto Sans KR', sans-serif">		
					<tr>			
					<% for (ChefDeal cd:Dao.getChefDealList(new ChefDeal(loc))) { 

						%>
						<td onclick="showdetail()">
							<div id="img_box">
								<img src="../ChefDeal<%=cd.getdImage() %>" width="300px" height="200px" id="img_food" >
							</div>
							<div id="img_box_info">
								<h2 style="color:#353535; text-align:center; font-weight:bold;">[<%=cd.getAddress() %>]<%=cd.getRestTitle() %></h2>
								<h3 style="color:#A6A6A6; text-align:center; text-decoration: underline;"> <%=cd.getdName() %> </h3>
								<div id="deal_info"><%=status[idx] %> </div>
								<span><img src="image/point_<%=cd.getdPercent() %>.png" id="img_info"><img src="<%=newly[idx]%>" id="img_info2" style="left:-60px" ></span>
								<span id="price_bf"<%=size2[idx]%>><%=cd.getdPricebf() %>원</span><span id="price_af"<%=size[idx]%>><%=cd.getdPriceaf() %>원</span>
							</div>
						</td>
					<% idx++;
					if (idx%3==0) { %>
						</tr>
						<tr>
					<%} %>	
				<%} 
				if (idx==0) { %>
					<h2 style="text-align:center; color:#FFB10A;">조회된 데이터가 없습니다.</h2>	
				<%}%>	
					
				</table>

             </article>
         </div>
     </section>
     <footer>
         <div class="wrap">
             <h5>회사정보</h5>
         </div>
     </footer>
 </body>
 
    
    
    
<script type="text/javascript">
    
	function Filter(selectVal){
		var selectVal = document.querySelector("select").value;
 			//location.href="이동할페이지?요청key=요청값"
 		location.href="ChefDealListFilter.jsp?loc="+selectVal;
 	}

	function showdetail(obj){
 		location.href="ChefDeal.jsp?deal=4";
 	}


</script>
    
    
</html>




    
</html>





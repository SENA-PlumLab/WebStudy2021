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
    ArrayList <ChefDeal> cd = Dao.getChefDealList();
	String deal = request.getParameter("deal");
	int dealnum = Integer.parseInt(deal);
    %>
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

					<table  width="1100px" style="font-family:'Noto Sans KR', sans-serif">
					
					<thead>
						<tr class="line">
							<th><img src="image_food/mfg.png" width="1000px" height="450px"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="title" style="color:#353535; font-size:30px">
								[<%=cd.get(dealnum).getAddress()%>]<%=cd.get(dealnum).getRestTitle() %>
								<br><input type="button" name="rest" value="맛집상세보기 >"/>
							</td>
						<tr>
							<td class="contents" style="color:#A6A6A6; font-size:25px; font-weight:bold">
								<%=cd.get(dealnum).getdName() %> 
							</td>
						</tr>
						<tr>
							<td class="contents" style="font-weight: bold">
								사용기간 : 구매일로부터 90일
							</td>
						</tr>
						<tr>
							<td style="font-weight: bold; text-align:right">
								<span style="color:#A6A6A6; padding-right:100px; text-decoration: line-through;">
								<%=cd.get(dealnum).getdPricebf() %>원</span>
								<br><span><img src="image/point_<%=cd.get(dealnum).getdPercent() %>.png" style="width:60px; height:30px;"></span>
								<span style="color:#191919; padding-right:100px; font-size:25px"><%=cd.get(dealnum).getdPriceaf() %>원</span>
							</td>
						</tr>
						
														
						<tr>
							<td>
								<hr style= "height: 1px; background-color:#A6A6A6">
							</td>
						</tr>
						<tr>
							<td>
								<div id="deal_info"> 여름시즌 한정 딜입니다. </div>
							</td>
						</tr>
						<tr>
							<td class="title">
								맛집 소개
							</td>
						</tr>
						<tr>
							<td class="contents">
								매드포갈릭은 식재료 손질부터 메뉴의 완성까지 
								<br>300명의 전문셰프와 함께, 모든 매장을 직접 운영합니다.
								<br>매드포갈릭은 경상북도 의성군 마늘농장에서 연간 350t에 달하는 마늘을 사용하며, 
								<br>최상의 식재료만을 고집합니다.
								<br>24시간 숙성한 생 도우 피자, 20여가지에 달하는 매드포갈릭만의 수제 특제 소스,
								<br>다양한 조리법으로 마늘의 풍미를 더한 시크릿 레서피는 매드포갈릭의 프라이드입니다.
								<br>매드포갈릭의 프라이빗 브랜드 와인 (Mad Wine)은 와인라벨의 독창적인 디자인 아트웍과 함께 
								<br>이탈리아, 프랑스, 스페인 등 유서깊은 정통 유럽 와이너리에서 생산된 와인만을 엄선합니다.
							</td>
						</tr>
						<tr>
							<td class="title">
								메뉴 소개
							</td>
						</tr>
						<tr>
							<td class="contents">
								<div>
									<span style="color:#353535; font-size:20px; font-weight:bold"><%=cd.get(dealnum).getdName() %></span>
								</div>
								치즈를 듬뿍 버무린 리소 파스타와 버터에 구운 랍스터, 그리고 허브향 가득한 신선한 채소와 육즙이 가득한 등심 스테이크 앤 리소 랍스터 
								<br>※ 11,500원 추가 시 300g으로 제공됩니다. 
								<br>※ Side menu 리소 랍스터 14,000원, 프레시 부라타 치즈(50g) 5,000원 
								<br>※ 특정 원재료에 알레르기가 있으신 경우 매장에 사전 문의 부탁드립니다.
							</td>
						</tr>						
						<tr>
							<td class="title">
								맛집 위치
							</td>
						</tr>
						<tr>
							<td class="contents">
								<div style="font:normal normal 400 12px/normal dotum, sans-serif; width:700px; height:432px; color:#333; position:relative"><div style="height: 400px;"><a href="https://map.kakao.com/?urlX=391444.0&amp;urlY=5743.0&amp;name=%EC%A0%9C%EC%A3%BC%ED%8A%B9%EB%B3%84%EC%9E%90%EC%B9%98%EB%8F%84%20%EC%A0%9C%EC%A3%BC%EC%8B%9C%20%EB%8F%99%EB%AC%B8%EB%A1%9C%2055&amp;map_type=TYPE_MAP&amp;from=roughmap" target="_blank"><img class="map" src="http://t1.daumcdn.net/roughmap/imgmap/c813f1fdf437272f61ca3067ccf556c278918a10a3948c369ff77edb974354d8" width="698px" height="398px" style="border:1px solid #ccc;"></a></div><div style="overflow: hidden; padding: 7px 11px; border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 0px 0px 2px 2px; background-color: rgb(249, 249, 249);"><a href="https://map.kakao.com" target="_blank" style="float: left;"><img src="//t1.daumcdn.net/localimg/localimages/07/2018/pc/common/logo_kakaomap.png" width="72" height="16" alt="카카오맵" style="display:block;width:72px;height:16px"></a><div style="float: right; position: relative; top: 1px; font-size: 11px;"><a target="_blank" href="https://map.kakao.com/?from=roughmap&amp;eName=%EC%A0%9C%EC%A3%BC%ED%8A%B9%EB%B3%84%EC%9E%90%EC%B9%98%EB%8F%84%20%EC%A0%9C%EC%A3%BC%EC%8B%9C%20%EB%8F%99%EB%AC%B8%EB%A1%9C%2055&amp;eX=391444.0&amp;eY=5743.0" style="float:left;height:15px;padding-top:1px;line-height:15px;color:#000;text-decoration: none;">길찾기</a></div></div></div>
							</td>
						</tr>	
						<tr>
							<td>
							<br>
								<hr style= "height: 1px; background-color:#A6A6A6">
							</td>
						</tr>
						<tr>
							<td class="title" style="color:#4C4C4C;">
								사용 방법
							</td>
						</tr>
						<tr>
							<td class="contents" style="color:#A6A6A6;">
								결제 시 부여받은 QR코드를 매장에 비치된 QR코드 스캐너에서 스캔해주세요.
								<br>스캔이 불가능할 시 코드 하단 12자리 숫자 코드를  매장 직원에게 제시하세요.
								<br>사용 처리가 완료된 CHEF딜은 재사용 및 환불이 불가합니다.
							</td>
						</tr>
						<tr>
							<td class="title" style="color:#4C4C4C;">
								환불규정
							</td>
						</tr>
						<tr>
							<td class="contents" style="color:#A6A6A6;">
								상품 사용 기간 내 환불 요청 시, 구매 금액 전액 환불 가능합니다.
								<br>상품 사용 기간 이후 환불 요청 건은 수수료 10%를 제외한 금액이 환불처리 됩니다. 
							</td>
					</tbody>
					<tfoot>
						<tr>
							<td align="center"><input type="button" name="numOf" value="구매하기" id="show">
							<div class="background">
							  <div class="window">
							    <div class="popup">
							    	<br>
									<h3> 인원수 <select style="width:70px; heigth:23px; font-size:20px;">
										<%for (int num=1; num<=10; num++) { %>
										<option><%=num %></option>
										<%} %>
									</select> </h3>
							      <input type="button" name="order" value="구매하기" onclick="order()"/>
							      <input type="button" name="close" value="닫기" id="close"/>
							    </div>
							  </div>
							</div>
							</td>
						</tr>
					</tfoot>
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
    

	function order(){
		// 구매요청
		var selectVal = document.querySelector("select").value;
		var dealnum = "<%=dealnum%>"
		if (confirm("선택한 인원수 : "+selectVal+"\n 위 내용으로 구매 하시겠습니까?")){
			location.href="ChefDealod.jsp?numOf="+selectVal+"&deal="+dealnum;
		}else {
			alert("구매가 취소되었습니다.");
		}
 	}
	function restaurant(){
		// 맛집상세정보로 이동
		var rest = document.querySelector("[name=rest]");
 		location.href="밋집상세정보";
 	}
	function show () {
		// 인원선택 팝업창 띄우기
		  document.querySelector(".background").className = "background show";
	}
	function close () { 
		// 팝업창 닫기
		  document.querySelector(".background").className = "background";
	}
	
	document.querySelector("#show").addEventListener('click', show);
	document.querySelector("#close").addEventListener('click', close);


</script>
    
    
</html>



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
    ArrayList <ChefDealod> cdo = Dao.getChefDealodList();
	String deal = request.getParameter("deal");
	int dealnum = Integer.parseInt(deal);

	String numOf = request.getParameter("numOf");
	int num = Integer.parseInt(numOf);	
	int point = cdo.get(dealnum).getMemPoint();
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
					<div align="center" >
					<table width="700px" style="font-family:'Noto Sans KR', sans-serif;">
					<thead>
						<tr class="line">
							<th colspan="3" style="color:#FF7012; font-size:30px">결제하기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="210px">
								<img src="../ChefDeal<%=cdo.get(dealnum).getdImage() %>" style="width: 210px; height: 150px; border-radius : 30px; padding-right:10px">
							</td>
							<td colspan="2" style="textpadding-left: 0px">
							<h3 style="color:#353535; font-size:30px; padding-left: 10px">
								[<%=cdo.get(dealnum).getAddress() %>] <%=cdo.get(dealnum).getRestTitle() %> </h3>
							<span style="color:#A6A6A6; font-size:15px; font-weight:bold; ">
								<%= cdo.get(dealnum).getRestText()%> <input type="button" name="rest" value="맛집상세보기 >"/> </span>
							</td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td id="title_detail">옵션정보</td>
							<td colspan="2" style="color:#A6A6A6; font-size:15px; text-align:right">
							사용기한: 구매일로부터 90일 (금일기준 <%=cdo.get(dealnum).getToDate() %>)</td>
						</tr>
						<tr>	
							<td colspan="3"><hr id="line"></td>
						</tr>
						<tr>
							<td colspan="2"><span id="title_pay"><%= cdo.get(dealnum).getdName()%></span>
								<span style="color:#A6A6A6;">  <%=num %>개</span>
							</td>
							<td id="contents_pay"><%=cdo.get(dealnum).getdPridceaf()*num %></td>
						</tr>
						<tr><td><br></td></tr>
						<tr>
							<td colspan="2" id="title_detail"">결제정보</td>
						</tr>
						<tr>	
							<td colspan="3"><hr id="line"></td>
						</tr>
						<tr>
							<td colspan="2"><span id="title_pay">총 티켓금액</span></td>
							<td id="contents_pay"><%=cdo.get(dealnum).getdPridceaf()*num %></td>
						</tr>
						<tr>
							<td colspan="2"><span id="title_pay">포인트 사용</span></td>
							<td id="contents_pay"  style="text-align:right;" colspan="2">
								<div id="pointform" style="padding-left:5px;">
        							<input type="text" value="" id="point" onkeyup="usepoint()"/>
        						</div>
        						<h5 style="padding-left: 60px; color:A6A6A6";>가용 포인트&nbsp<%=point %>&nbsp&nbsp
        						<input type="button" value="전액 사용" id="pointbtn" onclick="useall()"/></h5>
        					</td>
						</tr>
						<tr>
							<td colspan="2"><span id="title_pay">총 결제금액</span></td>
							<td id="contents_pay">
								<div id="totform"><%=cdo.get(dealnum).getdPridceaf()*num %></div>
							</td>
						</tr>
						<tr><td><br></td></tr>
        				<tr>
							<td colspan="2" id="title_detail">결제 수단</td>
						</tr>
						<tr>	
							<td colspan="3"><hr id="line"></td>
						</tr>
						<tr>
							<td colspan="3" id="radioline">
								<input type="radio" name="paymethod" id="method1" value="1" onclick='pay1()'/> 간편결제<br>
								<div id="simplepay"></div>
							</td>
						</tr>
						<tr>		
							<td colspan="3" id="radioline"><hr id="lightline"></td>
						</tr>
						<tr>
							<td colspan="3" id="radioline">
								<input type="radio" name="paymethod" id="method2" value="2" onclick='pay2()'/> 일반결제<br>
								<div id="commonpay"></div>
							</td>
						</tr>
						<tr>
							<td colspan="3" id="radioline"><hr id="lightline" ></td>
						</tr>
						<tr>
							<td colspan="3" id="radioline">
								<input type="radio" name="paymethod" id="method3" value="3" onclick='pay3()'/> 
								<img src="image/kakaopay.png" style="width: 50px; heigth:25px"><br>
								<div id="kakaopay"></div>
							</td>
						</tr>
						<tr>	
							<td colspan="3" id="radioline"><hr id="lightline"></td>
						</tr>
						<tr>
							<td colspan="3" id="radioline" style="padding-left:20px; padding-right:20px;"></td>
						<tr>
							<td colspan="3" style="padding-left:5px">
								<h5>취소 수수료 안내
								<br>· 사용기한 내 취소 : 취소수수료 없음
								<br>· 사용기한 이후 취소 : 10%의 취소수수료 발생
								<br></h5>
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<ul id="agree">
								  <li><input type="checkbox" id="a1" name="agree" />
									<span>취소수수료 규정동의 (필수)</span>
								  </li>
								
								  <li><input type="checkbox" id="a2" name="agree" />
									<span style="text-decoration:underline;" onclick="showagree()">셰프딜 사용 및 환불규정</span><span>동의 (필수)</span>
								  </li>
								
								  <li><input type="checkbox" id="a3" name="agree" />
									<span>개인정보 제3자 제공 동의 (필수)</span>
								  </li>
								</ul>
							</td>
						</tr>
						<tr>
							<td colspan="3" style="text-align:center">
								<br>
									<input type="button" name="numOf" value="결제하기" onclick="pay()"/>
								<br>
							</td>
						</tr>
								
					</table>
					</div>
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
    
    
    function usepoint() {
    	// 엔터키 누를때 동작, 유효성 검사
		 if (window.event.keyCode == 13) {
			    var point = document.querySelector("#point");
				var totform = document.querySelector("#totform");
				var tot = <%=cdo.get(dealnum).getdPridceaf()*num%>;
			if (isNaN(point.value)) {
				alert("포인트를 숫자로 입력해주세요.");
				point.value="0";
				point.focus();
			}else if (point.value><%=point%>) {
				alert("가용 포인트를 초과하였습니다.");
				point.value="0";
				point.focus();
			}else if (!((point.value%10)==0)) {
				alert("10포인트 단위로 사용 가능합니다.");
				point.value="0";
				point.focus();
			}else{
				totform.innerHTML=tot-point.value;	
			}
	    }
	 }
    
    function useall() {
    	// 모두사용 버튼 누를때 동작
	    var point = document.querySelector("#point");
		var totform = document.querySelector("#totform");
		var tot = <%=cdo.get(dealnum).getdPridceaf()*num%>;
		point.value=<%=point%>;
    }

	function pay1() {
		// 간편결제 선택시 실행
		var simplepay = document.querySelector("#simplepay");
		simplepay.innerHTML="<span id='title_pay' style='padding-left:30px; font-size:15px;'>등록된 카드	\t\t\t<select id='simple_pay'><option>국민카드 [3401-****-2811-****]</option><option>신한카드 [8271-****-3914-****]</option></select></span>";
	}
	function pay2() {
		// 일반결제 선택시 실행
	}
	function pay3() {
		// 카카오페이 선택시 실행
		window.open("https://mockup-pg-web.kakao.com/v1/3d18c6628006195ebd0eb0c8cfac94d7b16cc2abe72d6167d43143a09bea9015/info", '', 'width=400, height=430')
	}	
	function showagree() {
		// 환불규정 보기
		window.open("RefundPolicy.jsp",'','width=550, height=600');
	}
	function pay() {
		// 체크 여부 확인 
		var Resulta1 = document.getElementById('a1').checked;
		var Resulta2 = document.getElementById('a2').checked;
		var Resulta3 = document.getElementById('a3').checked;
		
		if (document.getElementById("method1").checked != true 
				&& document.getElementById("method2").checked != true 
				&& document.getElementById("method3").checked != true) {
			alert("결제 방식을 선택해주세요.");
		}else if (Resulta1==false) {
			alert("결제 진행 필수사항을 동의해주세요.");
		}else if (Resulta2==false){
			alert("결제 진행 필수사항을 동의해주세요.");
		}else if (Resulta3==false){
			alert("결제 진행 필수사항을 동의해주세요.");
		}else {
			alert("결제가 완료되었습니다.");
			location.href="ChefDealList.jsp";
		}
	}

	</script>
    
    
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "java.util.*"
    import = "jspexp_0.z02_vo.*"
    import = "Project_6th.JAVA.z0717_project.*"
%>
  <!-- 오류날 시 아래를 복붙 -->  
  <%
  	request.setCharacterEncoding("utf-8"); // 요청값에 대한 한글 encoding처리
  	String path = request.getContextPath(); 
  	//기준경로 설정  \jspexp_0\src\main\webapp
  %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link rel="stylesheet" href="style.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
 


</head>
<body>
	<%
		delListDao delDao = new delListDao();
		ArrayList<restaurant> rlist = delDao.restView(new restaurant("기와탭룸"));
	
	%>
    <header>
        <div class="wrap">
            <div class="header_nav">
                <h1 class="logo">
                    <a href="/AllYouCanEat/main/index_login.html"><img src="../image/FOODlogo.png"></a>
                </h1>
                <div class="search_bar">
                    <input type="text" class="search_text" placeholder="검색어를 입력해주세요.">
                    <button>검색</button>
                </div>
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
            <article> 
                <img src="../image/giwa.PNG">
                <img src="../image/giwa1.PNG">
                <img src="../image/giwa2.PNG">
                <img src="../image/giwa3.PNG">
            </article>
            <article> 
                <div>
                    <div class="rest_title">
                        
                            <h2>기와탭룸</h2>
                        
                        <div>
                            <button onclick="location.href='../review/review.jsp'">
                                <i class="fas fa-pencil-alt"></i>
                                <Span>리뷰쓰기</Span>
                            </button>
                            <button>
                                <i class="far fa-star"></i>
                                <span>손도장</span>
                            </button>
                        </div>
                    </div>
                    <div class="rest_tab">
                        <table class="main_tab">
                            <!-- 주소 전화번호 음식종류? 가격대 주차 영업시간 웹사이트 메뉴 -->
                            	<% for(restaurant r:rlist) { %>
                                <tr><th>주소</th><td><%=r.getRestAddress()%></td></tr>
                                <tr><th>전화번호</th><td><%=r.getRestPhoneNum()%></td></tr>
                                <tr><th>음식종류</th><td>양식 펍</td></tr>
                                <tr><th>가격대</th><td>15000원대</td></tr>
                                <tr><th>주차</th><td><%=r.getRestAddress()=="0"?"가능":"불가능"%></td></tr>
                                <tr><th>영업시간</th><td><%=r.getRestHours()%></td></tr>
                                <% } %>
                                <tr>
                                    <th>메뉴</th>
                                    <td>
                                        <table class="menu_tab">
                                            <tr><td>닭반마리 팬구이</td><td>21000</td></tr>
                                            <tr><td>살라미뢰스티</td><td>18000</td></tr>
                                            <tr><td>라구파스타</td><td>18000</td></tr>
                                            <tr><td>하와이안 그릴  프라이즈</td><td>19000</td></tr>
                                            <tr><td>생맥주</td><td>4000</td></tr>
                                        </table>        
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="rest_review">
                            <div class="rest_review_title">
                                <h2>리뷰</h2>
                                <ul>
                                    <li><button>맛있다</button></li>
                                    <li><button>괜찮네</button></li>
                                    <li><button>보통이에요</button></li>
                                    <li><button>별로네</button></li>
                                    <li><button>최악이에요</button></li>
                                </ul>
                            </div>
                            <div class="rest_review_con">
                                <div class="user_img">
                                    <img src="../image/pizza.jpg">
                                    <span>유저이름</span>
                                </div>
                                <div class="user_review">
                                    <p>라구파스타와 하와이안 쉬림프, 맥주까지 모든게 완벽.. 가격대비 인테리어와 서비스도 좋고 재방문의사있음!!!</p>
                                </div>
                                <div class="user_point">
                                    <span>맛있다</span>
                                </div>
                            </div>
                            <div class="rest_review_con">
                                <div class="user_img">
                                    <img src="../image/giwa1.PNG">
                                    <span>유저이름</span>
                                </div>
                                <div class="user_review">
                                    <p>겨울맥주는 따뜻한 곳에서. 가는 길에 너무 추워서 “우리 맥주 마실 수 있을까?” “실내 안 따뜻하면 그냥 마시지 말자” 해놓고 꿀떡꿀떡 잘만 마셨다. 고즈넉한 한옥에 흐르는 트렌디한 음악. 어울리는 이 조합과 아늑한 분위기, 편안한 사람들과 함께하니 목구멍 최대오픈 (^○^) 
쉬어가기 참 좋은 곳이다. 감당 안되는 컨셉도 없고!

맥주는 딱 선택장애 없이 즐겁게 고를만큼 있다. 넷이서 공교롭게도 입맛이 다 달라서 기와탭룸 맥주 5종을 다 마셔볼 수 있었다. 그리고 한옥에 있으면 왠지 국뽕이 뿜뿜해서 게스트맥주 중에서는 안동라거를 골랐다. 역시 게스트보단 호스트가 맛있었다. 

개인적인 취향이 씁쓸 구수인 필자의 입맛에는 글랜체크가 제일 맛있긴 했다. 시어서커, 오렌지비앙코를 Sip으로 마시게된다면 글랜체크는 Gulp해서 꿀꺽꿀꺽하게 되는 맛. 
그리고 어느 취향에도 잘 맞을 것 같았던 건 핑크세종.
개중 제일 비싼데 마셔보면 끄덕끄덕. 향이 깊이 배어있다.
안동라거 맛은 왜 기억이 안나지. 그제 마셨는데. (?)

안주로는 닭반마리를 주문했다. 굽네스타일인데 좀더 오븐에 홈메이드한 스타일이다. 부드러운 와중에 겉은 야들야들하게 아주 잘 구웠다. 함께 주는 사워소스도 킬포.

미친듯이 맛있어서 다음에 또 와야겠다 싶은 메뉴나, 이번에 못 먹어봐서 아쉬움을 남긴 메뉴는 없었지만 다음에도 삼청동에서 맥주 마실 일이 있다면 1빠로 생각날 것 같은 곳.</p>
                                </div>
                                <div class="user_point">
                                    <span>맛있다</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div>
                        
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
</html>
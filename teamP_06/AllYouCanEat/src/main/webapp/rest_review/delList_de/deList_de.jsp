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
		
			ArrayList<delList> dlist = delDao.delList();
		
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
                <article class="section_title"> 
                    <h2>전체 베스트 맛집 TOP 10</h2>
                    <h3>"살면서 한 번쯤은 가봐야 되지 않겠어?!"</h3>
                </article>
                <article class="section_main"> 
                
                
					<%	

						int cnt = 1;
						for(delList d:dlist) {
					
					%>
							
					
                    <div>
                        <div class="rest_image">
                            <a href="../restaurant/restaurant.jsp">
                                <img src="<%=d.getRestImage() %>">
                            </a>
                        </div>
                        <div class="rest_text"> 
                            <h3><span><%=cnt++%>위 </span> <%=d.getRestTitle() %> <span><%=d.getReviewpoint()%> 점</span></h3>
                            <h4><%=d.getRestAddress() %></h4>
                            <p><%=d.getReviewcontent() %></p>
                            <button class="bookmark">
                                <i class="far fa-star"></i>
                            </button>
                            <a class="rest_more" href="../restaurant/restaurant.jsp">더 보기 > </a>
                        </div>
                        
                    </div>
                    
                    
                    <% }%>
                    
                </article>
            </div>
        </section>
        <footer>
            <div class="wrap">
                <h5>회사정보</h5>
            </div>
        </footer>
    </body>
     <!-- 1) text-overflow: ellipsis; 여러줄안됨
          2) .bookmart 클릭시 i class=""
                    >><i class="fas fa-star"></i> 변경
    -->
    
    <Script>
        var bookmarkI = document.querySelectorAll(".bookmark i");
        // 오류남
        for(var idx=0; idx<bookmarkI.length; idx++){
            if(bookmarkI[idx].className=="fas fa-star"){
               bookmarkI[idx].onclick = function(){
                    this.className="far fa-star";
                } 
            }else{
                bookmarkI[idx].onclick = function(){
                    this.className="fas fa-star";
                }
            }
        }
    </Script>
    
</html>
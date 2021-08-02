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

<!-- 외부css 가져오기 -->
	<link rel="stylesheet" href="style.css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
 
</head>
<body>

		<%

			delListDao delDao = new delListDao();
		
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
        <section>
            <div class="wrap">
                <article class="review_title">
                    <h3>"<span>가게이름</span>"에 대한 리뷰를 작성해주세요</h3>
                </article>
                <article class="review_main">
                    <div class="review_point">
                        <ul>
                            <li><button class=""><i class="far fa-laugh"></i>맛있다!</button></li>
                            <li><button class="cancle_btn"><i class="far fa-smile"></i>괜찮네~</button></li>
                            <li><button class="cancle_btn"><i class="far fa-meh-blank"></i>보통이에요.</button></li>
                            <li><button class="cancle_btn"><i class="far fa-grin-beam-sweat"></i>별로네..</button></li>
                            <li><button class="cancle_btn"><i class="far fa-tired"></i>최악이야!!</button></li>
                        </ul>
                    </div>
                    <div class="review_text">
                        	<input type="text" name="review_text" placeholder="메뉴는 어떠셨나요? 분위기와 서비스도궁금합니다!">
                    	
                    </div>
                </article>
                <article class="review_file_upload">
                    	<input type="file" name="review_file" accept="image/*" files="">
                	
                </article>
                <article class="review_btns">
                    <button class="cancle_btn">취소</button>
                    <button class="input_btn" onclick="send()">리뷰올리기</button>
                </article>
            </div>
        </section>
        <footer>
            <div class="wrap">
                <h5>회사정보</h5>
            </div>
        </footer>
    </body>
    
    <script>
        var reviewPoint = document.querySelectorAll(".review_point ul li button");
        
        // class="cancle_btn", "
        for(var idx=0; idx<reviewPoint.length; idx++){
            reviewPoint[idx].onclick = function(){
                this.className = "";
            }
        }
        
        
        var cancle_btn = document.querySelector(".review_btns .cancle_btn");
        cancle_btn.onclick = function(){
            var cancle = confirm("리뷰작성을 취소하시겠습니까?");
            if(cancle){
                location.href="../restaurant/restaurant.jsp";
            }else{
                
            }
            
        }
        var input_btn = document.querySelector(".review_btns .input_btn");
        var review_text = document.querySelector(".review_main .review_text [name=review_text]");
        
        input_btn.onclick = function(){
            if(review_text.value==""){
                alert("내용을 입력해주세요.");
                review_text.focus();
                return false;
            }else{
                alert("리뷰가 등록되었습니다.");
                location.href="../restaurant/restaurant.jsp";
            }  
        }
        
       

    </script>

</html>
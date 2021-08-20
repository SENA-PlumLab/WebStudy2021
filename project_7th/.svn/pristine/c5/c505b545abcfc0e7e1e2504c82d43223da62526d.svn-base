<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	    
    import = "java.util.*"
    import = "model2.myPage.MPDao"
    import = "model2.vo.*"
    
   %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick</title>
<link rel="stylesheet" href="section_mypage.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">



<style>

	.btn_cancel {
	    width: 100px;
	    padding: 5px 20px;
	    background-color: #FDFBFC;
	    border: 1px solid #10223b;
	    border-radius: 5px;
	    cursor: pointer;
	}
	
	.btn_default{
	    width: 100px;
	    padding: 5px 20px;
	    color: #FDFBFC;
	    background-color: #10223b;
	    border: none;
	    border: 1px solid #10223b;
	    border-radius: 5px;
	    cursor: pointer;
	}

	#wrap3 {
		width : 850px;
		border : 2px solid #07CBE5;
		padding : 20px 30px;
	}
	
	
	
	.follow_div > h4 {
		padding : 25px 0px;
	}
	
	.follow_table{
		overflow: hidden;
		
	 	border : 2px solid #DDEEEB;
	 	padding : 10px;
	}
	.follow_table .follow_left{
		width : 39%;
		height : 300px;
		text-align : center;
		padding : 30px;
	 	float : left;
	 	
	 	
	}
	
	.follow_table .follow_left img{
		width : 200px;
		height : 200px;
        object-fit:cover; 
	 	border : 2px solid #DDEEEB;
	}
	
	.follow_table .follow_left span {
		padding : 10px;
	}
	
	.follow_table .follow_right {
		width : 60%;
		height : 300px;
	 	position : relative;
	 	float : left;
	}
	
	.follow_table .follow_right > input[value="삭제"] {
		position : absolute;
		top : 5px;
		right : 5px;	
	}
	
	.follow_table .follow_right > div h5 {
		padding : 0px 5px;
		padding-top : 35px;
		font-size : 20px;
	}
	
	.follow_table .follow_right > div p {
	
		width : 100%;
		padding : 10px;
		background: #FDFBFC;
		
		
		/* 한줄 자르기 */
		display : inline-block;
	    white-space: nowrap;
	    
	    overflow: hidden;
	    text-overflow: ellipsis;
	    
	    /* 여러줄 추가 스타일 */
	    white-space : normal;
		height : 150px;
		
		word-wrap: break-word;
		display: -webkit-box;
		-webkit-line-clamp: 3;
		-webkit-box-orient: vertical;

	    
	}
	
</style>
</head>
<body>
<header>

</header>    
	<%
		Object loginM = session.getAttribute("loginM");
		String loginMS = (String)loginM;
		MPDao dao = new MPDao();
		
	
	%>
	<section>
		
		<div id="wrap3">
			<div class="follow_div">
			
				<h4>팔로윙한 리스트</h4>
				<div class="follow_table">
					<div class="follow_left">
						<img src="../image/nyanya.jpg"><br>
						<span>프로필사진</span>
					</div>
					<div class="follow_right">
						<input type="button" value="삭제" class="btn_default">
						<div>
							<h5>닉네임 : <span>nyanya</span></h5>
						</div>
						<div>
							<h5>소개글</h5>
							<p>안녕하세요.1. 구운 감자를 곁들인 닭 반마리 팬구이
이건 꼭 시키셔야 합니다! 퍽퍽살인데도 굉장히 촉촉하고 소스에 찍어먹으면 정말 맛있어요ㅠㅠ 같이 나오는 감튀도 너무 맛있어서 둘이서 가시면 간단한 식사 메뉴로도 정말 좋습니다.</p>
						</div>
					</div>
				</div>
				
				
			</div>
		</div>
		
	</section>
<footer>

</footer>
</body>
</html>
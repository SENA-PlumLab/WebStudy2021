<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "model2.login.*"
    import = "java.util.*"
    import = "model2.vo.*"
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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
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

            
            .idPassSearch{
                
                min-width: 700px;
                background-color: #FDFBFC;
                padding: 20px;
                text-align: center;
            }
            
            .idPassSearch > article {
                display: inline-block;
                font-size: 12px;
            }
            .idPassSearch > article:first-child {
                border-right: 2px dotted #10223b;
            }
            .idPassSearch > article  h2 {
                padding: 10px 0px;
                text-align: center;
            }
            
            .idPassSearch > article  div {
                padding: 5px;
            }
            
            .idPassSearch > article  div > p {
                padding-bottom: 25px;
            }
            
            
            .idPassSearch .id_search {
                width: 49%;
                height: 100%;
                
            }
            .idPassSearch .pass_search {
                width: 49%;
                height: 100%;
            }
            .idPassSearch .pass_search> div > input {
                float: center;
            }
            .idPassSearch > article input[type=button] {
                margin: 20px;
                width: 200px;
            }
            
        </style>
    </head>
    <body>
        <section class="idPassSearch">
        	
	            <article class="id_search">
	            	
       				<form id="idSearch_form">
	                <h2>아이디찾기</h2>
	                <div>
	                    <p>회원가입시 사용한 전화번호를 입력해주세요.(-포함)</p>
	                    <span>전화번호 : </span>
	                    <input type="text" name="phoneId" placeholder="전화번호 입력" value="">
	                </div>
	                <input class="btn_default" type="button" name="id_sear_btn" value="아이디 찾기">
	                </form>
	            </article>
	            <article class="pass_search">
	            	<form id="passSearch_form">
	                <h2>패스워드 찾기</h2>
	                <div>
	                    아이디 : <input type="text" name="email" placeholder="이메일입력" value="">
	                </div>
	                <div>
	                    전화번호 : <input type="text" name="phonePass" placeholder="전화번호입력" value="">
	                </div>
	                
	                <input class="btn_default" type="button" name="pass_sear_btn" value="비밀번호 찾기">
	                 </form>
	            </article>
         
        </section>
		
        
		<%
			LoginDao loDao = new LoginDao();
			String phoneId = request.getParameter("phoneId");
			
			

			boolean isPass = true;
			if(loDao.idSearch(phoneId).size()==0){
				isPass = false;
			}
			
			String phoneIdCheck = null;
			String IdCheckrResult = null;
			if(phoneId!=null&&loDao.idSearch(phoneId).size()!=0) {
				phoneIdCheck = loDao.idSearch(phoneId).get(0).getMemPhone();
				IdCheckrResult = loDao.idSearch(phoneId).get(0).getMemId();
			}
			

			String email = request.getParameter("email");
			String phonePass = request.getParameter("phonePass");
			
			

			String idPassCheck = null;
			String phonePassCheck = null;
			
			String PassCheckrResult = null;
			if(phonePass!=null&&email!=null&&loDao.idSearch(phoneId).size()!=0) {
				idPassCheck = loDao.idSearch(phoneId).get(0).getMemId();
				phonePassCheck = loDao.idSearch(phoneId).get(0).getMemPhone();
				PassCheckrResult = loDao.idSearch(phoneId).get(0).getMemPw();
			}
		%>
        
        
        
    </body>
    
    <script>
    
    	var SIform = document.querySelector("#idSearch_form");
        // 아이디
        var idSearBtn = document.querySelector("[name=id_sear_btn]");
        var phoneId = document.querySelector("[name=phoneId]");
        
        
        idSearBtn.onclick = function(){
            if(phoneId.value==null||phoneId.value==""){
                alert("전화번호를 입력해주세요.");
                phoneId.focus();
                return false;
            }  
            var regExpPhone = /^\d{3}-\d{4}-\d{4}$/;
            if(!(phoneId.value.match(regExpPhone))){
                alert("전화번호를 확인해주세요.");
                phoneId.focus();
                return false;
            }
            
            SIform.submit();
        }
        if(<%=phoneIdCheck%>!=null) {
	       if(<%=phoneId%>==<%=phoneIdCheck%>){
	       		alert("아이디는 <%=IdCheckrResult%>입니다.");
	       }
        }
        
        
        
        // 비밀번호 
        
        
    	var SPform = document.querySelector("#passSearch_form");
        
        var passSearBtn = document.querySelector("[name=pass_sear_btn]");
        
        var email = document.querySelector("[name=email]");
        var phonePass = document.querySelector("[name=phonePass]");
        
        passSearBtn.onclick = function(){
            
            if(email.value==null||email.value==""){
                alert("이메일을 입력해주세요.");
                email.focus();
                return false;
            }  
            var regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if(!(email.value.match(regExpEmail))){
                alert("이메일형식을 확인해주세요.");
                email.focus();
                return false;
            }
            
            if(phonePass.value==null||phonePass.value==""){
                alert("전화번호를 입력해주세요.");
                phonePass.focus();
                return false;
            }  
            var regExpPhone = /^\d{3}-\d{4}-\d{4}$/;
            if(!(phonePass.value.match(regExpPhone))){
                alert("전화번호를 확인해주세요.");
                phonePass.focus();
                return false;
            }
            

            SPform.submit();
        }
        
        
        var isPass = <%=isPass%>;
        if(!isPass){
        	alert("입력정보를 다시 확인해주세요.")
        }
        
    </script>

</html>
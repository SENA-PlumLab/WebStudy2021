<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "java.util.*"
    import = "model2.join.*"
    import = "model2.vo.*"
  %>
  <%
  	request.setCharacterEncoding("utf-8"); // 요청값에 대한 한글 encoding처리
  	String path = request.getContextPath();
  %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyOnePick Sign In</title>

	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
     
     <link rel="stylesheet" href="signInstyle.css" />
     <link rel="stylesheet" href="loginstyle.css" />
     <link rel="stylesheet" href="../common/style.css" type="text/css">
<style>
		
</style>
<script type="text/javascript">

</script>
</head>
<body>


	<%@include file="../common/header.jsp"%>
	
	

	<section>
        <div class="wrap">
            <article class="signin_main">
                <!-- article에 min-width:1100px; -->
                <form id="signin_form">
                    <div class="signin_main_header">   
                        <h2><img src="../image/picklogo.png"></h2>
                        <p>회원가입 페이지</p>
                    </div>
                    <div class="signin_main_section">   
                        <table class="signin_tab">
                            <tr><th>이메일</th><td><input type="text" name="id" value="" placeholder="이메일을 입력해주세요."><input id="emailCheck" type="button" class="btn_default" value="인증번호전송"></td></tr>
                            <tr><th>인증번호</th><td><input type="text" name="idCheck" value="" placeholder="이메일로 받은 인증번호를 입력해주세요."><input id="emailNumCheck" type="button" class="btn_default" value="인증번호확인"></td></tr>
                            <tr><th>비밀번호</th><td><input type="text" name="pass" value="" placeholder="숫자+영문 조합으로 8~13글자 사이로 입력해주세요."></td></tr>
                            <tr><th>비밀번호 확인</th><td><input type="text" name="passCheck" value="" placeholder="비밀번호 칸과 동일하게 입력해주세요."></td></tr>
                            <tr><th>전화번호</th><td><input type="text" name="phoneNum" value="" placeholder="' - ' 를 포함하여 입력해주세요."></td></tr>
                        </table>
                    </div>
                    <div class="signin_main_checkbox">
                        <div>
                            <input type="checkbox" name="check"><span> 만14세이상 *</span>
                        </div>
                        <div>
                            <input type="checkbox" name="check"><span> <a href="#">이용약관</a> *</span>
                        </div>
                        <div>
                            <input type="checkbox" name="check"><span> <a href="#">개인정보수집</a> *</span>
                        </div>
                        <div>
                            <input type="checkbox" name="noncheck"><span> 마케팅정보수신</span>
                        </div>
                    </div>
                    <div class="signin_main_footer">
                        <button id ="btnWelcome" class="btn_default" onclick="welcome()">회원가입</button>
                        <input type="button" id="btnCancel" class="btn_cancel" value="취소">
                    </div>
                </form>
            </article>
        </div>
    </section>
		<%

		boolean isInsert = false;
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phoneNum");
		
		if(id!=null&&pass!=null&&phone!=null){
			if(id!=""&&pass!=""&&phone!=""){
				joinDao Jdao = new joinDao();
				Member ins = new Member(id, pass, phone);
				Jdao.joinMember(ins);
				isInsert=true;
			}
		}
	
	%>
	
	<%@include file="../common/footer.jsp" %>
	
   <script>
        var id = document.querySelector("[name=id]");
        var idCheck = document.querySelector("[name=idCheck]");
        var pass = document.querySelector("[name=pass]");
        var passCheck = document.querySelector("[name=passCheck]");
        var phoneNum = document.querySelector("[name=phoneNum]");
        
        var checkboxArry = document.querySelectorAll("[name=check]");
        
        
        
        var emailBool = false; 
        var emailCheck = document.querySelector("#emailCheck");
        var emailNumCheck = document.querySelector("#emailNumCheck")
        emailCheck.onclick = function(){
            alert("이메일전송. 임시인증번호 : asdf");
        }
        emailNumCheck.onclick = function(){
            // 이메일 인증
            if(idCheck.value=="asdf"){
                emailBool = true;
            }
            if(emailBool){
                alert("인증성공"); 
                emailCheck.style.display="none";
                emailNumCheck.style.display= "none";
                idCheck.readOnly= true;
            }else{
                alert("인증번호를 확인해주세요.");
                return false;
            }
        }
        
        
        var signinForm = document.querySelector("#signin_form");
        
        var btnWelcome = document.querySelector("#btnWelcome");
        btnWelcome.onclick = function(){
        	

            
            // 유효성 
            // email
            if(id.value==null||id.value==""){
                alert("이메일을 입력해주세요.");
                id.focus();
                return false;
            }
            
            var regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            if(!(id.value.match(regExpEmail))){
                alert("이메일형식을 확인해주세요.");
                id.focus();
                return false;
            }
            
            
            if(idCheck.value==null||idCheck.value==""){
                alert("이메일 인증을 해주세요.");
                idCheck.focus();
                return false;
            }
            
            // 만약 이메일 넘버와 입력한 넘버가 같다면
            // ture를 리턴
            
            
            
            // pass
            if(pass.value==null||pass.value==""){
                alert("비밀번호를 입력해주세요.");
                pass.focus();
                return false;
            }
            var regExpPass = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,13}/;
            if(!(pass.value.match(regExpPass))){
                alert("비밀번호는 8~13자 사이의 문자+숫자 조합으로 해주세요.");
                pass.focus();
                return false;
            }
            
            if(passCheck.value==null||passCheck.value==""){
                alert("비민번호확인을 해주세요.");
                passCheck.focus();
                return false;
            }
            if(pass.value!=passCheck.value){
                alert("비밀번호가 일치하지 않습니다.");
                passCheck.focus();
                return false;
            }
            
            
            //전화번호
             if(phoneNum.value==null||phoneNum.value==""){
                alert("전화번호를 입력해주세요.");
                phoneNum.focus();
                return false;
            }
            // 3. 전화번호
            
            var regExpPhone = /^\d{3}-\d{4}-\d{4}$/;
            if(!(phoneNum.value.match(regExpPhone))){
                alert("전화번호를 확인해주세요.");
                phoneNum.focus();
                return false;
            }
            
            
            //동의 체크
            if(!checkboxArry[0].checked){
                alert("동의 필수 항목(만 14세 이상)을 체크해주세요.");
                return false;
            }
            if(!checkboxArry[1].checked){
                alert("동의 필수 항목(이용약관)을 체크해주세요.");
                return false;
            }
            if(!checkboxArry[2].checked){
                alert("동의 필수 항목(개인정보수집)을 체크해주세요.");
                return false;
            }

        	signinForm.submit();
        }
        
        var isInsert = <%=isInsert%>;
		if(isInsert){
			location.href="welcome1.html";
		}
		
		
        
        var btnCancel = document.querySelector("#btnCancel");
        btnCancel.onclick = function(){
            if(confirm("취소하시겠습니까?")){
                location.href="../mainPage/mainPage.jsp";
            }
        }
    </script>
</body>
</html>
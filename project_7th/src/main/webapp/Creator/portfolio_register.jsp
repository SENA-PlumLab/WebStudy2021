<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick</title>
<link rel="stylesheet" href="../common/style.css" type="text/css">
<link rel="stylesheet" href="portfolio_register.css" type="text/css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	    <section>
        <div class="wrap">
            <article>
                <!-- article에 min-width:1100px; -->
                <form id="protFrom">
                    <div class="portfolio_main">
                        <div class="portfolio_top">
                            <h2>포트폴리오 등록</h2>
                            <p> 크리에이터가 되기 위한 한걸음! </p>
                        </div>

                        <div class="portfolio_title">
                            <h3>제목</h3>
                            <input type="text" name="portTitle" value="" maxlength="30" placeholder="제목을 입력해주세요(최대 30자)">
                        </div>
                        <div class="portfolio_content">
                            <h3>내용</h3>
                            <textarea name="portContent" rows="15" cols="100%" placeholder="최대 1000자까지 입력가능합니다." maxlength="1000" style="resize: none;"></textarea>
                        </div>
                        <div class="portfolio_file">
                            <h3>파일</h3>
                            <input type="file" name="portFile">
                        </div>
                        <div class="portfolio_link">
                            <h3>링크</h3>
                            <input type="text" name="portLink" value="" placeholder="포트폴리오의 링크를 적어주세요.">
                        </div>
                        <div class="portfolio_footer">
                            <input type="button" id="portCanBtn" class="btn_cancel" value="취소">
                            <input type="button" id="portInBtn" class="btn_default" value="등록">
                        </div>
                    </div>
                    
                </form>
            </article>
        </div>
    </section>
    
    <%
    	String portTitle = request.getParameter("portTitle");
    	String portContent = request.getParameter("portContent");
    	String portFile = request.getParameter("portFile");
    	String portLink = request.getParameter("portLink");
    	boolean protPass = false;
    	if(portTitle!=null) {
	    	MPDao MPDao = new MPDao();
	   		MPDao.insertPortfoilo(new Portfoilo("mem-0001", portTitle, portContent, portFile, portLink));
	   		protPass = true;
    	}
   	%>
    
	<%@include file="../common/footer.jsp" %>
	    <script>
        
        
        // 글자수 제목 30자 이내
        // var titleLength = /^.{0,30}$/; ?? 왜 안되징
        
        var portTitle = document.querySelector("[name=portTitle]");
        portTitle.onkeydown = function(){
            if(portTitle.value.length==30){
                alert("제목은 30자까지입니다.");
            }
        }
        // 내용 1000자 이내
         var portContent = document.querySelector("[name=portContent]");
        portContent.onkeydown = function(){
            if(portContent.value.length==1000){
                alert("내용은 1000자까지입니다.");
            }
        }
        
        var portCanBtn = document.querySelector("#portCanBtn");
        portCanBtn.onclick = function(){
            if(confirm("취소하시겠습니까?")){
                // 되는지 확인 전페이지로 돌아가기
                location.href = document.referrer;
            }
        }
        var portInBtn = document.querySelector("#portInBtn");
        var protFrom = document.querySelector("#protFrom");
        var protPass = <%=protPass%>;
        portInBtn.onclick = function(){
            if(portTitle.value==null||portTitle.value==""){
                alert("제목을 입력해주세요.")
                portTitle.focus();
                return false;
            }
            protFrom.submit();
            
        }
        if(protPass){
        	location.href="Creator_swich.jsp";
        }
    </script>
</body>
</html>
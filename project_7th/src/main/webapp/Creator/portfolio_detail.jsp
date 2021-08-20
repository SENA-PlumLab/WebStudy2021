<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
    
    import = "java.util.*"
    import = "model2.myPage.*"
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
<link rel="stylesheet" href="../common/style.css" type="text/css">
<link rel="stylesheet" href="portfolio_register.css" type="text/css">
</head>
<body>
	<%@include file="../common/header.jsp"%>
	    
	    <%
	    	String pfNum = request.getParameter("pfNum");
    		MPDao MPDao = new MPDao();
    		ArrayList<PortfoiloDetail> portDetail = MPDao.getPortDetail(new PortfoiloDetail(pfNum));
	    	
	    %>
	    <section>
        <div class="wrap">
            <article>
                <!-- article에 min-width:1100px; -->
                <form id="protFrom" action="portfolioUpt.jsp">
                    <div class="portfolio_main">
                        <div class="portfolio_top">
                            <h2>포트폴리오 수정</h2>
                            <p> 크리에이터가 되기 위한 한걸음! </p>
                        </div>
                        <input type="hidden" name="pfNum" value="<%=pfNum%>">
						<% if(portDetail!=null){
							for(PortfoiloDetail pd:portDetail) { %>
						
                        <div class="portfolio_title">
                            <h3>제목</h3>
                            <input type="text" name="portTitle" value="<%=pd.getPfTitle()%>" maxlength="30" placeholder="">
                        </div>
                        <div class="portfolio_content">
                            <h3>내용</h3>
                            <textarea name="portContent" rows="15" cols="100%" placeholder="최대 1000자까지 입력가능합니다." maxlength="1000" style="resize: none;"><%=pd.getPfContent() %></textarea>
                        </div>
                        <div class="portfolio_file">
                            <h3>파일</h3>
                            <input type="file" name="portFile" value="<%=pd.getPfFile()%>">
                        </div>
                        <div class="portfolio_link">
                            <h3>링크</h3>
                            <input type="text" name="portLink" value="<%=pd.getPfLink()%>" placeholder="포트폴리오의 링크를 적어주세요.">
                        </div>
                        
                        <% } 
                        }
                        %>
                        <div class="portfolio_footer">
                        	<input type="button" id="delPort" class="btn_default" value="삭제">
                            <input type="button" id="portInBtn" class="btn_default" value="수정">
                        </div>
                    </div>
                    
                </form>
            </article>
        </div>
    </section>

    
	<%@include file="../common/footer.jsp" %>
	    <script>
        
	    var portInBtn = document.querySelector("#portInBtn");
        var protFrom = document.querySelector("#protFrom");
       
        portInBtn.onclick = function(){
            if(portTitle.value==null||portTitle.value==""){
                alert("제목을 입력해주세요.")
                portTitle.focus();
                return false;
            }
            protFrom.submit();  
        }
        
        

        var delPort = document.querySelector("#delPort");
        delPort.onclick = function(){
            if(confirm("해당 포트폴리오를 삭제하시겠습니까?")){
				var pfNumjs = "<%=pfNum%>";
				location.href="portfolioDel.jsp?pfNum="+pfNumjs;
			
            }
        }
        
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
        
        
        
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import = "java.util.*"
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

<link rel="stylesheet" href="../main/main_style.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
        

</head>
<body>
	<%@include file="../mainSupporter/MPHeader.jsp"%>
	
	    <section>
            <div class="wrap">
                <article>
                   <h2>대제목</h2>
                   <h3>소제목</h3>
                    여기에 꾸며주세요
                </article>
            </div>
        </section>
	
	<%@include file="../mainSupporter/MPFooter.jsp" %>
</body>
</html>
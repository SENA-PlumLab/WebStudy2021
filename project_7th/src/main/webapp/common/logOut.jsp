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

</head>
<body>
    <%
    	session.removeAttribute("loginM");
    %>
    <Script>
 		location.href="../mainPage/mainPage.jsp";

    </Script>
</body>
</html>
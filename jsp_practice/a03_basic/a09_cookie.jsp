
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
/*
1. 결과로 특정 데이터를 클라이언트에 저장: 쿠키
2. 결과로 특정 데이터를 서버에 저장: 세션
*/


//쿠키 설정
Cookie c1 = new Cookie("name", "himan");
response.addCookie(c1);

Cookie c2 = new Cookie("pname", "mala-tang");
response.addCookie(c2);
Cookie c3 = new Cookie("price", "8000");
response.addCookie(c3);
Cookie c4 = new Cookie("cnt", "5");
response.addCookie(c4);
%>
<body>
	<h3 align="center"></h3>
	<a href="a10_showCookie.jsp">저장된 쿠키 값 확인하러 가기!</a>
</body>
</html>
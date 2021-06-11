<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    import = "javaexp.z01_vo.Food"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	Food f = new Food("사과", 2000, "청과물가게");
%>
<body>
	<h2> 웹 프로그래밍 시작!! </h2>
	<h3> 물건명: <%=f.getName() %></h3>
	<h3> 가격: <%=f.getPrice() %></h3>
	<h3> 파는 곳: <%=f.getLoc() %></h3>
</body>
</html>


<%--

-화면단 (Front End)-
html/css
javascript ==> jquery

==> ajax (비동기 프로그래밍): front end와 back end 연결

-내부 처리 프로그램(back End)-
java
데이터베이느
jsp
SpringFreameWork



--%>
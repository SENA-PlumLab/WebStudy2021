<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "z02_vo.*"
    import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>

<%--

# 세션이란?
1. 웹 컨테이너에서 클라이언트의 정보를 보관할 때, 사용된다.
2. 오직 서버에서만 생성하여 저장된다.
3. 클라이언트와 관계에서 세션이 생성되기에, 같은 브라우저가 아니면 세션은 종료가 된다.
4. session의 설정/삭제
	session.setAttribute("세션명", 할당할 객체);
	지정한 세션만 삭제: session.removeAttribute("세션명");
	전체 세션의 종료: session.invalidate()
5. session의 유효시간 설정.
	1) web.xml
	<session-config>
		<session-timeout> 분 단위
	2) setMaxInativeInterval();
 --%>
<%
	//1. 기본 변수 할당
	session.setAttribute("num01", 25);
	//2. 기본 객체 할당
	session.setAttribute("p01", new Person("홍길동", 25, "서울"));
	//3. 배열형 List 객체할당
	session.setAttribute("list", Arrays.asList("사과", "바나나", "딸기"));
	
	//1. 변수 가져오기
	int num01 = (Integer)session.getAttribute("num01");
	//2. 객체 가져오기
	Person p01 = (Person)session.getAttribute("p01");
	//3. 배열 가져오기
	List<String> fruits = (List<String>)session.getAttribute("list");


%>
 
 
<body>
	<h2 align="center"></h2>
	<table align="center" class="listTable" style="border:1">
		<tr><th>변수(num01)</th><td><%=num01 %></td></tr>
		<tr><th>변수(num01)EL</th><td>${num01 }</td></tr>
		<tr><th>변수(p01)</th><td><%=p01.getName() %>, <%=p01.getAge() %>, <%=p01.getLoc() %></td></tr>
		<tr><th>변수(p01)EL</th><td>${p01.name }, ${p01.age }, ${p01.loc }</td></tr>
		<tr><th>배열(List)</th><td><%=fruits.get(0) %>, <%=fruits.get(1) %>, <%=fruits.get(2) %></td></tr>
		<tr><th>배열(List)EL</th><td>${list.get(0) }, ${list.get(1) }, ${list.get(2) }</td></tr>
	</table>

</body>
</html>
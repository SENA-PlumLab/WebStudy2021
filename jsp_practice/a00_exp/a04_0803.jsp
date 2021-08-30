<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--
# 정리문제
1. 액션태그 중, include, forward의 차이를 기술하세요!
2. 예외페이지 기본처리 형식을 파일로 기술하세요.
3. 서버, 클라이언트의 관계에서 임시 저장 객체 두가지를 기술하고, 그 중 client에 저장될 때, 핵심
   코드를 기술하세요.
5. ID:[   ][로그인] 요청값을 받아 조건문과 forward 액션태그를 이용해서, himan이면 
   main.jsp 아니면 login.jsp페이지로 이동하게하세요
6. 생성자 객체를 아이디, 패스워드, 이름, 기능메서드로 화면에 있는 테이블에 출력하게 선언하고,
   아이디[   ] 패스워드[    ] 이름[    ][등록] ==> 클릭시 하단 테이블에 생성자 객체의 메소드 show() 
   테이블                   출력
9:30까지 일단 진행해보겠습니다.

1. 
 - include는 명시된 page가 부모 페이지에 종속적으로 포함됨. 제어권은 부모페이지에 유지 됨.
 - forward는 페이지 제어권이 forward에 명시된 page로 이동하고, 최종적으로 페이지 이동이 생김.

2. 
 - 에러페이지: <%@ isErrorPage="true" %>
 - 실제 실행 페이지: <%@ errorPage="에러페이지.jsp" %>
3. 
 - session: 데이터를 서버에 저장
 - Cookie: 데이터를 클라이언트에 저장
	Cookie c1 = new Cookie("name", "himan");
	response.addCookie(c1);
5.

 --%>
<body>
	<form >
		<input type="text" name="name2">	
		<br>
		<input type="submit" value="확인"/>
		<br>
	</form>
	<hr>
		ID: <input type="text" id="id"><br>
		PW: <input type="text" id="pw"><br>
		이름: <input type="text" id="name"><br>
		<button onclick="setCon()">등록</button><br>
	<table id="id-table">
	</table>
</body>

<script type="text/javascript">
/*
	<%--
	String name2 = request.getParameter("name2");
	String urlToGo = "";
	if(name2.equals("himan")){
		urlToGo="login.jsp";
	}
	else{
		urlToGo="main.jsp";
	}
	
	<jsp:forward page="<%=urlToGo %>" />
	--%>
*/
function member(id, pw, name) {
	this.id= id;
	this.pw= pw;
	this.name = name;
	show = id+"("+name+")님 환영합니다!";
}
var setCon = function(){ 
	var id = document.querySelector("#id").value;
	var pw = document.querySelector("#pw").value;
	var name = document.querySelector("#name").value;
	var m1 = new member(document.querySelector("#id").value, 
			document.querySelector("#pw").value, document.querySelector("#name").value);
	var table = document.querySelector("#id-table");
	table.innerHTML+="<tr><td>id</td><td>"+id+"</td><tr>";
	table.innerHTML+="<tr><td>pw</td><td>"+pw+"</td><tr>";
	table.innerHTML+="<tr><td>name</td><td>"+name+"</td><tr>";
	table.innerHTML+="<tr><td colspan='2'>"+show+"</td><tr>";
}

</script>
</html>
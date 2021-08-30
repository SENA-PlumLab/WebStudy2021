<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script><script type="text/javascript"></script>
<%--

1. 
 *자바빈에서 프로퍼티란 저장되어있는 값을 표현하는 것,
 *메소드 이름을 사용해 프로펕의 이름을 결정 
 **주의 필드가 아님!
class Person{
	private String name; //프로퍼티 아님
	public void setName(String name){
		//set을 뺀 Name => 소문자 name. 이것이 프로퍼티이다.
	}
	public String getName(){
		//get을 뺀 Name => 소문자 name. 이것이 프로퍼티이다.
	}
} 


2.
 <jsp:useBean id="person" class="a00_exp.z01_Person">
 <jsp:setProperty name="person" property="name" value="himan"/>
 <jsp:setProperty name="person" property="age" value="60"/>
 <jsp:setProperty name="person" property="loc" value="seoul, korea"/>
 
 <body>
	이름 : <jsp:getProperty name="person" property="name" /><br>
	나이 : <jsp:getProperty name="person" property="age"/><br>
	위치 : <jsp:getProperty name="person" property="loc"/><br>
</body>
3.
 모델1은 클라이언트의 브라우저가 JSP, JavaBean, DB 순서로 접근한다.
 모델2는 클라이언트의 브라우저가 Servlet에 데이터를 요청하면 JSP, JavaBean을 통해 DB와 통신한 것으로 응답한다. 
 - 차이점
	모델1: 비즈니스 로직 영역(Controller)에 프레젠테이션 영역(View)를 같이 구현하는 방식
	모델2: 비즈니스 로직 영역와 프레젠테이션 영역이 분리외어있는 구현 방식



 --%>



<body>
	
</body>
</html>
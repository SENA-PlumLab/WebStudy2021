<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "z02_vo.*"
    import = "java.util.*"    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<c:set var = "path" value="${pageContext.request.contextPath}"/>
<fmt:requestEncoding value="utf-8"/>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%--

# 자바빈
1. 웹 프로그래밍에서 데이터의 표현을 목적으로 사용한다.
2. 일반적인 빈 구성
	값을 저장하기 위한 필드
	값을 수정하기 위한 setter
	값을 읽기 위한 getter
3. 자바빈 프로퍼티 **
	1) 프로퍼티는 자바빈에 저장되어있는 값을 표현한다.
	2) 메소드 이름을 ㅅ용해서 프로퍼티의 이름을 결정한다.
	3) 규칙: 프로퍼티 이름이 propName일 경우..
		- setter: public void setPropName(Type value)
		- getter: public Type getPropName()
		- boolean: isPropName()
		- 배열 지정 가능: public void setName(String[])
		ex) 프로퍼티명이 age인 경우
			setter: public void setAge(int age)
			getter: public int getAge()
			boolean: public boolean isAge()
4. 활용
	1) useBean: <jsp:setProperty name="p01" property="loc" value="서울"/>
	2) el/jstl: ${p01.name} ==> p01.getName()
5. <jsp:useBean> 태그
	1) jsp에서 자바빈 객체를 생성할 때 사용
		<jsp:useBean id="빈이름" class="패키지명.자바클래스" scope="session범위" />
		
		ex) <jsp:useBean id="p01" class="z02_vo.Person" scope="request" />
			==> request.setAttribute("p01", new Person());
			
			<jsp:useBean name="p01" property="name" value="홍길동" />
			==> Person p01 = new Person();
				p01.setName("홍길동");
				request.setAttribute("p01", p01);
					
			<jsp:getProperty name="p01" property="name" />
			==> Person p01 = (Person)request.getAttribute("p01");
				<%=p01.getName() %>
				${p01.name}

--%>
<body>
<%
Person p = new Person();
p.setName("마길동");
p.setAge(28);
p.setLoc("서울신림동");

session.setAttribute("p01", p);
Person p01 = (Person)session.getAttribute("p01");
%>




</body>
</html>
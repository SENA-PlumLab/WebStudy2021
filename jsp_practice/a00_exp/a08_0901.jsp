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
<%

%>
<body>
	<p>
		1. fmt 날짜 기본 형식 
		<br> now 설정: <c:set var="now" value="<%=new Date() %>" />
		<br> 기본 출력: ${now }
	</p>
	<p>
		<br>2. full 형식 출력
		<br>date: <fmt:formatDate type="date" dateStyle="full" value="${now}" />
		<br>time: <fmt:formatDate type="time" timeStyle="full" value="${now}"/>
		<br>both: <fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${now }"/>
		<br>pattern: <fmt:formatDate pattern="yyyy/MM/dd kk:mm:ss.S" value="${now }" />
	</p>
	<p>
		<br>3. 숫자형 데이터
		<br> num01 설정: <c:set var="num01" value="8482465.1234" />
		<br> 통화 단위: <fmt:formatNumber type="currency" currencySymbol="￦" value="${num01 }" />
		<br> 퍼센트: <fmt:formatNumber type="percent" value="${0.33 }" />
		<br> 패턴: <fmt:formatNumber pattern="00,000,000.0000" value="${num01 }" />
	</p>
	<p>
		<br>4. MVC패턴
		<br>controller: 요청값을 받아 모델 데이터에 맞게 변경, 화면에 전달할 핵심 데이터를 모델 데이터로 만듦
		<br>service: 요청값에 따라 데이터 처리/모델 데이터 변형 처리 프로세스
		<br>dao: Data Access Object, 데이터에 접근하여 처리하는 객체
		<br>view: controller를 통해 모델 데이터를 전달 받아 화면을 구성 함
		<br>model: 화면에 전달할 핵심 데이터를 만듬
	</p>
	<div>
		<br>5. id확인
		<jsp:useBean id="dao" class="z01_database.A05_PreparedDao"/>
		<table>
			<tr><th>사원명</th><th>입사일</th><th>급여</th><th>보너스</th></tr>
			<c:forEach var="emp" items="${dao.getEmpList() }" varStatus="sts" >
				<tr>
					<td>${emp.ename }</td>
					<td><fmt:formatDate type="both" dateStyle="full" timeStyle="full" value="${emp.hiredate }"/></td>
					<td><fmt:formatNumber value="${emp.sal }" type="currency" /></td>
					<td><fmt:formatNumber value="${emp.comm/emp.sal }" type="percent" /></td>
				</tr>
			</c:forEach>
		</table>
				
	</div>
</body>
</html>
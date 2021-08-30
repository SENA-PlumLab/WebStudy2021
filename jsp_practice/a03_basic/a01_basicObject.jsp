<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="z01_error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%

/*

# jsp 기본 객체

1. jsp 변수들을 저장할 때, 특정한 범위로 처리할 수 있다. (page 범위, 시간 - session time, 브라우저와 서버 관계, 서버)
	cf) java-데이터 유형과 메모리의 크기 ==> jsp-데이터 유형 + 시간과 페이지 범위
	ex) 로그인한 후, DB 접속하고 가져온 Member 정보를 웹 페이지마다 가지고 있게 함. 각 페이지마다 접근 권한을 활용하거나 로그인 유지 처리에 필요한 범위 - session
2. 범위 내용
	pageContext(page), request(요청), session(세션), application(서버)
3. 사용방법
	.setAttribute("키", "값");
	.getAttribute("키"); 해당 키를 가져온다

*/

session.setAttribute("id", "하이맨");
	
	
%>
</head>
<body>
	<h3 align="center">세션값 확인</h3>
	<a>세션 아이디: <%=session.getAttribute("id")%></a>
</body>
<script type="text/javascript">

location.href="../a00_exp/a03_0802_2.jsp";

</script>
</html>



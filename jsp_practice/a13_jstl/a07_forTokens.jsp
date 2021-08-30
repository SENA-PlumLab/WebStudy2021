<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%--

# forTokens
구분자에 의해 데이터를 배열로 만듦

<c:forEach>는 List, 배열 요소를 순서대로 반복해서 처리할 수 있는 태그 입니다.

출처: https://offbyone.tistory.com/368 [쉬고 싶은 개발자]


--%>
<body>
<%
ArrayList<String> nameList = new ArrayList<String>(Arrays.asList("홍길동", "김철수", "박영희"));

model.addAttribute("nameList", nameList);
%>
<c:forEach var="name" items="${nameList}" varStatus="status">

    <p>${status.count} : <c:out value="${name}" /></p>

</c:forEach>
</body>
</html>
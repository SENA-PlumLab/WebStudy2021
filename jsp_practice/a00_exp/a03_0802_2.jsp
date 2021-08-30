<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="../a03_basic/z01_error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

String name = request.getParameter("name");
int age;
if(request.getParameter("age")!="" || request.getParameter("age")!=null){
	age = request.getParameter("age");
}
else { 
	age = 0;
}

int count;
if(request.getParameter("count")!="" || request.getParameter("count")!=null){
	count = request.getParameter("count");
}
else { 
	count = 0;
}

int total = count*5000;

if(age>60){ total*=0.8;}

%>
<body>
	<h2><%=name %>님 (<%=age %>세)</h2>
	<%=count %>명 입장료: <%=total %>원입니다.
</body>
</html>
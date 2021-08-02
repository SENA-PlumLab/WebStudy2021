<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ page import="teamP_06.BBSController" %>   
    
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

BBSController bCon = new BBSController();

String memNum = request.getParameter("memNum");

String title = request.getParameter("title");
String subTitle = request.getParameter("subtitle");
String contents = request.getParameter("ir1");
ArrayList<String> restList = new ArrayList<String>();
for(int i=1; i<3; i++){
	if (request.getParameter("rest"+i)!=""){
		restList.add(request.getParameter("rest"+i));
	}
	else break;
}

ArrayList<String> genList = bCon.writeBBS(memNum ,title, subTitle,contents, restList);


%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	
</body>
<script type="text/javascript">
if (typeof window !== 'undefined') { 
	window.alert('글번호: '+'<%=genList.get(0) %>'+', 작성 완료! ^^');
} 
document.location.href="bbs_view.jsp?memNum=mem-0001&bbsNum=<%=genList.get(0)%>";

</script>
</html>
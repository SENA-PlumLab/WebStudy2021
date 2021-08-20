<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
  
    import = "java.util.*"
    import = "model2.myPage.MPDao"
    import = "model2.vo.*"
%>
  <!-- 오류날 시 아래를 복붙 -->  
  <%
  	request.setCharacterEncoding("utf-8"); // 요청값에 대한 한글 encoding처리
  	String path = request.getContextPath(); 
  	//기준경로 설정  \jspexp_0\src\main\webapp
  %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 외부css 가져오기 -->
	<link rel="stylesheet" href="<%=path%>\a00_com\a00_com.css">

<style>
		
</style>
<script src="<%=path%>\a00_com\jquery-3.6.0.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("h3").text("제이쿼리 시작");
});
</script>
</head>
<body>
<%
		String pfNum = request.getParameter("pfNum");
		boolean isDelete = false;
		if(pfNum!=null){
			MPDao MPDao = new MPDao();

    		MPDao.deletePortDetail(pfNum);
			isDelete = true;
		}
	%>
	<h3>삭제</h3>
	
	
	<Script>
		var isDelete = "<%=isDelete%>";
		if(isDelete){
			if(confirm("삭제되었습니다.")){
            	window.close();
            	opener.location.reload();
			}
		}
	</Script>
</body>
</html>
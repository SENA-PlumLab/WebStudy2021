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
<!-- 네이버로 로그인 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>

<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>
<%

%>
<body>

</body>

<!-- 네이버아디디로로그인 Callback페이지 처리 Script -->
<script type="text/javascript">
var naver_id_login = new naver_id_login("3eVzkEaSUIXcPlc6Ru1B", "http://localhost:7080/jspexp/teamP_09/login/callback.jsp");
// 접근 토큰 값 출력
alert(naver_id_login.oauthParams.access_token);
// 네이버 사용자 프로필 조회
naver_id_login.get_naver_userprofile("naverSignInCallback()");
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
		// naver_id_login.getProfileData('프로필항목명');
		// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
		var id = naver_id_login.getProfileData('id');
		var name = naver_id_login.getProfileData('name');
		var birth;
		//출생연도
		if(naver_id_login.getProfileData('birthyear')=='undefined'){
			birth = '0000'
		} else {
			birth = naver_id_login.getProfileData('birthyear');
		}
		//생일
		if(naver_id_login.getProfileData('birthday')=='undefined'){
			birth += '0000'
		} else {
			//MM-DD 형식
			var birthArray=naver_id_login.getProfileData('birthday').split('-');
			birth += birthArray[0]+birthArray[1];
		}
		var email = naver_id_login.getProfileData('email');
		var mobile = naver_id_login.getProfileData('mobile');
		alert(id);
		alert(name);
		alert(birth);
		alert(email);
		alert(mobile);
	
		
		//document.location("join.jsp?id="+id+"&name="+name+"&birth="+birth+"&email="+email+"&mobile="+mobile);
	}


	
</script>
<!-- //네이버아디디로로그인 Callback페이지 처리 Script -->
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_06.MemberController" %>   
<%@ page import="teamP_06.Member" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../common/style.css?ver=1" rel="stylesheet" type="text/css">
<link href="bbs_write_css.css?ver=2" rel="stylesheet" type="text/css">
</head>
<body>
<%
MemberController mCon = new MemberController();

	String memNum = request.getParameter("memNum");
	
	Member m = mCon.findMemberByMemNum(memNum);
%>
<%@include file ="../common/header.jsp"  %>
	
	
<section >
<div class="center">
	<form class="form" action="bbs_write_insert.jsp?memNum=<%=memNum %>" method="post">
		<div class="title-holder">
			<span>제목: </span>
			<input class="title" type="text" id="title" name="title">
		</div>			
		<div class="title-holder">
			<span>부제목: </span>
			<input class="title" type="text" id="subtitle" name="subtitle">
		</div>			
		<textarea name="ir1" id="ir1" rows="10" cols="100" 
					style="width:766px; height:412px; display:none;">
			
		</textarea>
		<div class="rest" id="rest">
			<span> 기행문 속 식당 </span>
			<input type="text" id="rest1" name="rest1">
			<input type="text" id="rest2" name="rest2">			
		</div>
		
	</form>
	<div class="btn-holder">
	<button class="btn" id="dddRest" onclick="addRest()">추가</button>
	<button class="btn" id="deleteRest" onclick="deleteRest()">삭제</button>
	</div>
	<div class="btn-holder">
		<input class="btn-submit" type="button" onclick="submitContents();" value="저장" />
	</div>
</div>
</section>
	
        
<%@include file ="../common/footer.jsp" %>
</body>
<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
//멤버 권한 체크 (관리자만 글 작성 가능)
if(<%=m.getAuth()%><10){
	alert("권한이 없습니다!");
	location.href="bbs_list.jsp";
}

//스마트 에디터
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "ir1",
 sSkinURI: "se2/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});
function submitContents() {
	 // 에디터의 내용이 textarea에 적용된다.
	 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	 try {
		 document.getElementById("ir1").form.submit();
	 } catch(e) {}
}

var restDiv = document.querySelector("#rest")
var restCnt = 3;
var addRest = function(){
	if(restCnt>=5){
		alert('더 이상 추가할 수 없습니다.');
	}
	else{
		restDiv.innerHTML+='<input type="text" id= "rest'+restCnt+'" name="rest'+restCnt+'">';
		restCnt++;
	}
	
}
var deleteRest = function(){
	if(restCnt<=2){
		alert('더 이상 삭제할 수 없습니다.');
		
	}
	else {
		document.querySelector("#rest"+(--restCnt)).remove();
	}
}

</script>
<script type="text/javascript" src="bbs_write_validation.js"></script> 

</html>
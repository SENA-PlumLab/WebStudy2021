<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ page import="teamP_06.BBSController" %>   
<%@ page import="teamP_06.BBS" %>   
<%@ page import="teamP_06.BBSRec" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../common/style.css?ver=1" rel="stylesheet" type="text/css">
<link href="bbs_write_css.css?ver=1" rel="stylesheet" type="text/css">
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

BBSController bCon = new BBSController();
BBS b = new BBS();
ArrayList<BBSRec> rcList = new ArrayList<BBSRec>();

String memNum = request.getParameter("memNum");
String bbsNum = request.getParameter("bbsNum");

b = bCon.getBBS(bbsNum);
rcList = bCon.getBBSRecByBBSNum(bbsNum);
if(rcList.size()==0){
	rcList.add(0, new BBSRec("없음","",""));
	rcList.add(1, new BBSRec("없음","",""));
}
if(rcList.size()==1){
	rcList.add(1, new BBSRec("","",""));
}

%>
<%@include file ="../common/header.jsp"  %>
	
	
<section >
<div class="center">
	<form class="form" action="bbs_edit_update.jsp?memNum=<%=memNum %>&bbsNum=<%=bbsNum %>" method="post">
		<div class="title-holder"><span>제목: </span><input class="title" type="text" id="title" name="title" value="<%=b.getTitle()%>" disabled></div>			
		<div class="title-holder"><span>부제목: </span><input class="title" type="text" id="subtitle" name="subtitle" value="<%=b.getSubtitle()%>" disabled></div>			
		<textarea name="ir1" id="ir1" rows="10" cols="100" style="width:766px; height:412px; display:none;">
			<%=b.getContents() %>
		</textarea>
		<div class="rest" id="rest">
			<span> 기행문 속 식당 </span>
			<input type="text" id="rest1" name="rest1" value="<%=rcList.get(0).getRestNum()%>" disabled>
			<input type="text" id="rest2" name="rest2" value="<%=rcList.get(1).getRestNum()%>" disabled>			
		</div>
		
	</form>
	<div class="btn-holder">
		<input class="btn" type="button" onclick="submitContents();" value="저장" />
	</div>
</div>
</section>
	
        
<%@include file ="../common/footer.jsp" %>
</body>
<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
 oAppRef: oEditors,
 elPlaceHolder: "ir1",
 sSkinURI: "se2/SmartEditor2Skin.html",
 fCreator: "createSEditor2"
});

//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents() {
	 // 에디터의 내용이 textarea에 적용된다.
	 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	
	 // 에디터의 내용에 대한 값 검증은 이곳에서
	 // document.getElementById("ir1").value를 이용해서 처리한다.
	
	 try {
		 document.getElementById("ir1").form.submit();
	 } catch(e) {}
}
</script>

</html>
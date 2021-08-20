<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Creator.*"
    %>
 <%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
%>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="Funding_Register_Story.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<script src="jquery-3.6.0.js" 
	type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function () {

	$("[name=save]").click(function() {
		if ($("[name=fdStoryImg]").val()=="") {
			alert("스토리 이미지를 첨부하세요.");
			$(this).focus();
		}else if ($("[name=fdStorySum]").val()=="") {
			alert("스토리요약을 입력하세요.");
			$(this).focus()
		}else if ($("[name=fdStory]").val()=="") {
			alert("프로젝트 스토리를 입력하세요.");
			$(this).focus();
		}else{
			$("#frm01").submit();
		}
	});
	
	$('#summaryText').keyup(function(e) {
		var content = $(this).val();
		$('#count1').text(250 - content.length);
		if (content.length > 250) {
			$(this).val($(this).val().substring(0, 250));
			alert("입력 가능한 글자수를 초과하였습니다.");
		}
	});

	$('#contentText').keyup(function(e) {
		var content = $(this).val();
		$('#count2').text(1000 - content.length);
		if (content.length > 1000) {
			$(this).val($(this).val().substring(0, 1000));
			alert("입력 가능한 글자수를 초과하였습니다.");
		}
	});
	
});
</script>

</head>
<%-- 
# 

--%>
<%
	String memNum = (String) session.getAttribute("memnum");
	String creNum = (String) session.getAttribute("creNuum");
	
	String fdStoryImg = request.getParameter("fdStoryImg");
	String fdStorySum= request.getParameter("fdStorySum");
	String fdStory = request.getParameter("fdStory");

	if (fdStorySum!=null) {
		DAO_MyOnePick dao = new DAO_MyOnePick ();
		dao.update_story(new Funding(fdStoryImg,fdStorySum,fdStory));
	}

	%>
<body>
	<h1 id="Register_title">스토리 작성</h1>
	<form id="frm01">
	<table id="story">
	<tr>
		<td colspan="2" class="fd_dt_title">스토리 이미지<span style="color:red">*</span></td>
	</tr>
	<tr>
		<td colspan="2">
            <input type="file" value="파일 선택" name="fd_img"/>
			<h3 class="warning">3MB 이하의 JPEG, PNG 파일</h3></td>
	</tr>
	<tr>
		<td colspan="2" class="fd_dt_title">스토리요약<span style="color:red">*</span></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="fdStorySum" id="summaryText" class="fd_dt_contents" cols="30" rows="10"></textarea>
      		<h3 class="warning">남은글자수 <span id="count1">250</span></h3></td>
	</tr>
	<tr>
		<td colspan="2" class="fd_dt_title">프로젝트 스토리<span style="color:red">*</span></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="fdStory" id="contentText" class="fd_dt_contents" cols="30" rows="10"></textarea>
      		<h3 class="warning">남은글자수 <span id="count2">1000</span></h3></td>
	</tr>
	</table>
	</form>
	<input type="submit" value="저장하기" name="save" class="save_choice"/>	

<script type="text/javascript">

</script>
</body>
</html>
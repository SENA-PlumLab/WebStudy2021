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
		if ($("[name=fdRefund]").val()=="") {
			alert("펀딩금 환불정책을 입력하세요.");
			$(this).focus();
		}else{
			if (confirm("최종 등록 하시겠습니까?")) {
				$("#frm01").submit();
				location.href="Funding_Register_Policy_finish.jsp";
			}
		};
	});
	
	$('#fdRefundText').keyup(function(e) {
		var content = $(this).val();
		$('#count1').text(500 - content.length);
		if (content.length > 500) {
			$(this).val($(this).val().substring(0, 500));
			alert("입력 가능한 글자수를 초과하였습니다.");
		}
	});

	$('#fdPolicyText').keyup(function(e) {
		var content = $(this).val();
		$('#count2').text(500 - content.length);
		if (content.length > 500) {
			$(this).val($(this).val().substring(0, 500));
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
	
	String fdRefund = request.getParameter("fdRefund");
	String fdPolicy= request.getParameter("fdPolicy");

	if (fdRefund!=null) {
		DAO_MyOnePick dao = new DAO_MyOnePick ();
		dao.update_policy(new Funding(fdRefund,fdPolicy));
	}

	%>
<body>
	<h1 id="Register_title">정책동의</h1>
	<form id="frm01">
	<table id="policy">
	<tr>
		<td colspan="2" class="fd_dt_title">펀딩금 환불정책<span style="color:red">*</span></td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="fdRefund" id="fdRefundText" class="fd_dt_contents"></textarea>
      		<h3 class="warning">남은글자수 <span id="count1">500</span></h3></td>
	</tr>
	<tr>
		<td colspan="2" class="fd_dt_title">발생한 하자에 대한 A/S 정책</td>
	</tr>
	<tr>
		<td colspan="2">
			<textarea name="fdPolicy" id="fdPolicyText" class="fd_dt_contents"></textarea>
      		<h3 class="warning">남은글자수 <span id="count2">500</span></h3></td>
	</tr>
	</table>
	</form>
	<input type="submit" value="최종 저장하기" name="save" class="save_choice"/>

<script type="text/javascript">

</script>
</body>
</html>
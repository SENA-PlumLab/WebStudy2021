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
<style>
	
</style>
<link rel="stylesheet" href="Funding_Register.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">

<script src="jquery-3.6.0.js" 
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var idx=1;
		var idx2=1;
		var idx3=1;
		var isSelected=false;
		var isSelected2=false;
		var isSelected3=false;
		$("#option1").click(function(){
			idx++
			if(idx%2==0) {
				if (isSelected2||isSelected3) {
					alert("하나의 테마만 선택하세요");
				}else {
					$(this).val("선택완료");
					isSelected=true;
					$("[name=option]").val(1)
				}
			}else {
				$(this).val("선택");
				isSelected=false;
				$("[name=option]").val(null);
			}
		});
		$("#option2").click(function(){
			idx2++
			if(idx2%2==0) {
				if (isSelected||isSelected3) {
					alert("하나의 테마만 선택하세요");
				}else {
					$(this).val("선택완료");
					isSelected2=true;
					$("[name=option]").val(2)
				}
			}else {
				$(this).val("선택");
				isSelected2=false;
				$("[name=option]").val(null);
			}
		});
		$("#option3").click(function(){
			idx3++
			if(idx3%2==0) {
				if (isSelected||isSelected2) {
					alert("하나의 테마만 선택하세요");
				}else {
					$(this).val("선택완료");
					isSelected3=true;
					$("[name=option]").val(3)
				}
			}else {
				$(this).val("선택");
				isSelected3=false;
					$("[name=option]").val(null);
			}
		}); 
		$("[name=save]").click(function() {
			if (!($("[name=option]").val()==1||
				$("[name=option]").val()==2||
				$("[name=option]").val()==3)) {
				alert("테마를 선택해주세요.");
			}else { 
				$("#frm01").submit();
				
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
	String fdThemeNumS=request.getParameter("option");

	if (fdThemeNumS!=null) {
	int fdThemeNum =Integer.parseInt(fdThemeNumS);
	DAO_MyOnePick dao = new DAO_MyOnePick ();
	dao.inserttest(new Funding("crt-0002",fdThemeNum));
	}
	%>
<body>
	<h1 id="Register_title">테마 선택</h1>
	<form id="frm01">
	<table>
		<tr>
			<td>
				<input type="hidden" name="option" value=""/>
				<div class="theme">
					<img src="image/frame.png">
					<ul>
						<li><img src="image/check.png" class="check">My One Pick 티칭</li> 
						<li><img src="image/check.png" class="check">스토리 디벨롭 지원</li>
						<li><img src="image/check.png" class="check">새소식 알림</li> 
						<li><img src="image/check.png" class="check">펀딩 인증마크</li> 
					</ul>
				<input type="button" value="선택" id="option1" class="choice">
				</div>
								<div class="theme">
					<img src="image/frame2.png" style="width:360px; height:350px;">
					<ul style="top:385px;">
						<li><img src="image/check.png" class="check">My One Pick 티칭</li> 
						<li><img src="image/check.png" class="check">스토리 디벨롭 지원</li>
						<li><img src="image/check.png" class="check">새소식 알림</li> 
						<li><img src="image/check.png" class="check">펀딩 인증마크</li> 
						<li><img src="image/check.png" class="check">컨텐츠 제작 도우미</li> 
						<li><img src="image/check.png" class="check">리스트 상위노출</li> 
						<li><img src="image/check.png" class="check">컨텐츠 광고제작</li> 
					</ul>
					<input type="button" value="선택" id="option2" class="choice" style="top:353px;">
				</div>
				<div class="theme">
					<img src="image/frame3.png" style="width:350px; height:420px;">
					<ul style="top:750px;">
						<li><img src="image/check.png" class="check">My One Pick 티칭</li> 
						<li><img src="image/check.png" class="check">스토리 디벨롭 지원</li>
						<li><img src="image/check.png" class="check">새소식 알림</li> 
						<li><img src="image/check.png" class="check">펀딩 인증마크</li> 
						<li><img src="image/check.png" class="check">컨텐츠 제작 도우미</li> 
						<li><img src="image/check.png" class="check">리스트 상위노출</li> 
						<li><img src="image/check.png" class="check">컨텐츠 광고제작</li>
						<li><img src="image/check.png" class="check">온·오프라인 펀딩</li>
						<li><img src="image/check.png" class="check">제조사 물품 할인</li>
					</ul>
					<input type="button" value="선택" id="option3" class="choice" style="top:715px;">	
				</div>
			<td>
		</tr>
	</table>
	</form>
	<input type="submit" value="저장하기" name="save" class="save_choice" />	
	
</body>
</html>
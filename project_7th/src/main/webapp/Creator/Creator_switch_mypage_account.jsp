<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	
	    
    import = "java.util.*"
    import = "model2.myPage.MPDao"
    import = "model2.vo.*"
    
   %>
<%
request.setCharacterEncoding("utf-8");
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick</title>
<link rel="stylesheet" href="section_mypage.css" type="text/css">
<link rel="stylesheet" href="section_mypage_account.css" type="text/css">
<link rel="stylesheet" href="../common/style.css" type="text/css">

</head>
<body>
<header>

</header>    

	<%
		Object loginM = session.getAttribute("loginM");
		String loginMS = (String)loginM;
		MPDao dao = new MPDao();
		ArrayList<Member> mlist = dao.getMember(new Member(loginMS));
	
	%>
	<section>
		<% for(Member m:mlist) { %>
		<form id="account_form" method="post" enctype="multipart/form-data">
			<div id="wrap3">
				<table class="account_profile mymage_table">
					<tr><th colspan="3">프로필 정보</th><tr>
					<tr>
						<th>프로필사진</th>
						<td><input type="text" name="memImg" value="<%=m.getMemIng()%>" disabled="disabled"></td>
						<td>
						<label class="label_btn" for="profileImg">사진 등록</label>
						<input type="file" id="profileImg" name="profileImg"
						 accept="image/*" onchange=loadFile(this)>
						</td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input type="text" name="memNick" value="<%=m.getMemNick()%>"></td>
						<td></td>
					</tr>
					<tr>
						<th>소개글</th>
						<td><input type="text" name="memText" value="<%=m.getMemText()%>"></td>
						<td></td>
					</tr>
				</table>
				<table class="account_account mymage_table">
				<tr><th colspan="3">계정정보</th><tr>
					<tr>
						<th>이메일</th>
						<td class="disabled_email"><input type="text" name="memImg" value="<%=m.getMemId()%>" disabled="disabled"></td>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="text" name="memNick" value="<%=m.getMemPw()%>"></td>
						<td></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="memText" value="<%=m.getMemPhone()%>"></td>
						<td></td>
					</tr>
				
				</table>	
				<div class="account_btns">
					<input id="account_btn" class="btn_default" type="button" value="수정">
				</div>
			</div>
		<% } %>
		</form>
	</section>
<footer>

</footer>

	<script>
		var profileImg = document.querySelector("#profileImg");
		var memImg = document.querySelector("[name=memImg]");
		function loadFile(input){
			var file = input.files[0]; // 선택된 파일 가져오기
			memImg.value = "../image/"+file.name;
		}
	
		var accountBtn = document.querySelector("#account_btn");
		var accountform = document.querySelector("#account_form");
		accountBtn.onclick = function(){
			location.href = "Creator_swich.jsp";
			accountform.submit();
		};
	</script>
</body>
</html>
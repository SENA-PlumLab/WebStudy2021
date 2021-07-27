<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
 <%@ page import="teamP_06.MemberController" %>
 <%@ page import="teamP_06.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	MemberController mCon = new MemberController();
	Member m = new Member("mem-0005");
	
	//--------------------------
	m = mCon.findMember(m);

	%>
	
	<h3>MemNum: <%=m.getMemNum() %></h3>
	<h3>MemID: <%=m.getmID() %></h3>
	<h3>MemPW: <%=m.getmPW() %></h3>
	<h3>MemNick: <%=m.getmName()%></h3>
	<h3>MemMail: <%=m.getmEmail() %></h3>
	<h3>MemImg: <%=m.getmImage() %></h3>
	<h3>JoinDate: <%=m.getJoinDate() %></h3>
	<h3>MemPoint: <%=m.getmPoint() %></h3>
	<hr>
	<section>
		<h2>회원가입 정보 입력</h2>
	<form method="post" action="joinMember_insert.jsp" name="write">
		<table width="650" border=1 align="center" cellspacing="0" cellpadding="5" style="margin-left: auto; margin-right: auto;">
			<col width="150">
			<col width="500">
			<tr>
				<td colspan="2" align="center"> 회원정보 입력 </td>
			</tr>
			<tr>
				<td>아이디<span id="required">*</span></td>
				<td><input type="text" name="memID" size=10 style="width:100px;"></td>
			</tr>
			<tr>
				<td>비밀번호<span id="required">*</span></td>
				<td><input type="text" name="memPW" size=10 style="width:100px;"></td>
			</tr>
			<tr>
				<td>비밀번호 재입력<span id="required">*</span></td>
				<td><input type="text" size=30 style="width:100px;"></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><input type="text" name="mName" size=10 style="width:100px;"></td>
			</tr>
			<tr>
				<td>이메일<span id="required">*</span></td>
				<td><input type="text" name="mEmail1" size=10 style="width:100px;">
					@
					<input type="text" name="mEmail2" id="mEmail2" size=10 style="width:100px;">
					<select name="mEmail2_select" onchange=getEmailSelect(this)>
						<option value="">이메일 선택</option>
						<option value="naver.com">네이버</option>
						<option value="daum.net">다음</option>
						<option value="google.com">구글</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="text" name="mImage" size=10 style="width:450px;"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type=submit value="확인">
					<input type=button id="cancel" onclick=cancel() value="취소">
				</td>
			</tr>
			</table>
	</form>
	</section>	
</body>

<script type="text/javascript">
var email2Select = document.getElementsByName('mEmail2_select');
function getEmailSelect(e){
	var value = e.value;
	console.log(value);
	document.getElementById("mEmail2").value = value;
}
function cancel() {
	location.href="resumeList.jsp";
	//window.location='recruitList.jsp';
}
</script>

</html>
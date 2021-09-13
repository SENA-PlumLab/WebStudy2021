<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="z02_vo.*" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.js"> </script>
<script type="text/javascript"></script>

<!-- main css -->
<link rel="stylesheet" href="../main/main_style.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css">

<link rel="stylesheet" href="join_css.css" />

<%
String id = request.getParameter("id");
%>


<body>
	<%@include file="../mainSupporter/MPHeader.jsp"%>

	<section>
		<div class="wrap">
			<article>
				<form method="post" action="${path}/JoinProc.do" onsubmit="return checkForm();">
					<table>
						<tr>
							<th colspan="2"><h2>회원가입</h2></th>
						</tr>
						
						<tr>
							<td width="30%">ID <span class="necessary">*</span>
							</td>
							<td><input type="text" id="id" name="id" placeholder="ID">
								<input type="button" id="btn-checkID" class="btn-custom"
								value="ID 중복확인" /> <span id="check-result"><i
									class="fas fa-check-circle"></i></span></td>
						</tr>

						<tr>
							<td>비밀번호 <span class="necessary">*</span>
							</td>
							<td><input type="password" id="pass" name="pass"
								placeholder="Password"></td>
						</tr>

						<tr class="pw-holder">
							<td>비밀번호 재입력 <span class="necessary">*</span>
							</td>
							<td><input type="password" id="pass2" name="pass2"
								placeholder="Password"></td>
						</tr>

						<tr class="notice-holder">
							<td></td>
							<td><span class="note">비밀번호 일치</span></td>
						</tr>

						<tr>
							<td>이름 <span class="necessary">*</span>
							</td>
							<td><input type="text" id="name" name="name"
								placeholder="Name"></td>
						</tr>

						<tr>
							<td>이메일 <span class="necessary">*</span>
							</td>
							<td><input type="email" id="email" name="email"
								placeholder="Example@naver.com"></td>
						</tr>

						<tr>
							<td>생년월일 <span class="necessary">*</span>
							</td>
							<td><input type="date" id="birth" name="birth"
								value="1970-01-01"></td>
						</tr>
						<tr>
							<td>전화번호</td>
							<td><input type="text" id="mobile" name="mobile"
								placeholder="01033337777"> <span class="note">하이픈(-)
									제외</span></td>
						</tr>

						<tr>
							<td colspan="2" class="check-holder" style="text-align: left">
								개인정보 제공 동의 <span class="necessary">*</span> <input
								type="checkbox" id="check" name="check">
							</td>
						</tr>

						<tr>
							<td colspan="2" class="btn-holder"><input type="submit"
								class="btn-custom btn-submit" value="회원가입"></td>
						</tr>

					</table>
				</form>
			</article>
		</div>
	</section>

	<!-- The Modal -->
	<div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">

			<span class="close">&times;</span>
			<h3>ID 중복확인</h3>
			<br>
			<div class="modal-div">
				<input type="text" id="id-check" placeholder="ID"> 
				<input type="button" class="btn-custom" value="ID 중복확인">
			</div>
			<div class="modal-div">
				결과: <span class="necessary"> 사용 가능 </span>
			</div>
		</div>

	</div>



	<%@include file="../mainSupporter/MPFooter.jsp"%>
</body>
<script type="text/javascript">
// Get the modal
var modal = document.getElementById('myModal');
// Get the button that opens the modal
var btn = document.getElementById("btn-checkID");
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];                                          
// When the user clicks on the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
    $("#id-check").val($("#id").val());
}
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



</script>
</html>
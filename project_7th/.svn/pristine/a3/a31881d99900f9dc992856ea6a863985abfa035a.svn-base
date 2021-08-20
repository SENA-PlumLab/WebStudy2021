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
<link rel="stylesheet" href="../common/style.css" type="text/css">


<style>

	
	.btn_cancel {
	    width: 100px;
	    padding: 5px 20px;
	    background-color: #FDFBFC;
	    border: 1px solid #10223b;
	    border-radius: 5px;
	    cursor: pointer;
	}
	
	.btn_default{
	    width: 100px;
	    padding: 5px 20px;
	    color: #FDFBFC;
	    background-color: #10223b;
	    border: none;
	    border: 1px solid #10223b;
	    border-radius: 5px;
	    cursor: pointer;
	}
	
	.btn_state {
	    width: 150px;
	    padding: 5px 20px;
	    color: #FDFBFC;
	    background-color: #FE0D49;
	    border: none;
	    border: 1px solid #FE0D49;
	    border-radius: 5px;
	    cursor: pointer;
	}

	#wrap3 {
		width : 850px;
		border : 2px solid #07CBE5;
		padding : 20px 30px;
	}
	
	.mymage_table{
		width : 100%;
		text-align: left;
		
        border-collapse: collapse;
		/*
		border : 2px solid #DDEEEB;
		*/
	}
	
	.mymage_table tr th{
		width : 20%;
		padding : 5px 10px;
	}
	.mymage_table tr td{
		padding : 5px 10px;
	}
	.mymage_table tr td:last-child {
		width : 25%;
	}
	.mymage_table tr td:nth-child(2) {
		background-color: #ffffff;
	}
	.mymage_table input[type="text"] {
		width:100%;
		height:100%;
		padding : 7px;
		border : none;
	}
	
	
	.PF_title{
		position : relative;
	}
	.PF_title h3 {
		 padding : 25px 0px;
	}
	.PF_title > input[value="등록"] {
		position : absolute;
		top : 25px;
		right : 5px;	
	}
	
	.PF_content{
		padding : 20px 10px;
	}
	
	.PF_table {
		margin : 20px 0px;
	}
	.PF_table td {
		border : 2px solid #FDFBFC;
	}
	
	.PF_table tr th {
		width : 10%;
	}
	.PF_table tr td:last-child {
		width : 70%;
	}
	
	.PF_table td > .btn_default{
		display :block;
		margin : 10px auto;
		
	}
	.PF_none {
		width : 100%;
		height : 200px;
		background-color : #DDEEEB;
		border : 2px solid #DDEEEB;
	}

	.PF_none p {
		padding-top : 90px;
		text-align: center;
	}
	
</style>
</head>
<body>
<header>

</header>    
	<%
	
		Object loginM = session.getAttribute("loginM");
		String loginMS = (String)loginM;
		MPDao dao = new MPDao();
		ArrayList<Portfoilo> portList = dao.getPortfoilo(new Portfoilo(loginMS));
		
	%>
	<section>
		
		<div id="wrap3">
			<div class="PF_div">
				<div class="PF_title">
					<h3>포토폴리오</h3>
					<input type="button" name="PFInput" value="등록" class="btn_default" onclick="portRegi()">
				</div>
				<div class="PF_content"> 
				<%
					int cnt = 0;
					if(portList!=null) {
						for(Portfoilo port:portList) {
				%>
					<form id="form<%=cnt++%>">
					<input type="hidden" name="pfNum" value="<%=port.getPfNum()%>">
					<table class="mymage_table PF_table">
						<tr><th>제목</th><td><input type="text" value="<%=port.getPfTitle()%>" disabled="disabled"></td>
							<td rowspan="4">
								<%if(port.getPfStateNum()==0) { %>
									<input type="button" id="PFstateNum" class="btn_state" value="등록중">
									<input type="button" id="uptPort" class="btn_default" value="수정">
								<% }else if(port.getPfStateNum()==1){ %>
									<input type="button" id="PFstateNum" class="btn_state" value="제출">
									<input type="button" id="uptPort" class="btn_default" value="수정">
								<% }else if(port.getPfStateNum()==2){ %>
									<input type="button" id="PFstateNum" class="btn_state" value="심사완료(통과)">
									<input type="button" id="uptPort" class="btn_default" value="수정">
								<% }else if(port.getPfStateNum()==3){ %>
									<input type="button" id="PFstateNum" class="btn_state" value="심사완료(미통과)">
									<input type="button" id="uptPort" class="btn_default" value="수정">
								<% }else{
									
								} %>
							</td>
						</tr>
						<tr><th>내용</th><td><input type="text" value="<%=port.getPfContent()%>" disabled="disabled"></td></tr>
						<tr><th>파일</th><td><input type="text" value="<%=port.getPfFile()%>" disabled="disabled"></td></tr>
						<tr><th>링크</th><td><input type="text" value="<%=port.getPfLink()%>" disabled="disabled"></td></tr>
					</table>
					</form>
				 <% 
						}
					}else{ %>
					<div class="PF_none">
						<p>포토폴리오 정보가 없습니다.</p>
					</div>
				<%	 }  %>
					
				</div>
			</div>
		
		</div>
		
	</section>
<footer>

</footer>

<script>
 	function portRegi(){

 		window.open('portfolio_register.jsp')
 	}
 	
 	var uptPort = document.querySelectorAll("#uptPort");
 	var formArry = document.querySelectorAll("form");
 	
 	
 	//이중반복문해결해야함...
/*  	var count = 0; 
 	for(var idx = 0; idx<formArry.length; idx++){
	 	uptPort[idx].onclick = function(){
			// 새창으로 열기
	 		var gsWin = window.open('about:blank','portDviewer','width=1200, height=800');
	 	    formArry[count].action = "portfolio_detail.jsp";
	 	    formArry[count].target ="portDviewer";
	 	    formArry[count].submit();
	 	}
	 	count++;
 	} */
 	
 	uptPort[0].onclick = function(){
		// 새창으로 열기
 		var gsWin = window.open('about:blank','portDviewer','width=1200, height=800');
 	    formArry[0].action = "portfolio_detail.jsp";
 	    formArry[0].target ="portDviewer";
 	    formArry[0].submit();
 	}
 	uptPort[1].onclick = function(){
		// 새창으로 열기
 		var gsWin = window.open('about:blank','portDviewer','width=1200, height=800');
 	    formArry[1].action = "portfolio_detail.jsp";
 	    formArry[1].target ="portDviewer";
 	    formArry[1].submit();
 	}
 	uptPort[2].onclick = function(){
		// 새창으로 열기
 		var gsWin = window.open('about:blank','portDviewer','width=1200, height=800');
 	    formArry[2].action = "portfolio_detail.jsp";
 	    formArry[2].target ="portDviewer";
 	    formArry[2].submit();
 	}
 	uptPort[3].onclick = function(){
		// 새창으로 열기
 		var gsWin = window.open('about:blank','portDviewer','width=1200, height=800');
 	    formArry[3].action = "portfolio_detail.jsp";
 	    formArry[3].target ="portDviewer";
 	    formArry[3].submit();
 	}

</script>
</body>
</html>
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
<link rel="stylesheet" href="../common/style.css" type="text/css">

<link rel="stylesheet" href="section_mypage_buy.css" type="text/css">


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
		
		border : 2px solid #DDEEEB;
		
	}
	.mymage_table tr:first-child th{
		border : none;
		padding : 10px 0px;
		
	}
	.mymage_table tr td{
		padding : 5px 10px;
		border : 2px solid #DDEEEB;
	}
	.mymage_table tr td:last-child {
		width : 25%;
		border:none;
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
	section > div > .card_div {
		padding-bottom: 70px;
	}
		
	.card_div .card_title {
		position : relative;
	}
	.card_div .card_title input[name="cardInput"] {
		position: absolute;
		right : 0px;
		top : 0px;
	}
	
	.buy_table tr th{
		border : none;
	}
	.buy_table tr td{
		border : none;
	}

	.add_div .add_title{
		position : relative;
	}
	.add_div .add_title input[name="addInput"] {
		position: absolute;
		right : 0px;
		top : 0px;
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
		ArrayList<Address> addList = dao.getAddress(new Address(loginMS));
		ArrayList<Payment> payList = dao.getPayment(new Payment(loginMS));
	
	%>
	<section>
		
		<div id="wrap3">
			<div class="card_div">
				<div class="card_title">
					<h3>결제수단</h3>
					<input type="button" name="cardInput" value="카드등록" class="btn_default">
				</div>
				<% if(payList!=null) { 
					for(Payment p:payList) {
				%>
					<table class="mymage_table buy_table">
						<tr><th colspan="3"></th></tr>
						<tr><th>카드은행</th><td><%=p.getBankName() %></td><td><input type="button" class="btn_default" value="수정"></td></tr>
						<tr><th>카드번호</th><td><%=p.getCardNum()%></td><td><input type="button" class="btn_default" value="삭제"></td></tr>
					</table>
				<% 
					}
				}else{  %>
					<div>
						<p>카드정보가 없습니다.</p>
					</div>
				<%} %>
				
				
			</div>
			
			<div class="add_div">
				<div class="add_title">
					<h3>배송지관리</h3>
					<input type="button" name="addInput" value="주소등록" class="btn_default">
				</div>
			<%
			if(addList!=null) {
				for(Address add:addList) { %>
					<table class="mymage_table buy_table">
						<tr><th colspan="3"></th></tr>
						<tr><th>기본주소</th><td><%=add.getDefaultAddress()%></td><td><input type="button" class="btn_default" value="수정"></td></tr>
						<tr><th>상세주소</th><td><%=add.getDetailAddress()%></td><td><input type="button" class="btn_default" value="삭제"></td></tr>
					</table>
				<% } 
			}else{
			%>
				<div>
					<p>배송비정보가 없습니다.</p>
				</div>
			<%}  %>
			</div>
		</div>
		
	</section>
<footer>

</footer>
</body>
</html>
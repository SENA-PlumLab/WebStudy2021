<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"
    %>
 <% 
    request.setCharacterEncoding("utf-8"); // 한글 encoding처리
    String path =request.getContextPath(); // 기준경로 설정



    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Refund Policy</title>
<link rel="stylesheet" href="<%=path%>/a00_com/a00_com.css">
<style>
</style>
<script type="text/javascript">
	window.onload=function(){
		document.querySelector("h3").innerText="";
	}
</script>
</head>
<%-- 
# 

--%>
<%

%>
<body>

	<table width="600px" style="background-color:white; text-align:center;">
		<tr><th><h2>셰프딜 사용 및 환불 규정</h2></th></tr>
		<tr><th style="color:#FFC19E">1. 티켓 사용 조건</th></tr>
		<tr><td>회원은 티켓 정보에 명시된 내용 및 회원이 설정한 예약 정보에 따라서만
		<br> 상품을 사용하실 수 있습니다.</td></tr>
		<tr><th style="color:#FFC19E"><br>2. 상품의 구매 변경 및 환불 규정</th></tr>
		<tr><td>① 상품의 구매 변경 및 취소 규정은 전자상거래 등에서의 소비자보호에 관한 법률 등 관련 법령을 준수합니다.
		<br>② 구매한 상품에 대하여 변경을 원할 경우, 상품을 제공하는 상품 상세 페이지 및 결제 페이지 상 명시된 규정에 따라 처리됩니다. 단, 1회 이상 변경된 예약을 취소하는 경우, 발생한 모든 예약 변경 중에서 예약 변경을 시도한 시점과 방문 일시가 가장 가까운 시점을 기준으로 취소 수수료가 부과됩니다.
		<br>③ 회원이 상품 구매 시 지정된 예약 일시에 상품을 사용하지 못한 경우 변경 및 환불은 불가능합니다.
		<br>④ 회원이 구매한 상품을 취소하는 경우, 회원은 결제 시 사용한 결제수단을 통하여 환불 받을 수 있으나, 상품 상세 페이지 및 결제 페이지 상 명시된 수수료 및 위약금 발생 요인에 해당할 경우 취소수수료 및 위약금을 제한 금액만 환불됩니다.
		<br>⑤ 회원은 상품의 내용이 표시∙광고 내용과 다르거나 계약 내용과 다르게 이행된 때에는 그 상품을 공급받은 날부터 1개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 60일 이내에 구매를 취소할 수 있습니다.
		<br>⑥ 회사는 상품의 판매처 및 특성에 따라 구매 변경 및 취소 관련 규정을 개별약관 및 상품 구매 페이지에 별도로 동의를 받고 있으며 이 경우 상품의 구매 변경 및 취소에 대한 규정은 본 약관보다 개별약관이 우선하여 적용됩니다.
		<br>⑦ 기타 이 약관 및 홈페이지의 이용안내에 규정되지 않은 취소 및 환불에 대한 사항에 대해서는 소비자 피해보상 규정에서 정한 바에 따릅니다.
		</td></tr>
	</table>
	
</body>
</html>
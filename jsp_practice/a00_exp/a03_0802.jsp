<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
/*
 # 정리문제(금)
1. 리스트된 화면의 특정 키를 통해 상세화면에 전송처리하는 js를 기술하세요.
2. 상세화면에서 받은 key를 요청값을 이용해서, 요청값을 받았을 때, 처리할 프로세스를
   기술하세요.
3. 요청값을 기준으로 dao에 단일 데이터를 처리하여 form하위 input에 할당하는 프로세스를
   순서로 기술하세요.
4. 상세화면을 특정한 내용을 변경 후, 처리하는 프로세스를 파일명 기준으로 하여 핵심 코드를 기술하세요.
5. 회원리스트 화면에서 상세화면 처리 및 수정 처리하세요.
# 주간 정리문제
1. go.jsp에 요청값(name=홍길동)를 단계별로 아래와 같이 처리할 때, 사용 코드를 기술하세요.
    1) a href
    2) h2로 클릭시 
    3) form객체 get방식 2페이지 처리
    4) form객체 post방식 1페이지 처리
2. 요청값에 대한, null값과 숫자값 처리를 간단한 예제로 기술하세요
3. 요청값의 1페이지로 아래와 같은 내용을 처리하세요.
    놀이공원입장료 :50000
    나이 :[   ] (나이에 따른 할인율계산)
    인원 :[   ]
    [입장료계산]
4. 물건정보 테이블을 만들고, 물건리스트 처리하는 화면과 등록/상세조회/수정/삭제 구현 처리하세요.
~ 9:30까지 일단 진행하겠습니다.  
 
 */</script>
 <%
 SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
 Calendar calendar = Calendar.getInstance();

 Date dateObj = calendar.getTime();
 String formattedDate = dtf.format(dateObj);
 System.out.println(formattedDate);

 
 String name;
 %>
<body>
	<h2> <%=formattedDate%></h2>
	<hr>
	<form method="post" name="set" onsubmit="write()">
		놀이공원 입장료: 50000<br>
		이름: <input type=text name="name"><br>
		나이: <input type=text name="age" id="age"><br>
		인원: <select name="count" id="count">
				<option value="1" selected>1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select><br>
	</form>
	<button id="set-total">계산</button>
		<input type="text" id="total" disabled> 원<br>
		<br>
		<input type="submit" value="확인">
</body>

<script type="text/javascript">

//1.
var write = function(){
	//location.href="a03_0802_2.jsp?date=<%=formattedDate%>";
};
document.querySelector("h2").onclick=write();

//2.

//3.
document.querySelector("#set-total").onclick = function(){
	var age= document.querySelector("#age").value;
	var count =  document.querySelector("#count").value;
	var total =  5000*count;
	console.log(age);
	console.log(count);
	if(parseInt(age) > 60 ){
		total *= 0.8;
	}
	document.querySelector("#total").value=total;
}

</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">

/*

# 주간 정리문제
1. js의 배열에 대한 반복문 처리 형식(for in, for of, forEach)을 
  간단한 예제로 기술하세요.
2. 화살표 함수를 활용하여, 물건명과 가격의 총합을 처리하는 함수를 만드세요.
3. js의 속성할당 방식 2가지를 기술하고, 구매정보를 화면에 출력하는 
   속성과 메서드를 처리하세요.
4. database의 함수 종속성 개념을 기술하세요.
5. database의 정규화과정을 기술하세요.
6. jsp로 현재 로그인된 회원의 정보(id, 이름, 포인트, 권한)을 객체화하여 화면에 출력하세요.
7. database로 만들어진 회원정보(id, pass,이름, 포인트, 권한)를 
   dao 기존 기능 메서드에 추가하여, 현재 등록된 jsp 회원정보를 출력하세요.
~ 9:30까지 해보시고, 시간조정 하겠습니다.
 */

 
</script>
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">

// 1.
var arry = [1, 3, "배열입니다.", "This is arry", 3000];
document.write("<h2> for in </h2>")
for(var i in arry){
	document.write(arry[i]+"<br>");
}
document.write("<h2> for of </h2>")
for(var i of arry){
	document.write(i+"<br>");
}
document.write("<h2> forEach </h2>")
arry.forEach(function(item){
	document.write(item+"<br>")
})

//2.
document.write("<hr>")
var arry2 = [{'pname':'마라탕', 'price':13000, 'cnt':10},
			{'pname':'짜장면', 'price':7000, 'cnt':7}];
arry2.forEach(function(item){
	for(key in item){
		document.write(key+': '+item[key]+",");
	}
	document.write("<br>")
})
/*
document.write("<h2>합계: ");
var total = 0;
arry2.forEach(function(item){
	total += item['price'];
})
document.write(total+"</h2>");
*/
var price1 = arry2[0]['price'];
var price2 = arry2[1]['price'];
document.write("<h2>합계: ");
var total = ()=> document.write(price1+price2);
total();
document.write("</h2>");

//3.
document.write("<div></div>");
var divObj = document.querySelector("div");
divObj.setAttribute('class','div_3');


</script>
</html>
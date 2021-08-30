<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">

/*
# 정리문제
1. 요청값을 전달하는 url형식과 요청값을 받는 jsp 기능 메서드를 기술하세요.
2. 아래의 요청값 전달 처리의 방식 기본예제를 코드하세요
    0) 현재페이지 요청값 처리
    1) a href 요청값 처리하기
    2) 함수호출하여 location.href 객체활용하기
3. 아래와 같은 처리를 함수와 location.href를 통해서 요청처리하세요.
   id:[    ]
   pass:[    ]
   [로그인] ==> 로그인  
   1단계) 로그인한 id:@@@ 패스워드 @@@  
   2단계) 인증여부 성공/실패 (himan/7777)
   3단계) 다음 페이지 js에서 alert으로 성공여부에 때라 main페이지 이동/login 페이지이동
   hit) 다음페이지에서 location.href 활용
   4단계) 다음 페이지에서 select * from member where id = ? and pass=?
      를 통한 dao를 만든 후, dao 연동하여 인증여부처리 및 3단계의 페이지 이동 로직 처리.
# 9:30까지 일단 진행해보겠습니다.
 */
</script>
<title>Insert title here</title>
</head>
<body>
	<%
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
			
	Calendar time = Calendar.getInstance();
	       
	String format_time1 = format1.format(time.getTime());
	String format_time2 = format2.format(time.getTime());
	%>
	<form method="post" action="a02_0727_2.jsp?time1=<%=format_time1%>&time2=<%=format_time2%>" name="write">
	<div>
		<h2><%=format_time1%></h2>
		<h2><%=format_time2%></h2>
		<button type="button" value="함수호출" onclick="goTo()"/>
		<a href="a02_0727_2.jsp?time1=<%=format_time1%>&time2=<%=format_time2%>'">
			ahref
		</a>
		<hr>
	</div>
	<div>
		<h2>Login</h2>
		ID: <input type=text name="id" width=100px>
		PW: <input type=text name="pass" width=100px>	
		<input type=submit value="로그인">
	</form>
	</div>
</body>
<script type="text/javascript">
	var goTo = function(){
		location.href='a02_0727_2.jsp?time1=<%=format_time1%>&time2=<%=format_time2%>';
	}
</script>
</html>
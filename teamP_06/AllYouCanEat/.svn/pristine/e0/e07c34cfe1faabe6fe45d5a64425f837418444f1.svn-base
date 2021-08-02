<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ page import="teamP_06.BBSController" %>   
<%@ page import="teamP_06.MemberController" %>   
<%@ page import="teamP_06.Member" %>   
<%@ page import="teamP_06.BBS" %>   
<%@ page import="teamP_06.BBSRec" %>   
    
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

MemberController mCon = new MemberController();
BBSController bCon = new BBSController();

String memNum = request.getParameter("memNum");
String bbsNum = request.getParameter("bbsNum");

Member m = mCon.findMemberByMemNum(memNum);
BBS b = bCon.visitBBS(bbsNum);
ArrayList<BBSRec> rcList = bCon.getBBSRecByBBSNum(bbsNum);
if(rcList.size()==0){
	rcList.add(0, new BBSRec("없음","",""));
	rcList.add(1, new BBSRec("없음","",""));
}
if(rcList.size()==1){
	rcList.add(1, new BBSRec("","",""));
}

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../common/style.css?ver=1" rel="stylesheet" type="text/css">
<link href="bbs_view_css.css?ver=6" rel="stylesheet" type="text/css">

</head>
<body>
<%@include file ="../common/header.jsp"%>
        <section>
            <div class="wrap">
                <article> <!-- article에 man-writh:1100px; -->
	<!-- 게시물 읽기 시작 { -->
	<article id="bo_v" style="width:100%">
	<section class="write-btn-holder">
		<span> 맛집기행문 </span>
		<button id="btn-write" class="btn" onclick="writeBBS()" style="">글쓰기</button>
	</section>
    <section id="bo_v_info">
        <h2>페이지 정보</h2>
        작성자 <strong><span class="sv_member"><%=b.getmName() %></span></strong>
        조회 <strong><i class="fa fa-eye" aria-hidden="true"></i> <%=b.getHit() %>회</strong>
        <strong class="if_date">작성일 <%=b.getBbsDate() %></strong>
    </section>
    <header>
        <h2 id="bo_v_title">
         <span class="bo_v_tit">
          <%=b.getTitle() %>
         </span>
         <span class="bo_v_tit2">
          <%=b.getSubtitle() %>
         </span>
        </h2>
    </header>
    <section id="bo_v_atc">
        <!-- 본문 내용 시작 { -->
			<div id="bo_v_con">
				<%=b.getContents() %>
			</div>
			<div id="bo_v_con_res">
			<span>기행문 속 식당</span>
			<a href="식당 상세조회.jsp?restNum=<%=rcList.get(0).getRestNum()%>">1. <%=rcList.get(0).getRestTitle() %> (<%=rcList.get(0).getRestAddress() %>)</a><br>
			<a href="식당 상세조회.jsp?restNum=<%=rcList.get(1).getRestNum()%>">2. <%=rcList.get(1).getRestTitle() %> (<%=rcList.get(1).getRestAddress() %>)</a><br>
			</div>
			<!-- } 본문 내용 끝 -->
    </section>

    <!-- 게시물 상단 버튼 시작 { -->
			<div id="bo_v_top">
					<ul class="bo_v_com">
						<button class="btn" id="edit" onclick="editBBS()">수정</button>
						<button class="btn" id="delete" onclick="deleteBBS()">삭제</button>
						<button class="btn" id="List" onclick="goList()">목록</button>	
					</ul>
			</div>
			<!-- } 게시물 상단 버튼 끝 --></article>
<!-- } 게시판 읽기 끝 -->
	</article>
            </div>
        </section>
	
<%@include file ="../common/footer.jsp" %>
</body>
<script type="text/javascript">

//삭제여부 확인
if(<%=b.getAvailable()%>==0){
	document.querySelector("article").remove();
	alert("<%=bbsNum%>번 글은 이미 삭제된 글입니다.");
	window.history.back();
}
//관리자에게만 글쓰기 버튼 출력
if(<%=m.getAuth()%>==10){
	document.querySelector("#btn-write").style.visibility="visible";
}	

//이하 버튼 onclick
var editBBS = function(){
	location.href="bbs_edit.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsNum%>";
}
var writeBBS = function(){
	location.href="bbs_write.jsp?memNum=<%=memNum%>";
}
var deleteBBS = function(){
	if(confirm("삭제하시겠습니까?")){
		location.href="bbs_delete.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsNum%>";
	}
}
var goList = function(){
	location.href="bbs_list.jsp?memNum=<%=memNum%>&index=1";
}



</script>
</html>
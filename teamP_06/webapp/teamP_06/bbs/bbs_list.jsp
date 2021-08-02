<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%@ page import="teamP_06.MemberController" %>   
<%@ page import="teamP_06.Member" %> 
<%@ page import="teamP_06.BBSController" %>
<%@ page import="teamP_06.BBS" %>    
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

MemberController mCon = new MemberController();
BBSController bCon = new BBSController();

String memNum = request.getParameter("memNum");
Member m = mCon.findMemberByMemNum(memNum);

int index = Integer.parseInt(request.getParameter("index"));

//---- 이 페이지에 표시할 게시글 내용 처리 -----
ArrayList<BBS> bbsList = bCon.getListByPage(8, index);
//실제 게시글 갯수
int countOfBBS = bbsList.size();
//로딩된 리스트가 8개보다 작을 때(8-bbsList.size() > 0)
if(bbsList.size()<8){
	for(int i=bbsList.size(); i<8; i++){
		//memNum=0으로 된 익명객체 생성해서 넣어둠.
				// HTML 로드 시 outBountOfIndex 오류가 생기므로..
		bbsList.add(new BBS());
		bbsList.get(i).setBBSEmpty();
	}
}
//------------------------------------

//전체 게시글 갯수 (페이지 넘버 표시에 사용)
int wholeCount = bCon.getCountOfBBS();
//페이지 넘버는 1부터 maxPage까지
int maxPage = (wholeCount/8)+1;

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../common/style.css?ver=1" rel="stylesheet" type="text/css">
<link href="bbs_list_css.css?ver=3" rel="stylesheet" type="text/css">

</head>
<body>
	<%@include file ="../common/header.jsp"%>
		
		
		<section>
            <div class="wrap">
            
            <article id="bo_v">
			<section class="write-btn-holder">
			<span> 맛집기행문 </span>
			<button id="btn-write" class="btn" onclick="writeBBS()">글쓰기</button>
			</section>
			</article>
			
			
                <article id="list">
                    <div id="list1" style="cursor:pointer">
                        <a href="#">
                            <img src="img/img1.png">
                            <h3><%=bbsList.get(0).getTitle() %></h3>
                            <p><%=bbsList.get(0).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(0).getHit() %></span>
                            <span>작성일 <%=bbsList.get(0).getBbsDate() %></span>
                        </a>
                    </div>
                    <div id="list2" style="cursor:pointer">
                        <a href="#">
                            <img src="img/img2.png">
                            <h3><%=bbsList.get(1).getTitle() %></h3>
                            <p><%=bbsList.get(1).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(1).getHit() %></span>
                            <span>작성일 <%=bbsList.get(1).getBbsDate() %></span>
                        </a>
                    </div>
                    <div id="list3" style="cursor:pointer">
                        <a href="#">
                            <img src="img/img3.jpg">
                            <h3><%=bbsList.get(2).getTitle() %></h3>
                            <p><%=bbsList.get(2).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(2).getHit() %></span>
                            <span>작성일 <%=bbsList.get(2).getBbsDate() %></span>
                        </a>
                    </div>
                    <div id="list4" style="cursor:pointer">
                        <a href="#">
                             <img src="img/img4.png">
                            <h3><%=bbsList.get(3).getTitle() %></h3>
                            <p><%=bbsList.get(3).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(3).getHit() %></span>
                            <span>작성일 <%=bbsList.get(3).getBbsDate() %></span>
                        </a>
                    </div>
                    <div id="list5" style="cursor:pointer">
                        <a href="#">
                            <img src="img/img5.jpg">
                            <h3><%=bbsList.get(4).getTitle() %></h3>
                            <p><%=bbsList.get(4).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(4).getHit() %></span>
                            <span>작성일 <%=bbsList.get(4).getBbsDate() %></span>
                        </a>
                    </div>
                    <div id="list6" style="cursor:pointer">
                        <a href="#">
                            <img src="img/img6.png">
                            <h3><%=bbsList.get(5).getTitle() %></h3>
                            <p><%=bbsList.get(5).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(5).getHit() %></span>
                            <span>작성일 <%=bbsList.get(5).getBbsDate() %></span>
                        </a>
                    </div>
                     <div id="list7" style="cursor:pointer">
                        <a href="#">
                        	<img src="img/empty.png">
                            <h3><%=bbsList.get(6).getTitle() %></h3>
                            <p><%=bbsList.get(6).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(6).getHit() %></span>
                            <span>작성일 <%=bbsList.get(6).getBbsDate() %></span>
                        </a>
                    </div>
                     <div id="list8" style="cursor:pointer">
                        <a href="#">
                            <img src="img/empty.png">
                            <h3><%=bbsList.get(7).getTitle() %></h3>
                            <p><%=bbsList.get(7).getSubtitle() %></p>
                            <span>조회 <%=bbsList.get(7).getHit() %></span>
                            <span>작성일 <%=bbsList.get(7).getBbsDate() %></span>
                        </a>
                    </div>
                    
                    <table class="index-holder">
                    	<tr id="index-holder">
                    	</tr>
                    </table>
					
					
                </article>
            </div>
        </section>
        
        
        
        <%@include file ="../common/footer.jsp" %>
</body>
<script type="text/javascript">

//관리자에게만 글쓰기 버튼 출력
if(<%=m.getAuth()%>==10){
	document.querySelector("#btn-write").style.visibility="visible";
}	

document.getElementById("list1").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(0).getBbsNum()%>";
};
document.getElementById("list2").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(1).getBbsNum()%>";
};
document.getElementById("list3").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(2).getBbsNum()%>";
};
document.getElementById("list4").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(3).getBbsNum()%>";
};	
document.getElementById("list5").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(4).getBbsNum()%>";
};
document.getElementById("list6").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(5).getBbsNum()%>";
};
document.getElementById("list7").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(6).getBbsNum()%>";
};	
document.getElementById("list8").onclick=function(){
	location.href="bbs_view.jsp?memNum=<%=memNum%>&bbsNum=<%=bbsList.get(7).getBbsNum()%>";
};			

//bbsList에서 표시할 글이 없을 경우 이동경로의 변수를 전부 0으로 놓고 hidden 처리 한다.	
if(<%=countOfBBS%><8){
	switch(<%=countOfBBS%>){
	case 1:
		document.querySelector("#list2").style.visibility="hidden";
	case 2:
		document.querySelector("#list3").style.visibility="hidden";
	case 3:
		document.querySelector("#list4").style.visibility="hidden";
	case 4:
		document.querySelector("#list5").style.visibility="hidden";
	case 5:
		document.querySelector("#list6").style.visibility="hidden";
	case 6:
		document.querySelector("#list7").style.visibility="hidden";
	case 7:
		document.querySelector("#list8").style.visibility="hidden";
	
		break;
	}
}


//for문으로 index-holder에 숫자 넣고 onclick 주기..?
//		--> <td>요소 추가 OK. 근데 onlick이 안먹음..ㅎㅎ
var indexHolder = document.getElementById("index-holder");
for(var i=0; i<<%=maxPage%>; i++){
	indexHolder.innerHTML +="<td id='index"+(i+1)+"' style='cursor:pointer'>"+(i+1)+"</td>";
}


switch(<%=maxPage%>){
case 4:
	if(<%=maxPage%> >=4){
	document.getElementById("index4").onclick=function(){
	location.href="bbs_list.jsp?memNum=<%=memNum%>&index=4";
	};	
	}
case 3:
	if(<%=maxPage%> >=3){
	document.getElementById("index3").onclick=function(){
	location.href="bbs_list.jsp?memNum=<%=memNum%>&index=3";
	};	
	}
case 2:
	if(<%=maxPage%> >=2){
	document.getElementById("index2").onclick=function(){
	location.href="bbs_list.jsp?memNum=<%=memNum%>&index=2";
	};
	}
case 1:
	document.getElementById("index1").onclick=function(){
	location.href="bbs_list.jsp?memNum=<%=memNum%>&index=1";
	};	
	break;
}


var writeBBS = function(){
	location.href="bbs_write.jsp?memNum=mem-0001";
}

</script>
</html>
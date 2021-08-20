<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<%
String dept = (String)session.getAttribute("dept");
String name = (String)session.getAttribute("name");
String date = (String)session.getAttribute("date");


%>
<meta charset="UTF-8">

    <!-- Page Wrapper -->
    <div class="container-fluid" id="wrapper">
	  <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-dark static-top">

                    <!-- Topbar Navbar -->
                    <div class="navbar-collapse collapse w-30 order-1 order-md-0 dual-collapse2">
       					 <ul class="navbar-nav me-auto">
						 <a class="navbar-brand" href="../index/admin_index.jsp">
							<img src="../common/img/logo.png"></a>
                        </ul>
                    </div>
          
					<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
      					<ul class="navbar-nav ms-auto" id="topbar-item">
        						<li class="nav-item" id="topbar-greeting">
         					 		<%=dept %> <%=name %>님, 환영합니다!<br>
         					 		<span>(로그인: <%=date %>)</span>
         					 	</li>
       						     <li class="nav-item">
									<a href="#" class="d-none d-sm-inline-block btn btn-sm btn-outline-light shadow-sm" id="btn_logout">
                                	<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                	Log out
                               		</a>
                               	</li>
                            </ul>
                    </div>       
                    

                </nav>
                <!-- End of Topbar -->
		
    <div class="row flex-nowrap">
    	
    
    <!--  Side bar -->
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0" id="sidebar">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <a href="#" class="d-flex align-items-center pb-3 mb-md-0 mx-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline" id="sidebar-title">Menu</span>
                </a>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                   <!--  <li class="nav-item">
                        <a href="#" class="nav-link align-middle px-0">
                            <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
                        </a>
                    </li> -->
                    <li>
                    	<!-- href="#submenu1"으로 하면 토글 가능! -->
                        <a href="#submenu1_" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                            <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">▶ 회원 관리</span> </a>
                        <ul class="collapse show nav flex-column" id="submenu1" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="../member/check_grade.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">크리에이터 등업</span></a>
                            </li>
                            <li>
                                <a href="../member/entire.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">전체 회원 조회</span></a>
                            </li>
                            <li>
                                <a href="../member/portfolio.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">전체 포트폴리오 조회</span></a>
                            </li>
                        </ul>
                    </li>
                     <li>
                        <a href="#submenu2_" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <i class="fs-4 bi-bootstrap"></i> <span class="ms-1 d-none d-sm-inline">▶ 펀딩 관리</span></a>
                        <ul class="collapse show nav flex-column" id="submenu2" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="../funding/check_funding.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">가등록 펀딩 승인</span></a>
                            </li>
                            <li>
                                <a href="../funding/entire.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">전체 펀딩 조회</span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#submenu3_" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <i class="fs-4 bi-bootstrap"></i> <span class="ms-1 d-none d-sm-inline">▶ 신고 관리</span></a>
                        <ul class="collapse show nav flex-column" id="submenu2" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="../report/check_report.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">새로운 신고 확인</span></a>
                            </li>
                            <li>
                                <a href="../report/doublecheck_report.jsp" class="nav-link px-0"> <span class="d-none d-sm-inline">보류 신고</span></a>
                            </li>
                             <li>		                        
		                        <a href="../report/report_log.jsp" class="nav-link px-0 align-middle">
                            	<span class="d-none d-sm-inline">신고 확인 내역</span> </a>
		                    </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#submenu4_" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">
                            <span class="ms-1 d-none d-sm-inline">▶ 로그</span></a>
                        <ul class="collapse show nav flex-column" id="submenu3" data-bs-parent="#menu">
                            <li class="w-100">
                                <a href="../log/contents_log.jsp" class="nav-link px-0 align-middle">
		                            <span class="d-none d-sm-inline">컨텐츠 활동 로그</span> </a>
                            </li>
                           	<li>
		                        <a href="../log/member_log.jsp" class="nav-link px-0 align-middle">
		                            <span class="d-none d-sm-inline">회원 로그</span> </a>
		                    </li>
                        </ul>
                    </li>
                    <!-- <li>
                        <a href="../log/report_log.jsp" class="nav-link px-0 align-middle">
                            <span class="ms-1 d-none d-sm-inline">신고 로그</span> </a>
                    </li>
                    <li>
                        <a href="../log/contents_log.jsp" class="nav-link px-0 align-middle">
                            <span class="ms-1 d-none d-sm-inline">컨텐츠 활동 로그</span> </a>
                    </li>
                    <li>
                        <a href="../log/member_log.jsp" class="nav-link px-0 align-middle">
                            <span class="ms-1 d-none d-sm-inline">회원 로그</span> </a>
                    </li> -->
                </ul>
            </div>
        </div>
    <!--  End of Side bar -->   
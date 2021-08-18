<%@page import="teamP_07.ReportDao"%>
<%@page import="teamP_07.FundingDao"%>
<%@page import="teamP_07.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>This is title</title>
</head>
	<!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,400;0,900;1,100&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;900&display=swap" rel="stylesheet">
  
  <!-- Font Awesome -->
  <script src="https://kit.fontawesome.com/05c8c4d672.js" crossorigin="anonymous"></script>

  <!-- Bootstrap Scripts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <!-- Chart -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
 <!-- css -->
<link rel="stylesheet" href="../common/style.css?ver=5">


<%
MemberDao mDao = new MemberDao();
int mCnt=mDao.getmemberDTO_gradeCheck_cnt();

FundingDao fDao = new FundingDao();
int fCnt=fDao.getFundingList_check_cnt();

ReportDao rDao = new ReportDao();
int rCnt=rDao.getReportDTO_cnt();



boolean isLoggedIn = true;
// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
if (session.getAttribute("eeenum")==null) {
	
    isLoggedIn=false; //==>js에서 redirect
}

%>


<body id="page-top">
<!-- navbar import -->
<%@ include file="../common/navbar.jsp" %>
        
    

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="col py-3">

            <!-- Main Content -->
            <div id="content">

               

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Card1 -->
                        <div  class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div id="card1" class="card-body" style="cursor: pointer;">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                               등업 신청</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=mCnt %></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Card2 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div id="card2" class="card-body" style="cursor: pointer;">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                가등록 상품 검토</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=fCnt %></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Card3 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div id="card3" class="card-body" style="cursor: pointer;">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">목표달성 펀딩 비율
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">30%</div>
                                                </div>
                                                <div class="col">
                                                    <div class="progress progress-sm mr-2">
                                                        <div class="progress-bar bg-info" role="progressbar"
                                                            style="width: 50%" aria-valuenow="30" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Card4 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div id="card4" class="card-body" style="cursor: pointer;">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                신고 관리</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><%=rCnt %></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->

                    <div class="row">

                        <!-- Chart -->
                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">신규 회원 수</h6>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    
 </div>   
<!-- Bootstrap js script -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  <script type="text/javascript" src="admin_index.js" charset="utf-8"></script>
  <script type="text/javascript">
  //세션검사, 로그아웃 버튼
  if(<%=isLoggedIn%>==false){
	  alert('로그인 정보가 없습니다!');
	  document.location.href="../login/login.jsp";
  }
  $("#btn_logout").click(function(){
	  
	  document.location.href="../login/logout.jsp";
	  
  })
  
  //카드 클릭 이벤트
  $("#card1").click(function(){
	  document.location.href="../member/check_grade.jsp";
  });
  $("#card2").click(function(){
	  document.location.href="../funding/check_funding.jsp";
  });
  $("#card3").click(function(){
	  document.location.href="../funding/entire.jsp";
  });
  $("#card4").click(function(){
	  document.location.href="../report/check_report.jsp";
  });
  </script>
</body>
</html>

<%@page import="teamP_07.Report"%>
<%@page import="teamP_07.ReportDao"%>
<%@page import="java.util.ArrayList"%>
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

  ReportDao rDao = new ReportDao();

	ArrayList<Report> rList = rDao.getReportDTO_entire();

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
						<h2 class="h3 mb-4 text-gray-800">신고 확인 내역</h2>
						<div class="table-responsive">
							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th scope="col">Report</th>
										<th scope="col">Member</th>
										<th scope="col">Contents</th>
										<th scope="col">Income</th>
										<th scope="col">Edit</th>
										<th scope="col">Status</th>
										<th scope="col">Name</th>
										<th scope="col">Position</th>
									</tr>
								</thead>
								<tbody>
								<%	for (Report r : rList) { %>
									<tr>
										<td><%=r.getRptNum() %></td>
										<td><a href="#" onclick="popUp_mem(this, '<%=r.getMemNum2() %>')"><%=r.getMemNum2() %></td>
										<td><a href="#" onclick="popUp(this, '<%=r.getCttnum() %>')"><%=r.getCttnum() %></a></td>
										<td><%=r.getIncome() %></td>										
										<td><%=r.getEdit_date() %></td>										
										<td><%=r.getStatus_name() %></td>										
										<td><%=r.getEmp_name() %></td>										
										<td><%=r.getEmp_pos() %></td>										
									</tr>
								<%} %>
								
									</tbody>
									</table>
									<!-- Content Row -->
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

  <script type="text/javascript" src="entire.js" charset="utf-8"></script>
  <script type="text/javascript">
//세션검사, 로그아웃 버튼
  if(<%=isLoggedIn%>==false){
	  alert('로그인 정보가 없습니다!');
	  document.location.href="../login/login.jsp";
  }
$("#btn_logout").click(function(){
	  
	  document.location.href="../login/logout.jsp";
	  
  })
  
//멤버 조회 팝업
function popUp_mem(e, memNum){
    window.open('../member/visit_member.jsp?memNum='+memNum, '내용 확인', 'width=600px,height=600px,scrollbars=yes');
}
//콘텐츠 내용 조회 팝업
function popUp(e, cttNum){
	//var cttNum = e;
	console.log(cttNum);
    window.open('../report/visit_contents.jsp?cttNum='+cttNum, '내용 확인', 'width=600px,height=600px,scrollbars=yes');
}

  </script>
</body>
</html>
<%@page import="teamP_07.Report"%>
<%@page import="teamP_07.ReportDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
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
  <link rel="stylesheet" href="check_report.css">
  
  
  <%
	ReportDao rDao = new ReportDao();

	ArrayList<Report> rList = rDao.getReportDTO();
	
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
                        <h1 class="h3 mb-0 text-gray-800">신고 관리</h1>
                    </div>
						<div class="table-responsive">
							<form method="post" action="update_report.jsp">
							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th scope="col">Report Number</th>
										<th scope="col">Member Number</th>
										<th scope="col">Content Number</th>
										<th scope="col">Status</th>
										<th scope="col">Check</th>
									</tr>
								</thead>
								<tbody>
								<%	for (Report r : rList) { %>
									<tr>
										<td><%=r.getRptNum() %></td>
										<td><%=r.getMemNum2() %></td>
										<td><a href="" target="_blank"><%=r.getCttnum() %></a></td>
										<td><%=r.getStatusNum() %></td>										
										<td> <input class='check'  type='checkbox' value='<%=r.getRptNum() %>' name='update' /></td>
									</tr>
								<%} %>
								</tbody>
							</table>
							
							</div>
							<div>
							<select name="status">
								<option value=1>정상 신고 확인</option>
								<option value=0>혐의 없음</option>								
								<option value=3>보류</option>								
							</select>
							<input type="submit" id="btn-submit" class="btn-outline-primary" value="선택 확인"></div>
							</form>
									<!-- Content Row -->
						
						<!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->            
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    
<!-- Bootstrap js script -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script type="text/javascript">


$(".check").click(function(){ 
    var checkBtn = $(this);
//checkBtn.parent() : checkBtn의 부모는 <td>이다.
// checkBtn.parent().parent() : <td>의 부모이므로 <tr>이다.
var tr = checkBtn.parent().parent();
var td = tr.children();

//console.log("클릭한 Row의 모든 데이터 : "+tr.text());
//console.log("0 : "+td.eq(0).text());
//console.log("1 : "+td.eq(1).text());
//console.log("2 : "+td.eq(2).text());
//$('#'+td.eq(0).text()).val(td.eq(1).text());

td.eq(1).append("<input type='hidden' value='"+td.eq(1).text()+"' name='memnum2'>");


/* var rptnum = td.eq(0).text();
var memnum = td.eq(1).text();
var cttnum = td.eq(2).text();
var count = td.eq(3).text(); */
});

//세션검사, 로그아웃 버튼
if(<%=isLoggedIn%>==false){
	  alert('로그인 정보가 없습니다!');
	  document.location.href="../login/login.jsp";
}
$("#btn_logout").click(function(){
	  
	  document.location.href="../login/logout.jsp";
	  
})


</script>
  
</body>
</html>
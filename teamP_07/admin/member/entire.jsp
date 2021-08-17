<%@page import="teamP_07.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_07.MemberDao" %>   
    
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
  String dept = "컨텐츠팀";
  String name = "김염병";
  String date = "2021-08-17 11:34:02";
  session.setAttribute("dept",dept); 
  session.setAttribute("name",name); 
  session.setAttribute("date",date); 
  
  
  MemberDao mDao = new MemberDao();

	ArrayList<Member> mList = mDao.getmemberDTO();

  %>
<body id="page-top">

<!-- navbar import -->
<jsp:include page="../common/navbar.jsp">
<jsp:param name="dept" value='<%=session.getAttribute("dept")%>' />
<jsp:param name="name" value='<%=session.getAttribute("name")%>' />
<jsp:param name="date" value='<%=session.getAttribute("date")%>' />
</jsp:include>


        <!-- Content Wrapper -->
        <div id="content-wrapper" class="col py-3">

            <!-- Main Content -->
            <div id="content">

               

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">신규 회원 수</h1>
                    </div>

						<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

						<h2>전체 회원 조회</h2>
						<div class="table-responsive">
							<table class="table table-striped table-sm">
								<thead>
									<tr>
										<th scope="col">MemNum</th>
										<th scope="col">ID</th>
										<th scope="col">Name</th>
										<th scope="col">Join Date</th>
										<th scope="col">Grade</th>
										<th scope="col">Report</th>
									</tr>
								</thead>
								<tbody>
								<%	for (Member m : mList) { %>
									<tr>
										<td><%=m.getMemNum() %></td>
										<td><%=m.getmID() %></td>
										<td><%=m.getmName() %></td>
										<td><%=m.getJoinDate() %></td>
										<td><%=m.getMemgrade() %></td>										
										<td><%=m.getReport() %></td>										
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
  
</body>
</html>
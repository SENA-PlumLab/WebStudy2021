<%@page import="teamP_07.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="teamP_07.MemberDao" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My One Pick - Admin</title>
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
    <link rel="stylesheet" href="check_grade.css?ver=2">
  
  
<%
MemberDao mDao = new MemberDao();
ArrayList<Member> mList = mDao.getmemberDTO();
	
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
                  
						<h2 class="h3 mb-4 text-gray-800">전체 회원 조회</h2>
						<div class="table-responsive">
							<form method="post" action="update_grade.jsp">
							<table class="table table-hover table-sm">
								<thead>
									<tr>
										<th scope="col">MemNum</th>
										<th scope="col">ID</th>
										<th scope="col">Name</th>
										<th scope="col">Join Date</th>
										<th scope="col">Grade</th>
										<th scope="col">Report</th>
										<th scope="col">Check</th>
									</tr>
								</thead>
								<tbody>
								<%	for (Member m : mList) { %>
									<tr>
										<td><a href="#" onclick="popUp_mem(this, '<%=m.getMemNum() %>')"><%=m.getMemNum() %></td>
										<td><%=m.getmID() %></td>
										<td><%=m.getmName() %></td>
										<td><%=m.getJoinDate() %></td>
										<td><%=m.getMemgrade() %></td>										
										<td><%=m.getReport() %></td>
										<td> <input class='check'  type='checkbox' value='<%=m.getMemNum() %>' name='update' /></td>																				
									</tr>
								<%} %>
								</tbody>
							</table>	
							<div id="btn-holder">
								<select name="status">
									<option value=0>활동 정지</option>												
									<option value=1>일반 회원</option>												
								</select>
								<input type="submit" id="btn-submit" class="btn-outline-primary" value="선택 확인">
							</div>
							</form>
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
    window.open('visit_member.jsp?memNum='+memNum, '내용 확인', 'width=600px,height=600px,scrollbars=yes');
}
</script>
  
  
</body>
</html>
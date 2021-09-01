<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"

    import = "java.util.*"

%>
  <%
  	request.setCharacterEncoding("utf-8");
  %>
  
<%
	Object loginId = session.getAttribute("");

%>
<header>
       <div class="wrap">
           <div class="main_top">
           	<%if(loginId==null||loginId.equals("")) { %>
               	<a href="../login/login.jsp">로그인 및 회원가입</a>
              <% }else{%>             	
               	<a href="#"><img src="../image/carrots.jpg"></a>
               	<a href="#">게시물 쓰기</a>
               <% } %>
           </div>
           <div class="main_title">
               <h1><img src="../image/logo.png"></h1>
               <div class="main_search">
                   <input type="text" class="main_search_input"placeholder="검색어를 입력해주세요.">
                   <i class="fas fa-search"></i>
               </div>
           </div>
       </div>
   </header>
   <nav>
       <div class="wrap">
           <div class="main_category">
               <ul>
                   <a href="#"><li>category</li></a>
                   <a href="#"><li>category</li></a>
                   <a href="#"><li>category</li></a>
                   <a href="#"><li>category</li></a>
               </ul>
           </div>
       </div>
   </nav>
	

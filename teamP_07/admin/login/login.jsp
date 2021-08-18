<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title></title>
  <!-- jquery -->
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <!-- tsParticles -->
  <script src="https://cdn.jsdelivr.net/npm/tsparticles@1.33.3/tsparticles.min.js"></script>

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,400;0,900;1,100&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Ubuntu&display=swap" rel="stylesheet">

  <!-- animate.css -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" integrity="sha512-c42qTSw/wPZ3/5LBzD+Bw5f7bSF2oxou6wEb+I/lqeaKV5FDIfMvvRp772y4jcJLKuGUOpbJMdg/BTl50fJYAw==" crossorigin="anonymous"
    referrerpolicy="no-referrer" />
  <!-- Bootstrap Scripts -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
  <!-- css -->
  <link rel="stylesheet" href="style.css?">


</head>

<body class="d-flex h-100 text-center">
  <!-- tsParticles container -->
  <div id="tsparticles"></div>
  <!-- https://github.com/matteobruni/tsparticles -->
  
  
     
<main class="form-signin">
  <form method="post" action="login_verify.jsp">
    <img src="../common/img/logo.png" alt="" width="200" >

    <div class="form-floating">
      <input type="text" class="form-control" name="id" placeholder="id">
      <label for="floatingInput">ID</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" name="pass" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>

    
    <button class="w-100 btn btn-lg btn-dark" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; My One Pick</p>
  </form>
</main>
  
  
  
  
  

  <!-- Bootstrap js script -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <!-- script -->
  <script type="text/javascript" src="tsParticles.js" charset="utf-8"></script>

</body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form method="POST" action='UserController?action=login' name="frmLoginUser">
      	<p><input type="text" placeholder="Username" name="userlogin" value="<c:out value="${user.userLogin}" />" /></p>
      	<p><input type="password" placeholder="Password" name="userpwd" value="<c:out value="${user.userPwd}" />" /></p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>
    <div class="login-help">
      <p>Not yet registered? <a href="Registration.jsp">Click here to do it</a>.</p>
    </div>
  </section>
</body>
</html>
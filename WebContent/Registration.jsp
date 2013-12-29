<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Registration Form</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
    <body>
    	<section class="container">
			<div class="login">
				<h1>Enter your data here</h1>
				<form method="POST" action='UserController?action=register' name="frmRegisterUser">
					<p><input type="text" placeholder="Enter Lastname" name="lastname" value="<c:out value="${user.lastName}" />" /></p>
					<p><input type="text" placeholder="Enter Firstname" name="firstname" value="<c:out value="${user.firstName}" />" /></p>
					<p><input type="text" placeholder="Enter email" name="usermail" value="<c:out value="${user.userMail}" />" /></p>
					<p><input type="text" placeholder="Enter login" name="userlogin" value="<c:out value="${user.userLogin}" />" /></p>
					<p><input type="password" placeholder="Enter password" name="userpwd" value="<c:out value="${user.userPwd}" />" /></p>
					<p class="submit"><input type="submit" name="register" value="Register"></p>
				</form>
			</div>
			<div class="login-help">
				<p>Already Registered! <a href="Login.jsp">Click here to login</a>.</p>
    		</div>
  		</section>
	</body>
</html>
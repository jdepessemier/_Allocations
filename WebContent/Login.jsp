<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>CIRB - Project Allocations</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
</head>
<body>
<div class="container">
  <div class="page-header">
    <div class="row">
      <div class="span3">
      	<a href="http://www.cirb.irisnet.be" target="_blank"><img alt="CIRB" src="https://irisbox.irisnet.be/resources/img/cirb-brussels.png" class="pull-right"></a>
      </div>
      <div class="span9">
        <h2>Projects Allocations Management</h2>
      </div>
    </div>
  </div>
	<div class="row">
  		<div class="span4 offset2">
  			<br></br>
			<h4>Login to enter the site</h4>
				<form class="well" id="formulaire" method="POST" action='UserController?action=login' name="frmLoginUser">    
  					<input type="text" class="span3" placeholder="Username" name="userlogin" value="<c:out value="${user.userLogin}" />" />   
  					<input type="password" class="span3" placeholder="Password" name="userpwd" value="<c:out value="${user.userPwd}" />" /> 
  					<button type="submit" class="btn btn-primary btn-small pull-right"> <i class="icon-user icon-white"></i> Login</button> 
				</form>
		</div>
    	<div class="span5">
    		<br></br>
    		<br></br>
    		<p>Please enter your login and password to access the Projects Allocations Management utilities. 
    		This is a private site reserved to registered CIRB users.</p>
    		<p>Please Contact us to get access.</p>
    	</div>
  	</div>
</div>
</body>
</html>
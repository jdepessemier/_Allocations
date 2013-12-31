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
    <div class="row">
      <div class="span3">
      	<a href="http://www.cirb.irisnet.be" target="_blank"><img alt="CIRB" src="https://irisbox.irisnet.be/resources/img/cirb-brussels.png" class="pull-right"></a>
      </div>
      <div class="span9">
        <h2>Projects Allocations Management</h2>
      </div>
    </div>
    <div class="row">
    	<div class="tabbable"> 
    		<ul class="nav nav-tabs">
      			<li class="dropdown" onclick="location.href='Home.jsp';"><a data-toggle="tab">Home</a></li>
      			<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Users Management <b class="caret"></b> </a>
        			<ul class="dropdown-menu">
      					<li class="dropdown"><a href='#' onclick='invokeServlet("UserController?action=listUser")' data-toggle="tab">List Users</a></li>
      					<li class="dropdown"><a href='#' onclick='invokeServlet("UserController?action=listEmployee")' data-toggle="tab">List Employees</a></li>
        			</ul>
      			</li>	
      			<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Administration <b class="caret"></b> </a>
        			<ul class="dropdown-menu">
          				<li onclick="location.href='FileUpload.jsp';"><a data-toggle="tab">Upload Data</a></li>
        			</ul>
      			</li>      			
    		</ul>
		</div>  
    </div>
</div>
<div class="container">
  <div class="row">
	<div class="span4 offset4">
		<h3>Enter your data here</h3>
		<form class="well" id="formulaire" method="POST" action='UserController?action=register' name="frmRegisterUser">
			<p><input type="text" class="span3" placeholder="Enter Lastname" name="lastname" value="<c:out value="${user.lastName}" />" /></p>
			<p><input type="text" class="span3" placeholder="Enter Firstname" name="firstname" value="<c:out value="${user.firstName}" />" /></p>
			<p><input type="text" class="span3" placeholder="Enter email" name="usermail" value="<c:out value="${user.userMail}" />" /></p>
			<p><input type="text" class="span3" placeholder="Enter login" name="userlogin" value="<c:out value="${user.userLogin}" />" /></p>
			<p><input type="password" class="span3" placeholder="Enter password" name="userpwd" value="<c:out value="${user.userPwd}" />" /></p>		
  			<label></label>
  			<button type="submit" class="btn btn-primary btn-small pull-right"> <i class="icon-user icon-white"></i> Register</button> 
		</form>
	</div>
  </div> 
</div>

<script type='text/javascript'>
function invokeServlet(URL)
{
   location.href = URL;
}
</script>
<script src="js/jquery.js"></script> 
<script src="js/bootstrap.min.js"></script>   
</body>
</html>
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
     			<li onclick="location.href='Registration.jsp';"><a data-toggle="tab">Register Users</a></li>
    		</ul>
		</div>  
    </div>
</div>
<div class="container">
  <div class="row">
	<div class="span4 offset4">
		<h3> Choose File :</h3>
			<form class="well" id="formulaire" method="POST" action='upload?action=uploadSnaphot' enctype="multipart/form-data">
            	<p><input class="span3" type="file" name="file" /></p>
                <button type="submit" class="btn btn-primary btn-small pull-right"> <i class="icon-file icon-white"></i> Upload Snapshot Data</button>
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
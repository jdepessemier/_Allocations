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
        <h1>Projects Allocations Management</h1>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="span12">
      <table class="table table-bordered table-striped table-condensed">
        <thead>
          <tr>
            <th>User Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>eMail</th>
            <th>Login</th>
            <th>Password</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                	<td><c:out value="${user.userId}" /></td>
                	<td><c:out value="${user.firstName}" /></td>
                	<td><c:out value="${user.lastName}" /></td>
                	<td><c:out value="${user.userMail}" /></td>
                	<td><c:out value="${user.userLogin}" /></td>
                	<td><c:out value="${user.userPwd}" /></td>
                </tr>
            </c:forEach>
        </tbody>
      </table>
    </div>
  </div> 
  <div class="row">
	<div class="span4 offset2">
		<h4>Choose File to Upload in Server</h4>
		<form class="well" id="formulaire" action="upload" method="post" enctype="multipart/form-data"> 
			<p><input type="file" class="span3" placeholder="FileName" name="file" /></p>   
  			<label></label>
  			<button type="submit" class="btn btn-primary btn-small pull-right"> <i class="icon-user icon-white"></i> Upload File Data</button> 
		</form>
	</div>
  </div>
   <div class="row">
	<div class="span4 offset2">
		<h4>Display Employees</h4>
		<form class="well" id="formulaire" action="UserController?action=listEmployee" method="post"> 
  			<label></label>
  			<button type="submit" class="btn btn-primary btn-small pull-right"> <i class="icon-user icon-white"></i> Show Employees</button> 
		</form>
	</div>
  </div>  
</div>    
</body>
</html>

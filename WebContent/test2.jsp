<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>tuto02_03a</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
</head>

<body>
<div class="container">
  <div class="page-header">
    <div class="row">
      <div class="span12">
        <h1>Projects Allocations Site</h1>
      </div>
    </div>
  </div>
  <div class="row">
	<div class="span7">
		<form class="well" id="formulaire" method="POST" action='UserController?action=login' name="frmLoginUser">    
  			<input type="text" class="span3" placeholder="Username" name="userlogin" value="<c:out value="${user.userLogin}" />" />  
  			<span class="help-inline">Type your login here !</span>  
  			<input type="password" class="span3" placeholder="Password" name="userpwd" value="<c:out value="${user.userPwd}" />" /> 
  			<span class="help-inline">Type your password here !</span>
  			<label></label>
  			<button type="submit" class="btn">Submit</button>  
		</form>
	</div>
    <div class="span5">
    </div>
  </div>
</div>
</body>
</html>

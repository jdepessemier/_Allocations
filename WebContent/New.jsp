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
  <title>Welcome</title>
  <link rel="stylesheet" href="css/style.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<section class="container">
    <table id="table-2" >
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
</section>
<section class="container"> 
        <div class="login">
            <h1> Choose File to Upload in Server </h1>
            <form action="upload" method="post" enctype="multipart/form-data">
                <p><input type="file" name="file" /></p>
                <p><input type="submit" value="Upload File Data" /></p>
            </form>          
        </div>
</section>
<section class="container"> 
        <div class="login">
            <form action="UserController?action=listEmployee" method="post">
                <p><input type="submit" value="Show Employees" /></p>
            </form>          
        </div>
</section>

</body>
</html>






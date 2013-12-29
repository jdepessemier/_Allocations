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
            	<th>Id</th>
            	<th>Employee</th>
                <th>Service</th>
                <th>Department</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="empl">
                <tr>
                	<td><c:out value="${empl.employeeId}" /></td>
                	<td><c:out value="${empl.employeeName}" /></td>
                	<td><c:out value="${empl.employeeService}" /></td>
                	<td><c:out value="${empl.employeeDepartment}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>






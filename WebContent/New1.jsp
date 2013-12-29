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
        <caption>
        <h4>Users List</h4>
        </caption>
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
    </div>
  </div>
 </div>
</body>
</html>






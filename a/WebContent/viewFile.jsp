
<%@page import="com.hero.test.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hey Cool</title>

<h1>you're in JSP</h1>
</head>
<body>

 <c:forEach items="${sessionScope.empList}"  var="entry">
 
 <table>
  <tr><td>${entry.getEmpid()}</td><td>${entry.getEname()}</td><td>${entry.getEsal()}</td></tr>
 </table>
 
  
 </c:forEach>
 


</body>


</html>
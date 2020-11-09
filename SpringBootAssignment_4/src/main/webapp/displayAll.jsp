<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All</title>
</head>
<body align="center" style="background-color:#00cc99;">

<h3>Employees List</h3>
	<table border="1" cellpadding="2" cellspacing="2" align="center">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Email</th>
			<th>Location</th>
			
		</tr>
		<c:forEach var="item"  items="${result}">
			<tr>
				<td>${item.empid}</td>
				<td>${item.empname}</td>
				<td>${item.empemail }</td>
				<td>${item.location }</td>
				
			</tr>
		</c:forEach>
	</table><br>
	<a href="index.jsp">Home</a>

</body>
</html>
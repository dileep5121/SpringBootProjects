<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body align="center" style="background-color:#00cc99;">

<form  action="/addemployee" onsubmit="myFunction()">
<hl>Employee Form</hl>
<br>
<br>
Employee Id:&nbsp &nbsp &nbsp &nbsp<input type="number" name="empid"/><br>
Employee Name:<input type="text" name="empname"/><br>
Employee Email:<input type="email" name="empemail"/><br>
Location:&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="text"/ name="location"><br><br>
<button type="submit">Submit</button>

</form>
<script>
function myFunction() {
  alert("Form submitted successfully");
}
</script>

</body>
</html>
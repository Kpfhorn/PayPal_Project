<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="mystyle.css">

</head>
<body>

	<header> </header>

	<nav>
		<ul>
			<li><a href="welcomePageManager.jsp">Welcome Page</a></li>
			<li><a href="addEmployee.jsp">Add Employee</a></li>
			<li><a href="welcomePage.jsp">Logout</a></li>
		</ul>
	</nav>

	<main>
	<h1 style="font-family: arial; text-align: center; font-size: 20pt;">
		Delete Employee</h1>
		<form method="post" action="DeteleEmployee">
		<p>Employee ID was not found or Employee name does not match.</p>
		<br>
			<label>Name</label> <br> <input class="input"type="text" name="nameEmployee" /> <br>
			<label>Employee Id</label> <br> <input class="input"type="text" name="employeeId" /> <br> 
			<p></p>
			<input type="submit" value="Delete" />
			<input type="reset" value="Cancel" />
		</form>

	</main>

	<footer> </footer>

</body>
</html>
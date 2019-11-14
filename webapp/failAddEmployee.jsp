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
			<li><a href="deleteEmployee.jsp">Delete Employee</a></li>
			<li><a href="welcomePage.jsp">Logout</a></li>
			
		</ul>
	</nav>

	<main>
	<h1 style="font-family: arial; text-align: center; font-size: 30pt;">
		Add Employee</h1>

		<form method="post" action="AddEmployee">
			<p>error has in fields</p>
			<label>Name</label> <br> <input class="input"type="text" name="nameEmployee" /> <br>
			<label>Address</label><br><input class="input"type="text" name="addressEmployee"/><br>
			<label>Birthday</label><br><input class="input"type="date" name="bday"/><br>
			<label>Email</label><br><input class="input"type="text" name="emailEmployee"/><br>
			<label>Phone Number</label><br><input class="input"type="text" name="phoneNumber"/><br>
			<label>SSN</label> <br> <input class="input"type="password" name="ssn" /> <br>
			<label>License Number</label><br> <input class="input"type="text" name="lincenseNumber"/><br>
			<p></p>
			<input type="submit" value="Create" />
			<input type="reset" value="Cancel" />
		</form>


	</main>

	<footer> </footer>

</body>
</html>
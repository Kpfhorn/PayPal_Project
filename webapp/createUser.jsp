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
			<li><a href="welcomePage.jsp">Welcome Page</a></li>
			<li><a href="login.jsp">Login Page</a></li>
		</ul>
	</nav>

	<main>
	<h1 style="font-family: arial; text-align: center; font-size: 20pt;">
		Create Account</h1>

		<form method="post" action="CreateUser">
			<label>Username:</label> <br> <input class="input" type="text" name="userid" /> <br>
			<label>Password:</label> <br> <input class="input" type="password" name="pswrd" /> <br>
			<label>Email:</label> <br> <input class="input"type="email" name="email" /> <br> 
			<p></p>
			<input type="submit" value="Create" />
			<input type="reset" value="Cancel" />
		</form>

	</main>

	<footer> </footer>

</body>
</html>
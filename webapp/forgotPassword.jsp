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
			<li><a href="createUser.jsp">Create Account</a></li>
			<li><a href="login.jsp">Login Account</a></li>
		</ul>
	</nav>

	<main>
	<h3 style="text-align: center;">Recover Password</h3>
		<form>
			<label>Username</label><br> <input type="text" name="userid" /> <br>
			<label>Email</label><br> <input type="email" name="email" /> <br> 
			<p></p>
			<input type="submit"value="Request Password" />
			<br> <a href="forgetUsername.jsp">Forgot username</a>
		</form>
	</main>

	<footer> </footer>
</body>
</html>
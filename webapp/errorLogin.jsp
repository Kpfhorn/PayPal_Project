<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>

<header> </header>

<nav>
	<ul>
		<li><a href="welcomePage.jsp">Weclome Page</a></li>
		<li><a href="createUser.jsp">Create Page</a></li>
	</ul>
</nav>

<body>

	<h1 style="font-family: arial; text-align: center; font-size: 20pt;">Login</h1>
	<main>
		<form method="post" action="LoginCheck">
			
			<p style="font-size: 15pt">Username/Password was incorrect.</p>
			<br>
			<label>Username</label> <br> <input class="input"type="text" name="userid" /> <br>
			<label>Password</label> <br> <input class="input"type="password" name="pswrd" /> <br>
			<p></p>
			<select name="selectType">
				<option value="customer">Customer</option>
				<option value="manager">Manager</option>
				<option value="employee">Employee</option>
			</select>
			<br>
			<p></p>
			<input class="button"type="submit" value="Login" /> 
			<input class="button"type="reset"	value="Cancel" /> <br> <a href="forgetUsername.jsp">Forgot
				username</a> |<a href="forgotPassword.jsp">Forgot password</a>
		</form>
	</main>
	<footer> </footer>

</body>

</html>
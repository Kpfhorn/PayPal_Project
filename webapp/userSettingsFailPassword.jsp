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
			<li><a href="welcomePageCustomer.jsp">Home</a></li>
			<li><a href="welcomePage.jsp">Logout</a></li>
		</ul>
	</nav>
	<main>
	<p>Points: 0</p>
	<form method="post" action="UserSettingChangeServlet">
	
		<label>Password did not match or Did not match old password</label><br>
		<label>Old password</label><br>
		<input class="input" type="text" name="oldPswrd" /><br> <label>Change
			Password</label><br> <input class="input" type="text" name="pswrdChange" /><br>
		<label>Retype Password</label><br> <input class="input"
			type="text" name="pswrdCheck" /><br> <input type="submit"
			 value="Change" /> <input type="reset" value="Cancel" />
	</form>
	<form method="post" action="UserSettingChangeServlet"
		style="top: 425px;">
		<label>Old email</label><br><input class="input" type="text" name="oldEmail"/> <br>
		<label>Change Email</label><br> <input class="input" type="text"
			name="emailChange" /><br> <label>Retype Email</label><br>
		<input class="input" type="text" name="emailCheck" /><br>
		<p></p>
		<input type="submit" value="Change" /> <input
			type="reset" value="Cancel" />
	</form>
	</main>

	<footer> </footer>
</body>
</html>
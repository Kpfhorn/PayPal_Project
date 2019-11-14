<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
	<header>
	</header>
	<nav>
		<ul>
			<li><a href="welcomePageEmpolyee.jsp">Home</a></li>
			<li><a href="welcomePage.jsp">Logout</a></li>
		</ul>
	</nav>
	<main>
		<form method="post" action="WorkClockInOutServlet">
				<button name="clockIn"value="in">Clock In</button>
		</form>
		<form method="post" action="ClockOutServlet" style="top:300px">
			<button name="clockOut"value="out">Clock Out</button>
		</form>
	</main>

	<footer> </footer>
</body>
</html>
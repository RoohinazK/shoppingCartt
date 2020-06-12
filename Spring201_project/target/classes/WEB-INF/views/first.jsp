<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
	background-color: lightgreen;
}

header {
	width: 1000px;
}

@media only screen and (max-width: 600px) {
	body {
		background-color: lightblue;
	}
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">KALINGA Travel Booking</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home</a></li>
				<li class="active"><a href="/userregistration">Register
						User </a></li>
				<li class="active"><a href="/booking">Add Booking </a></li>
				<li class="active"><a href="/display">DISPLAY </a></li>
			</ul>
			<form class="navbar-form navbar-left" action="/action_page.php">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button class="btn btn-default" type="submit">
					<i class="glyphicon glyphicon-search"></i>
				</button>
			</form>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>
	<header>
		<h2>Welcome To Kalinga Travel</h2>
		<h3>This portal provides you the following:</h3>
		<h4>1.Registering User</h4>
		<h4>2.Adding Booking to users</h4>
		<h4>3.Viewing all the booking details</h4>
	</header>
	<script>
		$(window).resize(function() {
			if ($('header').width() <= 320) {

			}
		});
	</script>
</body>
</html>
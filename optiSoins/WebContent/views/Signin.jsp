<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="prefetch"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	
<title>Sign in</title>
</head>
<body>
	<div class="pen-title">
		<div class="input-container">
			<form class="login" action="/optiSoins/MyServlet" method="post">
				<div class="container">
					  <div class="card"></div>
					<div class="card">
						<h1 class="title">Login</h1>
						Login :<input type="text" id="Username" placeholder="Login"
							name="login" size="20" /><br>
						<div class="bar"></div>
					</div>
						Password : <input type="text" name="pwd" placeholder="Password"
							id="Password" size="20" /><br> <br>
					
						<input type="submit" name="Submit" value="Submit" />
				</div>
			</form>			
		</div>
	</div>

</body>
</html>
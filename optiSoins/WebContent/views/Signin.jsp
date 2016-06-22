<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">


<title>Sign in</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Identifiez-vous</h1>
				 <form class="form-signin" action="/optiSoins/LoginServlet" method="post">
	                <input type="text" class="form-control" placeholder="Login" name="login" required autofocus>
	                <input type="password" class="form-control" name="pwd" placeholder="Mot de passe" required>
	                <button class="btn btn-lg btn-primary btn-block" type="submit">Envoyer</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
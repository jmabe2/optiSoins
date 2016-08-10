
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<jsp:include page="header.jsp"/>

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
<jsp:include page="footer.jsp"/>
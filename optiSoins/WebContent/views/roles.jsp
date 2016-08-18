<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roles</title>
</head>
<body>
	<form action="/optiSoins/CreateRoleServlet" method="POST">

		Introduisez le nom du role : <input type="text" name="nomRole"><br>
		Actif :  <input type="checkbox" name="actif"><br> 
		Inactif :  <input type="checkbox" name="Inactif" ><br><br> 
		
		<input type="submit" value="Créer un role" /> <br>
		<input type="button" value="Modifier un role" /><br>

	</form>
	

</body>
</html>
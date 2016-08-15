<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="header.jsp"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Interventions</title>
</head>
<body>

<form action="/optiSoins/InterventionServlet" method="POST">
  Entrez le nom de l'intervention : <input type="text" name="nomIntervention"><br>
  Entrez la date de l'intervention : <input type="text" name="dateIntervention"><br>
  Entrez la description de l'intervention : <input type="text" name="descriptIntervention"><br><br>
  <input type="submit" value="Créer une intervention" />
  <input type="button" value="Modifier une intervention" /><br>
  
</form>
</body>
</html>
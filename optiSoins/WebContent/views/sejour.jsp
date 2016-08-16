<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="header.jsp"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Séjours</title>
</head>
<body>

<form action="/optiSoins/CreateSejourServlet" method="POST">

  Introduisez la date d'entrée  : <input type="text" name="dateEntree" ><br>
  Introduisez la date de sortie : <input type="text" name="dateSortie" ><br>
  Introduisez l'emplacement de la chambre : <input type="text" name="emplacementChambre"><br>
  Introduisez le motif du séjour : <input type="text" name="motifSejour"><br><br>

  <input type="submit" value="Créer un séjour" /><br>
  <input type="button" value="Modifier un séjour" /><br>
  
</form>
</body>
</html>
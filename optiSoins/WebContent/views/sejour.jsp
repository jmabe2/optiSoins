<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="header.jsp"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>S�jours</title>
</head>
<body>

<form action="/optiSoins/CreateSejourServlet" method="POST">

  Introduisez la date d'entr�e  : <input type="text" name="dateEntree" ><br>
  Introduisez la date de sortie : <input type="text" name="dateSortie" ><br>
  Introduisez l'emplacement de la chambre : <input type="text" name="emplacementChambre"><br>
  Introduisez le motif du s�jour : <input type="text" name="motifSejour"><br><br>

  <input type="submit" value="Cr�er un s�jour" /><br>
  <input type="button" value="Modifier un s�jour" /><br>
  
</form>
</body>
</html>
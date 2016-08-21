<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/sejours" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<label>Date d'entrée :</label>  <input type="text" name="dateEntree"><br>
	<label>Date de sortie : </label>  <input type="text" name="dateSortie"><br>
	<label>Emplacement : </label>  <input type="text" name="emplacement"><br>
	<label>Motif séjour : </label>  <input type="text" name="motifSejour"><br>
	<label>Actif : </label>  <input type="checkbox" name="actif"><br>
	<button type="submit">Enregistrer</button><br>

</form>
<jsp:include page="../footer.jsp"/>

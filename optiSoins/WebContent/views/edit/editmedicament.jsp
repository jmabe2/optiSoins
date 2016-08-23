<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/medicaments" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="medicamentId" value="${medicament.getIdMedicament()}">
	<label>Nom: </label>
	<input type="text" name="name" value="${medicament.getNom()}"><br>
	<label>Description: </label>
	<input type="text" name="description" value="${medicament.getDescription()}"><br>
	<label>Quantité: </label>
	<input type="text" name="quantiteDispo" value="${medicament.getQuantiteDispo()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${medicament.getActif() ? "checked" : ""}><br>
	
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/medicaments"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

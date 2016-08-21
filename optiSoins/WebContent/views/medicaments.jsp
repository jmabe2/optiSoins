<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/medicaments" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="medicamentId" value="${medicament.getIdMedicament()}">
	<label>Nom: </label>${medicament.getNom()}<br>
	<label>Description: </label>${medicament.getDescription()}<br>
	<label>Quantité: </label>${medicament.getQuantiteDispo()}<br>
	<label>Actif: </label> ${role.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
</form>
	<a href="${pageContext.request.contextPath}/medicaments"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

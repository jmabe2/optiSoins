<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/sejours" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<label>Date d'entrée : </label> ${sejour.getDateEntree()}<br>
	<label>Date de sortie : </label> ${sejour.getDateSortie()}<br>
	<label>Emplacement : </label> ${sejour.getEmplacement()}<br>
	<label>Motif du séjour : </label> ${sejour.getMotifSejour()}<br>
	<label>Actif : </label> ${sejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
	
</form>
	<a href=${pageContext.request.contextPath}/intervention><button>Créer une intervention</button></a><br><br>
	<a href=${pageContext.request.contextPath}/sejourchambre><button>Changer de chambre</button></a><br><br>	
	<a href=${pageContext.request.contextPath}/sejours><button>Retour à la liste</button></a>
	
<jsp:include page="footer.jsp"/>


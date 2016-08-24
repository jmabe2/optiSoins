<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/sejourchambre" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="sejourId" value="${sejourchambre.getIdSejour()}">
	<label>Date d'entr�e : </label> ${sejourchambre.getDateEntree()}<br>
	<label>Date de sortie : </label> ${sejourchambre.getDateSortie()}<br>
	<label>Emplacement : </label> ${sejourchambre.getEmplacement()}<br>
	<label>Motif du s�jour : </label> ${sejourchambre.getMotifSejour()}<br>
	<label>Actif : </label> ${sejourchambre.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
	
</form>

	<a href=${pageContext.request.contextPath}/sejourchambre><button>Retour � la liste</button></a>
	
<jsp:include page="footer.jsp"/>


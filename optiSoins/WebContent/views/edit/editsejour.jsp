<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/sejours" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="sejourId" value="${role.getIdSejour()}">
	<label>Date d'entrée : </label>
	<input type="text" name="dateEntree" value="${sejour.getDateEntree()}"><br>
	<label>Date de sortie : </label>
	<input type="text" name="dateSortie" value="${sejour.getDateSortie()}"><br>
	<label>Emplacement : </label>
	<input type="text" name="emplacement" value="${sejour.getEmplacement()}"><br>
	<label>Motif du Séjour : </label>
	<input type="text" name="motif" value="${sejour.getMotifSejour()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${sejour.getActif() ? "checked" : ""}><br>
	<button type="submit">Enregistrer</button>
	
</form>

	<a href="${pageContext.request.contextPath}/sejour"><button>Retour à la liste</button></a>
	
<jsp:include page="../footer.jsp"/>
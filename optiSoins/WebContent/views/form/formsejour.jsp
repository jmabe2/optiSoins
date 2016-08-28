	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<input type="hidden" name="patientId" value="${param.patientId}${sejour.getPatient().getIdPatient()}">
<label>Date d'entrée : </label>
	<input type="text" name="dateEntree" class="datepicker" value="${param.dateEntree}<fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" />" > <span class="erreur">${erreurs['dateEntree']}</span><br>
	<label>Date de sortie : </label>
	<input type="text" name="dateSortie" class="datepicker" value="${param.dateSortie}<fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" />" > <span class="erreur">${erreurs['dateSortie']}</span><br>
	<label>Emplacement : </label>
	<input type="text" name="emplacement" value="${param.emplacement}${sejour.getEmplacement()}"><br>
	<label>Motif du Séjour : </label>
	<input type="text" name="motifSejour" value="${param.motifSejour}${sejour.getMotifSejour()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${param.actif != null || param.action == 'create' ? "checked" : ""}${sejour.getActif() != null ? "checked" : ""}><br>
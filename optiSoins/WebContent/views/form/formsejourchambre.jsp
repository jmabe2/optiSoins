	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<input type="hidden" name="sejourId" value="${param.sejourId}${sejourchambre.getSejour().getIdSejour()}">
	<input type="hidden" name="sejourchambreId" value="${sejourchambre.getIdSejourChambre()}">
	<label>Date d'entrée : </label>
	<input type="text" name="dateEntree" class="datepicker" value="${param.dateEntree}<fmt:formatDate value="${sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" />" > <span class="erreur">${erreurs['dateEntree']}</span><br>
	<label>Date de sortie : </label>
	<input type="text" name="dateSortie" class="datepicker" value="${param.dateSortie}<fmt:formatDate value="${sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" />" > <span class="erreur">${erreurs['dateSortie']}</span><br>
	<label>N° de chambre : </label>
	<input type="text" name="numchambre" value="${param.numchambre}${sejourchambre.getChambre().getNumeroChambre()}"> 
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${param.actif != null || param.action == 'create' ? "checked" : ""}${sejourchambre.getActif() != null ? "checked" : ""}><br>
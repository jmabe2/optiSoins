<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/sejourchambre" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="sejourId" value="${sejourchambre.getSejour().getIdSejour()}">
	<input type="hidden" name="sejourchambreId" value="${sejourchambre.getIdSejourChambre()}">
	<label>Patient : </label>${sejourchambre.getSejour().getPatient().getNom()} ${sejourchambre.getSejour().getPatient().getPrenom()}<br>
	<label>Séjour du : </label><fmt:formatDate value="${sejourchambre.getSejour().getDateEntree()}" pattern="yyyy-MM-dd" /> <label> au </label> <fmt:formatDate value="${sejourchambre.getSejour().getDateSortie()}" pattern="yyyy-MM-dd" /><br>
	<label>Date d'entrée : </label>
	<fmt:formatDate value="${sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" />
	<br> <label>Date de sortie : </label>
	<fmt:formatDate value="${sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" /><br>
	<label>Chambre : </label> ${sejourchambre.getChambre().getNumeroChambre()}<br>
	<label>Actif : </label> ${sejourchambre.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
	
</form>

	<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="sejourId"
		value="${sejourchambre.getSejour().getIdSejour()}">
	<button type="submit">Retour au séjour</button>
	</form>
<jsp:include page="footer.jsp"/>


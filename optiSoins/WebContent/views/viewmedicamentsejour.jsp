<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/medicamentsejour" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="sejourId" value="${medicamentsejour.getSejour().getIdSejour()}">
	<input type="hidden" name="medicamentsejourId" value="${medicamentsejour.getIdMedicamentSejour()}">
	<label>Patient : </label>${medicamentsejour.getSejour().getPatient().getNom()} ${medicamentsejour.getSejour().getPatient().getPrenom()}<br>
	<label>Séjour du : </label><fmt:formatDate value="${medicamentsejour.getSejour().getDateEntree()}" pattern="yyyy-MM-dd" /> <label> au </label> <fmt:formatDate value="${medicamentsejour.getSejour().getDateSortie()}" pattern="yyyy-MM-dd" /><br>
	<label>Médicament: </label>${medicamentsejour.getMedicament().getNom()}<br>
	<label>Indication : </label>${medicamentsejour.getIndication()}<br>
	<label>Posologie : </label>${medicamentsejour.getPosologie()}<br> 
	<label>Remarque : </label>${medicamentsejour.getRemarque()}<br> 
	<label>Actif : </label> ${medicamentsejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
	
</form>

	<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="sejourId"
		value="${medicamentsejour.getSejour().getIdSejour()}">
	<button type="submit">Retour au séjour</button>
	</form>
<jsp:include page="footer.jsp"/>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/interventions" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="interventionId" value="${intervention.getIdIntervention()}">
	<label>Patient : </label>${intervention.getSejour().getPatient().getNom()} ${intervention.getSejour().getPatient().getPrenom()}<br>
	<label>Séjour du : </label><fmt:formatDate value="${intervention.getSejour().getDateEntree()}" pattern="yyyy-MM-dd" /> <label> au </label> <fmt:formatDate value="${intervention.getSejour().getDateSortie()}" pattern="yyyy-MM-dd" /><br>
	<label>Date de l'intervention : </label><fmt:formatDate value="${intervention.getDate()}" pattern="yyyy-MM-dd" /><br>
	
	<label>Description de l'intervention : </label>${intervention.getDescription()}<br>
	<label>Nom de l'intervention : </label>${intervention.getNom()}<br>
	<label>type de l'intervention : </label>${intervention.getTypeintervention().getLibelle()}<br>
	<button type="submit">Modifier</button>	
	
</form>

	<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="sejourId"
		value="${intervention.getSejour().getIdSejour()}">
	<button type="submit">Retour au séjour</button>
</form>
	
<jsp:include page="footer.jsp"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/interventions" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="interventionId" value="${intervention.getIdIntervention()}">
	<label>Date de l'intervention : </label>
	<input type="text" name="date" value="${intervention.getDate()}"><br>
	<label>Description de l'intervention : </label>
	<input type="text" name="description" value="${intervention.getDescription()}"><br>
	<label>Nom de l'intervention : </label>
	<input type="text" name="name" value="${intervention.getNom()}"><br>
	<button type="submit">Modifier</button>	
	
</form>

	<a href="${pageContext.request.contextPath}/intervention"><button>Retour à la liste</button></a>
	
<jsp:include page="footer.jsp"/>

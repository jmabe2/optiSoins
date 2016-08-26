<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="typeInterventionId" value="${typeintervention.getIdTypeIntervention()}">
	<label>Libellé : </label>
	<input type="text" name="Libelle" value="${typeintervention.getLibelle()}"><br>
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/typeintervention"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="typeinterventionId" value="${typeintervention.getIdTypeIntervention()}">
	<label>Libellé: </label>${typeintervention.getLibelle()}<br>
	<button type="submit">Modifier</button>	
</form>
	<a href="${pageContext.request.contextPath}/typeintervention"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

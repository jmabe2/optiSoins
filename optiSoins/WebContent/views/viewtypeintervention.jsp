<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="typeInterventionId" value="${typeintervention.getIdTypeIntervention()}">
	<label>Libell�: </label>${typeintervention.getLibelle()}<br>
	<button type="submit">Modifier</button>	
</form>
			<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er</button>
			</form>
	<a href="${pageContext.request.contextPath}/typeintervention"><button>Retour � la liste</button></a>
<jsp:include page="footer.jsp"/>

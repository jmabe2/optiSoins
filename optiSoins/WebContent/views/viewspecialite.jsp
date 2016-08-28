<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/specialites" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="specialiteId" value="${specialite.getIdSpecialite()}">
	<label>Nom: </label>${specialite.getSpecialite()}<br>
	<label>Actif: </label> ${specialite.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
</form>
			<form action="${pageContext.request.contextPath}/specialites" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer</button>
			</form>
	<a href="${pageContext.request.contextPath}/specialites"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

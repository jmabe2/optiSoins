<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/equipements" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="equipementId" value="${equipement.getIdEquipement()}">
	<label>Nom: </label>${equipement.getNom()}<br>
	<label>Description: </label>${equipement.getDescription()}<br>
	<button type="submit">Modifier</button>	
</form>
			<form action="${pageContext.request.contextPath}/equipements" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er</button>
			</form>
	<a href="${pageContext.request.contextPath}/equipements"><button>Retour � la liste</button></a>
<jsp:include page="footer.jsp"/>

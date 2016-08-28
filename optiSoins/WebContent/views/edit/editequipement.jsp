<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/equipements" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="equipementId" value="${equipement.getIdEquipement()}">
	<label>Nom: </label>
	<input type="text" name="name" value="${equipement.getNom()}"><br>
	<label>Description: </label>
	<input type="text" name="description" value="${equipement.getDescription()}"><br>
	
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/equipements"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

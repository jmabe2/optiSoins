<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/types" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="typeId" value="${typechambre.getIdTypeChambre()}">
	<label>Nom: </label>
	<input type="text" name="name" value="${typechambre.getNom()}">
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${typechambre.getActif() ? "checked" : ""}><br>
	
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/types"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

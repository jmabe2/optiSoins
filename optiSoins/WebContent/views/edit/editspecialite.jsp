<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/specialites" method="post">
	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="specialiteId" value="${specialite.getIdSpecialite()}">
	<label>Nom: </label>
	<input type="text" name="name" value="${specialite.getSpecialite()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${specialite.getActif() ? "checked" : ""}><br>
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/specialites"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

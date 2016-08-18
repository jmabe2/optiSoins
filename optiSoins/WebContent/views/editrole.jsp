<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/roles" method="post">
	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="roleId" value="${role.getIdRole()}">
	<label>Nom: </label>
	<input type="text" name="name" value="${role.getNom()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${role.getActif() ? "checked" : ""}><br>
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/roles"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

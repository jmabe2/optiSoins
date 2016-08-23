<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="utilisateurId" value="${utilisateur.getIdUtilisateur()}">
	<jsp:include page="../form/formutilisateur.jsp" />
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/utilisateurs"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

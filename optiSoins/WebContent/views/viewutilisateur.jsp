<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="utilisateurId" value="${utilisateur.getIdUtilisateur()}">
	<label>Nom: </label>${utilisateur.getNom()}<br>
	<label>Actif: </label> ${utilisateur.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
</form>
	<a href="${pageContext.request.contextPath}/utilisateurs"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

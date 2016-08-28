<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="utilisateurId" value="${utilisateur.getIdUtilisateur()}">
	<label>Nom: </label>${utilisateur.getNom()}<br>
	<label>Pr�nom: </label>${utilisateur.getPrenom()}<br>
	<label>Sexe: </label>${utilisateur.getSexe()=="M" ? "Homme" : "Femme"}<br>
	<label>Date de naissance: </label><fmt:formatDate value="${utilisateur.getDateNaissance()}" pattern="yyyy-MM-dd" /><br>
	<label>Login: </label>${utilisateur.getLogin()}<br>
	<label>R�le: </label>${utilisateur.getRole().getNom()}<br>
	<c:if test="${utilisateur.getRole().getNom().equals(\"M�decin\")}">
   	    <label>Sp�cialit�: </label>${utilisateur.getSpecialite().getSpecialite()}<br>
	</c:if>
	<label>Actif: </label> ${utilisateur.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
</form>

<form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	<input type="hidden" name="action" value="create">
	<button type="submit">Cr�er</button>	

</form>
	<a href="${pageContext.request.contextPath}/utilisateurs"><button>Retour � la liste</button></a>
<jsp:include page="footer.jsp"/>

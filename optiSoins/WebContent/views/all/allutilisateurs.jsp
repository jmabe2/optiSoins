<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

			<h2>Utilisateurs</h2><br>
			<form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date Naiss.</th>
                    <th>Role</th>
                    <th>Actif</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${utilisateurs}" var="utilisateur">
                    <tr>
                        <td>${utilisateur.getIdUtilisateur()}</td>
                        <td>${utilisateur.getNom()}</td>
                        <td>${utilisateur.getPrenom()}</td>
                        <td><fmt:formatDate value="${utilisateur.getDateNaissance()}" pattern="yyyy-MM-dd" /></td>
                        <td>${utilisateur.getRole().getNom()}</td>
                        <td>${utilisateur.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                        <form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	    					<input type="hidden" name="action" value="view">
	    					<input type="hidden" name="utilisateurId" value="${utilisateur.getIdUtilisateur()}">
	    					<button type="submit">Visualiser</button>
						  </form>
						  </td>
						  <td>
                          <form action="${pageContext.request.contextPath}/utilisateurs" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="utilisateurId" value="${utilisateur.getIdUtilisateur()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

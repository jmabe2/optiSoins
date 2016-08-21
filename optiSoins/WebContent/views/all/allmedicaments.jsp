<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Medicaments</h2><br>
			<form action="${pageContext.request.contextPath}/medicaments" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer un médicament</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th> Quantité disponible</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${medicaments}" var="medicament">
                    <tr>
                        <td>${medicament.getIdMedicament()}</td>
                        <td>${medicament.getNom()}</td>
                         <td>${medicament.getDescription()}</td>
                        <td>${medicament.getQuantiteDispo()}</td>                      
                        <td>${medicament.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                          <form action="${pageContext.request.contextPath}/medicaments" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="medicamentId" value="${medicament.getIdMedicament()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>
</html>
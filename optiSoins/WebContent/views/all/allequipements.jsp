<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Equipements</h2><br>
			<form action="${pageContext.request.contextPath}/equipements" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer un equipement</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th></th>
                </tr>
                <c:forEach items="${equipements}" var="equipement">
                    <tr>
                        <td>${equipement.getIdEquipement()}</td>
                        <td>${equipement.getNom()}</td>
                         <td>${equipement.getDescription()}</td>
                         
                        <td>
                          <form action="${pageContext.request.contextPath}/equipements" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="equipementId" value="${equipement.getIdEquipement()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>
</html>
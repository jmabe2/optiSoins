<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Types de chambre</h2><br>
			<form action="${pageContext.request.contextPath}/types" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer un type de chambre</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${types}" var="typechambre">
                    <tr>
                        <td>${typechambre.getIdTypeChambre()}</td>
                        <td>${typechambre.getNom()}</td>                     
                        <td>${typechambre.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                          <form action="${pageContext.request.contextPath}/types" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="typeId" value="${typechambre.getIdTypeChambre()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>
</html>
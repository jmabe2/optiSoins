<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Interventions</h2><br>
			<form action="${pageContext.request.contextPath}/intervention" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er une intervention</button><br><br>
			</form>
			
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom de l'intervention</th>
 				    <th>Description de l'intervention</th>                   
 				    <th>Date de l'intervention</th>
                    <th></th>
                </tr>
                <c:forEach items="${interventions}" var="sejour">
                    <tr>
                        <td>${role.getIdIntervention()}</td>
                        <td>${role.getdNom()}</td>
						<td>${role.getDescription()}</td>
						<td>${role.getDate()}</td>
                        <td>
                        
                          <form action="${pageContext.request.contextPath}/interventions" method="post">
                          
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="interventionId" value="${role.getIdIntervention()}">
	    					
	    					<button type="submit">Modifier une intervention</button>
						  
						  </form>
						  </td>
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

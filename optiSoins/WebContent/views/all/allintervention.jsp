<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

			<h2>Interventions</h2><br>
						
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Nom</th>
 				    <th>Description</th>                   
 				    <th>Date de l'intervention</th>
                    <th></th>
                </tr>
                <c:forEach items="${interventions}" var="intervention">
                    <tr>
                        <td>${intervention.getIdIntervention()}</td>
                        <td>${intervention.getTypeintervention().getLibelle()}</td>
                        <td>${intervention.getNom()}</td>
						<td>${intervention.getDescription()}</td>
						<td> <fmt:formatDate value="${intervention.getDate()}" pattern="yyyy-MM-dd" /> </td>
                        <td>
                        <c:if test="${intervention.getUtilisateur().getIdUtilisateur()==sessionScope['loginUser'].idUtilisateur}">
                          <form action="${pageContext.request.contextPath}/intervention" method="post">
                          
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="interventionId" value="${intervention.getIdIntervention()}">
	    					
	    					<button type="submit">Modifier intervention</button>
						  
						  </form>
						  </c:if>
						  </td>
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

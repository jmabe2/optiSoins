<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="header.jsp" />

<form action="${pageContext.request.contextPath}/sejours" method="post">

	<input type="hidden" name="action" value="edit"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<label>Patient: </label>${sejour.getPatient().getNom()} ${sejour.getPatient().getPrenom()}<br>
	<label>Date d'entrée : </label>
	<fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" />
	<br> <label>Date de sortie : </label>
	<fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" />
	<br> <label>Emplacement : </label> ${sejour.getEmplacement()}<br>
	<label>Motif du séjour : </label> ${sejour.getMotifSejour()}<br> <label>Actif
		: </label> ${sejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>

</form>
<form action="${pageContext.request.contextPath}/intervention"
	method="post">
	<input type="hidden" name="action" value="create"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<button type="submit">Ajouter une intervention</button>
	</form>
	<br>
	<h4><u>Interventions</u></h4><br>
	            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Nom</th>
 				    <th>Description</th>                   
 				    <th>Date de l'intervention</th>
                    <th></th>
                </tr>
                <c:forEach items="${sejour.getInterventions()}" var="intervention">
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
	<br>

<form action="${pageContext.request.contextPath}/patients" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="patientId"
		value="${sejour.getPatient().getIdPatient()}">
	<button type="submit">Retour au patient</button>
</form>


<jsp:include page="footer.jsp" />


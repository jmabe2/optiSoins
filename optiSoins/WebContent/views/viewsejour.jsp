<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="header.jsp" />

<form action="${pageContext.request.contextPath}/sejours" method="post">

	<input type="hidden" name="action" value="edit"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<label>Patient: </label>${sejour.getPatient().getNom()} ${sejour.getPatient().getPrenom()}<br>
	<label>Date d'entr�e : </label>
	<fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" />
	<br> <label>Date de sortie : </label>
	<fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" />
	<br> <label>Emplacement : </label> ${sejour.getEmplacement()}<br>
	<label>Motif du s�jour : </label> ${sejour.getMotifSejour()}<br> <label>Actif
		: </label> ${sejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>

</form>
<h4>Interventions</h4><br>
<c:if test="${sessionScope['loginUser'].role.nom.equals('Admin') || sessionScope['loginUser'].role.nom.equals('M�decin')}">
<form action="${pageContext.request.contextPath}/intervention"
	method="post">
	<input type="hidden" name="action" value="create"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<button type="submit">Ajouter une intervention</button>
	</form>
</c:if>
	<br>
	
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
	
	<h4>Chambres</h4><br>
	<form action="${pageContext.request.contextPath}/sejourchambre"
	method="post">
	<input type="hidden" name="action" value="create"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<button type="submit">Ajouter une chambre</button>
	</form>
	<br>
	
	            <table class="table table-striped">
                <tr>
                    
                    <th>Num�ro</th>
                    <th>Date de d�but</th>
 				    <th>Date de fin</th>                   
                    <th></th>
                </tr>
                <c:forEach items="${sejour.getSejourchambres()}" var="sejourchambre">
                    <tr>
                    	 <td>${sejourchambre.getChambre().getNumeroChambre()}</td>
                        <td><fmt:formatDate value="${sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" /></td>
                        <td><fmt:formatDate value="${sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" /></td>
                        
                        <td>
                        
                          <form action="${pageContext.request.contextPath}/sejourchambre" method="post">
                          
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="sejourchambreId" value="${sejourchambre.getIdSejourChambre()}">
	    					
	    					<button type="submit">Modifier chambre</button>
						  
						  </form>
						  
						  </td>
                    </tr>
                </c:forEach>
            </table>
	<br>

<h4>M�dicaments</h4><br>
<form action="${pageContext.request.contextPath}/medicamentsejour"
	method="post">
	<input type="hidden" name="action" value="create"> <input
		type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<button type="submit">Ajouter un m�dicament</button>
	</form>
	<br>
	
	            <table class="table table-striped">
                <tr>
                    
                    <th>Medicament</th>
                    <th>Indication</th>
 				    <th>Posologie</th>
 				    <th>Remarque</th>                  
                    <th></th>
                </tr>
                <c:forEach items="${sejour.getMedicamentsejours()}" var="medicamentsejour">
                    <tr>
                    	 <td>${medicamentsejour.getMedicament().getNom()}</td>
                    	 <td>${medicamentsejour.getIndication()}</td>
                    	 <td>${medicamentsejour.getPosologie()}</td>
                    	 <td>${medicamentsejour.getRemarque()}</td>
                        <td>
                        
                          <form action="${pageContext.request.contextPath}/medicamentsejour" method="post">
                          
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="medicamentsejourId" value="${medicamentsejour.getIdMedicamentSejour()}">
	    					
	    					<button type="submit">Modifier m�dicament</button>
						  
						  </form>
						  
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


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp"/>
<h3>Fiche patient</h3><br>
<form action="${pageContext.request.contextPath}/patients" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="patientId" value="${patient.getIdPatient()}">
	<label>Nom: </label>${patient.getNom()}<br>
	<label>Prénom: </label>${patient.getPrenom()}<br>
	<label>Sexe: </label>${patient.getSexe()=="M" ? "Homme" : "Femme"}<br>
	<label>Date de naissance: </label><fmt:formatDate value="${patient.getDateDeNaissance()}" pattern="yyyy-MM-dd" /><br>
	<label>Adresse: </label><textarea readonly>${patient.getAdresse()}</textarea><br>
	<label>Actif: </label> ${patient.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}<br>
	<button type="submit">Modifier</button>	
</form><br>
    <h4><u>Séjours</u></h4><br>
			<form action="${pageContext.request.contextPath}/sejours" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<input type="hidden" name="patientId" value="${patient.getIdPatient()}">
	    		<button type="submit">Créer un séjour</button><br><br>
			</form>
			
			<table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Date d'entrée</th>
 				    <th>Date de sortie</th>                   
 				    <th>Emplacement</th>
 				    <th>Motif du séjour</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${sejours}" var="sejour">
                    <tr>
                        <td>${sejour.getIdSejour()}</td>
                        <td><fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" /></td>
                        <td><fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" /></td>
						<td>${sejour.getEmplacement()}</td>
				        <td>${sejour.getMotifSejour()}</td>
					    <td>${sejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                        
             			  <form action="${pageContext.request.contextPath}/sejours" method="post">
                          <input type="hidden" name="action" value="view">
	    				  <input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	    				  <button type="submit">Visualiser</button>						  
						  </form>
						  
						  </td>
						  <td>
                          <form action="${pageContext.request.contextPath}/sejours" method="post">
                          <input type="hidden" name="action" value="edit">
	    				  <input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	    				  <button type="submit">Modifier séjour</button>						  
						  </form>
						  </td>
						  
						  
						  </td>
                    </tr>
                </c:forEach>
            </table>

    
	<a href="${pageContext.request.contextPath}/patients"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<input type="hidden" name="sejourId" value="${param.sejourId}${intervention.getSejour().getIdSejour()}">
	<input type="hidden" name="utilisateurId" value="${sessionScope['loginUser'].idUtilisateur}">
	<label>Date de l'intervention : </label>
	<input type="text" name="date" class="datepicker" value="${param.date}<fmt:formatDate value="${intervention.getDate()}" pattern="yyyy-MM-dd" />" > <span class="erreur">${erreurs['date']}</span><br>
	<label>Description de l'intervention : </label>
	<input type="text" name="description" value="${param.description}${intervention.getDescription()}"><br>
	<label>Nom de l'intervention : </label>
	<input type="text" name="nom" value="${param.nom}${intervention.getNom()}"><br>
	<label>Type d'intervention: </label>
			<select name="typeintervention">
					<c:forEach items="${typeinterventions}" var="typeintervention">
						<option value="${typeintervention.getIdTypeIntervention()}" ${param.typeintervention == typeintervention.getIdTypeIntervention() ? "selected" : ""}${intervention.getTypeintervention().getIdTypeIntervention() == typeintervention.getIdTypeIntervention() ? "selected" : ""}>${typeintervention.getLibelle()}</option>
					</c:forEach>
			</select><br>
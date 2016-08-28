	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<input type="hidden" name="sejourId" value="${param.sejourId}${medicamentsejour.getSejour().getIdSejour()}">
	<input type="hidden" name="medicamentsejourId" value="${medicamentsejour.getIdMedicamentSejour()}">
	<label>Médicament: </label>
		<select name="medicament">
					<c:forEach items="${medicaments}" var="medicament">
						<option value="${medicament.getIdMedicament()}" ${param.medicament == medicament.getIdMedicament() ? "selected" : ""}${medicamentsejour.getMedicament().getIdMedicament() == medicament.getIdMedicament() ? "selected" : ""}>${medicament.getNom()}</option>
					</c:forEach>
			</select><br>
	<label>Indication : </label>
	<input type="text" name="indication" value="${param.indication}${medicamentsejour.getIndication()}"> <br>
	<label>Posologie : </label>
	<input type="text" name="posologie" value="${param.posologie}${medicamentsejour.getPosologie()}"> <br>
	<label>Remarque : </label>
	<input type="text" name="remarque" value="${param.remarque}${medicamentsejour.getRemarque()}"> <br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${param.actif != null || param.action == 'create' ? "checked" : ""}${medicamentsejour.getActif() != null ? "checked" : ""}><br>
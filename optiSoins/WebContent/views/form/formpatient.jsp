	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<table>
		<tr>
			<td><label>Nom: </label></td>
			<td><input type="text" name="nom" value="${param.nom}${patient.getNom()}">
			<span class="erreur">${erreurs['nom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Prenom: </label></td>
			<td><input type="text" name="prenom" value="${param.prenom}${patient.getPrenom()}">
			<span class="erreur">${erreurs['prenom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Sexe: </label></td>
			<td><select name="sexe">
					<option value="M" ${param.sexe == "M" ? "selected" : ""}${patient.getSexe() == "M" ? "selected" : ""}>Homme</option>
					<option value="F" ${param.sexe == "F" ? "selected" : ""}${patient.getSexe() == "F" ? "selected" : ""}>Femme</option>
			</select></td>
		</tr>
		<tr>
			<td><label>Date de naissance: </label></td>
			<td><input type="text" name="datenaiss" value="${param.datenaiss}<fmt:formatDate value="${patient.getDateNaissance()}" pattern="yyyy-MM-dd" />"></td>
		</tr>
		<tr>
			<td><label>Actif: </label></td>
			<td><input type="checkbox" name="actif" ${param.actif != null ? "checked" : ""}${patient.getActif() != null ? "checked" : ""}><br></td>
		</tr>
	</table>
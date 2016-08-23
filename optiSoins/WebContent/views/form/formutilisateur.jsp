	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<table>
		<tr>
			<td><label>Nom: </label></td>
			<td><input type="text" name="nom" value="${param.nom}${utilisateur.getNom()}">
			<span class="erreur">${erreurs['nom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Prenom: </label></td>
			<td><input type="text" name="prenom" value="${param.prenom}${utilisateur.getPrenom()}">
			<span class="erreur">${erreurs['prenom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Sexe: </label></td>
			<td><select name="sexe">
					<option value="M" ${param.sexe == "M" ? "selected" : ""}${utilisateur.getSexe() == "M" ? "selected" : ""}>Homme</option>
					<option value="F" ${param.sexe == "F" ? "selected" : ""}${utilisateur.getSexe() == "F" ? "selected" : ""}>Femme</option>
			</select></td>
		</tr>
		<tr>
			<td><label>Date de naissance: </label></td>
			<td><input id="datenaiss" type="text" name="datenaiss" value="${param.datenaiss}<fmt:formatDate value="${utilisateur.getDateNaissance()}" pattern="yyyy-MM-dd" />"></td>
		</tr>
		<tr>
			<td><label>Login: </label></td>
			<td><input type="text" name="login" value="${param.login}${utilisateur.getLogin()}"></td>
		</tr>
		<tr>
			<td><label>Mot de passe: </label></td>
			<td><input type="password" name="mdp" value="${param.mdp}${utilisateur.getMotDePasse()}"></td>
		</tr>
		<tr>
			<td><label>Role: </label></td>
			<td><select id="selectRole" name="role">
					<c:forEach items="${roles}" var="role">
						<option value="${role.getIdRole()}" ${param.role == role.getIdRole() ? "selected" : ""}${utilisateur.getRole().getIdRole() == role.getIdRole() ? "selected" : ""}>${role.getNom()}</option>
					</c:forEach>
			</select><br></td>
		</tr>
		<tr id="specialite">
			<td><label>Spécialité: </label></td>
			<td><select name="specialite">
					<c:forEach items="${specialites}" var="specialite">
						<option value="${specialite.getIdSpecialite()}" ${param.specialite == specialite.getIdSpecialite() ? "selected" : ""}${utilisateur.getSpecialite().getIdSpecialite() == specialite.getIdSpecialite() ? "selected" : ""}>${specialite.getSpecialite()}</option>
					</c:forEach>
			</select><br></td>
		</tr>
		<tr>
			<td><label>Actif: </label></td>
			<td><input type="checkbox" name="actif" ${param.actif != null ? "checked" : ""}${utilisateur.getActif() != null ? "checked" : ""}><br></td>
		</tr>
	</table>
	<script type="text/javascript">
		$('#selectRole').on('change', function() {		  
			  if( $("#selectRole option:selected").text() == "Médecin") {
				  $('#specialite').show();
			  } else {
				  $('#specialite').hide();
			  }
			});
		$(document).ready(function() {      
		    $("#selectRole").change();
		});
		$("#datenaiss").flatpickr();;
		
			
	</script>
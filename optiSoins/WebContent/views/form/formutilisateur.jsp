	<table>
		<tr>
			<td><label>Nom: </label></td>
			<td><input type="text" name="nom" value="${utilisateur.getNom()}">
			<span class="erreur">${erreurs['nom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Prenom: </label></td>
			<td><input type="text" name="prenom" value="${utilisateur.getPrenom()}">
			<span class="erreur">${erreurs['prenom']}</span>
			</td>
		</tr>
		<tr>
			<td><label>Sexe: </label></td>
			<td><select name="sexe">
					<option value="M">Homme</option>
					<option value="F">Femme</option>
			</select></td>
		</tr>
		<tr>
			<td><label>Date de naissance: </label></td>
			<td><input type="text" name="datenaiss"></td>
		</tr>
		<tr>
			<td><label>Login: </label></td>
			<td><input type="text" name="login"></td>
		</tr>
		<tr>
			<td><label>Mot de passe: </label></td>
			<td><input type="text" name="mdp"></td>
		</tr>
		<tr>
			<td><label>Role: </label></td>
			<td><select name="role">
					<c:forEach items="${roles}" var="role">
						<option value="${role.getIdRole()}">${role.getNom()}</option>
					</c:forEach>
			</select><br></td>
		</tr>
		<tr>
			<td><label>Spécialité: </label></td>
			<td><select name="specialite">
					<c:forEach items="${specialites}" var="specialite">
						<option value="${specialite.getIdSpecialite()}">${specialite.getSpecialite()}</option>
					</c:forEach>
			</select><br></td>
		</tr>
		<tr>
			<td><label>Actif: </label></td>
			<td><input type="checkbox" name="actif"><br></td>
		</tr>
	</table>
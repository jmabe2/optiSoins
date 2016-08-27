<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/equipcs" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="equipcId" value="${equipc.getIdEquipementchambre()}">
	<label>Equipement:</label> 
	<select id="selectEquipement" name="equip">
					<c:forEach items="${equipements}" var="equipement">
						<option value="${equipement.getIdEquipement()}" ${param.equipement == equipement.getIdEquipement() ? "selected" : ""}${equipement.getIdEquipement() == equipement.getIdEquipement() ? "selected" : ""}>${equipement.getNom()}</option>
					</c:forEach>
			</select><br>
	
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/chambres"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/chambres" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
	<label>Numéro de chambre: </label>
	<input type="text" name="name" value="${chambre.getNuméroChambre()}"><br>
	<label>Type de chambre :</label> 
	<select id="selectType" name="type">
					<c:forEach items="${types}" var="typechambre">
						<option value="${typechambre.getIdTypeChambre()}" ${param.typechambre == typechambre.getIdTypeChambre() ? "selected" : ""}${typechambre.getIdTypeChambre() == typechambre.getIdTypeChambre() ? "selected" : ""}>${typechambre.getNom()}</option>
					</c:forEach>
			</select><br>
	
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/chambres"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

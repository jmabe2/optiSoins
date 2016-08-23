<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/chambres" method="post">
	<input type="hidden" name="action" value="savecreate">
	<label>Numero de chambre :</label>  <input type="text" name="numeroChambre"><br>
	<label>Type de chambre :</label> 
	<select id="selectType" name="type">
					<c:forEach items="${types}" var="typechambre">
						<option value="${typechambre.getIdTypeChambre()}" ${param.typechambre == typechambre.getIdTypeChambre() ? "selected" : ""}${typechambre.getTypeChambre().getIdTypeChambre() == typechambre.getIdTypeChambre() ? "selected" : ""}>${typechambre.getNom()}</option>
					</c:forEach>
			</select><br>
	
	<button type="submit">Enregistrer</button>
</form>
<jsp:include page="../footer.jsp"/>

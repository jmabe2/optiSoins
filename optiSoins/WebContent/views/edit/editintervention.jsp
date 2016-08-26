<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/intervention" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="interventionId" value="${intervention.getIdIntervention()}">
	<label>Date de l'intervention : </label>
	<input type="text" class="datepicker" name="date" value=<fmt:formatDate value="${sejour.getDate()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Description de l'intervention : </label>
	<input type="text" name="description" value="${intervention.getDescription()}"><br>
	<label>Nom de l'intervention : </label>
	<input type="text" name="name" value="${intervention.getNom()}"><br>
	<td><label>Type d'intervention: </label></td>
			<td><select id="selectRole" name="typeintervention">
					<c:forEach items="${typeinterventions}" var="typeintervention">
						<option value="${typeintervention.getIdTypeIntervention()}" ${param.role == typeintervention.getIdTypeIntervention() ? "selected" : ""}${intervention.getTypeIntervention()().getIdTypeIntervention()() == typeintervention.getIdTypeIntervention() ? "selected" : ""}>${typeintervention.getNom()}</option>
					</c:forEach>
			</select><br></td>
	<button type="submit">Enregistrer</button>
	
</form>

	<a href="${pageContext.request.contextPath}/intervention"><button>Retour à la liste</button></a>
	<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
<jsp:include page="../footer.jsp"/>
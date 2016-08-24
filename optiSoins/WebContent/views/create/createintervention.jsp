<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/intervention" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<input type="hidden" name="sejourId" value="${param.sejourId}">
	<label>Date de l'intervention : </label>
	<input type="text"  class="datepicker" name="date" value=<fmt:formatDate value="${intervention.getDate()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Description de l'intervention : </label>
	<input type="text" name="desccription" value="${intervention.getDescription()}"><br>
	<label>Nom de l'intervention : </label>
	<input type="text" name="name" value="${intervention.getNom()}"><br>
	
	<tr id="typeintervention">
			<td><label>Type intervention : </label></td>
			<select id="typeintervention" name="typeintervention">
					<c:forEach items="${typeintervention}" var="typeintervention">
						<option value="${typeintervention.getIdTypeIntervention()}" ${param.typeintervention == typeintervention.getIdTypeIntervention() ? "selected" : ""}
						${typeintervention.getIdTypeIntervention () == typeintervention.getIdTypeIntervention() ? "selected" : ""}>${typeintervention.getLibelle()}</option>
					</c:forEach>
			</select>
		</tr>
		<br>
	<button type="submit">Enregistrer</button><br>

</form>

<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
	
<jsp:include page="../footer.jsp"/>

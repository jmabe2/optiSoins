<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/sejours" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	
	<jsp:include page="../form/formsejour.jsp" />
	<button type="submit">Enregistrer</button>
	
</form>
	<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
	<form action="${pageContext.request.contextPath}/patients" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="patientId"
		value="${param.patientId}${sejour.getPatient().getIdPatient()}">
	<button type="submit">Retour au patient</button>
</form>
	
<jsp:include page="../footer.jsp"/>
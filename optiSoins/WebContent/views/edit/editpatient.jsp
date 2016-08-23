<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/patients" method="post">
	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="patientId" value="${patient.getIdPatient()}">
	<jsp:include page="../form/formpatient.jsp" />
	<button type="submit">Enregistrer</button>
</form>
	<a href="${pageContext.request.contextPath}/patients"><button>Retour à la liste</button></a>
<jsp:include page="../footer.jsp"/>

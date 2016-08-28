<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/intervention" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="interventionId" value="${intervention.getIdIntervention()}">
	<jsp:include page="../form/formintervention.jsp" />
	<button type="submit">Enregistrer</button>
	
</form>

	<a href="${pageContext.request.contextPath}/intervention"><button>Retour à la liste</button></a>
	<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
<jsp:include page="../footer.jsp"/>
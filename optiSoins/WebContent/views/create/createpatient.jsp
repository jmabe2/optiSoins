<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<form action="${pageContext.request.contextPath}/patients"
	method="post">
	<input type="hidden" name="action" value="savecreate">
	<jsp:include page="../form/formpatient.jsp" />
	<button type="submit">Enregistrer</button>
</form>
<jsp:include page="../footer.jsp" />

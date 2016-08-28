<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/sejourchambre" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="sejourchambreId" value="${sejourchambre.getIdSejourChambre()}">
	<jsp:include page="../form/formsejourchambre.jsp" />
	<button type="submit">Enregistrer</button>
	
</form>

		<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="sejourId"
		value="${param.sejourId}${sejourchambre.getSejour().getIdSejour()}">
	<button type="submit">Retour au séjour</button>
	</form>
	
<jsp:include page="../footer.jsp"/>
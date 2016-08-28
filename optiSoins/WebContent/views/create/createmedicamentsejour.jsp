<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../header.jsp"/>

                                         
<form action="${pageContext.request.contextPath}/medicamentsejour" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<jsp:include page="../form/formmedicamentsejour.jsp" />
	<button type="submit">Enregistrer</button><br>
	
</form>
	<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="action" value="view"> <input
		type="hidden" name="sejourId"
		value="${param.sejourId}${medicamentsejour.getSejour().getIdSejour()}">
	<button type="submit">Retour au séjour</button>
	</form>


<jsp:include page="../footer.jsp"/>

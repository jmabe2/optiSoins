<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	<input type="hidden" name="action" value="savecreate">
	<label>Libellé : </label><input type="text" name="Libelle">
	<button type="submit">Enregistrer</button>
</form>
<jsp:include page="../footer.jsp"/>

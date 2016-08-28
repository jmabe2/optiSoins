<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/roles" method="post">
	<input type="hidden" name="action" value="savecreate">
	<label>Nom :</label>  <input type="text" name="name"><br>
	<label>Actif :</label>  <input type="checkbox" name="actif" checked><br><br>
	<button type="submit">Enregistrer</button>
</form>
<jsp:include page="../footer.jsp"/>

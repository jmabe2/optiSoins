<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/intervention" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<label>Date de l'intervention : </label>
	<input type="text" name="date" value="${intervention.getDate()}"><br>
	<label>Description de l'intervention : </label>
	<input type="text" name="desccription" value="${intervention.getDescription()}"><br>
	<label>Nom de l'intervention : </label>
	<input type="text" name="name" value="${intervention.getNom()}"><br>
	<button type="submit">Enregistrer</button><br>

</form>
<jsp:include page="../footer.jsp"/>

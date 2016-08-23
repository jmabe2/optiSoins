<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>
<form action="${pageContext.request.contextPath}/sejours" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<label>Date d'entrée :</label> 
	<input type="text" name="dateEntree" value="${sejour.getDateEntree()}"><br>
	<label>Date de sortie : </label>  
	<input type="text" name="dateSortie" value="${sejour.getDateSortie()}"><br>
	<label>Emplacement : </label>  
	<input type="text" name="emplacement" value="${sejour.getSejour()}"><br>
	<label>Motif séjour : </label>  
	<input type="text" name="motifSejour" value="${sejour.getMotifSejour()}"><br>
	<label>Actif : </label>  
	<input type="checkbox" name="actif" value="${sejour.getActif()}"><br>
	<button type="submit">Enregistrer</button><br>

</form>
<jsp:include page="../footer.jsp"/>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../header.jsp"/>

                                         
<form action="${pageContext.request.contextPath}/sejourchambre" method="post">
	
	<input type="hidden" name="action" value="savecreate">
	<label>Date d'entrée :</label> 
	<input type="text" name="dateEntree" value=<fmt:formatDate value="${sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Date de sortie : </label>  
	<input type="text" name="dateSortie" value=<fmt:formatDate value="${sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Actif : </label>  
	<input type="checkbox" name="actif" value="${sejour.getActif()}"><br>
	<button type="submit">Enregistrer</button><br>
	
</form>

<a href=c${pageContext.request.contextPath}/sejourchambre><button>Retour à la liste</button></a>

<jsp:include page="../footer.jsp"/>

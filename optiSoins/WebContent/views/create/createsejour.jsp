<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../header.jsp"/>

                                         
<form action="${pageContext.request.contextPath}/sejours" method="post">
	<input type="hidden" name="patientId" value="${param.patientId}">
	<input type="hidden" name="action" value="savecreate">
	<label>Date d'entrée :</label> 
	<input type="text"  class="datepicker" name="dateEntree" value=<fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Date de sortie : </label>  
	<input type="text" class="datepicker"  name="dateSortie" value=<fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Emplacement : </label>  
	<input type="text" name="emplacement" value="${sejour.getEmplacement()}"><br>
	<label>Motif séjour : </label>  
	<input type="text" name="motifSejour" value="${sejour.getMotifSejour()}"><br>
	<label>Actif : </label>  
	<input type="checkbox" name="actif" value="${sejour.getActif()}"><br>
	<button type="submit">Enregistrer</button><br>
	
</form>

<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>

<a href=c${pageContext.request.contextPath}/sejours><button>Retour à la liste</button></a>

<jsp:include page="../footer.jsp"/>

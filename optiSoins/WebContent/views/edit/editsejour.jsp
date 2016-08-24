<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/sejours" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	<label>Date d'entrée : </label>
	<input type="text" name="dateEntree" class="datepicker" value=<fmt:formatDate value="${sejour.getDateEntree()}" pattern="yyyy-MM-dd" /> > <br>
	<label>Date de sortie : </label>
	<input type="text" name="dateSortie" class="datepicker" value=<fmt:formatDate value="${sejour.getDateSortie()}" pattern="yyyy-MM-dd" /> ><br>
	<label>Emplacement : </label>
	<input type="text" name="emplacement" value="${sejour.getEmplacement()}"><br>
	<label>Motif du Séjour : </label>
	<input type="text" name="motifSejour" value="${sejour.getMotifSejour()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${sejour.getActif() ? "checked" : ""}><br>
	<button type="submit">Enregistrer</button>
	
</form>
	<script type="text/javascript">
		$(".datepicker").flatpickr();
	</script>
	<a href="${pageContext.request.contextPath}/sejours"><button>Retour à la liste</button></a>
	
<jsp:include page="../footer.jsp"/>
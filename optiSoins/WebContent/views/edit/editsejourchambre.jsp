<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

<form action="${pageContext.request.contextPath}/sejourchambre" method="post">

	<input type="hidden" name="action" value="saveedit">
	<input type="hidden" name="sejourchambreId" value="${sejourchambre.getIdSejour()}">
	<label>Date d'entrée : </label>
	<input type="text" name="dateEntree" value=<fmt:formatDate value="${sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" /> > <br>
	<label>Date de sortie : </label>
	<input type="text" name="dateSortie" value=<fmt:formatDate value="${sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" /> ><br>
	<input type="text" name="motif" value="${sejourchambre.getMotifSejour()}"><br>
	<label>Actif: </label>
	<input type="checkbox" name="actif" ${sejourchambre.getActif() ? "checked" : ""}><br>
	<button type="submit">Enregistrer</button>
	
</form>

	<a href="${pageContext.request.contextPath}/sejourchambre"><button>Retour à la liste</button></a>
	
<jsp:include page="../footer.jsp"/>
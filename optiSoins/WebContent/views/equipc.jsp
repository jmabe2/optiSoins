<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/equipcs" method="post">
	
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="sejourId" value="${equipcs.getIdEquipementChambre()}">
	<label>numero chambre : </label> ${equipc.getChambre().getNumeroChambre()}<br>
	<label>Equipement : </label> ${equipc.getEquipement().getNom()}<br>
	<button type="submit">Modifier</button>	
	
</form>
	<a href="${pageContext.request.contextPath}/chambres"><button>Retour à la liste</button></a>
	
<jsp:include page="footer.jsp"/>


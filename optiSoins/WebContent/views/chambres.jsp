<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/chambres" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
	<label>Numero de chambre: </label>${chambre.getNumeroChambre()}<br>
	<label>Type de chambre: </label>${chambre.getTypechambre().getNom()}<br>
	<button type="submit">Modifier</button>	
</form>
	<a href="${pageContext.request.contextPath}/chambres"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

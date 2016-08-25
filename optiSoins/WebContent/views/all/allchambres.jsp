<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Chambres</h2><br>
			<form action="${pageContext.request.contextPath}/chambres" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer une chambre</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Numero de chambre</th>
                    <th>Type de chambre</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${chambres}" var="chambre">
                    <tr>
                        <td>${chambre.getIdChambre()}</td>
                        <td>${chambre.getNumeroChambre()}</td>
                         <td>${chambre.getTypechambre().getNom()}</td>
                        <td>
                         <form action="${pageContext.request.contextPath}/chambres" method="post">
	    					<input type="hidden" name="action" value="view">
	    					<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
	    					<button type="submit">Visualiser</button>
						  </form>
						  </td>
						  <td>
                          <form action="${pageContext.request.contextPath}/chambres" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>						
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>
</html>
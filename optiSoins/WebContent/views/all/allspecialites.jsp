<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>specialites</h2><br>
			<form action="${pageContext.request.contextPath}/specialites" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${specialites}" var="specialite">
                    <tr>
                        <td>${specialite.getIdSpecialite()}</td>
                        <td>${specialite.getSpecialite()}</td>
                        <td>${specialite.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                          <form action="${pageContext.request.contextPath}/specialites" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="specialiteId" value="${specialite.getIdSpecialite()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

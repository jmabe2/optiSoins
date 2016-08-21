<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Roles</h2><br>
			<form action="${pageContext.request.contextPath}/roles" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer un role</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${roles}" var="role">
                    <tr>
                        <td>${role.getIdRole()}</td>
                        <td>${role.getNom()}</td>
                        <td>${role.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                          <form action="${pageContext.request.contextPath}/roles" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="roleId" value="${role.getIdRole()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

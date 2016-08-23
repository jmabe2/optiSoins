<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>S�jours</h2><br>
			<form action="${pageContext.request.contextPath}/sejours" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er un s�jour</button><br><br>
			</form>
			
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Date d'entr�e</th>
 				    <th>Date de sortie</th>                   
 				    <th>Emplacement</th>
 				    <th>Motif du s�jour</th>
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${sejours}" var="sejour">
                    <tr>
                        <td>${sejour.getIdSejour()}</td>
                        <td>${sejour.getDateEntree()}</td>
						<td>${sejour.getDateSortie()}</td>
						<td>${sejour.getEmplacement()}</td>
				        <td>${sejour.getMotifSejour()}</td>
					    <td>${sejour.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                        
                          <form action="${pageContext.request.contextPath}/sejours" method="post">
                          <input type="hidden" name="action" value="edit">
	    				  <input type="hidden" name="sejourId" value="${sejour.getIdSejour()}">
	    				  <button type="submit">Modifier un s�jour</button>
						  
						  </form>
						  </td>
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

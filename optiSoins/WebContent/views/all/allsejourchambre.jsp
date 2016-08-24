<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../header.jsp"/>

			<h2>Changement de chambre</h2><br>
			<form action="${pageContext.request.contextPath}/sejourchambre" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer un séjour</button><br><br>
			</form>
			
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Date d'entrée</th>
 				    <th>Date de sortie</th>                   
                    <th>Actif</th>
                    <th></th>
                </tr>
                <c:forEach items="${Sejourchambre}" var="Sejourchambre">
                    <tr>
                        <td>${Sejourchambre.getIdSejourchambre()}</td>
                        <td><fmt:formatDate value="${Sejourchambre.getDateEntree()}" pattern="yyyy-MM-dd" /></td>
                        <td><fmt:formatDate value="${Sejourchambre.getDateSortie()}" pattern="yyyy-MM-dd" /></td>
					    <td>${Sejourchambre.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                        
             			  <form action="${pageContext.request.contextPath}/Sejourchambre" method="post">
                          <input type="hidden" name="action" value="view">
	    				  <input type="hidden" name="SejourchambreId" value="${Sejourchambre.getIdSejourchambre()}">
	    				  <button type="submit">Visualiser</button>						  
						  </form>
						  
						  </td>
						  <td>
                          <form action="${pageContext.request.contextPath}/Sejourchambre" method="post">
                          <input type="hidden" name="action" value="edit">
	    				  <input type="hidden" name="SejourchambreId" value="${Sejourchambre.getIdSejourchambre()}">
	    				  <button type="submit">Modifier un séjour</button>						  
						  </form>
						  </td>
						  
						  
						  </td>
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

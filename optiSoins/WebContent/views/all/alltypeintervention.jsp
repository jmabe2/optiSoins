<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="../header.jsp"/>

			<h2>Type interventions</h2><br>
			<form action="${pageContext.request.contextPath}/typeintervention" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Cr�er un type d'intervention</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Libell�</th>
                </tr>
                <c:forEach items="${typeintervention}" var="typeintervention">
                    <tr>
                        <td>${typeintervention.getIdTypeIntervention()}</td>
                        <td>${typeintervention.getLibelle()}</td>
                        <td>
                        
                          <form action="${pageContext.request.contextPath}/typeintervention" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="typeinterventionId" value="${typeintervention.getIdTypeIntervention()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

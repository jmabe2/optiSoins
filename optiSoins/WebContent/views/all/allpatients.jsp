<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../header.jsp"/>

			<h2>Patients</h2><br>
			<fieldset>
			<legend>Rechercher</legend>
			<form action="${pageContext.request.contextPath}/patients" method="post">
	    		<input type="hidden" name="action" value="search">
	    		<label>Nom: </label><input type="text" name="searchnom" value="${param.searchnom}">
			    <label>Prenom: </label><input type="text" name="searchprenom" value="${param.searchprenom}">
	    		<button type="submit">Rechercher</button>
			</form>
			</fieldset>
			<form action="${pageContext.request.contextPath}/patients" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer</button>
			</form>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Date Naiss.</th>
                    <th>Actif</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach items="${patients}" var="patient">
                    <tr>
                        <td>${patient.getIdPatient()}</td>
                        <td>${patient.getNom()}</td>
                        <td>${patient.getPrenom()}</td>
                        <td><fmt:formatDate value="${patient.getDateDeNaissance()}" pattern="yyyy-MM-dd" /></td>
                        <td>${patient.getActif() ? "<span class=\"glyphicon glyphicon-check\"  aria-hidden=\"true\"></span>" : "<span class=\"glyphicon glyphicon-unchecked\"  aria-hidden=\"true\"></span>"}</td>
                        <td>
                        <form action="${pageContext.request.contextPath}/patients" method="post">
	    					<input type="hidden" name="action" value="view">
	    					<input type="hidden" name="patientId" value="${patient.getIdPatient()}">
	    					<button type="submit">Visualiser</button>
						  </form>
						  </td>
						  <td>
                          <form action="${pageContext.request.contextPath}/patients" method="post">
	    					<input type="hidden" name="action" value="edit">
	    					<input type="hidden" name="patientId" value="${patient.getIdPatient()}">
	    					<button type="submit">Modifier</button>
						  </form>
						  </td>
	
                    </tr>
                </c:forEach>
            </table>

<jsp:include page="../footer.jsp"/>

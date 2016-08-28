<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/chambres" method="post">
	<input type="hidden" name="action" value="edit">
	<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
	<label>Numero de chambre: </label>${chambre.getNumeroChambre()}<br>
	<label>Type de chambre: </label>${chambre.getTypechambre().getNom()}<br>
	<button type="submit">Modifier</button>	
</form><br>
<form action="${pageContext.request.contextPath}/chambres" method="post">
	    		<input type="hidden" name="action" value="create">
	    		<button type="submit">Créer</button>
			</form>

 <h4><u>Equipements</u></h4><br>
<form action="${pageContext.request.contextPath}/equipcs" method="post">
  		<input type="hidden" name="action" value="create">
  		<input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
  		<button type="submit">Ajouter un équipement</button><br><br>
</form>

<table class="table table-striped">
               <tr>
                   <th>Id</th>
				    <th>Equipement</th>                   
                   <th></th>
               </tr>
               <c:forEach items="${chambre.getEquipementchambres()}" var="equipc">
                   <tr>
                     <td>${equipc.getIdEquipementChambre()}</td>
					<td>${equipc.getEquipement().getNom()}</td>
                       
					  <td>
                         <form action="${pageContext.request.contextPath}/equipcs" method="post">
                         <input type="hidden" name="action" value="remove">
    				  <input type="hidden" name="idEquipementchambre" value="${equipc.getIdEquipementChambre()}">
    				  <input type="hidden" name="chambreId" value="${chambre.getIdChambre()}">
    				  <button type="submit">Retirer equipement</button>						  
					  </form>
					  </td>
                   </tr>
               </c:forEach>
           </table>

	<a href="${pageContext.request.contextPath}/chambres"><button>Retour à la liste</button></a>
<jsp:include page="footer.jsp"/>

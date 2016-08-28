<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<jsp:include page="header.jsp"/>

    <div class="jumbotron">
         <h1>Bienvenue!</h1>
         <p><c:out value="${sessionScope['loginUser'].prenom} ${sessionScope['loginUser'].nom}"></c:out></p>
         <p>Faites votre choix dans le menu</p>  
      </div>   

	<jsp:include page="footer.jsp"/>

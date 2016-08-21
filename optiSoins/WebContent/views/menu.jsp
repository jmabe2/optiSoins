	 <nav class="navbar navbar-inverse navbar-static">
    	<div class="container">
		    <ul class="nav navbar-nav">
		        <li><a href="${pageContext.request.contextPath}/views/welcome.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil</a></li>
		        <li><a href="${pageContext.request.contextPath}/patients"> Patients</a></li>
		        <li><a href="${pageContext.request.contextPath}/intervention"> Interventions</a></li>
		        <li><a href="${pageContext.request.contextPath}/sejours"> S�jours</a></li>
		        <li><a href="${pageContext.request.contextPath}/medicaments"> M�dicaments</a></li>
		        <li class="dropdown">
                	<a href="#" data-toggle="dropdown" class="dropdown-toggle">Configuration<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                    	<li><a href="${pageContext.request.contextPath}/chambres"> Chambres</a></li>
                    	<li><a href="${pageContext.request.contextPath}/utilisateurs"> Utilisateurs</a></li>
                    	<li><a href="${pageContext.request.contextPath}/roles"> R�les</a></li> 
                    	<li><a href="${pageContext.request.contextPath}/specialites"> Sp�cialit�s</a></li>                     
                    </ul>
                </li>
		        <li><a href="${pageContext.request.contextPath}/LogoutServlet"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> D�connexion</a></li>
		    </ul>
		</div>
	</nav>


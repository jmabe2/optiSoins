	 <nav class="navbar navbar-inverse navbar-static">
    	<div class="container">
		    <ul class="nav navbar-nav">
		        <li><a href="welcome.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil</a></li>
		        <li><a href="patients.jsp"> Patients</a></li>
		        <li><a href="intervention.jsp"> Interventions</a></li>
		        <li><a href="sejours.jsp"> S�jours</a></li>
		        <li><a href="medicaments.jsp"> M�dicaments</a></li>
		        <li class="dropdown">
                	<a href="#" data-toggle="dropdown" class="dropdown-toggle">Configuration<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                    	<li><a href="chambres"> Chambres</a></li>
                    	<li><a href="utilisateurs"> Utilisateurs</a></li>
                    	<li><a href="${pageContext.request.contextPath}/roles"> R�les</a></li>                     
                    </ul>
                </li>
		        <li><a href="/optiSoins/LogoutServlet"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> D�connexion</a></li>
		    </ul>
		</div>
	</nav>


package com.optisoins;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Role;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.RoleService;

/**
 * Servlet implementation class CreateRoleServlet
 */
@WebServlet("/CreateRoleServlet")
public class CreateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(CreateRoleServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateRoleServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		EntityManager em = EMF.getEM(); 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em1 = emf.createEntityManager();
		RoleService service = new RoleService(em);

		em.getTransaction().begin();
		
		try {
		
		Role ro = service.createRole(true, "");
		Role ro2 = service.createRole(false, "");
		Role ro3 = service.createRole(false, "");
		Role ro4 = service.createRole(true, "");
		
		em.getTransaction().commit();
	    log.info("Rules created !"); 

		}
		
		catch (Exception e){
			log.error(e,e);
			log.info("Rules not created !"); 
		}

		/* em.getTransaction().begin();
		service.RemoveRole(1);
		service.RemoveRole(2);
		service.RemoveRole(3);
		service.RemoveRole(4);
		em.getTransaction().commit();
	    log.info("Rules deleted !");*/


		/*List <Role> role = service.findAllRole();
		for(Role u : role){
		
		}*/

		em.close();
		emf.close();

		response.sendRedirect("views/welcome.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

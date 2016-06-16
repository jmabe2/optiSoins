package com.optisoins;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger; 
import com.optisoins.model.Role;
import com.optisoins.model.Utilisateur;
import com.optisoins.services.RoleService;


/**
 * Servlet implementation class MyServlet
 */
/**
 * Date 03/06/2016
 * @author Administrateur
 *
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(MyServlet.class);
	
	String name=null;
	String pwd =null;
	
	/**
	 * @author Administrateur
	 * @see HttpServlet#HttpServlet() 
	 */
	
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub 
	}
	
	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Utilisateur user = new Utilisateur();
		String name = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		//response.getWriter().print("Success !");
		//response.sendRedirect(getServletContext().getContextPath()+"/views/welcome.jsp");
		log.debug("Name: " + name + " pw S: " + pwd);
		HttpSession session = request.getSession();
		user.setNom(name);
		session.setAttribute("loginUser", user);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em = emf.createEntityManager();
		RoleService service = new RoleService(em);
		
		/*em.getTransaction().begin();
		Role ro = service.createRole(true, "Fou");
		Role ro2 = service.createRole(false, "ABC");
		Role ro3 = service.createRole(false, "DEF");
		Role ro4 = service.createRole(true, "GHI");
		em.getTransaction().commit();
	    log.info("Rules created !"); */


		/* em.getTransaction().begin();
		service.RemoveRole(1);
		service.RemoveRole(2);
		service.RemoveRole(3);
		service.RemoveRole(4);
		em.getTransaction().commit();
	    log.info("Rules deleted !");*/
		
		
		/*List<Role> role = service.findAllRole();
		for(Role u : role){
		*/
			
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

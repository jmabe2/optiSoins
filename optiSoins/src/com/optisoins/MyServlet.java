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

import com.optisoins.model.Role;
import com.optisoins.model.Utilisateur;
import com.optisoins.services.RoleService;
import com.optisoins.services.UtilisateurService;


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

	String name=null;
	String id=null; 

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

		String name = request.getParameter("name");
		String id = request.getParameter("ID");
		//response.getWriter().print("Testing Success !");
		
		response.sendRedirect(getServletContext().getContextPath()+"/views/welcome.jsp");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em = emf.createEntityManager();
		RoleService service = new RoleService(em);
		
		em.getTransaction().begin();
		Role ro = service.createRole(1, true, "Fou");
		//Utilisateur util = service.createUtilisateur(1, true, "fou", "fou1234");
		em.getTransaction().commit();
		System.out.println(ro+ "is persisted");
		
		List<Role> role = service.findAllRole();
		for(Role u : role){
			System.out.println(u+ "is existing");
			
			em.close();
			emf.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);





	}

}

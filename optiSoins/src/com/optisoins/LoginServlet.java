package com.optisoins;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.optisoins.connection.EMF;
import com.optisoins.entities.Patient;
import com.optisoins.entities.Role;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.RoleService;


/**
 * Servlet implementation class LoginServlet
 */
/**
 * Date 03/06/2016
 * @author Administrateur
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Logger log = Logger.getLogger(LoginServlet.class);

	/**
	 * @author Administrateur
	 * @see HttpServlet#HttpServlet() 
	 */

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub 
	}

	/** 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		Utilisateur user = new Utilisateur();
		String name = request.getParameter("login");
		String pwd = request.getParameter("pwd");
		EntityManager em = EMF.getEM();
		HttpSession session = request.getSession();
		TypedQuery<Utilisateur> query = em.createQuery("SELECT u from Utilisateur U where u.login like :login and u.motDePasse like :pwd", Utilisateur.class);
		query.setParameter("login", request.getParameter("login"));
		query.setParameter("pwd", request.getParameter("pwd"));
		try {
		user = query.getSingleResult();
			session.setAttribute("loginUser", user);
			response.sendRedirect(getServletContext().getContextPath()+"/views/welcome.jsp");
		} catch(NoResultException e) {
			response.sendRedirect(getServletContext().getContextPath()+"/views/signin.jsp");
		}
		




	}

}

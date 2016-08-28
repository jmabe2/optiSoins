package com.optisoins;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.UtilisateurService;
import com.optisoins.services.RoleService;
import com.optisoins.services.SpecialiteService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class utilisateurServlet
 */
@WebServlet("/utilisateurs")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(UtilisateurServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UtilisateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin"))) {	
		EntityManager em = EMF.getEM();
		UtilisateurService service = new UtilisateurService(em);
		request.setAttribute("utilisateurs", service.findAllUtilisateur());
		this.getServletContext().getRequestDispatcher("/views/all/allutilisateurs.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin"))) {	
		String jspview = "";
		String action = request.getParameter("action");
		EntityManager em = EMF.getEM();
		UtilisateurService service = new UtilisateurService(em);
		RoleService roleService = new RoleService(em);
		SpecialiteService specialiteService = new SpecialiteService(em);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> erreurs;

		// case View
		if (action.equalsIgnoreCase("view")) {
			jspview = "/views/viewutilisateur.jsp";
			int utilisateurId = Integer.parseInt(request.getParameter("utilisateurId"));
			Utilisateur utilisateur = service.findUtilisateur(utilisateurId);
			request.setAttribute("utilisateur", utilisateur);
			// case Edit
		} else if (action.equalsIgnoreCase("edit")) {
			request.setAttribute("roles", roleService.findAllRole());
			request.setAttribute("specialites", specialiteService.findAllSpecialite());
			jspview = "/views/edit/editutilisateur.jsp";
			int utilisateurId = Integer.parseInt(request.getParameter("utilisateurId"));
			Utilisateur utilisateur = service.findUtilisateur(utilisateurId);
			request.setAttribute("utilisateur", utilisateur);
			// case Create
		} else if (action.equalsIgnoreCase("create")) {
			request.setAttribute("roles", roleService.findAllRole());
			request.setAttribute("specialites", specialiteService.findAllSpecialite());
			jspview = "/views/create/createutilisateur.jsp";
		} else if (action.equalsIgnoreCase("saveedit")) {
			erreurs = service.validate(request);
			if (erreurs.isEmpty()) {
				jspview = "/views/viewutilisateur.jsp";
				em.getTransaction().begin();
				try {

					Utilisateur utilisateur = service
							.updateUtilisateur(Integer.parseInt(request.getParameter("utilisateurId")),
									(request.getParameter("actif") != null), request.getParameter("nom"),
									request.getParameter("prenom"), request.getParameter("sexe"),
									sdf.parse(request.getParameter("datenaiss")), request.getParameter("login"),
									request.getParameter("mdp"),
									roleService.findRole(Integer.parseInt(
											request.getParameter("role"))),
									(request.getParameter("specialite") != null ? specialiteService.findSpecialite(
											Integer.parseInt(request.getParameter("specialite"))) : null));
					em.getTransaction().commit();
					log.info("utilisateur updated !");
					request.setAttribute("utilisateur", utilisateur);
				} catch (Exception e) {
					log.error(e, e);
					log.info("utilisateur not updated !");
				}
			} else {
				request.setAttribute("erreurs", erreurs);
				request.setAttribute("roles", roleService.findAllRole());
				request.setAttribute("specialites", specialiteService.findAllSpecialite());
				jspview = "/views/edit/editutilisateur.jsp";

			}

		} else if (action.equalsIgnoreCase("savecreate")) {
			erreurs = service.validate(request);
			if (erreurs.isEmpty()) {
				jspview = "/views/viewutilisateur.jsp";

				try {

					em.getTransaction().begin();
					Utilisateur utilisateur = service
							.createUtilisateur((request.getParameter("actif") != null), request.getParameter("nom"),
									request.getParameter("prenom"), request.getParameter("sexe"),
									sdf.parse(request.getParameter("datenaiss")), request.getParameter("login"),
									request.getParameter("mdp"),
									roleService.findRole(Integer.parseInt(
											request.getParameter("role"))),
									(request.getParameter("specialite") != null ? specialiteService.findSpecialite(
											Integer.parseInt(request.getParameter("specialite"))) : null));

					em.getTransaction().commit();
					log.info("utilisateur created !");

					request.setAttribute("utilisateur", utilisateur);
				} catch (Exception e) {
					log.error(e, e);
					log.info("utilisateur not created !");
				}
			} else {
				request.setAttribute("roles", roleService.findAllRole());
				request.setAttribute("specialites", specialiteService.findAllSpecialite());
				jspview = "/views/create/createutilisateur.jsp";
				request.setAttribute("erreurs", erreurs);
			}

		} else if (action.equalsIgnoreCase("delete")) {
			int utilisateurId = Integer.parseInt(request.getParameter("utilisateurId"));
			em.getTransaction().begin();
			try {
				service.RemoveUtilisateur(utilisateurId);
				log.info("utilisateur deleted !");
			} catch (Exception e) {
				log.error(e, e);
				log.info("utilisateur not deleted !");
			}

			jspview = "/views/all/allutilisateurs.jsp";
			request.setAttribute("utilisateurs", service.findAllUtilisateur());
		}
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

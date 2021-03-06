package com.optisoins;

import java.io.IOException;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Specialite;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.SpecialiteService;
import com.optisoins.services.UtilisateurService;

/**
 * Servlet implementation class specialiteServlet
 */
@WebServlet("/specialites")
public class SpecialiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(SpecialiteServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SpecialiteServlet() {
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
			SpecialiteService service = new SpecialiteService(em);
			request.setAttribute("specialites", service.findAllSpecialite());
			this.getServletContext().getRequestDispatcher("/views/all/allspecialites.jsp").forward(request, response);
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
			SpecialiteService service = new SpecialiteService(em);

			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				jspview = "/views/edit/editspecialite.jsp";
				int specialiteId = Integer.parseInt(request.getParameter("specialiteId"));
				Specialite specialite = service.findSpecialite(specialiteId);
				request.setAttribute("specialite", specialite);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {
				jspview = "/views/create/createspecialite.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/viewspecialite.jsp";
				em.getTransaction().begin();
				try {

					Specialite specialite = service.updateSpecialite(
							Integer.parseInt(request.getParameter("specialiteId")),
							(request.getParameter("actif") != null), request.getParameter("name"));
					em.getTransaction().commit();
					log.info("specialite updated !");
					request.setAttribute("specialite", specialite);
				} catch (Exception e) {
					log.error(e, e);
					log.info("specialite not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/viewspecialite.jsp";
				em.getTransaction().begin();
				try {

					Specialite specialite = service.createSpecialite((request.getParameter("actif") != null),
							request.getParameter("name"));
					em.getTransaction().commit();
					log.info("specialite created !");
					request.setAttribute("specialite", specialite);
				} catch (Exception e) {
					log.error(e, e);
					log.info("specialite not created !");
				}

			} else if (action.equalsIgnoreCase("delete")) {
				int specialiteId = Integer.parseInt(request.getParameter("specialiteId"));
				em.getTransaction().begin();
				try {
					service.RemoveSpecialite(specialiteId);
					log.info("specialite deleted !");
				} catch (Exception e) {
					log.error(e, e);
					log.info("specialite not deleted !");
				}

				jspview = "/views/all/allspecialites.jsp";
				;
				request.setAttribute("specialites", service.findAllSpecialite());
			}
			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

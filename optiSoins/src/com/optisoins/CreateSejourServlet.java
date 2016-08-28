package com.optisoins;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Sejour;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.SejourService;
import com.optisoins.services.UtilisateurService;

/**
 * Servlet implementation class CreateSejour
 */
@WebServlet("/sejours")

public class CreateSejourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CreateSejourServlet.class);

	/**
	 * @see HttpServlet#HttpSevlet()
	 */
	public CreateSejourServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin", "Médecin", "Infirmière"))) {
			EntityManager em = EMF.getEM();
			SejourService service = new SejourService(em);
			request.setAttribute("sejours", service.findAllSejour());
			this.getServletContext().getRequestDispatcher("/views/all/allsejour.jsp").forward(request, response);
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
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin", "Médecin", "Infirmière"))) {
			String jspview = "";
			String action = request.getParameter("action");
			EntityManager em = EMF.getEM();
			SejourService service = new SejourService(em);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, String> erreurs;
			// case view
			if (action.equalsIgnoreCase("view")) {
				jspview = "/views/viewsejour.jsp";
				int sejourId = Integer.parseInt(request.getParameter("sejourId"));
				Sejour sej = service.findSejour(sejourId);
				request.setAttribute("sejour", sej);
			}

			else if (action.equalsIgnoreCase("edit")) {
				jspview = "/views/edit/editsejour.jsp";
				int sejourId = Integer.parseInt(request.getParameter("sejourId"));
				Sejour sej = service.findSejour(sejourId);
				request.setAttribute("sejour", sej);

				// case Create

			} else if (action.equalsIgnoreCase("create")) {
				jspview = "/views/create/createsejour.jsp";

				// case update

			} else if (action.equalsIgnoreCase("saveedit")) {
				erreurs = service.validate(request);
				if (erreurs.isEmpty()) {
				jspview = "/views/viewsejour.jsp";
				em.getTransaction().begin();
				try {

					Sejour sej = service.updateSejour(Integer.parseInt(request.getParameter("sejourId")),
							(request.getParameter("actif") != null), (sdf.parse(request.getParameter("dateEntree"))),
							(sdf.parse(request.getParameter("dateSortie"))), request.getParameter("emplacement"),
							request.getParameter("motifSejour"));

					em.getTransaction().commit();
					log.info("Stays updated !");
					request.setAttribute("sejour", sej);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Stays not updated !");
				}
				} else {
					request.setAttribute("erreurs", erreurs);
					jspview = "/views/edit/editsejour.jsp";

				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				erreurs = service.validate(request);
				if (erreurs.isEmpty()) {
				jspview = "/views/viewsejour.jsp";
				em.getTransaction().begin();
				try {

					Sejour sej = service.createSejour((request.getParameter("actif") != null),
							(sdf.parse(request.getParameter("dateEntree"))),
							(sdf.parse(request.getParameter("dateSortie"))), request.getParameter("emplacement"),
							request.getParameter("motifSejour"), Integer.parseInt(request.getParameter("patientId")));

					em.getTransaction().commit();
					log.info("Stays created !");
					request.setAttribute("sejour", sej);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Stays not created !");
				}

				} else {
					request.setAttribute("erreurs", erreurs);
					jspview = "/views/create/createsejour.jsp";

				}
			}
			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

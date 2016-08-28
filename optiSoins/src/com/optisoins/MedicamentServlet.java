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
import com.optisoins.entities.Medicament;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.MedicamentService;
import com.optisoins.services.UtilisateurService;

/**
 * Servlet implementation class MedicamentServlet
 */
@WebServlet("/medicaments")
public class MedicamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MedicamentServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicamentServlet() {
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
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin", "Pharmacien"))) {
			EntityManager em = EMF.getEM();
			MedicamentService service = new MedicamentService(em);
			request.setAttribute("medicaments", service.findAllMedicament());
			this.getServletContext().getRequestDispatcher("/views/all/allmedicaments.jsp").forward(request, response);
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
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin", "Pharmacien"))) {
			String jspview = "";
			String action = request.getParameter("action");
			EntityManager em = EMF.getEM();
			MedicamentService service = new MedicamentService(em);

			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				jspview = "/views/edit/editmedicament.jsp";
				int medicamentId = Integer.parseInt(request.getParameter("medicamentId"));
				Medicament medic = service.findMedicament(medicamentId);
				request.setAttribute("medicament", medic);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {
				jspview = "/views/create/createmedicament.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/medicaments.jsp";
				em.getTransaction().begin();
				try {

					Medicament medic = service.updateMedicament(Integer.parseInt(request.getParameter("medicamentId")),
							request.getParameter("name"), request.getParameter("description"),
							Integer.parseInt(request.getParameter("quantiteDispo")),
							(request.getParameter("actif") != null));
					em.getTransaction().commit();
					log.info("Medicament updated !");
					request.setAttribute("medicament", medic);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Medicament not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/medicaments.jsp";
				em.getTransaction().begin();
				try {

					Medicament medic = service.createMedicament(request.getParameter("name"),
							request.getParameter("description"),
							Integer.parseInt(request.getParameter("quantiteDispo")),
							(request.getParameter("actif") != null));
					em.getTransaction().commit();
					log.info("Medicament created !");
					request.setAttribute("medicament", medic);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Medicament not created !");
				}

			} else if (action.equalsIgnoreCase("delete")) {
				int medicamentId = Integer.parseInt(request.getParameter("medicamentId"));
				em.getTransaction().begin();
				try {
					service.RemoveMedicament(medicamentId);
					log.info("Medicament deleted !");
				} catch (Exception e) {
					log.error(e, e);
					log.info("Medicament not deleted !");
				}

				jspview = "/views/all/allmedicaments.jsp";
				;
				request.setAttribute("medicaments", service.findAllMedicament());
			}
			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

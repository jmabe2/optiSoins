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
import com.optisoins.entities.Medicamentsejour;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.MedicamentSejourService;
import com.optisoins.services.UtilisateurService;
import com.optisoins.services.MedicamentService;

/**
 * Servlet implementation class MedicamentsejourServlet
 */
@WebServlet("/medicamentsejour")
public class MedicamentsejourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MedicamentsejourServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MedicamentsejourServlet() {
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

		this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);

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
			MedicamentService medicamentService = new MedicamentService(em);
			MedicamentSejourService service = new MedicamentSejourService(em);

			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				request.setAttribute("medicaments", medicamentService.findAllMedicament());
				jspview = "/views/edit/editmedicamentsejour.jsp";
				int medicamentsejourId = Integer.parseInt(request.getParameter("medicamentsejourId"));
				Medicamentsejour sejch = service.findMedicamentSejour(medicamentsejourId);
				request.setAttribute("medicamentsejour", sejch);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {
				request.setAttribute("medicaments", medicamentService.findAllMedicament());
				jspview = "/views/create/createmedicamentsejour.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/viewmedicamentsejour.jsp";
				em.getTransaction().begin();
				try {

					Medicamentsejour medsej = service.updateMedicamentsejour(
							Integer.parseInt(request.getParameter("medicamentsejourId")),
							(request.getParameter("actif") != null),
							Integer.parseInt(request.getParameter("medicament")), request.getParameter("indication"),
							request.getParameter("posologie"), request.getParameter("remarque"),
							Integer.parseInt(request.getParameter("sejourId")));

					em.getTransaction().commit();
					log.info("Medicamentsejours updated !");
					request.setAttribute("medicamentsejour", medsej);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Medicamentsejours not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/viewmedicamentsejour.jsp";
				em.getTransaction().begin();
				try {

					Medicamentsejour medsej = service.createMedicamentsejour((request.getParameter("actif") != null),
							Integer.parseInt(request.getParameter("medicament")), request.getParameter("indication"),
							request.getParameter("posologie"), request.getParameter("remarque"),
							Integer.parseInt(request.getParameter("sejourId")));
					em.getTransaction().commit();
					log.info("Medicamentsejours created !");
					request.setAttribute("medicamentsejour", medsej);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Medicamentsejour not created !");
				}
			}

			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}

	}

}

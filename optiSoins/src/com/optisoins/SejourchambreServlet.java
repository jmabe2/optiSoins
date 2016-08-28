package com.optisoins;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Sejourchambre;
import com.optisoins.entities.Chambre;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.SejourChambreService;
import com.optisoins.services.ChambreService;
import com.optisoins.services.UtilisateurService;

/**
 * Servlet implementation class SejourchambreServlet
 */
@WebServlet("/sejourchambre")
public class SejourchambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(SejourchambreServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SejourchambreServlet() {
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
			SejourChambreService service = new SejourChambreService(em);
			ChambreService chambreService = new ChambreService(em);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Map<String, String> erreurs;
			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				jspview = "/views/edit/editsejourchambre.jsp";
				int sejourchambreId = Integer.parseInt(request.getParameter("sejourchambreId"));
				Sejourchambre sejch = service.findSejourChambre(sejourchambreId);
				request.setAttribute("sejourchambre", sejch);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {

				jspview = "/views/create/createsejourchambre.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				erreurs = service.validate(request);
				if (erreurs.isEmpty()) {
					jspview = "/views/viewsejourchambre.jsp";
					em.getTransaction().begin();
					try {
						Chambre chambre = chambreService
								.findByNum(Integer.parseInt(request.getParameter("numchambre")));
						Sejourchambre sejch = service.updateSejourchambre(
								Integer.parseInt(request.getParameter("sejourchambreId")),
								(request.getParameter("actif") != null), sdf.parse(request.getParameter("dateEntree")),
								sdf.parse(request.getParameter("dateSortie")), chambre,
								Integer.parseInt(request.getParameter("sejourId")));

						em.getTransaction().commit();
						log.info("Sejourchambres updated !");
						request.setAttribute("sejourchambre", sejch);
					} catch (Exception e) {
						log.error(e, e);
						log.info("Sejourchambres not updated !");
					}
				} else {
					request.setAttribute("erreurs", erreurs);
					jspview = "/views/edit/editsejourchambre.jsp";

				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				erreurs = service.validate(request);
				if (erreurs.isEmpty()) {
					jspview = "/views/viewsejourchambre.jsp";
					em.getTransaction().begin();
					try {
						Chambre chambre = chambreService
								.findByNum(Integer.parseInt(request.getParameter("numchambre")));
						Sejourchambre sejch = service.createSejourchambre((request.getParameter("actif") != null),
								sdf.parse(request.getParameter("dateEntree")),
								sdf.parse(request.getParameter("dateSortie")), chambre,
								Integer.parseInt(request.getParameter("sejourId")));
						em.getTransaction().commit();
						log.info("Sejourchambres created !");
						request.setAttribute("sejourchambre", sejch);
					} catch (Exception e) {
						log.error(e, e);
						log.info("Sejourchambre not created !");
					}
				} else {
					request.setAttribute("erreurs", erreurs);
					jspview = "/views/create/createsejourchambre.jsp";

				}
			}

			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);

		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}

	}

}

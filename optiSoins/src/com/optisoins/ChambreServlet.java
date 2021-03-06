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
import com.optisoins.entities.Chambre;
import com.optisoins.services.ChambreService;
import com.optisoins.services.TypechambreService;
import com.optisoins.services.UtilisateurService;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.EquipementchambreService;

/**
 * Servlet implementation class ChambreServlet
 */
@WebServlet("/chambres")
public class ChambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ChambreServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChambreServlet() {
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
			ChambreService service = new ChambreService(em);
			request.setAttribute("chambres", service.findAllChambre());
			this.getServletContext().getRequestDispatcher("/views/all/allchambres.jsp").forward(request, response);
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
			ChambreService service = new ChambreService(em);
			TypechambreService typeChambreService = new TypechambreService(em);
			EquipementchambreService equipService = new EquipementchambreService(em);

			// case Edit
			if (action.equalsIgnoreCase("view")) {
				jspview = "/views/chambres.jsp";
				int chambreId = Integer.parseInt(request.getParameter("chambreId"));
				Chambre chambre = service.findChambre(chambreId);
				request.setAttribute("chambre", chambre);
				request.setAttribute("equipcs", equipService.findAllEquipementchambre(chambreId));

			} else if (action.equalsIgnoreCase("edit")) {
				request.setAttribute("types", typeChambreService.findAllTypechambre());
				jspview = "/views/edit/editchambre.jsp";
				int chambreId = Integer.parseInt(request.getParameter("chambreId"));
				Chambre chambre = service.findChambre(chambreId);
				request.setAttribute("chambre", chambre);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {
				request.setAttribute("types", typeChambreService.findAllTypechambre());
				jspview = "/views/create/createchambre.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/chambres.jsp";
				em.getTransaction().begin();
				try {

					Chambre chambre = service.updateChambre(Integer.parseInt(request.getParameter("chambreId")),
							Integer.parseInt(request.getParameter("numeroChambre")),
							typeChambreService.findTypechambre(Integer.parseInt(request.getParameter("type"))));
					em.getTransaction().commit();
					log.info("Chambre updated !");
					request.setAttribute("chambre", chambre);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Chambre not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/chambres.jsp";
				em.getTransaction().begin();
				try {

					Chambre chambre = service.createChambre(Integer.parseInt(request.getParameter("numeroChambre")),
							typeChambreService.findTypechambre(Integer.parseInt(request.getParameter("type"))));
					em.getTransaction().commit();
					log.info("Chambre created !");
					request.setAttribute("chambre", chambre);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Chambre not created !");
				}

			}
			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}
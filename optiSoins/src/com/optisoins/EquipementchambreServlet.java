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
import com.optisoins.services.UtilisateurService;
import com.optisoins.entities.Utilisateur;
import com.optisoins.entities.Equipement;
import com.optisoins.services.EquipementService;
import com.optisoins.services.EquipementchambreService;
import com.optisoins.entities.Equipementchambre;

/**
 * Servlet implementation class EquipementchambreServlet
 */
@WebServlet("/equipcs")
public class EquipementchambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ChambreServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EquipementchambreServlet() {
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
			EquipementchambreService service = new EquipementchambreService(em);
			request.setAttribute("equipc", service.findAllEquipementchambre());
			this.getServletContext().getRequestDispatcher("/views/all/allequipc.jsp").forward(request, response);
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
			EquipementchambreService service = new EquipementchambreService(em);
			EquipementService equipementService = new EquipementService(em);

			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				request.setAttribute("equipements", equipementService.findAllEquipement());
				jspview = "/views/edit/editequipc.jsp";
				int equipcId = Integer.parseInt(request.getParameter("equipcId"));
				Equipementchambre equipc = service.findEquipementchambre(equipcId);
				request.setAttribute("equipc", equipc);

				// case Createc
			} else if (action.equalsIgnoreCase("create")) {
				request.setAttribute("equipements", equipementService.findAllEquipement());
				jspview = "/views/create/createequipc.jsp";
			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/equipc.jsp";
				em.getTransaction().begin();
				try {

					Equipementchambre equipc = service.updateEquipementchambre(
							Integer.parseInt(request.getParameter("equipcId")),
							Integer.parseInt(request.getParameter("equip")));
					em.getTransaction().commit();
					log.info("Equipement chambre updated !");
					request.setAttribute("equipc", equipc);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Equipement chambre not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/chambres.jsp";

				try {
					em.getTransaction().begin();
					Equipementchambre equipc = service.createEquipementchambre(
							Integer.parseInt(request.getParameter("chambreId")),
							Integer.parseInt(request.getParameter("equip")));
					em.getTransaction().commit();
					log.info("Equipement chambre created !");

					request.setAttribute("chambre", equipc.getChambre());
				} catch (Exception e) {
					log.error(e, e);
					log.info("Equipement chambre not created !");
				}

			} else if (action.equalsIgnoreCase("remove")) {
				jspview = "/views/chambres.jsp";

				try {
					em.getTransaction().begin();
					Equipementchambre equipementChambre = service
							.findEquipementchambre(Integer.parseInt(request.getParameter("idEquipementchambre")));
					Equipement equipement = equipementChambre.getEquipement();
					Chambre chambre = equipementChambre.getChambre();
					chambre.removeEquipementchambre(equipementChambre);
					equipement.removeEquipementchambre(equipementChambre);
					em.remove(equipementChambre);

					em.getTransaction().commit();
					log.info("Equipement chambre removed !");

					request.setAttribute("chambre", chambre);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Equipement chambre not removed!");
				}

			}
			em.close();

			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

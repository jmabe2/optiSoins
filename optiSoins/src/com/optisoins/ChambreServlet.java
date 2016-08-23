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
import com.optisoins.entities.Chambre;
import com.optisoins.services.ChambreService;
import com.optisoins.services.TypechambreService;
import com.optisoins.services.EquipementService;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class utilisateurServlet
 */
@WebServlet("/utilisateurs")
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
		EntityManager em = EMF.getEM();
		ChambreService service = new ChambreService(em);
		request.setAttribute("chambre", service.findAllChambre());
		this.getServletContext().getRequestDispatcher("/views/all/allchambres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String jspview = "";
		String action = request.getParameter("action");
		EntityManager em = EMF.getEM();
		ChambreService service = new ChambreService(em);
		TypechambreService typechambreService = new TypechambreService(em);
		EquipementService equipementService = new EquipementService(em);
		Map<String, String> erreurs;

		// case View
		if (action.equalsIgnoreCase("view")) {
			jspview = "/views/chambres.jsp";
			int chambreId = Integer.parseInt(request.getParameter("chambreId"));
			Chambre chambre = service.findChambre(chambreId);
			request.setAttribute("chambre", chambre);
			// case Edit
		} else if (action.equalsIgnoreCase("edit")) {
			request.setAttribute("typeChambres", typechambreService.findAllTypechambre());
			request.setAttribute("equipements", equipementService.findAllEquipement());
			jspview = "/views/edit/editchambre.jsp";
			int chambreId = Integer.parseInt(request.getParameter("chambreId"));
			Chambre chambre = service.findChambre(chambreId);
			request.setAttribute("chambre", chambre);
			// case Create
		} else if (action.equalsIgnoreCase("create")) {
			request.setAttribute("typeChambres", typechambreService.findAllTypechambre());
			request.setAttribute("equipements", equipementService.findAllEquipement());
			jspview = "/views/create/createutilisateur.jsp";
		} else if (action.equalsIgnoreCase("saveedit")) {
			jspview="/views/chambres.jsp";
        	em.getTransaction().begin();
				try {

					Chambre chambre = service.updateChambre(Integer.parseInt(request.getParameter("chambreId")),
									Integer.parseInt(request.getParameter("numeroChambre")),
									typechambreService.findTypechambre(Integer.parseInt(
											request.getParameter("typeChambre"))));
					em.getTransaction().commit();
					log.info("chambre updated !");
					request.setAttribute("chambre", chambre);
				} catch (Exception e) {
					log.error(e, e);
					log.info("chambre not updated !");
				}
			} else {
				request.setAttribute("typeChambres", typechambreService.findAllTypechambre());
				jspview = "/views/edit/editchambre.jsp";

			}

				try {

					Chambre chambre = service.createChambre(Integer.parseInt(request.getParameter("numeroChambre")),
									typechambreService.findTypechambre(Integer.parseInt(
											request.getParameter("typeChambre"))));

					em.getTransaction().commit();
					log.info("chambre created !");

					request.setAttribute("chambre", chambre);
				} catch (Exception e) {
					log.error(e, e);
					log.info("chambre not created !");
				}			
	
	}  else if (action.equalsIgnoreCase("delete")) {
			int chambreId = Integer.parseInt(request.getParameter("chambreId"));
			em.getTransaction().begin();}
			try {
				service.RemoveChambre(chambreId);
				log.info("chambre deleted !");
			} catch (Exception e) {
				log.error(e, e);
				log.info("chambre not deleted !");
			}

			jspview = "/views/all/allchambres.jsp";
			request.setAttribute("chambres", service.findAllChambre());
		}
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward(request, response);

	}

}

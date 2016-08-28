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
import com.optisoins.entities.Patient;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.SejourService;
import com.optisoins.services.PatientService;
import com.optisoins.services.RoleService;
import com.optisoins.services.SpecialiteService;
import com.optisoins.services.UtilisateurService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class patientServlet
 */
@WebServlet("/patients")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(PatientServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientServlet() {
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
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin","Médecin","Infirmière"))) {
		EntityManager em = EMF.getEM();
		PatientService service = new PatientService(em);
		request.setAttribute("patients", service.findAllPatient());
		this.getServletContext().getRequestDispatcher("/views/all/allpatients.jsp").forward(request, response);
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
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin","Médecin","Infirmière"))) {
		String jspview = "";
		String action = request.getParameter("action");
		EntityManager em = EMF.getEM();
		PatientService service = new PatientService(em);
		SejourService sejourService = new SejourService(em);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> erreurs;

		// case View
		if (action.equalsIgnoreCase("view")) {
			jspview = "/views/viewpatient.jsp";
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			Patient patient = service.findPatient(patientId);
			request.setAttribute("patient", patient);
			request.setAttribute("sejours", sejourService.findSejoursPatient(patientId));
		} else if (action.equalsIgnoreCase("search")) {
			jspview = "/views/all/allpatients.jsp";
			request.setAttribute("patients", service.searchPatients(request.getParameter("searchnom"),request.getParameter("searchprenom")));		
			// case Edit
		} else if (action.equalsIgnoreCase("edit")) {
			jspview = "/views/edit/editpatient.jsp";
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			Patient patient = service.findPatient(patientId);
			request.setAttribute("patient", patient);
			// case Create
		} else if (action.equalsIgnoreCase("create")) {
			jspview = "/views/create/createpatient.jsp";
		} else if (action.equalsIgnoreCase("saveedit")) {
			erreurs = service.validate(request);
			if (erreurs.isEmpty()) {
				jspview = "/views/viewpatient.jsp";
				em.getTransaction().begin();
				try {

					Patient patient = service
							.updatePatient(Integer.parseInt(request.getParameter("patientId")),
									(request.getParameter("actif") != null), request.getParameter("nom"),
									request.getParameter("prenom"), request.getParameter("sexe"),
									sdf.parse(request.getParameter("datenaiss")), request.getParameter("adresse"));
					em.getTransaction().commit();
					log.info("patient updated !");
					request.setAttribute("patient", patient);
				} catch (Exception e) {
					log.error(e, e);
					log.info("patient not updated !");
				}
			} else {
				request.setAttribute("erreurs", erreurs);
				jspview = "/views/edit/editpatient.jsp";

			}

		} else if (action.equalsIgnoreCase("savecreate")) {
			erreurs = service.validate(request);
			if (erreurs.isEmpty()) {
				jspview = "/views/viewpatient.jsp";

				try {

					em.getTransaction().begin();
					Patient patient = service
							.createPatient((request.getParameter("actif") != null), request.getParameter("nom"),
									request.getParameter("prenom"), request.getParameter("sexe"),
									sdf.parse(request.getParameter("datenaiss")), request.getParameter("adresse"));

					em.getTransaction().commit();
					log.info("patient created !");

					request.setAttribute("patient", patient);
				} catch (Exception e) {
					log.error(e, e);
					log.info("patient not created !");
				}
			} else {
				jspview = "/views/create/createpatient.jsp";
				request.setAttribute("erreurs", erreurs);
			}

		} else if (action.equalsIgnoreCase("delete")) {
			int patientId = Integer.parseInt(request.getParameter("patientId"));
			em.getTransaction().begin();
			try {
				service.RemovePatient(patientId);
				log.info("patient deleted !");
			} catch (Exception e) {
				log.error(e, e);
				log.info("patient not deleted !");
			}

			jspview = "/views/all/allpatients.jsp";
			request.setAttribute("patients", service.findAllPatient());
		}
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

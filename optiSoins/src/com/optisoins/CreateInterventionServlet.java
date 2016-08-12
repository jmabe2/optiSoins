package com.optisoins;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Intervention;
import com.optisoins.services.InterventionService;

/**
 * Servlet implementation class InterventionServlet
 */
@WebServlet("/InterventionServlet")
public class CreateInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LoginServlet.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateInterventionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.setContentType("text/html");    
		PrintWriter pw = response.getWriter(); 

		EntityManager em = EMF.getEM(); 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em1 = emf.createEntityManager();
		InterventionService service = new InterventionService(em1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		em1.getTransaction().begin();  //create interventions in the db

		try {
			
			/*String dateInterv = request.getParameter("dateInterv");  
			String nomInterv = request.getParameter("nomInterv");  
			String descripInterv = request.getParameter("descripInterv");  */
		
			Intervention interv1 = service.createIntervention(formatter.parse("2015-08-11"), "Fou","ad");
			Intervention interv2 = service.createIntervention(formatter.parse("2015-08-12"), "Fou","ad");
			Intervention interv3 = service.createIntervention(formatter.parse("2015-08-13"), "Fou","ad");

			em1.getTransaction().commit();
			log.info("Interventions created !"); 

		}
		catch (Exception e){
			log.error(e,e);
			log.info("Interventions not created !"); 
		}




		/*  List<Intervention> interv = service.findAllIntervention();
		for(Intervention u : interv){
	          pw.println(interv);  
		 } 
		 em.getTransaction().begin(); // remove data from the db
		service.RemoveIntervention(1);
		em.getTransaction().commit();
	    log.info("Interventions deleted !");*/

		em1.close();
		emf.close();

		response.sendRedirect("views/intervention.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);



	}


}

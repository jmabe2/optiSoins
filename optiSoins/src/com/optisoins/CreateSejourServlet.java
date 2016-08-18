package com.optisoins;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import com.optisoins.connection.EMF;
import com.optisoins.entities.Intervention;
import com.optisoins.entities.Sejour;
import com.optisoins.services.InterventionService;
import com.optisoins.services.SejourService;

/**
 * Servlet implementation class CretateSejour
 */
@WebServlet("/CreateSejourServlet")
public class CreateSejourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CreateSejourServlet.class);     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSejourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");    
		PrintWriter pw = response.getWriter(); 

		EntityManager em = EMF.getEM(); 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em1 = emf.createEntityManager();
		SejourService service = new SejourService(em1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		em1.getTransaction().begin();  //create interventions in the db

		try {
			
			Sejour sej1 = service.createSejour(true, formatter.parse("2015-08-11"),formatter.parse("2015-08-12"),"Exemple","1");
			Sejour sej2 = service.createSejour(true, formatter.parse("2015-08-12"),formatter.parse("2015-08-13"),"Exemple","2");
			Sejour sej3 = service.createSejour(true, formatter.parse("2015-08-13"),formatter.parse("2015-08-14"),"Exemple","3");

			em1.getTransaction().commit();
			log.info("Stays created !"); 

		}
		catch (Exception e){
			log.error(e,e);
			log.info("Stays not created !"); 
		}




		/*  List<Sejour> sej = service.findAllSejour();
		for(Sejour u : sej){
	          pw.println(sej);  
		 } 
		 em.getTransaction().begin(); // remove data from the db
		service.RemoveSejour(1);
		em.getTransaction().commit();
	    log.info("Stays deleted !");*/

		em1.close();
		emf.close();

		response.sendRedirect("views/sejour.jsp");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

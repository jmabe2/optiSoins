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
@WebServlet("/intervention")
public class CreateInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CreateInterventionServlet.class);
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
		
		EntityManager em = EMF.getEM(); 
		InterventionService service = new InterventionService(em);
		request.setAttribute("intervention", service.findAllIntervention() );
		this.getServletContext().getRequestDispatcher("/views/all/allintervention.jsp").forward( request, response );
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jspview="";
        String action = request.getParameter("action");
        EntityManager em = EMF.getEM(); 
		InterventionService service = new InterventionService(em);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// case Edit
		if (action.equalsIgnoreCase("edit")){
			jspview="/views/edit/editintervention.jsp";
            int interventionId = Integer.parseInt(request.getParameter("interventionId"));
            Intervention interv = service.findIntervention(interventionId);
            request.setAttribute("intervention", interv);
        
        // case Create
		} else if (action.equalsIgnoreCase("create")){
        	jspview="/views/create/createintervention.jsp";        	
		} else if (action.equalsIgnoreCase("saveedit")){
        	jspview="/views/viewintervention.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Intervention interv = service.updateIntervention( Integer.parseInt(request.getParameter("interventionId") ),
    	        sdf.parse( request.getParameter("date")), request.getParameter("description"), 
    	        request.getParameter("nom") );                    		
                
    			em.getTransaction().commit();
                log.info("Interventions updated !");
                request.setAttribute("intervention", interv);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Interventions not updated !"); 
           }
        } else if (action.equalsIgnoreCase("savecreate")){
        	jspview="/views/viewintervention.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Intervention interv = service.createIntervention(sdf.parse( request.getParameter("date")), 
    			request.getParameter("description"), request.getParameter("nom") );                    		
    			em.getTransaction().commit();
                log.info("Interventions created !");
                request.setAttribute("intervention", interv);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Intervention not created !"); 
           }

        /*} else if (action.equalsIgnoreCase("delete")){
            int interventionrId = Integer.parseInt(request.getParameter("interventionId"));
            em.getTransaction().begin();  		
    		try {
    			service.RemoveIntervention (interventionId);
    			log.info("Interventions deleted !");
    		}
    		catch (Exception e){
        			log.error(e,e);
        			log.info("Interventions not deleted !"); 
            }*/

            jspview = "/views/all/allintervention.jsp";;
            request.setAttribute("intervention", service.findAllIntervention());    
        }
		
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward( request, response );



	}


}

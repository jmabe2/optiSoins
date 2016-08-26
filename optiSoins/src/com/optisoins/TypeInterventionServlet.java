package com.optisoins;

import java.io.IOException;

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
import com.optisoins.entities.Typeintervention;
import com.optisoins.services.TypeinterventionService;

/**
 * Servlet implementation class TypeinterventionServlet
 */
@WebServlet("/typeintervention")

public class TypeInterventionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(TypeInterventionServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeInterventionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = EMF.getEM(); 
		TypeinterventionService service = new TypeinterventionService(em);
		request.setAttribute("typeinterventions", service.findAllTypeintervention());
		this.getServletContext().getRequestDispatcher("/views/all/alltypeintervention.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String jspview="";
        String action = request.getParameter("action");
        EntityManager em = EMF.getEM(); 
		TypeinterventionService service = new TypeinterventionService(em);
		
		// case Edit
		if (action.equalsIgnoreCase("edit")){
			jspview="/views/edit/edittypeintervention.jsp";
            int typeInterventionId = Integer.parseInt(request.getParameter("typeInterventionId"));
            Typeintervention typeinterv = service.findTypeintervention(typeInterventionId);
            request.setAttribute("typeintervention", typeinterv);
        
        // case Create
		} else if (action.equalsIgnoreCase("create") ){
        	jspview="/views/create/createtypeintervention.jsp";        	
		} else if (action.equalsIgnoreCase("saveedit")){
        	jspview="/views/viewtypeintervention.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Typeintervention typeinterv = service.updateTypeintervention(Integer.parseInt(request.getParameter("typeInterventionId")),
    		    request.getParameter("Libelle"));                    		
                em.getTransaction().commit();
                log.info("Type intervention updated !");
                request.setAttribute("typeintervention", typeinterv);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Type intervention not updated !"); 
           }
        } else if (action.equalsIgnoreCase("savecreate")){
        	jspview="/views/viewtypeintervention.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Typeintervention typeinterv = service.createTypeintervention(request.getParameter("Libelle"));                    		
                em.getTransaction().commit();
                log.info("Type intervention created !");
                request.setAttribute("typeintervention", typeinterv);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Type intervention not created !"); 
           }

        } else if (action.equalsIgnoreCase("delete")){
            int TypeinterventionId = Integer.parseInt(request.getParameter("TypeInterventionId"));
            em.getTransaction().begin();  		
    		try {
    			service.RemoveTypeintervention(TypeinterventionId);
    			log.info("Type intervention deleted !");
    		}
    		catch (Exception e){
        			log.error(e,e);
        			log.info("Typeintervention not deleted !"); 
            }

            jspview = "/views/all/alltypeinterventions.jsp";;
            request.setAttribute("Typeintervention", service.findAllTypeintervention());    
        }
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward( request, response );
		
	}

}

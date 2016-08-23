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
import com.optisoins.entities.Equipement;
import com.optisoins.services.EquipementService;

/**
 * Servlet implementation class EquipementServlet
 */
@WebServlet("/equipements")
public class EquipementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(MedicamentServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = EMF.getEM(); 
		EquipementService service = new EquipementService(em);
		request.setAttribute("equipements", service.findAllEquipement());
		this.getServletContext().getRequestDispatcher("/views/all/allequipements.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String jspview="";
        String action = request.getParameter("action");
        EntityManager em = EMF.getEM(); 
        EquipementService service = new EquipementService(em);
		
		// case Edit
		if (action.equalsIgnoreCase("edit")){
			jspview="/views/edit/editequipement.jsp";
            int equipementId = Integer.parseInt(request.getParameter("equipementId"));
            Equipement equip = service.findEquipement(equipementId);
            request.setAttribute("equipement", equip);
        
        // case Create
		} else if (action.equalsIgnoreCase("create")){
        	jspview="/views/create/createequipement.jsp";        	
		} else if (action.equalsIgnoreCase("saveedit")){
        	jspview="/views/equipements.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Equipement equip = service.updateEquipement(Integer.parseInt(request.getParameter("equipementId")), request.getParameter("name") ,request.getParameter("description"));                  		
                em.getTransaction().commit();
                log.info("Equipement updated !");
                request.setAttribute("equipement", equip);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Equipement not updated !"); 
           }
        } else if (action.equalsIgnoreCase("savecreate")){
        	jspview="/views/equipements.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Equipement equip = service.createEquipement (request.getParameter("name") ,request.getParameter("description"));                     		
                em.getTransaction().commit();
                log.info("Equipement created !");
                request.setAttribute("equipement", equip);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Equipement not created !"); 
           }

        } else if (action.equalsIgnoreCase("delete")){
            int equipementId = Integer.parseInt(request.getParameter("equipementId"));
            em.getTransaction().begin();  		
    		try {
    			service.RemoveEquipement(equipementId);
    			log.info("Equipement deleted !");
    		}
    		catch (Exception e){
        			log.error(e,e);
        			log.info("Equipement not deleted !"); 
            }

            jspview = "/views/all/allequipements.jsp";;
            request.setAttribute("equipements", service.findAllEquipement());    
        }
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward( request, response );
		
	}

}

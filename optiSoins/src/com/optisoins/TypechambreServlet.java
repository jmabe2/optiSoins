package com.optisoins;

import java.io.IOException;
import java.util.Arrays;

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
import com.optisoins.entities.Typechambre;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.TypechambreService;
import com.optisoins.services.UtilisateurService;

/**
 * Servlet implementation class MedicamentServlet
 */
@WebServlet("/types")
public class TypechambreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(TypechambreServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypechambreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin"))) {	
		EntityManager em = EMF.getEM(); 
		TypechambreService service = new TypechambreService(em);
		request.setAttribute("types", service.findAllTypechambre());
		this.getServletContext().getRequestDispatcher("/views/all/alltypes.jsp").forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin"))) {			
		String jspview="";
        String action = request.getParameter("action");
        EntityManager em = EMF.getEM(); 
        TypechambreService service = new TypechambreService(em);
		
		// case Edit
		if (action.equalsIgnoreCase("edit")){
			jspview="/views/edit/edittype.jsp";
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            Typechambre type = service.findTypechambre(typeId);
            request.setAttribute("typechambre", type);
        
        // case Create
		} else if (action.equalsIgnoreCase("create")){
        	jspview="/views/create/createtype.jsp";        	
		} else if (action.equalsIgnoreCase("saveedit")){
        	jspview="/views/types.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Typechambre type = service.updateTypechambre(Integer.parseInt(request.getParameter("typeId")), request.getParameter("name"), (request.getParameter("actif") != null));                  		
                em.getTransaction().commit();
                log.info("Type updated !");
                request.setAttribute("typechambre", type);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Typechambre not updated !"); 
           }
        } else if (action.equalsIgnoreCase("savecreate")){
        	jspview="/views/types.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Typechambre type = service.createTypechambre (request.getParameter("name"), (request.getParameter("actif") != null));                     		
                em.getTransaction().commit();
                log.info("Typechambre created !");
                request.setAttribute("typechambre", type);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Medicament not created !"); 
           }

        } else if (action.equalsIgnoreCase("delete")){
            int typeId = Integer.parseInt(request.getParameter("typeId"));
            em.getTransaction().begin();  		
    		try {
    			service.RemoveTypechambre(typeId);
    			log.info("Typechambre deleted !");
    		}
    		catch (Exception e){
        			log.error(e,e);
        			log.info("Typechambre not deleted !"); 
            }

            jspview = "/views/all/alltypes.jsp";;
            request.setAttribute("typechambre", service.findAllTypechambre());    
        }
		em.close();
		this.getServletContext().getRequestDispatcher(jspview).forward( request, response );
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}
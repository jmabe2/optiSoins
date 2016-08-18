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
import com.optisoins.entities.Role;
import com.optisoins.services.RoleService;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/roles")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(RoleServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = EMF.getEM(); 
		RoleService service = new RoleService(em);
		request.setAttribute("roles", service.findAllRole());
		this.getServletContext().getRequestDispatcher("/views/allroles.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		String jspview="";
        String action = request.getParameter("action");
        EntityManager em = EMF.getEM(); 
		RoleService service = new RoleService(em);
		
		if (action.equalsIgnoreCase("edit")){
			jspview="/views/editrole.jsp";
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            Role role = service.findRole(roleId);
            request.setAttribute("role", role);
		} else if (action.equalsIgnoreCase("create")){
        	jspview="/views/createrole.jsp";        	
		} else if (action.equalsIgnoreCase("saveedit")){
        	jspview="/views/viewrole.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Role role = service.updateRole(Integer.parseInt(request.getParameter("roleId")),(request.getParameter("actif") != null), request.getParameter("name"));                    		
                em.getTransaction().commit();
                log.info("Role updated !");
                request.setAttribute("role", role);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Role not updated !"); 
           }
        } else if (action.equalsIgnoreCase("savecreate")){
        	jspview="/views/viewrole.jsp";
        	em.getTransaction().begin();  		
    		try {
    		
    			Role role = service.createRole((request.getParameter("actif") != null), request.getParameter("name"));                    		
                em.getTransaction().commit();
                log.info("Role created !");
                request.setAttribute("role", role);
    		}	
    		catch (Exception e){
    			log.error(e,e);
    			log.info("Role not created !"); 
           }

        } else if (action.equalsIgnoreCase("delete")){
            int roleId = Integer.parseInt(request.getParameter("roleId"));
            em.getTransaction().begin();  		
    		try {
    			service.RemoveRole(roleId);
    			log.info("Role deleted !");
    		}
    		catch (Exception e){
        			log.error(e,e);
        			log.info("Role not deleted !"); 
            }

            jspview = "/views/allroles.jsp";;
            request.setAttribute("roles", service.findAllRole());    
        }

		this.getServletContext().getRequestDispatcher(jspview).forward( request, response );
		
	}

}
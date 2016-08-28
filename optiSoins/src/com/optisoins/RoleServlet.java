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
import com.optisoins.entities.Role;
import com.optisoins.entities.Utilisateur;
import com.optisoins.services.RoleService;
import com.optisoins.services.UtilisateurService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("loginUser");
		if (UtilisateurService.checkRole(user, Arrays.asList("Admin"))) {
			EntityManager em = EMF.getEM();
			RoleService service = new RoleService(em);
			request.setAttribute("roles", service.findAllRole());
			this.getServletContext().getRequestDispatcher("/views/all/allroles.jsp").forward(request, response);
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
			RoleService service = new RoleService(em);

			// case Edit
			if (action.equalsIgnoreCase("edit")) {
				jspview = "/views/edit/editrole.jsp";
				int roleId = Integer.parseInt(request.getParameter("roleId"));
				Role role = service.findRole(roleId);
				request.setAttribute("role", role);

				// case Create
			} else if (action.equalsIgnoreCase("create")) {
				jspview = "/views/create/createrole.jsp";

			} else if (action.equalsIgnoreCase("saveedit")) {
				jspview = "/views/viewrole.jsp";
				em.getTransaction().begin();
				try {

					Role role = service.updateRole(Integer.parseInt(request.getParameter("roleId")),
							(request.getParameter("actif") != null), request.getParameter("name"));
					em.getTransaction().commit();
					log.info("Role updated !");
					request.setAttribute("role", role);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Role not updated !");
				}
			} else if (action.equalsIgnoreCase("savecreate")) {
				jspview = "/views/viewrole.jsp";
				em.getTransaction().begin();
				try {

					Role role = service.createRole((request.getParameter("actif") != null),
							request.getParameter("name"));
					em.getTransaction().commit();
					log.info("Role created !");
					request.setAttribute("role", role);
				} catch (Exception e) {
					log.error(e, e);
					log.info("Role not created !");
				}

			} else if (action.equalsIgnoreCase("delete")) {
				int roleId = Integer.parseInt(request.getParameter("roleId"));
				em.getTransaction().begin();
				try {
					service.RemoveRole(roleId);
					log.info("Role deleted !");
				} catch (Exception e) {
					log.error(e, e);
					log.info("Role not deleted !");
				}

				jspview = "/views/all/allroles.jsp";
				;
				request.setAttribute("roles", service.findAllRole());
			}
			em.close();
			this.getServletContext().getRequestDispatcher(jspview).forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/views/signin.jsp").forward(request, response);
		}
	}

}

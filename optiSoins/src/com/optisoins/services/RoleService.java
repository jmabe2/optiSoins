package com.optisoins.services;

import java.util.List;
import javax.persistence.*;

import com.optisoins.entities.Role;

public class RoleService {
	protected EntityManager em;

	public RoleService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Mehod to create a new role
	 * 
	 * @param actif
	 * @param nom
	 * @return created role object
	 */
	public Role createRole(boolean actif, String nom) {
		Role ro = new Role();
		ro.setActif(actif);
		ro.setNom(nom);
		em.persist(ro);
		return ro;
	}

	/**
	 * Method to update a role
	 * 
	 * @param idRole
	 * @param actif
	 * @param nom
	 * @return
	 */

	public Role updateRole(int idRole, boolean actif, String nom) {
		Role ro = em.find(Role.class, idRole);
		ro.setActif(actif);
		ro.setNom(nom);
		// em.persist(ro);
		return ro;
	}

	/**
	 * Method to find a role
	 * 
	 * @param idRole
	 * @return
	 */

	public Role findRole(int idRole) {
		return em.find(Role.class, idRole);
	}

	/**
	 * Method to remove a role
	 * 
	 * @param idRole
	 */

	public void RemoveRole(int idRole) {

		Role ro = findRole(idRole);
		if (ro != null) {
			em.remove(ro);
		}
	}

	/**
	 * Method to list all role
	 * 
	 * @return
	 */

	public List<Role> findAllRole() {

		TypedQuery<Role> query = em.createQuery("SELECT r from Role r", Role.class);
		return query.getResultList();

	}

}

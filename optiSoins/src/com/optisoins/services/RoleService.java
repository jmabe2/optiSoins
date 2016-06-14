package com.optisoins.services;

import java.util.List;
import javax.persistence.*;

import com.optisoins.model.Role;



public class RoleService {
	protected EntityManager em;
	
	public RoleService(EntityManager em){
		this.em=em;
	}

	public Role createRole(int idRole, boolean actif, String nom) 
	
	{
		Role ro = new Role(idRole);
		ro.setActif(actif);
		ro.setNom(nom);
		em.persist(ro);
		return ro;
	}
	
	public List<Role> findAllRole (){
		
		TypedQuery<Role> query = em.createQuery("SELECT r from Role r", Role.class);
		return query.getResultList();
	
	}

}


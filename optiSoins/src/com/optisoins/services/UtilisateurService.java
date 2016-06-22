package com.optisoins.services;
import javax.persistence.*;

import com.optisoins.entities.Utilisateur;

import java.util.Date;
import java.util.List;


public class UtilisateurService {
	protected EntityManager em;
	
	
	
	public UtilisateurService(EntityManager em){
		this.em=em;
	}

	public Utilisateur createUtilisateur(int idUtilisateur, boolean actif, String login, String mdp) 
	
	{
		Utilisateur util = new Utilisateur (idUtilisateur);
		util.setActif(actif);
		//util.setDateNaissance(dateNaissance);
		util.setLogin(login);
		util.setMotDePasse(mdp);
		em.persist(util);
		return util;
	}
	
	public List<Utilisateur> findAllUtilisateur (){
		
		TypedQuery<Utilisateur> query = em.createQuery("SELECT u from Utilisateur u", Utilisateur.class);
		return query.getResultList();
	
	}
	
	
	
}

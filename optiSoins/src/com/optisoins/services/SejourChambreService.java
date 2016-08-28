package com.optisoins.services;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.optisoins.entities.Chambre;
import com.optisoins.entities.Intervention;
import com.optisoins.entities.Sejour;
import com.optisoins.entities.Sejourchambre;

public class SejourChambreService {
	protected EntityManager em;

	
	public SejourChambreService(EntityManager em){
		this.em=em;
	}
	
	public SejourChambreService() {
	}

	/**
	 * Method to create a new sejourchambre
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param chambre
	 * @param sejourId
	 * @return
	 */
	public Sejourchambre createSejourchambre (boolean actif,Date dateEntree, Date dateSortie, Chambre chambre,int sejourId) 
	{
		Sejourchambre sejchamb = new Sejourchambre();
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		sejchamb.setChambre(chambre);
		Sejour sej = em.find(Sejour.class, sejourId);
		sejchamb.setSejour(sej);
		em.persist(sejchamb);
		sej.addSejourchambre(sejchamb);
		return sejchamb;
	}
	
	/**
	 * Method to update a sejourchambre
	 * @param idSejourchambre
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param chambre
	 * @param sejourId
	 * @return
	 */
	
	public Sejourchambre updateSejourchambre (int idSejourchambre,boolean actif,Date dateEntree, Date dateSortie, Chambre chambre, int sejourId) 	
	{
		Sejourchambre sejchamb = em.find(Sejourchambre.class, idSejourchambre);
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		sejchamb.setChambre(chambre);
		sejchamb.setSejour(em.find(Sejour.class, sejourId));
		return sejchamb;
		}
	
	/**
	 * Method to find a sejourchambre
	 * @param idSejourchambre
	 * @return
	 */
	
	public Sejourchambre findSejourChambre(int idSejourchambre){
		return em.find(Sejourchambre.class, idSejourchambre);
	}


	/**
	 * Method to list a sejourchambre
	 * @return
	 */
	
	public List<Sejourchambre> findAllSejourchambre (){
		
		TypedQuery<Sejourchambre> query = em.createQuery("SELECT sc from Sejourchambre sc", Sejourchambre.class);
		return query.getResultList();

	}
}

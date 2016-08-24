package com.optisoins.services;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.optisoins.entities.Sejour;
import com.optisoins.entities.Sejourchambre;

public class SejourChambreService {
	protected EntityManager em;

	
	public SejourChambreService(EntityManager em){
		this.em=em;
	}
	
	public SejourChambreService() {
	}


	public Sejourchambre createSejourchambre (boolean actif,Date dateEntree, Date dateSortie) 
	{
		Sejourchambre sejchamb = new Sejourchambre();
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		em.persist(sejchamb);
		return sejchamb;
	}

	public Sejourchambre updateSejourchambre (int idSejourchambre,boolean actif,Date dateEntree, Date dateSortie) 	
	{
		Sejourchambre sejchamb = new Sejourchambre();
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		return sejchamb;
		}
	
	public Sejourchambre findSejourChambre(int idSejourchambre){
		return em.find(Sejourchambre.class, idSejourchambre);
	}

	public void RemoveSejourchambre(int idSejourchambre){
		
		Sejourchambre sejchamb = findSejourChambre(idSejourchambre);
		if (sejchamb!=null){
			em.remove(sejchamb);
		}
	}

	public List<Sejourchambre> findAllSejourchambre (){
		
		TypedQuery<Sejourchambre> query = em.createQuery("SELECT sc from Sejourchambre sc", Sejourchambre.class);
		return query.getResultList();

	}
}

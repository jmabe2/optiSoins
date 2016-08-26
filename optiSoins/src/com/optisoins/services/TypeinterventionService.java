package com.optisoins.services;

import java.util.List;
import javax.persistence.*;
import com.optisoins.entities.Typeintervention;



public class TypeinterventionService {
	protected EntityManager em;
	
	public TypeinterventionService(EntityManager em){
		this.em=em;
	}

	/** 
	 * Mehod to create a new Typeintervention
	 * 
	 * @param actif
	 * @param nom
	 * @return created Typeintervention object
	 */
	public Typeintervention createTypeintervention(String libelle) 
	{
		Typeintervention Typeintervention = new Typeintervention();
		Typeintervention.setLibelle(libelle);
		em.persist(Typeintervention);
		return Typeintervention;
	}
	
	public Typeintervention updateTypeintervention(int idTypeintervention, String libelle) 	
	{
		Typeintervention typeinterv = em.find(Typeintervention.class, idTypeintervention);
		typeinterv.setLibelle(libelle);
		return typeinterv;
	}
	
	public Typeintervention findTypeintervention(int idTypeintervention){
		return em.find(Typeintervention.class, idTypeintervention);
	}
	
	public void RemoveTypeintervention(int idTypeintervention){
		
		Typeintervention Typeintervention=findTypeintervention(idTypeintervention);
		if (Typeintervention!=null){
			em.remove(Typeintervention);
		}
	}
	
	public List<Typeintervention> findAllTypeintervention (){
		TypedQuery<Typeintervention> query = em.createQuery("SELECT t FROM Typeintervention t", Typeintervention.class);
		return query.getResultList();
	
	}

}


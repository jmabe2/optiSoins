package com.optisoins.services;

import java.util.List;
import javax.persistence.*;
import com.optisoins.entities.Specialite;

public class SpecialiteService {
	protected EntityManager em;

	public SpecialiteService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Mehod to create a new specialite
	 * 
	 * @param actif
	 * @param nom
	 * @return created specialite object
	 */
	public Specialite createSpecialite(boolean actif, String nom) {
		Specialite specialite = new Specialite();
		specialite.setActif(actif);
		specialite.setSpecialite(nom);
		em.persist(specialite);
		return specialite;
	}

	/**
	 * Method to update a specialite
	 * 
	 * @param idSpecialite
	 * @param actif
	 * @param nom
	 * @return
	 */
	public Specialite updateSpecialite(int idSpecialite, boolean actif, String nom) {
		Specialite specialite = em.find(Specialite.class, idSpecialite);
		specialite.setActif(actif);
		specialite.setSpecialite(nom);
		return specialite;
	}

	/**
	 * Method to find a specialite
	 * 
	 * @param idspecialite
	 * @return
	 */
	public Specialite findSpecialite(int idspecialite) {
		return em.find(Specialite.class, idspecialite);
	}

	/**
	 * Method to remove a specialite
	 * 
	 * @param idspecialite
	 */
	public void RemoveSpecialite(int idspecialite) {

		Specialite specialite = findSpecialite(idspecialite);
		if (specialite != null) {
			em.remove(specialite);
		}
	}

	/**
	 * Method to list all specialite
	 * 
	 * @return
	 */
	public List<Specialite> findAllSpecialite() {

		TypedQuery<Specialite> query = em.createQuery("SELECT specialite from Specialite specialite", Specialite.class);
		return query.getResultList();

	}

}

package com.optisoins.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Typechambre;

public class TypechambreService {
	protected EntityManager em;

	public TypechambreService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Method to create a new Typechambre
	 * 
	 * @param nom
	 * @param actif
	 * @return
	 */
	public Typechambre createTypechambre(String nom, boolean actif)

	{
		Typechambre type = new Typechambre();
		type.setNom(nom);
		type.setActif(actif);
		em.persist(type);
		return type;
	}

	/**
	 * Method to update a new Typechambre
	 * 
	 * @param idTypechambre
	 * @param nom
	 * @param actif
	 * @return
	 */
	public Typechambre updateTypechambre(int idTypechambre, String nom, boolean actif) {
		Typechambre type = em.find(Typechambre.class, idTypechambre);
		type.setNom(nom);
		type.setActif(actif);
		return type;
	}

	/**
	 * Method to find a Typechambre
	 * 
	 * @param idTypechambre
	 * @return
	 */
	public Typechambre findTypechambre(int idTypechambre) {
		return em.find(Typechambre.class, idTypechambre);
	}

	/**
	 * Method to remove a Typechambre
	 * 
	 * @param idTypechambre
	 */
	public void RemoveTypechambre(int idTypechambre) {

		Typechambre type = findTypechambre(idTypechambre);
		if (type != null) {
			em.remove(type);
		}
	}

	/**
	 * Method to list all Typechambre
	 * 
	 * @return
	 */
	public List<Typechambre> findAllTypechambre() {

		TypedQuery<Typechambre> query = em.createQuery("SELECT r from Typechambre r", Typechambre.class);
		return query.getResultList();

	}

}

package com.optisoins.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.entities.Chambre;
import com.optisoins.entities.Typechambre;
import com.optisoins.entities.Utilisateur;
import com.optisoins.entities.Equipement;


public class ChambreService {
	protected EntityManager em;
	
	/*public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();

		if (Utils.fieldEmpty(request.getParameter("nom"))) {
			erreurs.put( "nom", "Veuillez entrer un nom" );
		}
		
		if (Utils.fieldEmpty(request.getParameter("prenom"))) {
			erreurs.put( "prenom", "Veuillez entrer un prénom" );
		}
		return erreurs;
	}*/
	
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public ChambreService(EntityManager em) {
		this.em=em;
	}

	/**
	 * Method to create a new chambre

	 * @param numeroChambre
	 * @param type
	 * @return
	 */
	
	public Chambre createChambre(int numeroChambre, Typechambre type) 
	{
		Chambre chambre = new Chambre();
		chambre.setNumeroChambre(numeroChambre);
		chambre.setTypechambre(type);
		em.persist(chambre);
		return chambre;
	}
	
	/**
	 * Method to update a chambre

	 * @param idChambre
	 * @param numeroChambre
	 * @param type
	 * @return
	 */
	public Chambre updateChambre(int idChambre,int numeroChambre, Typechambre type) 
	{
		Chambre chambre = em.find(Chambre.class, idChambre);
		chambre.setNumeroChambre(numeroChambre);
		chambre.setTypechambre(type);
		return chambre;
	}
	
	/**
	 *  Method to find a chambre
	 * @param idchambre
	 * @return
	 */
	
	public Chambre findChambre(int idchambre){
		return em.find(Chambre.class, idchambre);
	}
	
	/**
	 *  Method to remove a chambre
	 * @param idchambre
	 */
	
	public void RemoveChambre(int idchambre){
		
		Chambre chambre=findChambre(idchambre);
		if (chambre!=null){
			em.remove(chambre);
		}
	}
	
	/**
	 *  Method to list a chambre
	 * @return
	 */
	public List<Chambre> findAllChambre (){
		
		TypedQuery<Chambre> query = em.createQuery("SELECT chambre from Chambre chambre", Chambre.class);
		return query.getResultList();
	
	}
	
	/**
	 *  Method to find by number a chambre
	 * @param numChambre
	 * @return
	 */
	public Chambre findByNum (int numChambre){
		
		TypedQuery<Chambre> query = em.createQuery("SELECT chambre from Chambre chambre where chambre.numeroChambre=:numchambre", Chambre.class);
		query.setParameter("numchambre", numChambre);
		return query.getSingleResult();
	
	}

}


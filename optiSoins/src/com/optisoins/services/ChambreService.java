package com.optisoins.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.entities.Chambre;
import com.optisoins.entities.Typechambre;
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
	
	public ChambreService(EntityManager em){
		this.em=em;
	}

	public Chambre createChambre(int numeroChambre, Typechambre type) 
	{
		Chambre chambre = new Chambre();
		chambre.setNumeroChambre(numeroChambre);
		chambre.setTypechambre(type);
		em.persist(chambre);
		return chambre;
	}
	
	public Chambre updateChambre(int idChambre,int numeroChambre, Typechambre type) 
	{
		Chambre chambre = em.find(Chambre.class, idChambre);
		chambre.setNumeroChambre(numeroChambre);
		chambre.setTypechambre(type);
		return chambre;
	}
	
	public Chambre findChambre(int idchambre){
		return em.find(Chambre.class, idchambre);
	}
	
	public void RemoveChambre(int idchambre){
		
		Chambre chambre=findChambre(idchambre);
		if (chambre!=null){
			em.remove(chambre);
		}
	}
	
	public List<Chambre> findAllChambre (){
		
		TypedQuery<Chambre> query = em.createQuery("SELECT chambre from Chambre chambre", Chambre.class);
		return query.getResultList();
	
	}

}


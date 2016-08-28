package com.optisoins.services;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.optisoins.entities.Chambre;
import com.optisoins.entities.Sejour;
import com.optisoins.entities.Medicament;
import com.optisoins.entities.Medicamentsejour;

public class MedicamentSejourService {
	protected EntityManager em;

	
	public MedicamentSejourService(EntityManager em){
		this.em=em;
	}
	
	public MedicamentSejourService() {
	}

	/**
	 * Method to create a medicament during sejour
	 * @param actif
	 * @param medicamentId
	 * @param indication
	 * @param posologie
	 * @param remarque
	 * @param sejourId
	 * @return
	 */
	public Medicamentsejour createMedicamentsejour (boolean actif,int medicamentId, String indication, String posologie,String remarque,int sejourId) 
	{
		Medicamentsejour medsej = new Medicamentsejour();
		medsej.setActif(actif);
		medsej.setMedicament(em.find(Medicament.class, medicamentId));
		medsej.setIndication(indication);
		medsej.setPosologie(posologie);
		medsej.setRemarque(remarque);
		Sejour sej = em.find(Sejour.class, sejourId);
		medsej.setSejour(sej);
		em.persist(medsej);
		sej.addMedicamentsejour(medsej);
		return medsej;
	}

	/**
	 * Method to update a medicament during sejour
	 * @param idMedicamentsejour
	 * @param actif
	 * @param medicamentId
	 * @param indication
	 * @param posologie
	 * @param remarque
	 * @param sejourId
	 * @return
	 */
	
	public Medicamentsejour updateMedicamentsejour (int idMedicamentsejour,boolean actif,int medicamentId, String indication, String posologie,String remarque,int sejourId) 	
	{
		Medicamentsejour medsej = em.find(Medicamentsejour.class, idMedicamentsejour);
		medsej.setActif(actif);
		medsej.setMedicament(em.find(Medicament.class, medicamentId));
		medsej.setIndication(indication);
		medsej.setPosologie(posologie);
		medsej.setRemarque(remarque);
		medsej.setSejour(em.find(Sejour.class, sejourId));
		return medsej;
		}
	
	/**
	 * Method to find a medicament during a sejour
	 * @param idMedicamentsejour
	 * @return
	 */
	
	public Medicamentsejour findMedicamentSejour(int idMedicamentsejour){
		return em.find(Medicamentsejour.class, idMedicamentsejour);
	}


	/**
	 * Method to list all medicament during sejour
	 * @return
	 */
	
	public List<Medicamentsejour> findAllMedicamentsejour (){
		
		TypedQuery<Medicamentsejour> query = em.createQuery("SELECT ms from Medicamentsejour ms", Medicamentsejour.class);
		return query.getResultList();

	}
}

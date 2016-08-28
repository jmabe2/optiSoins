package com.optisoins.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Intervention;
import com.optisoins.entities.Patient;
import com.optisoins.entities.Role;
import com.optisoins.entities.Sejour;

public class SejourService {
	protected EntityManager em;


	public SejourService(EntityManager em){
		this.em=em;
		}
	/**
	 * Method to create a new sejour
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param emplacement
	 * @param motifSejour
	 * @param patientId
	 * @return
	 */
	
	public Sejour createSejour(boolean actif,Date dateEntree, Date dateSortie, String emplacement, String motifSejour, int patientId){
		Sejour sej = new Sejour();
		Patient patient = em.find(Patient.class, patientId);
		sej.setPatient(patient);
		sej.setActif(actif);
		sej.setDateEntree(dateEntree);
		sej.setDateSortie(dateSortie);
		sej.setEmplacement(emplacement);
		sej.setMotifSejour(motifSejour);
		em.persist(sej);
		return sej;
	}
	
	/**
	 * Method to update a sejour
	 * @param idSejour
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param emplacement
	 * @param motifSejour
	 * @return
	 */
	
	public Sejour updateSejour (int idSejour,boolean actif,Date dateEntree, Date dateSortie, String emplacement, String motifSejour) 	
	{
		Sejour sej = em.find(Sejour.class, idSejour);
		sej.setActif(actif);
		sej.setDateEntree(dateEntree);
		sej.setDateSortie(dateSortie);
		sej.setEmplacement(emplacement);
		sej.setMotifSejour(motifSejour);
		return sej;
		}
		
	/**
	 * Method to find a sejour
	 * @param idSejour
	 * @return
	 */
	
	public Sejour findSejour(int idSejour){
		return em.find(Sejour.class, idSejour);
	}
	
	/**
	 * Method to remove a sejour
	 * @param idSejour
	 */
	
	public void RemoveSejour(int idSejour){
		
		Sejour sej = findSejour(idSejour);
		if (sej!=null){
			em.remove(sej);
		}
	}
	
	/**
	 * Method to list all sejour
	 * @return
	 */
	public List<Sejour> findAllSejour (){
		
		TypedQuery<Sejour> query = em.createQuery("SELECT s from Sejour s", Sejour.class);
		return query.getResultList();

	}
	
	/**
	 * Method to list a sejour by patient
	 * @param patientId
	 * @return
	 */
	public List<Sejour> findSejoursPatient(int patientId) {
		TypedQuery<Sejour> query = em.createQuery("SELECT s from Sejour s where s.patient.idPatient=:patientId", Sejour.class).setParameter("patientId", patientId);
		return query.getResultList();
		
	}
}

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
	
	public Sejour createSejour(boolean actif,Date dateEntree, Date dateSortie, String emplacement, String motifSejour){
		Sejour sej = new Sejour();
		Patient patient = em.find(Patient.class, 1);
		sej.setPatient(patient);
		sej.setActif(actif);
		sej.setDateEntree(dateEntree);
		sej.setDateSortie(dateSortie);
		sej.setEmplacement(emplacement);
		sej.setMotifSejour(motifSejour);
		em.persist(sej);
		return sej;
	}
	
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
		
	public Sejour findSejour(int idSejour){
		return em.find(Sejour.class, idSejour);
	}

	public void RemoveSejour(int idSejour){
		
		Sejour sej = findSejour(idSejour);
		if (sej!=null){
			em.remove(sej);
		}
	}

	public List<Sejour> findAllSejour (){
		
		TypedQuery<Sejour> query = em.createQuery("SELECT s from Sejour s", Sejour.class);
		return query.getResultList();

	}
}

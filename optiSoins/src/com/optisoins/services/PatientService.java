package com.optisoins.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.entities.Patient;
import com.optisoins.Utils;
import com.optisoins.entities.Role;
import com.optisoins.entities.Specialite;


public class PatientService {
	protected EntityManager em;
	
	public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();

		if (Utils.fieldEmpty(request.getParameter("nom"))) {
			erreurs.put( "nom", "Veuillez entrer un nom" );
		}
		
		if (Utils.fieldEmpty(request.getParameter("prenom"))) {
			erreurs.put( "prenom", "Veuillez entrer un prénom" );
		}
		return erreurs;
	}
	
	public PatientService(EntityManager em){
		this.em=em;
	}

	/** 
	 * Mehod to create a new patient
	 * 
	 * @param actif
	 * @param nom
	 * @return created patient object
	 */
	public Patient createPatient(boolean actif, 
			String nom,
			String prenom,
			String sexe,
			Date datenaiss,
			String adresse) 
	{
		Patient patient = new Patient();
		patient.setActif(actif);
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setSexe(sexe);
		patient.setDateDeNaissance(datenaiss);
		patient.setAdresse(adresse);
		em.persist(patient);
		return patient;
	}
	
	public Patient updatePatient(int idPatient,boolean actif, 
			String nom,
			String prenom,
			String sexe,
			Date datenaiss,
			String adresse) 
	{
		Patient patient = em.find(Patient.class, idPatient);
		patient.setActif(actif);
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setSexe(sexe);
		patient.setDateDeNaissance(datenaiss);
		patient.setAdresse(adresse);
		return patient;
	}
	
	public Patient findPatient(int idpatient){
		return em.find(Patient.class, idpatient);
	}
	
	public void RemovePatient(int idpatient){
		
		Patient patient=findPatient(idpatient);
		if (patient!=null){
			em.remove(patient);
		}
	}
	
	public List<Patient> findAllPatient (){
		
		TypedQuery<Patient> query = em.createQuery("SELECT patient from Patient patient", Patient.class);
		return query.getResultList();
	
	}

}


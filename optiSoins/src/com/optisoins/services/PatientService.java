package com.optisoins.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.entities.Patient;
import com.optisoins.Utils;

public class PatientService {
	protected EntityManager em;

	/**
	 * method to validate name, surname
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();

		if (Utils.fieldEmpty(request.getParameter("nom"))) {
			erreurs.put("nom", "Veuillez entrer un nom");
		}

		if (Utils.fieldEmpty(request.getParameter("prenom"))) {
			erreurs.put("prenom", "Veuillez entrer un prénom");
		}
		return erreurs;
	}

	public PatientService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Mehod to create a new patient
	 * 
	 * @param actif
	 * @param nom
	 * @return created patient object
	 */
	public Patient createPatient(boolean actif, String nom, String prenom, String sexe, Date datenaiss,
			String adresse) {
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

	/**
	 * Method to update a patient
	 * 
	 * @param idPatient
	 * @param actif
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param datenaiss
	 * @param adresse
	 * @return
	 */

	public Patient updatePatient(int idPatient, boolean actif, String nom, String prenom, String sexe, Date datenaiss,
			String adresse) {
		Patient patient = em.find(Patient.class, idPatient);
		patient.setActif(actif);
		patient.setNom(nom);
		patient.setPrenom(prenom);
		patient.setSexe(sexe);
		patient.setDateDeNaissance(datenaiss);
		patient.setAdresse(adresse);
		return patient;
	}

	/**
	 * Method to find a patient
	 * 
	 * @param idpatient
	 * @return
	 */
	public Patient findPatient(int idpatient) {
		return em.find(Patient.class, idpatient);
	}

	/**
	 * Method to remove a patient
	 * 
	 * @param idpatient
	 */
	public void RemovePatient(int idpatient) {

		Patient patient = findPatient(idpatient);
		if (patient != null) {
			em.remove(patient);
		}
	}

	/**
	 * Method to list all patient
	 * 
	 * @return
	 */
	public List<Patient> findAllPatient() {

		TypedQuery<Patient> query = em.createQuery("SELECT patient from Patient patient", Patient.class);
		return query.getResultList();

	}

	/**
	 * Method to search by patient
	 * 
	 * @param searchnom
	 * @param searchprenom
	 * @return
	 */
	public List<Patient> searchPatients(String searchnom, String searchprenom) {
		TypedQuery<Patient> query = em.createQuery(
				"SELECT p from Patient p where p.nom like :searchnom and p.prenom like :searchprenom", Patient.class);
		query.setParameter("searchnom", "%" + searchnom + "%");
		query.setParameter("searchprenom", "%" + searchprenom + "%");
		return query.getResultList();

	}
}

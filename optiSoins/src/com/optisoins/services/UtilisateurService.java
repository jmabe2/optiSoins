package com.optisoins.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.entities.Utilisateur;
import com.optisoins.Utils;
import com.optisoins.entities.Role;
import com.optisoins.entities.Specialite;

public class UtilisateurService {
	protected EntityManager em;

	public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (Utils.fieldEmpty(request.getParameter("nom"))) {
			erreurs.put("nom", "Veuillez entrer un nom");
		}

		if (Utils.fieldEmpty(request.getParameter("prenom"))) {
			erreurs.put("prenom", "Veuillez entrer un prénom");
		}
		
		if (Utils.fieldEmpty(request.getParameter("datenaiss"))) {
			erreurs.put("datenaiss", "Veuillez entrer une date de naissance");
		} else {
			try {
				if (sdf.parse(request.getParameter("datenaiss")).after(new Date())) {
					erreurs.put("datenaiss", "Date de naissance non valide");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (Utils.fieldEmpty(request.getParameter("login"))) {
			erreurs.put("login", "Veuillez entrer un login");
		} else {

			TypedQuery<Utilisateur> query = em.createQuery("SELECT u from Utilisateur u where u.login like :login",
					Utilisateur.class);
			query.setParameter("login", request.getParameter("login"));
			if (!query.getResultList().isEmpty()) {
				erreurs.put("login", "Ce login existe déjà");
			}
		}
		return erreurs;
	}

	public UtilisateurService(EntityManager em) {
		this.em = em;
	}

	/**
	 * Mehod to create a new utilisateur
	 * 
	 * @param actif
	 * @param nom
	 * @return created utilisateur object
	 */
	public Utilisateur createUtilisateur(boolean actif, String nom, String prenom, String sexe, Date datenaiss,
			String login, String mdp, Role role, Specialite specialite) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setActif(actif);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setSexe(sexe);
		utilisateur.setDateNaissance(datenaiss);
		utilisateur.setLogin(login);
		utilisateur.setMotDePasse(mdp);
		utilisateur.setRole(role);
		utilisateur.setSpecialite(specialite);
		em.persist(utilisateur);
		return utilisateur;
	}

	/**
	 * Method to update a utilisateur
	 * 
	 * @param idUtilisateur
	 * @param actif
	 * @param nom
	 * @param prenom
	 * @param sexe
	 * @param datenaiss
	 * @param login
	 * @param mdp
	 * @param role
	 * @param specialite
	 * @return
	 */
	public Utilisateur updateUtilisateur(int idUtilisateur, boolean actif, String nom, String prenom, String sexe,
			Date datenaiss, String login, String mdp, Role role, Specialite specialite) {
		Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
		utilisateur.setActif(actif);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setSexe(sexe);
		utilisateur.setDateNaissance(datenaiss);
		utilisateur.setLogin(login);
		utilisateur.setMotDePasse(mdp);
		utilisateur.setRole(role);
		utilisateur.setSpecialite(specialite);
		return utilisateur;
	}

	/**
	 * Method to find a utilisateur
	 * 
	 * @param idutilisateur
	 * @return
	 */
	public Utilisateur findUtilisateur(int idutilisateur) {
		return em.find(Utilisateur.class, idutilisateur);
	}

	/**
	 * Method to remove a utilisateur
	 * 
	 * @param idutilisateur
	 */
	public void RemoveUtilisateur(int idutilisateur) {

		Utilisateur utilisateur = findUtilisateur(idutilisateur);
		if (utilisateur != null) {
			em.remove(utilisateur);
		}
	}

	/**
	 * Method to list utilisateur
	 * 
	 * @return
	 */
	public List<Utilisateur> findAllUtilisateur() {

		TypedQuery<Utilisateur> query = em.createQuery("SELECT utilisateur from Utilisateur utilisateur",
				Utilisateur.class);
		return query.getResultList();

	}

	/**
	 * Method to check utilisateur role
	 * 
	 * @param user
	 * @param roleNames
	 * @return
	 */

	public static boolean checkRole(Utilisateur user, List<String> roleNames) {
		return (user != null) && (roleNames.contains(user.getRole().getNom()));
	}

}

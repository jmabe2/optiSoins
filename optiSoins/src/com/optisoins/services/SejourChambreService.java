package com.optisoins.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

import com.optisoins.Utils;
import com.optisoins.entities.Chambre;
import com.optisoins.entities.Sejour;
import com.optisoins.entities.Sejourchambre;

public class SejourChambreService {
	protected EntityManager em;

	public SejourChambreService(EntityManager em) {
		this.em = em;
	}

	public SejourChambreService() {
	}

	public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		if (!Utils.fieldEmpty(request.getParameter("dateEntree"))
				&& !Utils.fieldEmpty(request.getParameter("dateSortie"))) {
			try {
				if (sdf.parse(request.getParameter("dateEntree"))
						.after(sdf.parse(request.getParameter("dateSortie")))) {
					erreurs.put("dateEntree", "La date d'entrée doit être <= à la date de sortie");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (Utils.fieldEmpty(request.getParameter("numchambre"))) {
			erreurs.put("login", "Veuillez entrer un numéro de chambre");
		} else {

			TypedQuery<Chambre> query = em.createQuery("SELECT c from Chambre c where c.numeroChambre = :numchambre",
					Chambre.class);
			try {
				query.setParameter("numchambre", Integer.parseInt(request.getParameter("numchambre")));
				if (query.getResultList().isEmpty()) {
					erreurs.put("numchambre", "Cette chambre n'existe pas");
				}
			} catch (NumberFormatException nfe) {
				erreurs.put("numchambre", "Les numéros de chambre ne comportent que des chiffres");
			}

		}
		return erreurs;
	}

	/**
	 * Method to create a new sejourchambre
	 * 
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param chambre
	 * @param sejourId
	 * @return
	 */
	public Sejourchambre createSejourchambre(boolean actif, Date dateEntree, Date dateSortie, Chambre chambre,
			int sejourId) {
		Sejourchambre sejchamb = new Sejourchambre();
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		sejchamb.setChambre(chambre);
		Sejour sej = em.find(Sejour.class, sejourId);
		sejchamb.setSejour(sej);
		em.persist(sejchamb);
		sej.addSejourchambre(sejchamb);
		return sejchamb;
	}

	/**
	 * Method to update a sejourchambre
	 * 
	 * @param idSejourchambre
	 * @param actif
	 * @param dateEntree
	 * @param dateSortie
	 * @param chambre
	 * @param sejourId
	 * @return
	 */

	public Sejourchambre updateSejourchambre(int idSejourchambre, boolean actif, Date dateEntree, Date dateSortie,
			Chambre chambre, int sejourId) {
		Sejourchambre sejchamb = em.find(Sejourchambre.class, idSejourchambre);
		sejchamb.setActif(actif);
		sejchamb.setDateEntree(dateEntree);
		sejchamb.setDateSortie(dateSortie);
		sejchamb.setChambre(chambre);
		sejchamb.setSejour(em.find(Sejour.class, sejourId));
		return sejchamb;
	}

	/**
	 * Method to find a sejourchambre
	 * 
	 * @param idSejourchambre
	 * @return
	 */

	public Sejourchambre findSejourChambre(int idSejourchambre) {
		return em.find(Sejourchambre.class, idSejourchambre);
	}

	/**
	 * Method to list a sejourchambre
	 * 
	 * @return
	 */

	public List<Sejourchambre> findAllSejourchambre() {

		TypedQuery<Sejourchambre> query = em.createQuery("SELECT sc from Sejourchambre sc", Sejourchambre.class);
		return query.getResultList();

	}
}

package com.optisoins.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Intervention;
import com.optisoins.entities.Patient;
import com.optisoins.entities.Sejour;
import com.optisoins.entities.Typeintervention;
import com.optisoins.entities.Utilisateur;

public class InterventionService {
	protected EntityManager em;

public InterventionService(EntityManager em){
	this.em=em;
}
/**
 * Method to create a intervention
 * @param date
 * @param description
 * @param nom
 * @param sejourId
 * @param typeInterventionId
 * @param utilisateurId
 * @return
 */
public Intervention createIntervention(Date date, String description, String nom, int sejourId, int typeInterventionId, int utilisateurId) 

{
	Intervention interv = new Intervention();
	Sejour sej = em.find(Sejour.class, sejourId);
	interv.setSejour(sej);
	interv.setUtilisateur(em.find(Utilisateur.class, utilisateurId));
	interv.setTypeintervention(em.find(Typeintervention.class, typeInterventionId));
	interv.setDate(date);
	interv.setDescription(description);
	interv.setNom(nom);
	em.persist(interv);
	sej.addIntervention(interv);
	return interv;
}

/**
 * Method to update a intervention
 * @param idIntervention
 * @param date
 * @param description
 * @param nom
 * @param typeInterventionId
 * @return
 */

public Intervention updateIntervention(int idIntervention,Date date, String description, String nom, int typeInterventionId) 	
{
	Intervention interv = em.find(Intervention.class, idIntervention);
	interv.setDate(date);
	interv.setDescription(description);
	interv.setTypeintervention(em.find(Typeintervention.class, typeInterventionId));
	interv.setNom(nom);
	return interv;
	
	}

/**
 * Method to find a intervention
 * @param idIntervention
 * @return
 */

public Intervention findIntervention(int idIntervention){
	return em.find(Intervention.class, idIntervention);
}

/**
 * Method to remove a intervention
 * @param idIntervention
 */

public void RemoveIntervention(int idIntervention){
	
	Intervention interv =findIntervention(idIntervention);
	if (interv!=null){
		em.remove(interv);
	}
}

/**
 * Method to list all intervention
 * @return
 */

public List<Intervention> findAllIntervention (){
	
	TypedQuery<Intervention> query = em.createQuery("SELECT i from Intervention i", Intervention.class);
	return query.getResultList();

}

}

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

public Intervention updateIntervention(int idIntervention,Date date, String description, String nom, int typeInterventionId) 	
{
	Intervention interv = em.find(Intervention.class, idIntervention);
	interv.setDate(date);
	interv.setDescription(description);
	interv.setTypeintervention(em.find(Typeintervention.class, typeInterventionId));
	interv.setNom(nom);
	return interv;
	
	}
public Intervention findIntervention(int idIntervention){
	return em.find(Intervention.class, idIntervention);
}

public void RemoveIntervention(int idIntervention){
	
	Intervention interv =findIntervention(idIntervention);
	if (interv!=null){
		em.remove(interv);
	}
}

public List<Intervention> findAllIntervention (){
	
	TypedQuery<Intervention> query = em.createQuery("SELECT i from Role i", Intervention.class);
	return query.getResultList();

}

}

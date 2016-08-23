package com.optisoins.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Intervention;
import com.optisoins.entities.Sejour;

public class InterventionService {
	protected EntityManager em;

public InterventionService(EntityManager em){
	this.em=em;
}

public Intervention createIntervention(Date date, String description, String nom) 

{
	Intervention interv = new Intervention();
	interv.setDate(date);
	interv.setDescription("description");
	interv.setNom("nom");
	em.persist(interv);
	return interv;
}

public Intervention updateIntervention(int idIntervention,Date date, String description, String nom) 	
{
	Intervention interv = em.find(Intervention.class, idIntervention);
	interv.setDate(date);
	interv.setDescription("description");
	interv.setNom("nom");
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

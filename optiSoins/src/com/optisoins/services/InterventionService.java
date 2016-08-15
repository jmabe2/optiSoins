package com.optisoins.services;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Intervention;

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

public Intervention findRole(int idIntervention){
	return em.find(Intervention.class, idIntervention);
}

public void RemoveIntervention(int idIntervention){
	
	Intervention interv =findRole(idIntervention);
	if (interv!=null){
		em.remove(interv);
	}
}

public List<Intervention> findAllIntervention (){
	
	TypedQuery<Intervention> query = em.createQuery("SELECT r from Role r", Intervention.class);
	return query.getResultList();

}

}

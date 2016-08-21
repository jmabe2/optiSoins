package com.optisoins.services;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Medicament;
import com.optisoins.entities.Role;

public class MedicamentService {
	protected EntityManager em;

public MedicamentService(EntityManager em){
	this.em=em;
}

public Medicament createMedicament(String nom, String description, int quantite, boolean actif) 

{
	Medicament medic = new Medicament();
	medic.setNom("nom");
	medic.setDescription("description");
	medic.setQuantiteDispo(quantite);
	medic.setActif(actif);
	em.persist(medic);
	return medic;
}

public Medicament updateMedicament(int idMedicament, String nom, String description, int quantite, boolean actif) 	
{
	Medicament medic = em.find(Medicament.class, idMedicament);
	medic.setNom("nom");
	medic.setDescription("description");
	medic.setQuantiteDispo(quantite);
	medic.setActif(actif);
	return medic;
}

public Medicament findMedicament(int idMedicament){
	return em.find(Medicament.class, idMedicament);
}

public void RemoveMedicament(int idMedicament){
	
	Medicament medic =findMedicament(idMedicament);
	if (medic!=null){
		em.remove(medic);
	}
}

public List<Medicament> findAllMedicament (){
	
	TypedQuery<Medicament> query = em.createQuery("SELECT r from Medicament r", Medicament.class);
	return query.getResultList();

}

}

package com.optisoins.services;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Medicament;
public class MedicamentService {
	protected EntityManager em;

public MedicamentService(EntityManager em){
	this.em=em;
}

/**
 * Method to create a medicament
 * @param nom
 * @param description
 * @param quantite
 * @param actif
 * @return
 */
public Medicament createMedicament(String nom, String description, int quantite, boolean actif) 

{
	Medicament medic = new Medicament();
	medic.setNom(nom);
	medic.setDescription(description);
	medic.setQuantiteDispo(quantite);
	medic.setActif(actif);
	em.persist(medic);
	return medic;
}

/**
 * Method to update a medicament
 * @param idMedicament
 * @param nom
 * @param description
 * @param quantite
 * @param actif
 * @return
 */

public Medicament updateMedicament(int idMedicament, String nom, String description, int quantite, boolean actif) 	
{
	Medicament medic = em.find(Medicament.class, idMedicament);
	medic.setNom(nom);
	medic.setDescription(description);
	medic.setQuantiteDispo(quantite);
	medic.setActif(actif);
	return medic;
}

/**
 * Method to find a medicament
 * @param idMedicament
 * @return
 */
public Medicament findMedicament(int idMedicament){
	return em.find(Medicament.class, idMedicament);
}

/**
 * Method to remove a medicament
 * @param idMedicament
 */
public void RemoveMedicament(int idMedicament){
	
	Medicament medic =findMedicament(idMedicament);
	if (medic!=null){
		em.remove(medic);
	}
}

/**
 * Method to list all medicament
 * @return
 */
public List<Medicament> findAllMedicament (){
	
	TypedQuery<Medicament> query = em.createQuery("SELECT m from Medicament m", Medicament.class);
	return query.getResultList();

}

}

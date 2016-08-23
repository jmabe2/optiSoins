package com.optisoins.services;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Equipement;
public class EquipementService {
	protected EntityManager em;

public EquipementService(EntityManager em){
	this.em=em;
}

public Equipement createEquipement(String nom, String description) 

{
	Equipement equip = new Equipement();
	equip.setNom(nom);
	equip.setDescription(description);
	em.persist(equip);
	return equip;
}

public Equipement updateEquipement(int idEquipement, String nom, String description) 	
{
	Equipement equip = em.find(Equipement.class, idEquipement);
	equip.setNom(nom);
	equip.setDescription(description);
	return equip;
}

public Equipement findEquipement(int idEquipement){
	return em.find(Equipement.class, idEquipement);
}

public void RemoveEquipement(int idEquipement){
	
	Equipement equip =findEquipement(idEquipement);
	if (equip!=null){
		em.remove(equip);
	}
}

public List<Equipement> findAllEquipement (){
	
	TypedQuery<Equipement> query = em.createQuery("SELECT r from Equipement r", Equipement.class);
	return query.getResultList();

}

}

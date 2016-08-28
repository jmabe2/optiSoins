package com.optisoins.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.optisoins.entities.Equipement;
import com.optisoins.entities.Chambre;
import com.optisoins.entities.Equipementchambre;

public class EquipementchambreService {
	protected EntityManager em;


	public EquipementchambreService(EntityManager em){
		this.em=em;
		}
	
	public Equipementchambre createEquipementchambre(int  chambreId, int equipementId){
		Equipementchambre equipc = new Equipementchambre();
		em.persist(equipc);
		Chambre chambre = em.find(Chambre.class, chambreId);
		Equipement equipement = em.find(Equipement.class, equipementId);
		chambre.addEquipementchambre(equipc);
		equipement.addEquipementchambre(equipc);
		em.persist(equipc);
		return equipc;
	}
	
	public Equipementchambre updateEquipementchambre (int idEquipementchambre, int equipementId ) 	
	{
		Equipementchambre equipc = em.find(Equipementchambre.class, idEquipementchambre);
		Equipement equipement = em.find(Equipement.class, equipementId);
		equipc.setEquipement(equipement);
		return equipc;
		}
		
	public Equipementchambre findEquipementchambre(int idEquipementchambre){
		return em.find(Equipementchambre.class, idEquipementchambre);
	}

	public void removeEquipementchambre(int idEquipementchambre){
		
		Equipementchambre equipc = findEquipementchambre(idEquipementchambre);
		Chambre chambre = equipc.getChambre();
		if (equipc!=null){
			em.remove(equipc);
			em.persist(chambre);
		}
	}

	public List<Equipementchambre> findAllEquipementchambre (){
		
		TypedQuery<Equipementchambre> query = em.createQuery("SELECT s from Equipementchambre s", Equipementchambre.class);
		return query.getResultList();

	}
	
	public List<Equipementchambre> findAllEquipementchambre(int chambreId) {
		TypedQuery<Equipementchambre> query = em.createQuery("SELECT s from Equipementchambre s where s.chambre.idChambre=:chambreId", Equipementchambre.class).setParameter("chambreId", chambreId);
		return query.getResultList();
		
	}
}

package com.optisoins.services;

import java.util.Date;
import java.text.SimpleDateFormat;
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
	
	public Equipementchambre createEquipementchambre(Chambre chambreId, Equipement equipementId){
		Equipementchambre equipc = new Equipementchambre();
		Chambre chambre = em.find(Chambre.class, chambreId);
		Equipement equipement = em.find(Equipement.class, equipementId);
		equipc.setChambre(chambre);
		equipc.setEquipement(equipement);
		em.persist(equipc);
		return equipc;
	}
	
	public Equipementchambre updateEquipementchambre (int idEquipementchambre, Equipement equipementId ) 	
	{
		Equipementchambre equipc = em.find(Equipementchambre.class, idEquipementchambre);
		equipc.setEquipement(equipementId);
		return equipc;
		}
		
	public Equipementchambre findEquipementchambre(int idEquipementchambre){
		return em.find(Equipementchambre.class, idEquipementchambre);
	}

	public void RemoveEquipementchambre(int idEquipementchambre){
		
		Equipementchambre equipc = findEquipementchambre(idEquipementchambre);
		if (equipc!=null){
			em.remove(equipc);
		}
	}

	public List<Equipementchambre> findAllEquipementchambre (){
		
		TypedQuery<Equipementchambre> query = em.createQuery("SELECT s from Equipementchambre s", Equipementchambre.class);
		return query.getResultList();

	}
	
	public List<Equipementchambre> findSejoursPatient(int chambreId) {
		TypedQuery<Equipementchambre> query = em.createQuery("SELECT s from Equipementchambre s where s.chambre.idChambre=:chambreId", Equipementchambre.class).setParameter("chambreId", chambreId);
		return query.getResultList();
		
	}
}

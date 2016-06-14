package com.optisoins.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.optisoins.model.Utilisateur;

public class UtilisateurTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("optiSoins_PU");
		EntityManager em = emf.createEntityManager();
		UtilisateurService service = new UtilisateurService(em);
		
		em.getTransaction().begin();
		Utilisateur util = service.createUtilisateur(1, true, "fou", "fou1234");
		em.getTransaction().commit();
		System.out.println(util+ "is persisted");
		

		
		List<Utilisateur> Utilis = service.findAllUtilisateur();
		for(Utilisateur u : Utilis){
			System.out.println(u+ "is existing");
			
			em.close();
			emf.close();
		}
	}

}

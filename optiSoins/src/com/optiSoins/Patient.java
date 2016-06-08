/**
 * 
 */
package com.optiSoins;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Administrateur
 *
 */

@Entity
@Table(name = "patient")

public class Patient {
	
	@Id private int idPatient;
	private String Nom;
	private String Prenom;
	
	
	public Patient (){
		
	}
	public Patient (int id){
		this.idPatient=id;
	}
	public int getId() {
		return idPatient;
	}
	public void setId(int id) {
		this.idPatient = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	
}
	



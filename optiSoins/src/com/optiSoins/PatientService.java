/**
 * 
 */
package com.optiSoins;
import javax.persistence.*;
import java.util.List;

/**
 * @author Administrateur
 *
 */

public class PatientService {
	
	protected EntityManager em;
	
	public PatientService (EntityManager em){
		this.em=em;
	}

	public Patient createPatient (int id, String name, String lastName){
		Patient Pat = new Patient(id);
		Pat.setNom(name);
		Pat.setPrenom(lastName);
		return Pat;
	}
	

	
	
}

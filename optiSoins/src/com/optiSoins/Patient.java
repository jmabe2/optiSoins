/**
 * 
 */
package com.optiSoins;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Administrateur
 *
 */

@Entity

public class Patient {
	
	@Id private int id;
	private String Name;
	private String LastName;
	
	
	public Patient (){
		
	}
	public Patient (int id){
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	

}

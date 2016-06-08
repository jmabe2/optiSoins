package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@Table(name="patient")
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idPatient;

	private byte actif;

	@Column(length=255)
	private String adresse;

	@Temporal(TemporalType.DATE)
	private Date ddn;

	@Column(nullable=false, length=255)
	private String nom;

	@Column(nullable=false, length=255)
	private String prenom;

	@Column(length=255)
	private String sexe;

	//bi-directional many-to-one association to Sejour
	@OneToMany(mappedBy="patient")
	private List<Sejour> sejours;

	public Patient() {
	}

	public int getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDdn() {
		return this.ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Sejour> getSejours() {
		return this.sejours;
	}

	public void setSejours(List<Sejour> sejours) {
		this.sejours = sejours;
	}

	public Sejour addSejour(Sejour sejour) {
		getSejours().add(sejour);
		sejour.setPatient(this);

		return sejour;
	}

	public Sejour removeSejour(Sejour sejour) {
		getSejours().remove(sejour);
		sejour.setPatient(null);

		return sejour;
	}

}
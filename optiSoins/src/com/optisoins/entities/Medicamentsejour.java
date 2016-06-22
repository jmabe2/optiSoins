package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medicamentsejour database table.
 * 
 */
@Entity
@Table(name="medicamentsejour")
@NamedQuery(name="Medicamentsejour.findAll", query="SELECT m FROM Medicamentsejour m")
public class Medicamentsejour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idMedicamentSejour;

	private boolean actif;

	@Column(length=255)
	private String indication;

	@Column(length=255)
	private String posologie;

	@Column(length=255)
	private String remarque;

	//bi-directional many-to-one association to Sejour
	@ManyToOne
	@JoinColumn(name="SejourIdSejour", nullable=false)
	private Sejour sejour;

	//bi-directional many-to-one association to Medicament
	@ManyToOne
	@JoinColumn(name="MedicamentIdMedicament", nullable=false)
	private Medicament medicament;

	public Medicamentsejour() {
	}

	public int getIdMedicamentSejour() {
		return this.idMedicamentSejour;
	}

	public void setIdMedicamentSejour(int idMedicamentSejour) {
		this.idMedicamentSejour = idMedicamentSejour;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getIndication() {
		return this.indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getPosologie() {
		return this.posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Sejour getSejour() {
		return this.sejour;
	}

	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}

	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

}
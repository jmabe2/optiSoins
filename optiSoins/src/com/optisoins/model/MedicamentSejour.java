package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the medicament_sejour database table.
 * 
 */
@Entity
@Table(name="medicament_sejour")
@NamedQuery(name="MedicamentSejour.findAll", query="SELECT m FROM MedicamentSejour m")
public class MedicamentSejour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idMedicament_sejour;

	private byte actif;

	@Column(length=255)
	private String indication;

	@Column(length=255)
	private String posologie;

	@Column(length=255)
	private String remarque;

	//bi-directional many-to-one association to Medicament
	@ManyToOne
	@JoinColumn(name="Medicament_idMedicament", nullable=false)
	private Medicament medicament;

	//bi-directional many-to-one association to Sejour
	@ManyToOne
	@JoinColumn(name="Sejour_idSejour", nullable=false)
	private Sejour sejour;

	public MedicamentSejour() {
	}

	public int getIdMedicament_sejour() {
		return this.idMedicament_sejour;
	}

	public void setIdMedicament_sejour(int idMedicament_sejour) {
		this.idMedicament_sejour = idMedicament_sejour;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
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

	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Sejour getSejour() {
		return this.sejour;
	}

	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}

}
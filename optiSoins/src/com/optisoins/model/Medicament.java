package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicament database table.
 * 
 */
@Entity
@Table(name="medicament")
@NamedQuery(name="Medicament.findAll", query="SELECT m FROM Medicament m")
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idMedicament;

	private byte actif;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String nom;

	@Column(nullable=false)
	private int quantite_dispo;

	//bi-directional many-to-one association to MedicamentSejour
	@OneToMany(mappedBy="medicament")
	private List<MedicamentSejour> medicamentSejours;

	public Medicament() {
	}

	public int getIdMedicament() {
		return this.idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite_dispo() {
		return this.quantite_dispo;
	}

	public void setQuantite_dispo(int quantite_dispo) {
		this.quantite_dispo = quantite_dispo;
	}

	public List<MedicamentSejour> getMedicamentSejours() {
		return this.medicamentSejours;
	}

	public void setMedicamentSejours(List<MedicamentSejour> medicamentSejours) {
		this.medicamentSejours = medicamentSejours;
	}

	public MedicamentSejour addMedicamentSejour(MedicamentSejour medicamentSejour) {
		getMedicamentSejours().add(medicamentSejour);
		medicamentSejour.setMedicament(this);

		return medicamentSejour;
	}

	public MedicamentSejour removeMedicamentSejour(MedicamentSejour medicamentSejour) {
		getMedicamentSejours().remove(medicamentSejour);
		medicamentSejour.setMedicament(null);

		return medicamentSejour;
	}

}
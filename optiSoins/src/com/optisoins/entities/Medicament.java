package com.optisoins.entities;

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

	private boolean actif;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=255)
	private String nom;

	@Column(nullable=false)
	private int quantiteDispo;

	//bi-directional many-to-one association to Medicamentsejour
	@OneToMany(mappedBy="medicament")
	private List<Medicamentsejour> medicamentsejours;

	public Medicament() {
	}

	public int getIdMedicament() {
		return this.idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
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

	public int getQuantiteDispo() {
		return this.quantiteDispo;
	}

	public void setQuantiteDispo(int quantiteDispo) {
		this.quantiteDispo = quantiteDispo;
	}

	public List<Medicamentsejour> getMedicamentsejours() {
		return this.medicamentsejours;
	}

	public void setMedicamentsejours(List<Medicamentsejour> medicamentsejours) {
		this.medicamentsejours = medicamentsejours;
	}

	public Medicamentsejour addMedicamentsejour(Medicamentsejour medicamentsejour) {
		getMedicamentsejours().add(medicamentsejour);
		medicamentsejour.setMedicament(this);

		return medicamentsejour;
	}

	public Medicamentsejour removeMedicamentsejour(Medicamentsejour medicamentsejour) {
		getMedicamentsejours().remove(medicamentsejour);
		medicamentsejour.setMedicament(null);

		return medicamentsejour;
	}

}
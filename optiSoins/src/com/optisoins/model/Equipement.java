package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the equipement database table.
 * 
 */
@Entity
@Table(name="equipement")
@NamedQuery(name="Equipement.findAll", query="SELECT e FROM Equipement e")
public class Equipement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idEquipement;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String nom;

	//bi-directional many-to-one association to EquipementChambre
	@OneToMany(mappedBy="equipement")
	private List<EquipementChambre> equipementChambres;

	public Equipement() {
	}

	public int getIdEquipement() {
		return this.idEquipement;
	}

	public void setIdEquipement(int idEquipement) {
		this.idEquipement = idEquipement;
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

	public List<EquipementChambre> getEquipementChambres() {
		return this.equipementChambres;
	}

	public void setEquipementChambres(List<EquipementChambre> equipementChambres) {
		this.equipementChambres = equipementChambres;
	}

	public EquipementChambre addEquipementChambre(EquipementChambre equipementChambre) {
		getEquipementChambres().add(equipementChambre);
		equipementChambre.setEquipement(this);

		return equipementChambre;
	}

	public EquipementChambre removeEquipementChambre(EquipementChambre equipementChambre) {
		getEquipementChambres().remove(equipementChambre);
		equipementChambre.setEquipement(null);

		return equipementChambre;
	}

}
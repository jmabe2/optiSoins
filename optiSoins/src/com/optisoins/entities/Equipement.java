package com.optisoins.entities;

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

	@Column(nullable=false, length=255)
	private String nom;

	//bi-directional many-to-one association to Equipementchambre
	@OneToMany(mappedBy="equipement")
	private List<Equipementchambre> equipementchambres;

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

	public List<Equipementchambre> getEquipementchambres() {
		return this.equipementchambres;
	}

	public void setEquipementchambres(List<Equipementchambre> equipementchambres) {
		this.equipementchambres = equipementchambres;
	}

	public Equipementchambre addEquipementchambre(Equipementchambre equipementchambre) {
		getEquipementchambres().add(equipementchambre);
		equipementchambre.setEquipement(this);

		return equipementchambre;
	}

	public Equipementchambre removeEquipementchambre(Equipementchambre equipementchambre) {
		getEquipementchambres().remove(equipementchambre);
		equipementchambre.setEquipement(null);

		return equipementchambre;
	}

}
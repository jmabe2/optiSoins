package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipementchambre database table.
 * 
 */
@Entity
@Table(name="equipementchambre")
@NamedQuery(name="Equipementchambre.findAll", query="SELECT e FROM Equipementchambre e")
public class Equipementchambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idEquipementChambre;

	//bi-directional many-to-one association to Chambre
	@ManyToOne
	@JoinColumn(name="ChambreIdChambre", nullable=true)
	private Chambre chambre;

	//bi-directional many-to-one association to Equipement
	@ManyToOne
	@JoinColumn(name="EquipementIdEquipement", nullable=true)
	private Equipement equipement;

	public Equipementchambre() {
	}

	public int getIdEquipementChambre() {
		return this.idEquipementChambre;
	}

	public void setIdEquipementChambre(int idEquipementChambre) {
		this.idEquipementChambre = idEquipementChambre;
	}

	public Chambre getChambre() {
		return this.chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Equipement getEquipement() {
		return this.equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

}
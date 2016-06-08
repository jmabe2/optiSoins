package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipement_chambre database table.
 * 
 */
@Entity
@Table(name="equipement_chambre")
@NamedQuery(name="EquipementChambre.findAll", query="SELECT e FROM EquipementChambre e")
public class EquipementChambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idEquipement_chambre;

	//bi-directional many-to-one association to Chambre
	@ManyToOne
	@JoinColumn(name="Chambre_idChambre", nullable=false)
	private Chambre chambre;

	//bi-directional many-to-one association to Equipement
	@ManyToOne
	@JoinColumn(name="Equipement_idEquipement", nullable=false)
	private Equipement equipement;

	public EquipementChambre() {
	}

	public int getIdEquipement_chambre() {
		return this.idEquipement_chambre;
	}

	public void setIdEquipement_chambre(int idEquipement_chambre) {
		this.idEquipement_chambre = idEquipement_chambre;
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
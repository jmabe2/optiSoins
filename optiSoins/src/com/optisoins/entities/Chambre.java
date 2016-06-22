package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chambre database table.
 * 
 */
@Entity
@Table(name="chambre")
@NamedQuery(name="Chambre.findAll", query="SELECT c FROM Chambre c")
public class Chambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idChambre;

	private int numeroChambre;

	//bi-directional many-to-one association to Typechambre
	@ManyToOne
	@JoinColumn(name="TypeChambreIdTypeChambre", nullable=false)
	private Typechambre typechambre;

	//bi-directional many-to-one association to Equipementchambre
	@OneToMany(mappedBy="chambre")
	private List<Equipementchambre> equipementchambres;

	//bi-directional many-to-one association to Sejourchambre
	@OneToMany(mappedBy="chambre")
	private List<Sejourchambre> sejourchambres;

	public Chambre() {
	}

	public int getIdChambre() {
		return this.idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	public int getNumeroChambre() {
		return this.numeroChambre;
	}

	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}

	public Typechambre getTypechambre() {
		return this.typechambre;
	}

	public void setTypechambre(Typechambre typechambre) {
		this.typechambre = typechambre;
	}

	public List<Equipementchambre> getEquipementchambres() {
		return this.equipementchambres;
	}

	public void setEquipementchambres(List<Equipementchambre> equipementchambres) {
		this.equipementchambres = equipementchambres;
	}

	public Equipementchambre addEquipementchambre(Equipementchambre equipementchambre) {
		getEquipementchambres().add(equipementchambre);
		equipementchambre.setChambre(this);

		return equipementchambre;
	}

	public Equipementchambre removeEquipementchambre(Equipementchambre equipementchambre) {
		getEquipementchambres().remove(equipementchambre);
		equipementchambre.setChambre(null);

		return equipementchambre;
	}

	public List<Sejourchambre> getSejourchambres() {
		return this.sejourchambres;
	}

	public void setSejourchambres(List<Sejourchambre> sejourchambres) {
		this.sejourchambres = sejourchambres;
	}

	public Sejourchambre addSejourchambre(Sejourchambre sejourchambre) {
		getSejourchambres().add(sejourchambre);
		sejourchambre.setChambre(this);

		return sejourchambre;
	}

	public Sejourchambre removeSejourchambre(Sejourchambre sejourchambre) {
		getSejourchambres().remove(sejourchambre);
		sejourchambre.setChambre(null);

		return sejourchambre;
	}

}
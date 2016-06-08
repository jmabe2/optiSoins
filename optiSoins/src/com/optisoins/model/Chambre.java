package com.optisoins.model;

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

	private int numero_chambre;

	//bi-directional many-to-one association to TypeChambre
	@ManyToOne
	@JoinColumn(name="Type_chambre_idType_chambre", nullable=false)
	private TypeChambre typeChambre;

	//bi-directional many-to-one association to EquipementChambre
	@OneToMany(mappedBy="chambre")
	private List<EquipementChambre> equipementChambres;

	//bi-directional many-to-one association to SejourChambre
	@OneToMany(mappedBy="chambre")
	private List<SejourChambre> sejourChambres;

	public Chambre() {
	}

	public int getIdChambre() {
		return this.idChambre;
	}

	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}

	public int getNumero_chambre() {
		return this.numero_chambre;
	}

	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}

	public TypeChambre getTypeChambre() {
		return this.typeChambre;
	}

	public void setTypeChambre(TypeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	public List<EquipementChambre> getEquipementChambres() {
		return this.equipementChambres;
	}

	public void setEquipementChambres(List<EquipementChambre> equipementChambres) {
		this.equipementChambres = equipementChambres;
	}

	public EquipementChambre addEquipementChambre(EquipementChambre equipementChambre) {
		getEquipementChambres().add(equipementChambre);
		equipementChambre.setChambre(this);

		return equipementChambre;
	}

	public EquipementChambre removeEquipementChambre(EquipementChambre equipementChambre) {
		getEquipementChambres().remove(equipementChambre);
		equipementChambre.setChambre(null);

		return equipementChambre;
	}

	public List<SejourChambre> getSejourChambres() {
		return this.sejourChambres;
	}

	public void setSejourChambres(List<SejourChambre> sejourChambres) {
		this.sejourChambres = sejourChambres;
	}

	public SejourChambre addSejourChambre(SejourChambre sejourChambre) {
		getSejourChambres().add(sejourChambre);
		sejourChambre.setChambre(this);

		return sejourChambre;
	}

	public SejourChambre removeSejourChambre(SejourChambre sejourChambre) {
		getSejourChambres().remove(sejourChambre);
		sejourChambre.setChambre(null);

		return sejourChambre;
	}

}
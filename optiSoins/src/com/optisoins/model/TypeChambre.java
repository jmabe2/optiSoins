package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_chambre database table.
 * 
 */
@Entity
@Table(name="type_chambre")
@NamedQuery(name="TypeChambre.findAll", query="SELECT t FROM TypeChambre t")
public class TypeChambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idType_chambre;

	private boolean actif;

	@Column(length=255)
	private String nom;

	//bi-directional many-to-one association to Chambre
	@OneToMany(mappedBy="typeChambre")
	private List<Chambre> chambres;

	public TypeChambre() {
	}

	public int getIdType_chambre() {
		return this.idType_chambre;
	}

	public void setIdType_chambre(int idType_chambre) {
		this.idType_chambre = idType_chambre;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Chambre> getChambres() {
		return this.chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Chambre addChambre(Chambre chambre) {
		getChambres().add(chambre);
		chambre.setTypeChambre(this);

		return chambre;
	}

	public Chambre removeChambre(Chambre chambre) {
		getChambres().remove(chambre);
		chambre.setTypeChambre(null);

		return chambre;
	}

}
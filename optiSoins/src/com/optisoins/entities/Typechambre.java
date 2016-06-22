package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typechambre database table.
 * 
 */
@Entity
@Table(name="typechambre")
@NamedQuery(name="Typechambre.findAll", query="SELECT t FROM Typechambre t")
public class Typechambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTypeChambre;

	private boolean actif;

	@Column(nullable=false, length=255)
	private String nom;

	//bi-directional many-to-one association to Chambre
	@OneToMany(mappedBy="typechambre")
	private List<Chambre> chambres;

	public Typechambre() {
	}

	public int getIdTypeChambre() {
		return this.idTypeChambre;
	}

	public void setIdTypeChambre(int idTypeChambre) {
		this.idTypeChambre = idTypeChambre;
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
		chambre.setTypechambre(this);

		return chambre;
	}

	public Chambre removeChambre(Chambre chambre) {
		getChambres().remove(chambre);
		chambre.setTypechambre(null);

		return chambre;
	}

}
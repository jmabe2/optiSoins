package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sejour_chambre database table.
 * 
 */
@Entity
@Table(name="sejour_chambre")
@NamedQuery(name="SejourChambre.findAll", query="SELECT s FROM SejourChambre s")
public class SejourChambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idSejour_chambre;

	private byte actif;

	@Temporal(TemporalType.DATE)
	private Date date_entree;

	@Temporal(TemporalType.DATE)
	private Date date_sortie;

	//bi-directional many-to-one association to Chambre
	@ManyToOne
	@JoinColumn(name="Chambre_idChambre", nullable=false)
	private Chambre chambre;

	//bi-directional many-to-one association to Sejour
	@ManyToOne
	@JoinColumn(name="Sejour_idSejour", nullable=false)
	private Sejour sejour;

	public SejourChambre() {
	}

	public int getIdSejour_chambre() {
		return this.idSejour_chambre;
	}

	public void setIdSejour_chambre(int idSejour_chambre) {
		this.idSejour_chambre = idSejour_chambre;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDate_entree() {
		return this.date_entree;
	}

	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}

	public Date getDate_sortie() {
		return this.date_sortie;
	}

	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}

	public Chambre getChambre() {
		return this.chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Sejour getSejour() {
		return this.sejour;
	}

	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}

}
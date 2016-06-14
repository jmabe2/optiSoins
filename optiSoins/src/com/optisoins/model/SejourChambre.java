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

	private boolean actif;

	@Temporal(TemporalType.DATE)
	@Column (name="date_entree")
	private Date dateEntree;

	@Temporal(TemporalType.DATE)
	@Column (name="date_sortie")
	private Date dateSortie;

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

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return this.dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
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
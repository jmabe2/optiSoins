package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sejourchambre database table.
 * 
 */
@Entity
@Table(name="sejourchambre")
@NamedQuery(name="Sejourchambre.findAll", query="SELECT s FROM Sejourchambre s")
public class Sejourchambre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idSejourChambre;

	private boolean actif;

	@Temporal(TemporalType.DATE)
	private Date dateEntree;

	@Temporal(TemporalType.DATE)
	private Date dateSortie;

	//bi-directional many-to-one association to Chambre
	@ManyToOne
	@JoinColumn(name="ChambreIdChambre", nullable=false)
	private Chambre chambre;

	//bi-directional many-to-one association to Sejour
	@ManyToOne
	@JoinColumn(name="SejourIdSejour", nullable=false)
	private Sejour sejour;

	public Sejourchambre() {
	}

	public int getIdSejourChambre() {
		return this.idSejourChambre;
	}

	public void setIdSejourChambre(int idSejourChambre) {
		this.idSejourChambre = idSejourChambre;
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
package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the intervention database table.
 * 
 */
@Entity
@Table(name="intervention")
@NamedQuery(name="Intervention.findAll", query="SELECT i FROM Intervention i")
public class Intervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idIntervention;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String nom;

	//bi-directional many-to-one association to Sejour
	@ManyToOne
	@JoinColumn(name="Sejour_idSejour", nullable=false)
	private Sejour sejour;

	//bi-directional many-to-one association to TypeIntervention
	@ManyToOne
	@JoinColumn(name="Type_intervention_idType_intervention", nullable=false)
	private TypeIntervention typeIntervention;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="Utilisateur_idUtilisateur", nullable=false)
	private Utilisateur utilisateur;

	public Intervention() {
	}

	public int getIdIntervention() {
		return this.idIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		this.idIntervention = idIntervention;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public Sejour getSejour() {
		return this.sejour;
	}

	public void setSejour(Sejour sejour) {
		this.sejour = sejour;
	}

	public TypeIntervention getTypeIntervention() {
		return this.typeIntervention;
	}

	public void setTypeIntervention(TypeIntervention typeIntervention) {
		this.typeIntervention = typeIntervention;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeintervention database table.
 * 
 */
@Entity
@Table(name="typeintervention")
@NamedQuery(name="Typeintervention.findAll", query="SELECT t FROM Typeintervention t")
public class Typeintervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idTypeIntervention;

	@Column(nullable=false, length=255)
	private String libelle;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="typeintervention")
	private List<Intervention> interventions;

	public Typeintervention() {
	}

	public int getIdTypeIntervention() {
		return this.idTypeIntervention;
	}

	public void setIdTypeIntervention(int idTypeIntervention) {
		this.idTypeIntervention = idTypeIntervention;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setTypeintervention(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setTypeintervention(null);

		return intervention;
	}

}
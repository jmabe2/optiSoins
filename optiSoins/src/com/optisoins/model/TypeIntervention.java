package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the type_intervention database table.
 * 
 */
@Entity
@Table(name="type_intervention")
@NamedQuery(name="TypeIntervention.findAll", query="SELECT t FROM TypeIntervention t")
public class TypeIntervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idType_intervention;

	@Column(length=255)
	private String libelle;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="typeIntervention")
	private List<Intervention> interventions;

	public TypeIntervention() {
	}

	public int getIdType_intervention() {
		return this.idType_intervention;
	}

	public void setIdType_intervention(int idType_intervention) {
		this.idType_intervention = idType_intervention;
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
		intervention.setTypeIntervention(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setTypeIntervention(null);

		return intervention;
	}

}
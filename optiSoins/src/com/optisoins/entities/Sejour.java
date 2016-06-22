package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sejour database table.
 * 
 */
@Entity
@Table(name="sejour")
@NamedQuery(name="Sejour.findAll", query="SELECT s FROM Sejour s")
public class Sejour implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idSejour;

	private boolean actif;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateEntree;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateSortie;

	@Column(length=255)
	private String emplacement;

	@Column(nullable=false, length=255)
	private String motifSejour;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="sejour")
	private List<Intervention> interventions;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PatientIdPatient", nullable=false)
	private Patient patient;

	//bi-directional many-to-one association to Medicamentsejour
	@OneToMany(mappedBy="sejour")
	private List<Medicamentsejour> medicamentsejours;

	//bi-directional many-to-one association to Sejourchambre
	@OneToMany(mappedBy="sejour")
	private List<Sejourchambre> sejourchambres;

	public Sejour() {
	}

	public int getIdSejour() {
		return this.idSejour;
	}

	public void setIdSejour(int idSejour) {
		this.idSejour = idSejour;
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

	public String getEmplacement() {
		return this.emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getMotifSejour() {
		return this.motifSejour;
	}

	public void setMotifSejour(String motifSejour) {
		this.motifSejour = motifSejour;
	}

	public List<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setSejour(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setSejour(null);

		return intervention;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Medicamentsejour> getMedicamentsejours() {
		return this.medicamentsejours;
	}

	public void setMedicamentsejours(List<Medicamentsejour> medicamentsejours) {
		this.medicamentsejours = medicamentsejours;
	}

	public Medicamentsejour addMedicamentsejour(Medicamentsejour medicamentsejour) {
		getMedicamentsejours().add(medicamentsejour);
		medicamentsejour.setSejour(this);

		return medicamentsejour;
	}

	public Medicamentsejour removeMedicamentsejour(Medicamentsejour medicamentsejour) {
		getMedicamentsejours().remove(medicamentsejour);
		medicamentsejour.setSejour(null);

		return medicamentsejour;
	}

	public List<Sejourchambre> getSejourchambres() {
		return this.sejourchambres;
	}

	public void setSejourchambres(List<Sejourchambre> sejourchambres) {
		this.sejourchambres = sejourchambres;
	}

	public Sejourchambre addSejourchambre(Sejourchambre sejourchambre) {
		getSejourchambres().add(sejourchambre);
		sejourchambre.setSejour(this);

		return sejourchambre;
	}

	public Sejourchambre removeSejourchambre(Sejourchambre sejourchambre) {
		getSejourchambres().remove(sejourchambre);
		sejourchambre.setSejour(null);

		return sejourchambre;
	}

}
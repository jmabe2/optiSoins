package com.optisoins.model;

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

	private byte actif;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date_entree;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date_sortie;

	@Column(length=255)
	private String emplacement;

	@Column(length=255)
	private String motif_sejour;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="sejour")
	private List<Intervention> interventions;

	//bi-directional many-to-one association to MedicamentSejour
	@OneToMany(mappedBy="sejour")
	private List<MedicamentSejour> medicamentSejours;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="Patient_idPatient", nullable=false)
	private Patient patient;

	//bi-directional many-to-one association to SejourChambre
	@OneToMany(mappedBy="sejour")
	private List<SejourChambre> sejourChambres;

	public Sejour() {
	}

	public int getIdSejour() {
		return this.idSejour;
	}

	public void setIdSejour(int idSejour) {
		this.idSejour = idSejour;
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

	public String getEmplacement() {
		return this.emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getMotif_sejour() {
		return this.motif_sejour;
	}

	public void setMotif_sejour(String motif_sejour) {
		this.motif_sejour = motif_sejour;
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

	public List<MedicamentSejour> getMedicamentSejours() {
		return this.medicamentSejours;
	}

	public void setMedicamentSejours(List<MedicamentSejour> medicamentSejours) {
		this.medicamentSejours = medicamentSejours;
	}

	public MedicamentSejour addMedicamentSejour(MedicamentSejour medicamentSejour) {
		getMedicamentSejours().add(medicamentSejour);
		medicamentSejour.setSejour(this);

		return medicamentSejour;
	}

	public MedicamentSejour removeMedicamentSejour(MedicamentSejour medicamentSejour) {
		getMedicamentSejours().remove(medicamentSejour);
		medicamentSejour.setSejour(null);

		return medicamentSejour;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<SejourChambre> getSejourChambres() {
		return this.sejourChambres;
	}

	public void setSejourChambres(List<SejourChambre> sejourChambres) {
		this.sejourChambres = sejourChambres;
	}

	public SejourChambre addSejourChambre(SejourChambre sejourChambre) {
		getSejourChambres().add(sejourChambre);
		sejourChambre.setSejour(this);

		return sejourChambre;
	}

	public SejourChambre removeSejourChambre(SejourChambre sejourChambre) {
		getSejourChambres().remove(sejourChambre);
		sejourChambre.setSejour(null);

		return sejourChambre;
	}

}
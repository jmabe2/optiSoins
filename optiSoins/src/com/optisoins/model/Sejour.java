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

	private boolean actif;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name="date_entree")
	private Date dateEntree;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false, name="date_sortie")
	private Date dateSortie;

	@Column(length=255)
	private String emplacement;

	@Column(length=255, name="motif_sejour")
	private String motifSejour;

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

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDate_entree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDatSortie() {
		return this.dateSortie;
	}

	public void setDate_sortie(Date dateSortie) {
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
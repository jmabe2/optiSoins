package com.optisoins.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUtilisateur;

	private boolean actif;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateNaissance;

	@Column(nullable=false, length=255)
	private String login;

	@Column(nullable=false, length=255)
	private String motDePasse;

	@Column(nullable=false, length=255)
	private String nom;

	@Column(nullable=false, length=255)
	private String prenom;

	@Column(nullable=false, length=255)
	private String sexe;

	//bi-directional many-to-one association to Intervention
	@OneToMany(mappedBy="utilisateur")
	private List<Intervention> interventions;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleIdRole", nullable=false)
	private Role role;

	//bi-directional many-to-one association to Specialite
	@ManyToOne
	@JoinColumn(name="SpecialiteIdSpecialite")
	private Specialite specialite;

	public Utilisateur() {
	}

	public Utilisateur(int idUtilisateur) {

	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Intervention> getInterventions() {
		return this.interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public Intervention addIntervention(Intervention intervention) {
		getInterventions().add(intervention);
		intervention.setUtilisateur(this);

		return intervention;
	}

	public Intervention removeIntervention(Intervention intervention) {
		getInterventions().remove(intervention);
		intervention.setUtilisateur(null);

		return intervention;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Specialite getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

}
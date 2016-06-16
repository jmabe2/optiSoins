package com.optisoins.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the specialite database table.
 * 
 */
@Entity
@Table(name="specialite")
@NamedQuery(name="Specialite.findAll", query="SELECT s FROM Specialite s")
public class Specialite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idSpecialite;

	private boolean actif;

	@Column(nullable=false, length=255)
	private String specialite;

	//bi-directional many-to-one association to Utilisateur
	@OneToMany(mappedBy="specialite")
	private List<Utilisateur> utilisateurs;

	public Specialite() {
	}

	public int getIdSpecialite() {
		return this.idSpecialite;
	}

	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur addUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().add(utilisateur);
		utilisateur.setSpecialite(this);

		return utilisateur;
	}

	public Utilisateur removeUtilisateur(Utilisateur utilisateur) {
		getUtilisateurs().remove(utilisateur);
		utilisateur.setSpecialite(null);

		return utilisateur;
	}

}
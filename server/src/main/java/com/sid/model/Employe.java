package com.sid.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employe implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nom;
	private String prenom;
	private String profession;

	public Employe() {
		super();
	}

	public Employe(String nom, String prenom, String profession) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}

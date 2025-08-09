package com.test.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departement")
public class Departement {
	
	@Id
	@GeneratedValue()
	private int id;
	
	private String nom;
	
	@OneToMany
	private List<Personne> employes = new ArrayList<>();
	
	@ManyToOne
	private Personne directeur;

	public Departement() {
		super();
	}

	public Departement(int id, String nom, List<Personne> employes, Personne directeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.employes = employes;
		this.directeur = directeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Personne> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Personne> employes) {
		this.employes = employes;
	}

	public Personne getDirecteur() {
		return directeur;
	}

	public void setDirecteur(Personne directeur) {
		this.directeur = directeur;
	}
	

}

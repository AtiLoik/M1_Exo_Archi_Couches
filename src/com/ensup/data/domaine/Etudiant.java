package com.ensup.data.domaine;

public class Etudiant {

	// Propri�t�s
	private String id, nom, prenom, email;
	
	/**
	 * Constructeur de la classe Etudiant.
	 * @param id L'ID de l'�tudiant.
	 * @param nom Le nom de l'�tudiant.
	 * @param prenom Le pr�nom de l'�tudiant.
	 * @param email L'email de l'�tudiant
	 */
	public Etudiant(String id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

	// GETTERS SETTERS //
	public String getNom() {
		return nom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

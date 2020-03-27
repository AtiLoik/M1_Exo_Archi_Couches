package com.ensup.data.service;

import java.util.List;

import com.ensup.data.dao.EtudiantDAO;
import com.ensup.data.metier.Etudiant;

public class EtudiantService {

	private EtudiantDAO etudiantDao;
	
	/**
	 * Constructeur de la classe EtudiantService.
	 */
	public EtudiantService() {
		etudiantDao = new EtudiantDAO();
	}
	
	/**
	 * Appelle la m�thode createEtudiant() de la classe EtudiantDAO.
	 * @param prenom Le pr�nom de l'�tudiant.
	 * @param nom Le nom de l'�tudiant.
	 * @param email L'email de l'�tudiant.
	 * @param genre Le genre de l'�tudiant
	 */
	public void createEtudiant(String prenom, String nom, String email, String genre) {
		etudiantDao.createEtudiant(prenom, nom, email, genre);
	}
	
	/**
	 * Appelle la m�thode getEtudiantById() de la classe EtudiantDAO.
	 * @param id L'ID de l'�tudiant.
	 * @return Un objet de type �tudiant correspondant � l'ID pass� en argument.
	 */
	public Etudiant getEtudiantById(String id) {
		return etudiantDao.getEtudiantById(id);
	}
	
	public List<Etudiant> getAllEtudiants(){
		return etudiantDao.getAllEtudiants();
	}
}

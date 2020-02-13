package com.ensup.data.service;

import com.ensup.data.dao.EtudiantDAO;
import com.ensup.data.domaine.Etudiant;

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
	 */
	public void createEtudiant(String prenom, String nom, String email) {
		etudiantDao.createEtudiant(prenom, nom, email);
	}
	
	/**
	 * Appelle la m�thode getEtudiantById() de la classe EtudiantDAO.
	 * @param id L'ID de l'�tudiant.
	 * @return Un objet de type �tudiant correspondant � l'ID pass� en argument.
	 */
	public Etudiant getEtudiantById(String id) {
		return etudiantDao.getEtudiantById(id);
	}
}

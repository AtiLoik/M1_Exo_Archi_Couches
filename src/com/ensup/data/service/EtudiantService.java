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
	 * Appelle la méthode createEtudiant() de la classe EtudiantDAO.
	 * @param prenom Le prénom de l'étudiant.
	 * @param nom Le nom de l'étudiant.
	 * @param email L'email de l'étudiant.
	 */
	public void createEtudiant(String prenom, String nom, String email) {
		etudiantDao.createEtudiant(prenom, nom, email);
	}
	
	/**
	 * Appelle la méthode getEtudiantById() de la classe EtudiantDAO.
	 * @param id L'ID de l'étudiant.
	 * @return Un objet de type étudiant correspondant à l'ID passé en argument.
	 */
	public Etudiant getEtudiantById(String id) {
		return etudiantDao.getEtudiantById(id);
	}
}

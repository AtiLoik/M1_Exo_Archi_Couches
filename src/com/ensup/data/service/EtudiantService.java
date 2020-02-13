package com.ensup.data.service;

import com.ensup.data.dao.EtudiantDAO;
import com.ensup.data.domaine.Etudiant;

public class EtudiantService {

	/*Attributs: */
	private EtudiantDAO etudiantDao;
	
	/*Constructeur: */
	public EtudiantService() {
		etudiantDao = new EtudiantDAO();
	}
	
	/*Permet de créer un étudiant*/
	public void createEtudiant(String prenom, String nom, String email) {
		etudiantDao.createEtudiant(prenom, nom, email);
	}
	
	/*Permet de récupérer les information d'un étudiant (via le toString)*/
	public Etudiant getEtudiantById(String id) {
		return etudiantDao.getEtudiantById(id);
	}
}

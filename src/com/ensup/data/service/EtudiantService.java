package com.ensup.data.service;

import com.ensup.data.dao.EtudiantDAO;
import com.ensup.data.domaine.Etudiant;

public class EtudiantService {

	private EtudiantDAO etudiantDao;
	
	public EtudiantService() {
		etudiantDao = new EtudiantDAO();
	}
	
	public void creerEtudiant(String prenom, String nom, String email) {
		etudiantDao.creerEtudiant(prenom, nom, email);
	}
	
	public Etudiant recupererEtudiant(String id) {
		return etudiantDao.recupererEtudiant(id);
	}
}

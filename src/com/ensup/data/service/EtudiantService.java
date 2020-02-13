package com.ensup.data.service;

import com.ensup.data.dao.EtudiantDAO;
import com.ensup.data.domaine.Etudiant;

public class EtudiantService {

	private EtudiantDAO etudiantDao;
	
	public EtudiantService() {
		etudiantDao = new EtudiantDAO();
	}
	
	public void createEtudiant(String prenom, String nom, String email) {
		etudiantDao.createEtudiant(prenom, nom, email);
	}
	
	public Etudiant getEtudiantById(String id) {
		return etudiantDao.getEtudiantById(id);
	}
}

package com.ensup.data.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ensup.data.domaine.Etudiant;
import com.ensup.data.service.EtudiantService;

public class Main {

	public static void main(String[] args) {

		/*
		 * BufferReader = Permet de lire les informations entrées dans la console;
		 * Créer un étudiant pour interagir avec la BDD
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EtudiantService service = new EtudiantService();
		
		try {
			System.out.println("Bienvenue dans le programme Etudiant");
			String choix;
			// Affiche les interactions dans la console, jusqu'à ce qu'un choix valide soit fait
			do {
				System.out.println("Quelle action souhaitez vous faire ?");
				System.out.println("1 - Créer un utilisateur");
				System.out.println("2 - Récuperer informations");
				
				System.out.print("");
				
				choix = br.readLine();
			}while(!choix.equals("1") && !choix.equals("2"));
			
			/* Si un choix valide est effectué:
			- 1: Insere une personne dans la BDD;
			- 2: Affiche les détails d'une personne */
			if(choix.equals("1")) {
				System.out.print("Quel est votre prenom: ");
				String prenom = br.readLine();
				
				System.out.print("");
				
				System.out.print("Quel est votre nom: ");
				String nom = br.readLine();
				
				System.out.print("");
				
				System.out.print("Quel est votre email: ");
				String email = br.readLine();
				
				// Fait appel Ã  la fonction createEtudiant de service/EtudiantService.java
				service.createEtudiant(prenom, nom, email);
			}else if(choix.equals("2")) {
				System.out.print("Quel id souhaitez vous recupérer ?");
				String id = br.readLine();
				// Fait appel a la fonction getEtudiantById de service/EtudiantService et la met dans un objet etudiant pour vÃ©rifier s'il est null ou non
				Etudiant etudiant = service.getEtudiantById(id);
				// S'il est null, envoie d'un message d'erreur, sinon affiche l'Ã©tudiant
				if(etudiant != null) {
					System.out.println(etudiant.toString());
				}else {
					System.out.println("Aucun utilisateur ne correspond à cet ID !");
				}
			}
		//Affiche une exception en cas de problemes	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

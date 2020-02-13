package com.ensup.data.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.ensup.data.domaine.Etudiant;
import com.ensup.data.service.EtudiantService;

public class Main {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		EtudiantService service = new EtudiantService();
		
		try {
			System.out.println("Bienvenue dans le programme Etudiant");
			String choix;
			do {
				System.out.println("Quelle action souhaitez vous faire ?");
				System.out.println("1 - Créer un utilisateur");
				System.out.println("2 - Récuperer informations");
				
				System.out.print("");
				
				choix = br.readLine();
			}while(!choix.equals("1") && !choix.equals("2"));
			
			if(choix.equals("1")) {
				System.out.print("Quel est votre prenom: ");
				String prenom = br.readLine();
				
				System.out.print("");
				
				System.out.print("Quel est votre nom: ");
				String nom = br.readLine();
				
				System.out.print("");
				
				System.out.print("Quel est votre email: ");
				String email = br.readLine();
				
				service.creerEtudiant(prenom, nom, email);
			}else if(choix.equals("2")) {
				System.out.print("Quel id souhaitez vous recupérer ?");
				String id = br.readLine();
				Etudiant etudiant = service.recupererEtudiant(id);
				System.out.println(etudiant.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

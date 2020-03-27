package com.ensup.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ensup.data.metier.Etudiant;

public class EtudiantDAO {

	private final String url = "jdbc:mysql://localhost/archi_couche_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private final String login = "root";
	private final String passwd = "";
	
	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	/**
	 * Constructeur de la classe EtudiantDAO.
	 */
	public EtudiantDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Ins�re un �tudiant dans la base de donn�es.
	 * @param prenom Le pr�nom de l'�tudiant.
	 * @param nom Le nom de l'�tudiant.
	 * @param email L'email de l'�tudiant.
	 * @return True
	 */
	public boolean createEtudiant(String prenom, String nom, String email, String genre) {
		try {
			String sql = "INSERT into etudiant (nom, prenom, email, genre) VALUES "
					+ "('"+nom+"'"
					+ ",'"+prenom+"'"
					+ ", '"+email+"'"
					+ ", '"+genre+"'"
					+")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * R�cup�re un �tudiant en fonction d'un ID.
	 * @param id L'ID de l'�tudiant.
	 * @return Un objet de type Etudiant correspondant � l'ID pass� en argument.
	 */
	public Etudiant getEtudiantById(String id) {
		try {
			String sql = "SELECT * FROM etudiant WHERE id = " + id + "";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return new Etudiant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("genre"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Etudiant> getAllEtudiants(){
		List<Etudiant> etudiants = new ArrayList<Etudiant>();
		
		try {
			String sql = "SELECT * FROM etudiant";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String mail = rs.getString("email");
				String genre = rs.getString("genre");
				
				etudiants.add(new Etudiant(id, nom, prenom, mail, genre));
			}
			return etudiants;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

package com.ensup.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ensup.data.domaine.Etudiant;

public class EtudiantDAO {

	private static String url = "jdbc:mysql://localhost/archi_couche_1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String login = "root";
	private static String passwd = "";
	
	private Connection cn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
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
	
	public boolean createEtudiant(String prenom, String nom, String email) {
		try {
			String sql = "INSERT into etudiant (nom, prenom, email) VALUES "
					+ "('"+nom+"'"
					+ ",'"+prenom+"'"
					+ ", '"+email+"'"
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
	
	public Etudiant getEtudiantById(String id) {
		try {
			String sql = "SELECT * FROM etudiant WHERE id = " + id + "";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return new Etudiant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
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
}

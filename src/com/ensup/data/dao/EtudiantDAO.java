package com.ensup.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ensup.data.domaine.Etudiant;

public class EtudiantDAO {

	static String url = "jdbc:mysql://localhost/uml_java2";
	static String login = "root";
	static String passwd = "";
	
	public boolean create(String prenom, String nom, String email) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "INSERT into etudiant (id_ecole, prenom, nom, numeroEtudiant) VALUES "
					+ "('"+prenom+"'"
					+ ",'"+nom+"'"
					+ ", '"+email+"'"
					+")";
			System.out.println(sql);
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public Etudiant getById(String id) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url, login, passwd);
			st = cn.createStatement();
			String sql = "SELECT * FROM etudiant WHERE id = " + id + "";
			System.out.println(sql);
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				return new Etudiant(rs.getString("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e ) {
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

package it.polito.tdp.ruzzle.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.ruzzle.DAO.DBConnect;

public class DAO {
	
	public boolean searchSequence(String sequence) {

		Connection conn = DBConnect.getConnection();

		String sql = "SELECT nome FROM parola WHERE nome LIKE ?";

		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, sequence + "%");
			ResultSet res = st.executeQuery();

			if (res.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database AA");
		}
	}

	public boolean isContenutaInDizionario(String parola) {
		Connection connection = DBConnect.getConnection();
		final String sql = "SELECT nome FROM parola WHERE nome=?";
		try {	
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				System.out.println("esiste: " + parola);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db");
		}
	}
	
	public boolean searchWord(String word) {

		Connection conn = DBConnect.getConnection();

		String sql = "SELECT nome FROM parola WHERE nome=?;";

		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, word);
			ResultSet res = st.executeQuery();

			if (res.next()) {
				System.out.println("esiste: " + word);
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database AA");
		}
	}
}


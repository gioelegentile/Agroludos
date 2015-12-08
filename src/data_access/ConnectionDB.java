/*
 * 
 */
package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionDB.
 */
class ConnectionDB {

	/** The db. */
	private Connection db = null; // Connessione al Database
	
	/** The path. */
	private String path;
	
	/** The name. */
	private String name; // Nome del Database
	
	/** The username. */
	private String username; // Nome utente per la connessione al Database
	
	/** The password. */
	private String password; // Password usata per la connessione al Database
	
	/** The connection. */
	private boolean connection;

	/**
	 * Instantiates a new connection db.
	 */
	ConnectionDB() {

		this.path = "localhost:3306";
		this.name = "agroludos";
		this.username = "root";
		this.password = "root";
		this.connection = false;
		
//		this.path = "sql3.freemysqlhosting.net:3306";
//		this.name = "sql367212";
//		this.username = "sql367212";
//		this.password = "aM5*fZ1*";
//		this.connection = false;
		
	}

	/**
	 * Connect db.
	 *
	 * @return the connection
	 */
	Connection connectDB() {

		try {

			new com.mysql.jdbc.Driver();
			db = DriverManager.getConnection("jdbc:mysql://" + path + "/"
					+ name, username, password);
			connection = true;

		} catch (SQLException e) {

			connection = false;
			e.printStackTrace();

		}

		return db;

	}

	/**
	 * Disconnect.
	 */
	void disconnect() {

		connection = false;

		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Checks if is connected.
	 *
	 * @return true, if is connected
	 */
	boolean isConnected() {
		return connection;
	}

	/**
	 * Update.
	 *
	 * @param stat the stat
	 * @throws SQLException the SQL exception
	 */
	void update(PreparedStatement stat) throws SQLException {
		try {
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
	}
	
	/**
	 * Select.
	 *
	 * @param stmt the stmt
	 * @return the array list
	 * @throws SQLException the SQL exception
	 */
	ArrayList<ArrayList<String>> select(PreparedStatement stmt) throws SQLException {
		ArrayList<ArrayList<String>> v = null;
		ArrayList<String> record;
		int colonne = 0;

		try {

			ResultSet rs = stmt.executeQuery();
			v = new ArrayList<ArrayList<String>>();
			ResultSetMetaData rsmd = rs.getMetaData();
			colonne = rsmd.getColumnCount();

			while (rs.next()) {
				record = new ArrayList<String>();
				for (int i = 0; i < colonne; i++)
					record.add(rs.getString(i + 1));
				v.add((ArrayList<String>) record);
			}

			rs.close();
			return v;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}

	}

}

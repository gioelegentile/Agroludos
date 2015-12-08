/*
 * 
 */
package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import email.Email;
import email.Email.Choise;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The connection db. */
	static ConnectionDB connectionDB = new ConnectionDB();
	
	/** The connection. */
	static Connection connection = connectionDB.connectDB();

	/**
	 * Riconnette al database nel caso si voglia eseguire una seconda query,
	 * come per esempio nei metodi privati.
	 */
	public void connect() {
		connectionDB = new ConnectionDB();
		connection = connectionDB.connectDB();
	}

	// PARTICIPATIONS

	/**
	 * Gets the participations data.
	 *
	 * @param id the id
	 * @return the participations data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationsData(String id)
			throws SQLException {

		connect();

		String query = "SELECT DISTINCT " + DBValues.PLY_USERNAME + ","
				+ DBValues.PLY_SIGNUPDATE + "," + DBValues.PLY_SIGNUPTIME
				+ " FROM " + DBValues.PLY_TAB + " WHERE " + DBValues.PLY_ID
				+ " =? ORDER BY " + DBValues.PLY_SIGNUPDATE + ", "
				+ DBValues.PLY_SIGNUPTIME + " ;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Update participation optionals.
	 *
	 * @param id the id
	 * @param username the username
	 * @param optionals the optionals
	 * @throws SQLException the SQL exception
	 */
	public void updateParticipationOptionals(String id, String username,
			ArrayList<String> optionals) throws SQLException {

		DAO dao = this;

		ArrayList<ArrayList<String>> playerData = getParticipationData(id,
				username);

		for (int i = 0; i < playerData.size(); i++) {
			dao.deleteParticipation(id, playerData.get(i).get(0));
		}

		dao.addParticipation(id, optionals, playerData.get(0).get(0),
				playerData.get(0).get(1), playerData.get(0).get(2));

	}

	/**
	 * Adds the participation.
	 *
	 * @param id the id
	 * @param optionals the optionals
	 * @param username the username
	 * @param date the date
	 * @param time the time
	 * @throws SQLException the SQL exception
	 */
	public void addParticipation(String id, ArrayList<String> optionals,
			String username, String date, String time) throws SQLException {

		float price = getTotalPrice(id, optionals);

		String query = "INSERT INTO " + DBValues.PLY_TAB
				+ " VALUES (?, ?, ?, ?, ?, ?);";

		try {

			for (int i = 0; i < optionals.size(); i++) {
				PreparedStatement statement = connection
						.prepareStatement(query);

				statement.setString(1, id);
				statement.setString(2, optionals.get(i));
				statement.setString(3, username);
				statement.setString(4, date);
				statement.setString(5, time);
				statement.setFloat(6, price);
				connectionDB.update(statement);
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete participation.
	 *
	 * @param id the id
	 * @param username the username
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteParticipation(String id, String username)
			throws SQLException {

		String query = "DELETE FROM " + DBValues.PLY_TAB + " WHERE "
				+ DBValues.PLY_USERNAME + " = ? AND " + DBValues.PLY_ID
				+ " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, id);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the participations.
	 *
	 * @param id the id
	 * @return the participations
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipations(String id)
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.USR_USERNAME + ","
				+ DBValues.USR_NAME + "," + DBValues.USR_SURNAME + ","
				+ DBValues.USR_FISCALCODE + "," + DBValues.USR_SEX + ","
				+ DBValues.USR_HEALTHCARDNUMBER + "," + DBValues.USR_BIRTHDATE
				+ "," + DBValues.USR_CERTIFICATEDATE + ","
				+ DBValues.USR_ADDRESS + "," + DBValues.PLY_SIGNUPDATE + ","
				+ DBValues.PLY_SIGNUPTIME + "," + DBValues.PLY_PRICE + " FROM "
				+ DBValues.USR_TAB + " JOIN " + DBValues.PLY_TAB + " ON "
				+ DBValues.PLY_TAB + "." + DBValues.PLY_USERNAME + " = "
				+ DBValues.USR_TAB + "." + DBValues.USR_USERNAME + " WHERE "
				+ DBValues.PLY_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the price.
	 *
	 * @param id the id
	 * @param username the username
	 * @return the price
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getPrice(String id, String username)
			throws SQLException {

		String query = "SELECT " + DBValues.PLY_PRICE + " FROM "
				+ DBValues.PLY_TAB + " WHERE " + DBValues.PLY_ID + " = ? AND "
				+ DBValues.PLY_USERNAME + " = ? ;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the participation data.
	 *
	 * @param id the id
	 * @param username the username
	 * @return the participation data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationData(String id,
			String username) throws SQLException {

		connect();

		String query = "SELECT DISTINCT " + DBValues.PLY_USERNAME + ","
				+ DBValues.PLY_SIGNUPDATE + "," + DBValues.PLY_SIGNUPTIME + ","
				+ DBValues.PLY_PRICE + " FROM " + DBValues.PLY_TAB + " WHERE "
				+ DBValues.PLY_ID + " =? AND " + DBValues.PLY_USERNAME
				+ " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the participation optionals.
	 *
	 * @param id the id
	 * @param username the username
	 * @return the participation optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationOptionals(String id,
			String username) throws SQLException {

		String query = "SELECT " + DBValues.PLY_OPTIONAL + " FROM "
				+ DBValues.PLY_TAB + " WHERE " + DBValues.PLY_ID + " = ? AND "
				+ DBValues.PLY_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	// MANAGER

	/**
	 * Gets the users not manager.
	 *
	 * @return the users not manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsersNotManager() throws SQLException {
		
		String query = "select user_login from login where user_login not in (select * from managers);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
	}
	
	/**
	 * Gets the managers.
	 *
	 * @return the managers
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getManagers() throws SQLException {

		String query = "SELECT * FROM " + DBValues.MNG_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Adds the manager.
	 *
	 * @param username the username
	 * @throws SQLException the SQL exception
	 */
	public void addManager(String username) throws SQLException {

		String query = "INSERT INTO " + DBValues.MNG_TAB + " VALUES " + "("
				+ "?);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete manager.
	 *
	 * @param username the username
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteManager(String username) throws SQLException {

		String query = "DELETE FROM " + DBValues.MNG_TAB + " WHERE "
				+ DBValues.MNG_USERNAME + " =?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete all managers.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteAllManagers() throws SQLException {

		String query = "DELETE FROM " + DBValues.MNG_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the manager email.
	 *
	 * @param username the username
	 * @return the manager email
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getManagerEmail(String username)
			throws SQLException {

		connect();

		String query = "SELECT " + DBValues.GST_EMAIL + " FROM "
				+ DBValues.GST_TAB + " JOIN " + DBValues.MNG_TAB + " ON "
				+ DBValues.GST_TAB + "." + DBValues.GST_USERNAME + " = "
				+ DBValues.MNG_TAB + "." + DBValues.MNG_USERNAME + " WHERE "
				+ DBValues.MNG_TAB + "." + DBValues.MNG_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}
	
	// COMPETITION

	/**
	 * Creates the competition.
	 *
	 * @param type the type
	 * @param date the date
	 * @param time the time
	 * @param manager the manager
	 * @param price the price
	 * @param min the min
	 * @param max the max
	 * @param optionals the optionals
	 * @throws SQLException the SQL exception
	 */
	public void createCompetition(String type, String date, String time,
			String manager, String price, String min, String max,
			ArrayList<String> optionals) throws SQLException {

		ArrayList<ArrayList<String>> IDs = getIDs();

		boolean found = true;
		int index = 1;
		int j = 0;
		while (j < IDs.size() && found) {
			found = IDs.get(j).get(0).equals(index + "");
			if (found) {
				j++;
				index++;
			}
		}

		String email = getManagerEmail(manager).get(0).get(0);
		String query = "INSERT INTO " + DBValues.CPT_TAB
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, true);";

		try {

			for (int i = 0; i < optionals.size(); i++) {
				PreparedStatement statement = connection
						.prepareStatement(query);

				statement.setString(1, index + "");
				statement.setString(2, optionals.get(i));
				statement.setString(3, type);
				statement.setString(4, manager);
				statement.setString(5, email);
				statement.setString(6, date);
				statement.setString(7, time);
				statement.setString(8, min);
				statement.setString(9, max);
				statement.setString(10, price);
				connectionDB.update(statement);
			}

		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Dispose competition.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean disposeCompetition(String id) throws SQLException {

		deleteParticipations(id);

		String query = "UPDATE " + DBValues.CPT_TAB + " SET "
				+ DBValues.CPT_ACTIVE + " = ? WHERE " + DBValues.CPT_ID
				+ "= ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, false);
			statement.setString(2, id);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Update competition.
	 *
	 * @param id the id
	 * @param type the type
	 * @param date the date
	 * @param time the time
	 * @param manager the manager
	 * @param price the price
	 * @param min the min
	 * @param max the max
	 * @param optionals the optionals
	 * @throws SQLException the SQL exception
	 */
	public void updateCompetition(String id, String type, String date,
			String time, String manager, String price, String min, String max,
			ArrayList<String> optionals) throws SQLException {

		DAO dao = this;
		ArrayList<ArrayList<String>> playersData = getParticipationsData(id);

		if (playersData.size() != 0) {

			ArrayList<ArrayList<String>> playerOptionals = new ArrayList<ArrayList<String>>();

			ArrayList<String> details = new ArrayList<String>();
			details.add(manager);
			details.add(id);
			details.add("Il manager ha diminuito il numero massimo di iscrizioni disponibili.");

			ArrayList<String> emails = getEmails(id);

			for (int i = 0; i < playersData.size(); i++) {
				playerOptionals.add(checkParticipationOptional(id, playersData
						.get(i).get(0), optionals));
				dao.deleteParticipation(id, playersData.get(i).get(0));
			}

			deleteCompetition(id);
			createCompetition(type, date, time, manager, price, min, max,
					optionals);

			int i = 0;
			for (; i < Integer.parseInt(max) && i < playerOptionals.size(); i++) {
				if (playerOptionals.get(i).size() == 0) {
					ArrayList<String> p = new ArrayList<String>();
					p.add("0");
					dao.addParticipation(id, p, playersData.get(i).get(0),
							playersData.get(i).get(1), playersData.get(i)
									.get(2));
				} else {
					dao.addParticipation(id, playerOptionals.get(i),
							playersData.get(i).get(0), playersData.get(i)
									.get(1), playersData.get(i).get(2));
				}
			}

			for (int j = i; j < playersData.size(); j++) {
				Email.send(emails.get(i), Choise.DELETE_PARTICIPATION_BY_MANAGER, details);
			}

		} else {
			deleteCompetition(id);
			createCompetition(type, date, time, manager, price, min, max,
					optionals);
		}

	}

	/**
	 * Gets the competitions as admin.
	 *
	 * @return the competitions as admin
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsAdmin()
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_ID + ","
				+ DBValues.CPT_TYPE + ", " + DBValues.CPT_MANAGER + ", "
				+ DBValues.CPT_EMAIL + ", " + DBValues.CPT_DATE + ", "
				+ DBValues.CPT_TIME + ", " + DBValues.CPT_MIN + ", "
				+ DBValues.CPT_MAX + ", " + DBValues.CPT_PRICE + ", "
				+ DBValues.CPT_ACTIVE + " FROM " + DBValues.CPT_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competitions as manager.
	 *
	 * @param username the username
	 * @return the competitions as manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsManager(String username)
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_ID + ","
				+ DBValues.CPT_TYPE + ", " + DBValues.CPT_MANAGER + ", "
				+ DBValues.CPT_EMAIL + ", " + DBValues.CPT_DATE + ", "
				+ DBValues.CPT_TIME + ", " + DBValues.CPT_MIN + ", "
				+ DBValues.CPT_MAX + ", " + DBValues.CPT_PRICE + " FROM "
				+ DBValues.CPT_TAB + " WHERE " + DBValues.CPT_MANAGER
				+ " = ? AND " + DBValues.CPT_ACTIVE + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setBoolean(2, true);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competitions as player.
	 *
	 * @param username the username
	 * @return the competitions as player
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsPlayer(String username)
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_TAB + "."
				+ DBValues.CPT_ID + "," + DBValues.CPT_TYPE + ", "
				+ DBValues.CPT_MANAGER + ", " + DBValues.CPT_EMAIL + ", "
				+ DBValues.CPT_DATE + ", " + DBValues.CPT_TIME + ", "
				+ DBValues.CPT_MIN + ", " + DBValues.CPT_MAX + ", "
				+ DBValues.CPT_PRICE + " FROM " + DBValues.CPT_TAB + " JOIN "
				+ DBValues.PLY_TAB + " ON " + DBValues.CPT_TAB + "."
				+ DBValues.CPT_ID + " = " + DBValues.PLY_TAB + "."
				+ DBValues.PLY_ID + " WHERE " + DBValues.PLY_USERNAME
				+ " = ? AND " + DBValues.CPT_ACTIVE + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setBoolean(2, true);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competitions as user.
	 *
	 * @return the competitions as user
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsUser()
			throws SQLException {
		String query = "SELECT DISTINCT " + DBValues.CPT_ID + ","
				+ DBValues.CPT_TYPE + ", " + DBValues.CPT_MANAGER + ", "
				+ DBValues.CPT_EMAIL + ", " + DBValues.CPT_DATE + ", "
				+ DBValues.CPT_TIME + ", " + DBValues.CPT_MIN + ", "
				+ DBValues.CPT_MAX + ", " + DBValues.CPT_PRICE + " FROM "
				+ DBValues.CPT_TAB + " WHERE " + DBValues.CPT_ACTIVE + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, true);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the active competitions.
	 *
	 * @return the active competitions
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getActiveCompetitions()
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_ID + ","
				+ DBValues.CPT_TYPE + ", " + DBValues.CPT_MANAGER + ", "
				+ DBValues.CPT_EMAIL + ", " + DBValues.CPT_DATE + ", "
				+ DBValues.CPT_TIME + ", " + DBValues.CPT_MIN + ", "
				+ DBValues.CPT_MAX + ", " + DBValues.CPT_PRICE + ", "
				+ DBValues.CPT_ACTIVE + " FROM " + DBValues.CPT_TAB + " WHERE "
				+ DBValues.CPT_ACTIVE + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setBoolean(1, true);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the email.
	 *
	 * @param id the id
	 * @return the email
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getEmail(String id) throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_EMAIL + " FROM "
				+ DBValues.CPT_TAB + " WHERE " + DBValues.CPT_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competition data.
	 *
	 * @param id the id
	 * @return the competition data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionData(String id)
			throws SQLException {

		String query = "SELECT DISTINCT " + DBValues.CPT_ID + ","
				+ DBValues.CPT_TYPE + ", " + DBValues.CPT_MANAGER + ", "
				+ DBValues.CPT_EMAIL + ", " + DBValues.CPT_DATE + ", "
				+ DBValues.CPT_TIME + ", " + DBValues.CPT_MIN + ", "
				+ DBValues.CPT_MAX + ", " + DBValues.CPT_PRICE + ", "
				+ DBValues.CPT_ACTIVE + " FROM " + DBValues.CPT_TAB + " WHERE "
				+ DBValues.CPT_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competition optionals.
	 *
	 * @param id the id
	 * @return the competition optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionOptionals(String id)
			throws SQLException {

		String query = "SELECT " + DBValues.CPT_OPTIONAL + " FROM "
				+ DBValues.CPT_TAB + " WHERE " + DBValues.CPT_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the total price.
	 *
	 * @param id the id
	 * @param optionals the optionals
	 * @return the total price
	 * @throws NumberFormatException the number format exception
	 * @throws SQLException the SQL exception
	 */
	public float getTotalPrice(String id, ArrayList<String> optionals)
			throws NumberFormatException, SQLException {

		float price = 0;

		for (int i = 0; i < optionals.size(); i++) {
			price += Float.parseFloat(getOptionalPrice(optionals.get(i)).get(0)
					.get(0));
		}

		price += Float.parseFloat(getCompetitionPrice(id).get(0).get(0));
		return price;

	}

	// USER

	/**
	 * Gets the users.
	 *
	 * @return the users
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsers() throws SQLException {

		String query = "SELECT * FROM " + DBValues.USR_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Adds the user.
	 *
	 * @param username the username
	 * @param name the name
	 * @param surname the surname
	 * @param fiscalCode the fiscal code
	 * @param sex the sex
	 * @param birthDate the birth date
	 * @param healthCard the health card
	 * @param certificateDate the certificate date
	 * @param address the address
	 * @throws SQLException the SQL exception
	 */
	public void addUser(String username, String name, String surname,
			String fiscalCode, String sex, String birthDate, String healthCard,
			String certificateDate, String address) throws SQLException {

		String query = "INSERT INTO " + DBValues.USR_TAB + " VALUES " + "("
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, name);
			statement.setString(3, surname);
			statement.setString(4, fiscalCode);
			statement.setString(5, sex);
			statement.setString(6, birthDate);
			statement.setString(7, healthCard);
			statement.setString(8, certificateDate);
			statement.setString(9, address);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Update user data.
	 *
	 * @param username the username
	 * @param name the name
	 * @param surname the surname
	 * @param fiscalCode the fiscal code
	 * @param sex the sex
	 * @param birthDate the birth date
	 * @param healthCard the health card
	 * @param certificateDate the certificate date
	 * @param address the address
	 * @throws SQLException the SQL exception
	 */
	public void updateUserData(String username, String name, String surname,
			String fiscalCode, String sex, String birthDate, String healthCard,
			String certificateDate, String address) throws SQLException {

		String query = "UPDATE " + DBValues.USR_TAB + " SET ";

		if (!name.isEmpty())
			query += DBValues.USR_NAME + " = '" + name + "' ,";
		if (!surname.isEmpty())
			query += DBValues.USR_SURNAME + " = '" + surname + "' ,";
		if (!fiscalCode.isEmpty())
			query += DBValues.USR_FISCALCODE + " = '" + fiscalCode + "' ,";
		if (!sex.isEmpty())
			query += DBValues.USR_SEX + " = '" + sex + "' ,";
		if (!birthDate.isEmpty())
			query += DBValues.USR_BIRTHDATE + " = '" + birthDate + "' ,";
		if (!healthCard.isEmpty())
			query += DBValues.USR_HEALTHCARDNUMBER + " = '" + healthCard
					+ "' ,";
		if (!certificateDate.isEmpty())
			query += DBValues.USR_CERTIFICATEDATE + " = '" + certificateDate
					+ "' ,";
		if (!address.isEmpty())
			query += DBValues.USR_ADDRESS + " = '" + address + "' ,";

		query = query.substring(0, query.length() - 2);
		query += " WHERE " + DBValues.USR_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Update guest data.
	 *
	 * @param username the username
	 * @param password the password
	 * @param email the email
	 * @throws SQLException the SQL exception
	 */
	public void updateGuestData(String username, String password, String email)
			throws SQLException {

		String query = "UPDATE " + DBValues.GST_TAB + " SET ";

		if (!password.isEmpty())
			query += DBValues.GST_PASSWORD + " = '" + password + "' ,";
		if (!email.isEmpty())
			query += DBValues.GST_EMAIL + " = '" + email + "' ,";

		query = query.substring(0, query.length() - 1);
		query += "WHERE " + DBValues.GST_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the user data.
	 *
	 * @param username the username
	 * @return the user data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUserData(String username)
			throws SQLException {

		String query = "SELECT * FROM " + DBValues.USR_TAB + " WHERE "
				+ DBValues.USR_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Adds the guest.
	 *
	 * @param username the username
	 * @param password the password
	 * @param email the email
	 * @throws SQLException the SQL exception
	 */
	public void addGuest(String username, String password, String email)
			throws SQLException {

		String query = "INSERT INTO " + DBValues.GST_TAB + " VALUES "
				+ "(?,?,?);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			statement.setString(3, email);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getGuests() throws SQLException {

		String query = "SELECT * FROM " + DBValues.GST_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the guest.
	 *
	 * @param username the username
	 * @return the guest
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getGuest(String username)
			throws SQLException {

		String query = "SELECT * FROM " + DBValues.GST_TAB + " WHERE "
				+ DBValues.GST_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	// ADMIN

	/**
	 * Gets the optionals.
	 *
	 * @return the optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getOptionals() throws SQLException {

		String query = "SELECT * FROM " + DBValues.OPT_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Adds the optional.
	 *
	 * @param name the name
	 * @param price the price
	 * @throws SQLException the SQL exception
	 */
	public void addOptional(String name, String price) throws SQLException {

		String query = "INSERT INTO " + DBValues.OPT_TAB + " VALUES " + "("
				+ "0, ?, ?);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, price);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete optional.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteOptional(String id) throws SQLException {

		String query = "DELETE FROM " + DBValues.OPT_TAB + " WHERE "
				+ DBValues.OPT_ID + " =?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the types.
	 *
	 * @return the types
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getTypes() throws SQLException {

		String query = "SELECT * FROM " + DBValues.TYP_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Adds the type.
	 *
	 * @param name the name
	 * @throws SQLException the SQL exception
	 */
	public void addType(String name) throws SQLException {

		String query = "INSERT INTO " + DBValues.TYP_TAB + " VALUES " + "("
				+ "0, ?);";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete type.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteType(String id) throws SQLException {

		String query = "DELETE FROM " + DBValues.TYP_TAB + " WHERE "
				+ DBValues.TYP_ID + " =?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	// PRIVATE

	/**
	 * Gets the optional price.
	 *
	 * @param id the id
	 * @return the optional price
	 * @throws SQLException the SQL exception
	 */
	private ArrayList<ArrayList<String>> getOptionalPrice(String id)
			throws SQLException {

		connect();

		String query = "SELECT " + DBValues.OPT_PRICE + " FROM "
				+ DBValues.OPT_TAB + " WHERE " + DBValues.OPT_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the competition price.
	 *
	 * @param id the id
	 * @return the competition price
	 * @throws SQLException the SQL exception
	 */
	private ArrayList<ArrayList<String>> getCompetitionPrice(String id)
			throws SQLException {

		connect();

		String query = "SELECT DISTINCT " + DBValues.CPT_PRICE + " FROM "
				+ DBValues.CPT_TAB + " WHERE " + DBValues.CPT_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Check participation optional.
	 *
	 * @param id the id
	 * @param username the username
	 * @param optionals the optionals
	 * @return the array list
	 * @throws SQLException the SQL exception
	 */
	private ArrayList<String> checkParticipationOptional(String id,
			String username, ArrayList<String> optionals) throws SQLException {

		connect();

		ArrayList<String> modOptionals = new ArrayList<String>();
		ArrayList<ArrayList<String>> optionalList = new ArrayList<ArrayList<String>>();

		String query = "SELECT  " + DBValues.PLY_OPTIONAL + " FROM "
				+ DBValues.PLY_TAB + " WHERE " + DBValues.PLY_ID + " =? AND "
				+ DBValues.PLY_USERNAME + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			statement.setString(2, username);
			optionalList = connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

		for (int i = 0; i < optionals.size(); i++) {
			for (int j = 0; j < optionalList.size(); j++) {
				if (optionalList.get(j).get(0).equals(optionals.get(i))) {
					modOptionals.add(optionalList.get(j).get(0));
				}
			}
		}

		return modOptionals;
	}

	/**
	 * Delete participations.
	 *
	 * @param id the id
	 * @throws SQLException the SQL exception
	 */
	private void deleteParticipations(String id) throws SQLException {

		String query = "DELETE FROM " + DBValues.PLY_TAB + " WHERE "
				+ DBValues.PLY_ID + " = ?;";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			connectionDB.update(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the i ds.
	 *
	 * @return the i ds
	 * @throws SQLException the SQL exception
	 */
	private ArrayList<ArrayList<String>> getIDs() throws SQLException {

		connect();

		String query = "SELECT DISTINCT " + DBValues.CPT_ID + " FROM "
				+ DBValues.CPT_TAB + ";";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			return connectionDB.select(statement);
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Delete competition.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	private boolean deleteCompetition(String id) throws SQLException {

		connect();

		String query;
		query = "DELETE FROM " + DBValues.CPT_TAB + " WHERE " + DBValues.CPT_ID
				+ " = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			connectionDB.update(statement);
			return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

	/**
	 * Gets the emails.
	 *
	 * @param id the id
	 * @return the emails
	 * @throws SQLException the SQL exception
	 */
	private ArrayList<String> getEmails(String id) throws SQLException {

		connect();

		String query = "SELECT DISTINCT " + DBValues.GST_EMAIL + " FROM "
				+ DBValues.GST_TAB + " JOIN " + DBValues.PLY_TAB + " ON "
				+ DBValues.GST_TAB + "." + DBValues.GST_USERNAME + " = "
				+ DBValues.PLY_TAB + "." + DBValues.PLY_USERNAME + " WHERE "
				+ DBValues.PLY_TAB + "." + DBValues.PLY_ID + " = ?;";

		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		try {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			result = connectionDB.select(statement);

			for (ArrayList<String> arr : result) {
				emails.add(arr.get(0));
			}
			
			return emails;
			
		} catch (SQLException e) {
			throw new SQLException(e);
		}

	}

}

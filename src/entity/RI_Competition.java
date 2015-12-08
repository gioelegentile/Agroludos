/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Competitions.
 */
public interface RI_Competition {

	/**
	 * Gets the competitions as admin.
	 *
	 * @return the competitions as admin
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsAdmin() throws SQLException;

	/**
	 * Gets the competitions as manager.
	 *
	 * @param username the username
	 * @return the competitions as manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsManager(String username) throws SQLException;

	/**
	 * Gets the competitions as player.
	 *
	 * @param username the username
	 * @return the competitions as player
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsPlayer(String username) throws SQLException;

	/**
	 * Gets the competitions as user.
	 *
	 * @return the competitions as user
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsUser() throws SQLException;

	/**
	 * Gets the active competitions.
	 *
	 * @return the active competitions
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getActiveCompetitions() throws SQLException;
	
	/**
	 * Gets the competition data.
	 *
	 * @param id the id
	 * @return the competition data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionData(String id) throws SQLException;
	
	/**
	 * Gets the competition optionals.
	 *
	 * @param id the id
	 * @return the competition optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionOptionals(String id) throws SQLException;
	
}

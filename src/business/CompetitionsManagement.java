/*
 * 
 */
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_Competition;
import entity.RI_Competition;
import entity.WI_Competition;

// TODO: Auto-generated Javadoc
/**
 * The Class CompetitionsManagement.
 */
public class CompetitionsManagement {

	/** The competitions read. */
	static RI_Competition competitionsRead = I_Competition
			.getCompetitionsRead();
	
	/** The competitions write. */
	static WI_Competition competitionsWrite = I_Competition
			.getCompetitionsWrite();

	/**
	 * Creates the competition.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean createCompetition(ArrayList<ArrayList<String>> data) throws SQLException {

		if (competitionsWrite.setData(data)) {
			competitionsWrite.createCompetition();
			return true;
		} else {
			return false;
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

		return competitionsWrite.disposeCompetition(id);

	}

	/**
	 * Update competition.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean updateCompetition(ArrayList<ArrayList<String>> data) throws SQLException {

		if (competitionsWrite.setUpdateData(data)) {
			competitionsWrite.updateCompetition();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Gets the competitions as admin.
	 *
	 * @return the competitions as admin
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsAdmin() throws SQLException {

		return competitionsRead.getCompetitionsAsAdmin();

	}

	/**
	 * Gets the competitions as manager.
	 *
	 * @param username the username
	 * @return the competitions as manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsManager(String username) throws SQLException {

		return competitionsRead.getCompetitionsAsManager(username);

	}

	/**
	 * Gets the competitions as player.
	 *
	 * @param username the username
	 * @return the competitions as player
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsPlayer(String username) throws SQLException {

		return competitionsRead.getCompetitionsAsPlayer(username);

	}

	/**
	 * Gets the competitions as user.
	 *
	 * @return the competitions as user
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionsAsUser() throws SQLException {

		return competitionsRead.getCompetitionsAsUser();

	}

	/**
	 * Gets the active competitions.
	 *
	 * @return the active competitions
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getActiveCompetitions() throws SQLException {

		return competitionsRead.getActiveCompetitions();

	}

	/**
	 * Gets the competition data.
	 *
	 * @param id the id
	 * @return the competition data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionData(String id) throws SQLException {
		
		return competitionsRead.getCompetitionData(id);
		
	}
	
	/**
	 * Gets the competition optionals.
	 *
	 * @param id the id
	 * @return the competition optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getCompetitionOptionals(String id) throws SQLException {
		
		return competitionsRead.getCompetitionOptionals(id);
		
	}

}

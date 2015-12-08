/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Competitions.
 */
public interface WI_Competition {

	/**
	 * Sets the data.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setData(ArrayList<ArrayList<String>> arrayList);

	/**
	 * Creates the competition.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void createCompetition() throws SQLException;

	/**
	 * Dispose competition.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean disposeCompetition(String id) throws SQLException;

	/**
	 * Update competition.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void updateCompetition() throws SQLException;

	/**
	 * Sets the update data.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setUpdateData(ArrayList<ArrayList<String>> arrayList);

}

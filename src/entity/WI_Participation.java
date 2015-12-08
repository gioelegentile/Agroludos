/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Participations.
 */
public interface WI_Participation {
	
	/**
	 * Sets the data.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setData(ArrayList<ArrayList<String>> arrayList);
	
	/**
	 * Sets the optionals.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setOptionals(ArrayList<String> arrayList);
	
	/**
	 * Adds the participation.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addParticipation() throws SQLException;
	
	/**
	 * Delete participation.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteParticipation(ArrayList<String> arrayList) throws SQLException;
	
	/**
	 * Update participation.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void updateParticipation() throws SQLException;
	
}

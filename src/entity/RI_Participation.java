/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Participations.
 */
public interface RI_Participation {

	/**
	 * Gets the participations.
	 *
	 * @param id the id
	 * @return the participations
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipations(String id) throws SQLException;
	
	/**
	 * Gets the participation data.
	 *
	 * @param data the data
	 * @return the participation data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationData(ArrayList<String> data) throws SQLException;
	
	/**
	 * Gets the participation optionals.
	 *
	 * @param data the data
	 * @return the participation optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationOptionals(ArrayList<String> data) throws SQLException;
	
	/**
	 * Gets the participations data.
	 *
	 * @param id the id
	 * @return the participations data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationsData(String id) throws SQLException;
	
}

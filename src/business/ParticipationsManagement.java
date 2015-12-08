/*
 * 
 */
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_Participation;
import entity.RI_Participation;
import entity.WI_Participation;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticipationsManagement.
 */
public class ParticipationsManagement {

	/** The participation read. */
	static RI_Participation participationRead = I_Participation
			.getParticipationsRead();
	
	/** The participation write. */
	static WI_Participation participationWrite = I_Participation
			.getParticipationsWrite();

	/**
	 * Adds the participation.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addParticipation(ArrayList<ArrayList<String>> data) throws SQLException {
		if (participationWrite.setData(data)) {
			participationWrite.addParticipation();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Delete participation.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteParticipation(ArrayList<String> arrayList) throws SQLException {

		return participationWrite.deleteParticipation(arrayList);

	}

	/**
	 * Update participation.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean updateParticipation(ArrayList<ArrayList<String>> data) throws SQLException {

		if (participationWrite.setData(data)) {
			participationWrite.updateParticipation();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Gets the participations.
	 *
	 * @param id the id
	 * @return the participations
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipations(String id) throws SQLException {

		return participationRead.getParticipations(id);

	}

	/**
	 * Gets the participation data.
	 *
	 * @param data the data
	 * @return the participation data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationData(ArrayList<String> data) throws SQLException {
		
		return participationRead.getParticipationData(data);
		
	}
	
	/**
	 * Gets the participation optionals.
	 *
	 * @param data the data
	 * @return the participation optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationOptionals(ArrayList<String> data) throws SQLException {
		
		return participationRead.getParticipationOptionals(data);
		
	}
	
	/**
	 * Gets the participations data.
	 *
	 * @param id the id
	 * @return the participations data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getParticipationsData(String id) throws SQLException {
		
		return participationRead.getParticipationsData(id);
	}

}

/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Manager.
 */
public interface RI_Manager {
	
	/**
	 * Gets the managers.
	 *
	 * @return the managers
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getManagers() throws SQLException;
	
	/**
	 * Gets the manager email.
	 *
	 * @param username the username
	 * @return the manager email
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getManagerEmail(String username) throws SQLException;

	/**
	 * Gets the users not manager.
	 *
	 * @return the users not manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsersNotManager() throws SQLException;
	
}

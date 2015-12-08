/*
 * 
 */
package entity;

import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Manager.
 */
public interface WI_Manager {

	/**
	 * Sets the data.
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean setData(String username);
	
	/**
	 * Adds the manager.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addManager() throws SQLException;
	
	/**
	 * Delete manager.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteManager() throws SQLException;
	
	/**
	 * Delete all managers.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteAllManagers() throws SQLException;

}

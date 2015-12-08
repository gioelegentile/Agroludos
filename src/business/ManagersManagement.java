/*
 * 
 */
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_Manager;
import entity.RI_Manager;
import entity.WI_Manager;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagersManagement.
 */
public class ManagersManagement {

	/** The manager read. */
	static RI_Manager managerRead = I_Manager.getManagerRead();
	
	/** The manager write. */
	static WI_Manager managerWrite = I_Manager.getManagerWrite();

	/**
	 * Adds the manager.
	 *
	 * @param username the username
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addManager(String username) throws SQLException {
		
		if (managerWrite.setData(username)) {
			managerWrite.addManager();
			return true;
		} else {
			return false;
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
		
		if (managerWrite.setData(username)) {
			managerWrite.deleteManager();
			return true;
		} else {
			return false;
		}
		
	}
		
	/**
	 * Gets the managers.
	 *
	 * @return the managers
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getManagers() throws SQLException {
		
		return managerRead.getManagers();
		
	}
	
	/**
	 * Gets the manager email.
	 *
	 * @param username the username
	 * @return the manager email
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getManagerEmail(String username) throws SQLException {
		
		return managerRead.getManagerEmail(username);
		
	}
	
	/**
	 * Gets the users not manager.
	 *
	 * @return the users not manager
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsersNotManager() throws SQLException {
		
		return managerRead.getUsersNotManager();
		
	}
	
}

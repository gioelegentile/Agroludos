/*
 * 
 */
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_User;
import entity.RI_User;
import entity.WI_User;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersManagement.
 */
public class UsersManagement {

	/** The user read. */
	static RI_User userRead = I_User.getUserRead();
	
	/** The user write. */
	static WI_User userWrite = I_User.getUserWrite();

	/**
	 * Adds the user.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addUser(ArrayList<String> data) throws SQLException {

		if (userWrite.setData(data)) {
			userWrite.addUser();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Update user data.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean updateUserData(ArrayList<String> data) throws SQLException {

		if (userWrite.setData(data)) {
			userWrite.updateUserData();
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Gets the user data.
	 *
	 * @param username the username
	 * @return the user data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getUserData(String username) throws SQLException {

		return userRead.getUserData(username);

	}
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsers() throws SQLException {

		return userRead.getUsers();

	}

}

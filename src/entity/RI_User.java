/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_User.
 */
public interface RI_User {

	/**
	 * Gets the user data.
	 *
	 * @param username the username
	 * @return the user data
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getUserData(String username) throws SQLException;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getUsers() throws SQLException;

}

/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_User.
 */
public interface WI_User {

	/**
	 * Adds the user.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addUser() throws SQLException;

	
	/**
	 * Update user data.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void updateUserData() throws SQLException;
	
	
	/**
	 * Sets the data.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setData(ArrayList<String> arrayList);

}

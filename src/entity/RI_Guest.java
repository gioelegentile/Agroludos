package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Guest.
 */
public interface RI_Guest {
	
	/**
	 * Gets the guest.
	 *
	 * @param username the username
	 * @return the guest
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getGuest(String username) throws SQLException;
	
	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getGuests() throws SQLException;

}

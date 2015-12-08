package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Guest.
 */
public interface WI_Guest {

	/**
	 * Adds the guest.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addGuest() throws SQLException;
	
	/**
	 * Update guest data.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void updateGuestData() throws SQLException;
	
	/**
	 * Sets the guest data.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public boolean setGuestData(ArrayList<String> arrayList);
	
}

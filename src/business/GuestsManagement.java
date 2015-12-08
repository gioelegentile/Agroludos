/*
 * 
 */
package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_Guest;
import entity.RI_Guest;
import entity.WI_Guest;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersManagement.
 */
public class GuestsManagement {

	/** The user read. */
	static RI_Guest guestRead = I_Guest.getGuestRead();
	
	/** The user write. */
	static WI_Guest guestWrite = I_Guest.getGuestWrite();

	/**
	 * Adds the guest.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addGuest(ArrayList<String> data) throws SQLException {

		if (guestWrite.setGuestData(data)) {
			guestWrite.addGuest();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Update guest data.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean updateGuestData(ArrayList<String> data) throws SQLException {

		if (guestWrite.setGuestData(data)) {
			guestWrite.updateGuestData();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Gets the guest.
	 *
	 * @param username the username
	 * @return the guest
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<String> getGuest(String username) throws SQLException {

		return guestRead.getGuest(username);

	}

	/**
	 * Gets the guests.
	 *
	 * @return the guests
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getGuests() throws SQLException {

		return guestRead.getGuests();

	}

}

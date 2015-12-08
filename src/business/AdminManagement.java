/*
 * 
 */
package business;

import entity.I_Admin;
import entity.RI_Admin;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminManagement.
 */
public class AdminManagement {

	/** The username. */
	public static RI_Admin adminRead = I_Admin.getAdminRead();

	/**
	 * Gets the admin username.
	 *
	 * @return the admin username
	 */
	public String getAdminUsername() {
		return adminRead.getUsername();
	}

	/**
	 * Gets the admin password.
	 *
	 * @return the admin password
	 */
	public String getAdminPassword() {
		return adminRead.getPassword();
	}

}

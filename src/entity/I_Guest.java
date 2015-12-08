/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class I_User.
 */
public class I_Guest {
	
	/** The User. */
	static Guest guest = new Guest();

	/**
	 * Gets the user read.
	 *
	 * @return the user read
	 */
	public static RI_Guest getGuestRead() {
		return guest;
	}

	/**
	 * Gets the user write.
	 *
	 * @return the user write
	 */
	public static WI_Guest getGuestWrite() {
		return guest;
	}

}

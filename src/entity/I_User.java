/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class I_User.
 */
public class I_User {
	
	/** The User. */
	static User User = new User();

	/**
	 * Gets the user read.
	 *
	 * @return the user read
	 */
	public static RI_User getUserRead() {
		return User;
	}

	/**
	 * Gets the user write.
	 *
	 * @return the user write
	 */
	public static WI_User getUserWrite() {
		return User;
	}

}

/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 */
public class Admin implements RI_Admin {

	/** The username. */
	private String username = "admin";
	
	/** The password. */
	private String password = "21232f297a57a5a743894a0e4a801fc3";

	/* (non-Javadoc)
	 * @see entity.RI_Admin#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see entity.RI_Admin#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

}

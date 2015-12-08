/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class I_Manager.
 */
public class I_Manager {

	/** The manager. */
	static Manager manager = new Manager();

	/**
	 * Gets the manager read.
	 *
	 * @return the manager read
	 */
	public static RI_Manager getManagerRead() {
		return manager;
	}

	/**
	 * Gets the manager write.
	 *
	 * @return the manager write
	 */
	public static WI_Manager getManagerWrite() {
		return manager;
	}
	
}

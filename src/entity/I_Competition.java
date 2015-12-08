/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class I_Competitions.
 */
public class I_Competition {

	/** The competition. */
	static Competition competition = new Competition();

	/**
	 * Gets the competitions read.
	 *
	 * @return the competitions read
	 */
	public static RI_Competition getCompetitionsRead() {
		
		return competition;
		
	}
	
	/**
	 * Gets the competitions write.
	 *
	 * @return the competitions write
	 */
	public static WI_Competition getCompetitionsWrite() {
		
		return competition;
		
	}
	
}

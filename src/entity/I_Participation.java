/*
 * 
 */
package entity;

// TODO: Auto-generated Javadoc
/**
 * The Class I_Participations.
 */
public class I_Participation {

	/** The participation. */
	static Participation participation = new Participation();

	/**
	 * Gets the participations read.
	 *
	 * @return the participations read
	 */
	public static RI_Participation getParticipationsRead() {

		return participation;

	}

	/**
	 * Gets the participations write.
	 *
	 * @return the participations write
	 */
	public static WI_Participation getParticipationsWrite() {

		return participation;

	}

}

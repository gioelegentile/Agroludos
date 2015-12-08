/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class DisposeCompetition.
 */
public class DisposeCompetition extends AbstractEmail {

	/** The receivers. */
	private ArrayList<ArrayList<String>> receivers;
	
	/** The id competition. */
	private String manager, idCompetition;
	
	/** The business. */
	private BusinessDelegate business;

	/* (non-Javadoc)
	 * @see email.AbstractEmail#send()
	 */
	@Override
	void send() {

		ArrayList<String> guest = new ArrayList<String>();
		ArrayList<String> detail = new ArrayList<String>();
		detail.add(manager);
		detail.add(idCompetition);

		for (ArrayList<String> player : receivers) {

			try {
				guest = (ArrayList<String>) business.execute("getGuest",
						player.get(0));
			} catch (SecurityException | NoSuchMethodException
					| ClassNotFoundException | InstantiationException
					| IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Email.send(guest.get(2), Email.Choise.DISPOSE_COMPETITION, detail);
			
		}
	}

	/**
	 * Instantiates a new dispose competition.
	 *
	 * @param receivers the receivers
	 * @param idCompetition the id competition
	 * @param manager the manager
	 */
	public DisposeCompetition(ArrayList<ArrayList<String>> receivers,
			String idCompetition, String manager) {
		business = new BusinessDelegate();
		this.receivers = receivers;
		this.idCompetition = idCompetition;
		this.manager = manager;
	}

}

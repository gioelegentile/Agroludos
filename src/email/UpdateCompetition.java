/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;

import email.Email.Choise;
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateCompetition.
 */
public class UpdateCompetition extends AbstractEmail {

	/** The receivers. */
	private ArrayList<ArrayList<String>> receivers;
	
	/** The manager. */
	private String idCompetition, manager;
	
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

			Email.send(guest.get(2), Choise.UPDATE_COMPETITION, detail);

		}
	}

	/**
	 * Instantiates a new update competition.
	 *
	 * @param receivers the receivers
	 * @param idCompetition the id competition
	 * @param manager the manager
	 */
	public UpdateCompetition(ArrayList<ArrayList<String>> receivers,
			String idCompetition, String manager) {
		business = new BusinessDelegate();
		this.receivers = receivers;
		this.idCompetition = idCompetition;
		this.manager = manager;
	}

}

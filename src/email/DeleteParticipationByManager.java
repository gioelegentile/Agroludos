/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteParticipationByManager.
 */
public class DeleteParticipationByManager extends AbstractEmail {

	/** The motivation. */
	private String manager,usernamePlayer,idCompetition, motivation;
	
	/** The business. */
	private BusinessDelegate business;

	/* (non-Javadoc)
	 * @see email.AbstractEmail#send()
	 */
	@Override
	void send() {
		
		ArrayList<String> guest = new ArrayList<String>();
		
		try {
			guest = (ArrayList<String>) business.execute(
					"getGuest", usernamePlayer);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> detail = new ArrayList<String>();
		detail.add(manager);
		detail.add(idCompetition);
		detail.add(motivation);
		Email.send(guest.get(2), Email.Choise.DELETE_PARTICIPATION_BY_MANAGER, detail);
		
	}
	
	/**
	 * Instantiates a new delete participation by manager.
	 *
	 * @param usernamePlayer the username player
	 * @param idCompetition the id competition
	 * @param manager the manager
	 * @param motivation the motivation
	 */
	public DeleteParticipationByManager(String usernamePlayer, String idCompetition, String manager, String motivation) {
		business = new BusinessDelegate();
		this.usernamePlayer = usernamePlayer;
		this.idCompetition = idCompetition;
		this.manager = manager;
		this.motivation = motivation;
	}
	
}

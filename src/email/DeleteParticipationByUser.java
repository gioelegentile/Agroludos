/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteParticipationByUser.
 */
public class DeleteParticipationByUser extends AbstractEmail{
	
	/** The id competition. */
	private String manager, usernamePlayer, idCompetition;
	
	/** The business. */
	private BusinessDelegate business;

	/* (non-Javadoc)
	 * @see email.AbstractEmail#send()
	 */
	@Override
	void send() {
		
		ArrayList<String> emailManager = new ArrayList<String>();
		try {
			emailManager = (ArrayList<String>) business.execute(
					"getManagerEmail", manager);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> detail = new ArrayList<String>();
		detail.add(usernamePlayer);
		detail.add(idCompetition);
		Email.send(emailManager.get(0), Email.Choise.DELETE_PARTICIPATION_BY_USER, detail);
		
	}
	
	/**
	 * Instantiates a new delete participation by user.
	 *
	 * @param usernamePlayer the username player
	 * @param idCompetition the id competition
	 * @param manager the manager
	 */
	public DeleteParticipationByUser(String usernamePlayer, String idCompetition, String manager) {
		business = new BusinessDelegate();
		this.usernamePlayer = usernamePlayer;
		this.idCompetition = idCompetition;
		this.manager = manager;
	}

}

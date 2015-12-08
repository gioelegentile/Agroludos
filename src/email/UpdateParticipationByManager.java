/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;
import business.BusinessDelegate;
import utility.ConvertIdOptional;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateParticipationByManager.
 */
public class UpdateParticipationByManager extends AbstractEmail {

	/** The motivation. */
	private String manager, usernamePlayer, idCompetition, motivation;
	
	/** The optional. */
	private ArrayList<String> optional;
	
	/** The business. */
	private BusinessDelegate business;

	/* (non-Javadoc)
	 * @see email.AbstractEmail#send()
	 */
	@Override
	void send() {
		ArrayList<String> guest = new ArrayList<String>();

		try {
			guest = (ArrayList<String>) business.execute("getGuest",
					usernamePlayer);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String opt = "";
		if (!optional.get(0).equals("0")) {
			for (String index : optional)
				try {
					opt += ConvertIdOptional.convert(index) + ", ";
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			opt = opt.substring(0, opt.length() - 2);
		} else {
			opt = "Nessuno";
		}

		ArrayList<String> detail = new ArrayList<String>();
		detail.add(manager);
		detail.add(idCompetition);
		detail.add(opt);
		detail.add(motivation);
		Email.send(guest.get(2), Email.Choise.UPDATE_PARTICIPATION_BY_MANAGER,
				detail);

	}

	/**
	 * Instantiates a new update participation by manager.
	 *
	 * @param manager the manager
	 * @param usernamePlayer the username player
	 * @param idCompetition the id competition
	 * @param optional the optional
	 * @param motivation the motivation
	 */
	public UpdateParticipationByManager(String manager, String usernamePlayer,
			String idCompetition, ArrayList<String> optional, String motivation) {
		business = new BusinessDelegate();
		this.usernamePlayer = usernamePlayer;
		this.idCompetition = idCompetition;
		this.manager = manager;
		this.optional = optional;
		this.motivation = motivation;
	}

}

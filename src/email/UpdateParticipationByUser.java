/*
 * 
 */
package email;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.ConvertIdOptional;
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class UpdateParticipationByUser.
 */
public class UpdateParticipationByUser extends AbstractEmail {

	/** The id competition. */
	private String manager, usernamePlayer, idCompetition;
	
	/** The optional. */
	private ArrayList<String> optional;
	
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
				| IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		detail.add(usernamePlayer);
		detail.add(idCompetition);
		detail.add(opt);
		Email.send(emailManager.get(0),
				Email.Choise.UPDATE_PARTICIPATION_BY_USER, detail);

	}

	/**
	 * Instantiates a new update participation by user.
	 *
	 * @param usernamePlayer the username player
	 * @param idCompetition the id competition
	 * @param manager the manager
	 * @param optional the optional
	 */
	public UpdateParticipationByUser(String usernamePlayer, String idCompetition,
			String manager, ArrayList<String> optional) {
		business = new BusinessDelegate();
		this.usernamePlayer = usernamePlayer;
		this.idCompetition = idCompetition;
		this.manager = manager;
		this.optional = optional;
	}

}

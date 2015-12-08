package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import data_access.DAO;
import utility.Check;
import utility.Crypt;

// TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */
public class Guest implements RI_Guest, WI_Guest {

	/** The username. */
	private String username;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;

	/* (non-Javadoc)
	 * @see entity.WI_Guest#setGuestData(java.util.ArrayList)
	 */
	@Override
	public boolean setGuestData(ArrayList<String> arrayList) {

		if (Check.isUsername(arrayList.get(0))
				&& Check.isPassword(arrayList.get(1))
				&& Check.isEmail(arrayList.get(2))) {

			this.username = arrayList.get(0);
			this.password = Crypt.encrypt(arrayList.get(1));
			this.email = arrayList.get(2);

			return true;
		} else {
			return false;
		}

	}
	
	/* (non-Javadoc)
	 * @see entity.WI_Guest#addGuest()
	 */
	@Override
	public void addGuest() throws SQLException {

		DAO dao = new DAO();
		dao.addGuest(username, password, email);

	}
	
	/* (non-Javadoc)
	 * @see entity.WI_Guest#updateGuestData()
	 */
	@Override
	public void updateGuestData() throws SQLException {

		DAO dao = new DAO();
		dao.updateGuestData(username, password, email);

	}

	/* (non-Javadoc)
	 * @see entity.RI_Guest#getGuest(java.lang.String)
	 */
	@Override
	public ArrayList<String> getGuest(String username) throws SQLException {

		DAO dao = new DAO();
		if (Check.isUsername(username))
			return dao.getGuest(username).get(0);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Guest#getGuests()
	 */
	@Override
	public ArrayList<ArrayList<String>> getGuests() throws SQLException {

		DAO dao = new DAO();
		return dao.getGuests();

	}
	
}

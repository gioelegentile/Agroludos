/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.Check;
import data_access.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User implements RI_User, WI_User {

	/** The address. */
	private String username, name, surname, fiscalCode, sex, healthCardNumber,
			birthDate, certificateDate, address;

	/* (non-Javadoc)
	 * @see entity.WI_User#setData(java.util.ArrayList)
	 */
	@Override
	public boolean setData(ArrayList<String> arrayList) {

		if (Check.isUsername(arrayList.get(0))
				&& Check.isName(arrayList.get(1))
				&& Check.isName(arrayList.get(2))
				&& Check.isFiscalCode(arrayList.get(3))
				&& Check.isSex(arrayList.get(4))
				&& Check.isDate(arrayList.get(5))
				&& Check.isHealthCard(arrayList.get(6))
				&& Check.isDate(arrayList.get(7))
				&& Check.isAddress(arrayList.get(8))) {

			this.username = arrayList.get(0);
			this.name = arrayList.get(1);
			this.surname = arrayList.get(2);
			this.fiscalCode = arrayList.get(3);
			this.sex = arrayList.get(4);
			this.birthDate = arrayList.get(5);
			this.healthCardNumber = arrayList.get(6);
			this.certificateDate = arrayList.get(7);
			this.address = arrayList.get(8);

			return true;

		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_User#addUser()
	 */
	@Override
	public void addUser() throws SQLException {

		DAO dao = new DAO();
		dao.addUser(username, name, surname, fiscalCode, sex, birthDate,
				healthCardNumber, certificateDate, address);

	}

	/* (non-Javadoc)
	 * @see entity.WI_User#updateUserData()
	 */
	@Override
	public void updateUserData() throws SQLException {

		DAO dao = new DAO();
		dao.updateUserData(username, name, surname, fiscalCode, sex, birthDate,
				healthCardNumber, certificateDate, address);

	}

	/* (non-Javadoc)
	 * @see entity.RI_User#getUserData(java.lang.String)
	 */
	@Override
	public ArrayList<String> getUserData(String username) throws SQLException {

		DAO dao = new DAO();
		if (Check.isUsername(username))
			return dao.getUserData(username).get(0);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_User#getUsers()
	 */
	@Override
	public ArrayList<ArrayList<String>> getUsers() throws SQLException {

		DAO dao = new DAO();
		return dao.getUsers();

	}

}

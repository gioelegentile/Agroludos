/*
 * 
 */
package utility;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class Autentication.
 */
public class Autentication {

	/**
	 * Checks if is admin.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if is admin
	 * @throws SQLException the SQL exception
	 */
	public static boolean isAdmin(String username, String password)
			throws SQLException {

		BusinessDelegate business = new BusinessDelegate();
		String adminUsername = "";
		String adminPassword = "";

		try {
			adminUsername = (String) business.execute("getAdminUsername", null);
			adminPassword = (String) business.execute("getAdminPassword", null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return username.equals(adminUsername) && password.equals(adminPassword);

	}

	/**
	 * Checks if is manager.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if is manager
	 * @throws SQLException the SQL exception
	 */
	public static boolean isManager(String username, String password)
			throws SQLException {

		BusinessDelegate business = new BusinessDelegate();
		ArrayList<String> managers = new ArrayList<String>();

		try {

			if (isGuest(username, password)) {

				boolean isManager = false;

				managers = (ArrayList<String>) business.execute("getManagers",
						null);

				for (int i = 0; i < managers.size() && !isManager; i++) {
					isManager = username.equals(managers.get(i)) ? true : false;
				}

				return isManager;
				
			}

		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Checks if is user.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if is user
	 */
	public static boolean isUser(String username, String password) {

		BusinessDelegate business = new BusinessDelegate();
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();

		try {

			if (isGuest(username, password)) {

				boolean isUser = false;

				users = (ArrayList<ArrayList<String>>) business.execute("getUsers",
						null);

				for (int i = 0; i < users.size() && !isUser; i++) {
					isUser = username.equals(users.get(i).get(0)) ? true : false;
				}

				return isUser;
				
			}

		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	
	/**
	 * Checks if is guest.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if is guest
	 */
	public static boolean isGuest(String username, String password) {

		BusinessDelegate business = new BusinessDelegate();
		ArrayList<ArrayList<String>> guestsData = new ArrayList<ArrayList<String>>();

		try {

			boolean isGuest = false;
			guestsData = (ArrayList<ArrayList<String>>) business.execute(
					"getGuests", null);

			for (int i = 0; i < guestsData.size() && !isGuest; i++) {
				isGuest = username.equals(guestsData.get(i).get(0))
						&& password.equals(guestsData.get(i).get(1)) ? true
						: false;
			}

			return isGuest;

		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}

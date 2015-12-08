/*
 * 
 */
package presentation;

import javax.swing.JFrame;

import ui.*;
import utility.Autentication;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class ApplicationController.
 */
public class ApplicationController {
	
	/** The login. */
	private Login login;
	
	/** The admin home. */
	private AdminHome adminHome;
	
	/** The admin competitions. */
	private AdminCompetitions adminCompetitions;
	
	/** The admin optionals. */
	private AdminOptionals adminOptionals;
	
	/** The admin types. */
	private AdminTypes adminTypes;
	
	/** The admin managers. */
	private AdminManagers adminManagers;
	
	/** The registration. */
	private Registration registration;
	
	/** The manager create competition. */
	private ManagerCreateCompetition managerCreateCompetition;
	
	/** The manager competitions. */
	private ManagerCompetitions managerCompetitions;
	
	/** The manager participation list. */
	private ManagerParticipationList managerParticipationList;
	
	/** The manager home. */
	private ManagerHome managerHome;
	
	/** The user home. */
	private UserHome userHome;
	
	/** The user registration. */
	private UserRegistration userRegistration;
	
	/** The user competition. */
	private UserSignCompetition userCompetition;
	
	/** The user data view. */
	private UserDataView userDataView;
	
	/** The guest data view. */
	private DataView dataView;
	
	/** The guest home. */
	private GuestHome guestHome;
	
	/** The guest competitions. */
	private GuestCompetitions guestCompetitions;
	
	/** The user competitions. */
	private UserCompetitions userCompetitions;
	
	/**
	 * Dispatch.
	 *
	 * @param frame the frame
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean dispatch(JFrame frame, ArrayList<String> data) throws SQLException {
		
		if (Autentication.isAdmin(data.get(0), data.get(1))) {
			adminHome  = new AdminHome();
			frame.setContentPane(adminHome);
			frame.validate();
			return true;
		} else if (Autentication.isManager(data.get(0), data.get(1))) {
			managerHome  = new ManagerHome(data.get(0));
			frame.setContentPane(managerHome);
			frame.validate();
			return true;
		} else if (Autentication.isUser(data.get(0), data.get(1))) {
			userHome  = new UserHome(data.get(0));
			frame.setContentPane(userHome);
			frame.validate();
			return true;
		} else if (Autentication.isGuest(data.get(0), data.get(1))){
			guestHome  = new GuestHome(data.get(0));
			frame.setContentPane(guestHome);
			frame.validate();
			return true;
		} else {
			return false;
		}
		
	}
	
	//LOGIN UI
	
	/**
	 * Login.
	 *
	 * @param frame the frame
	 */
	public void login(JFrame frame) {
		login = new Login();
		frame.setContentPane(login);
		frame.validate();
	}
	
	/**
	 * Login registration.
	 *
	 * @param frame the frame
	 */
	public void loginRegistration(JFrame frame) {
		registration = new Registration();
		frame.setContentPane(registration);
		frame.validate();
	}
	
	//ADMIN UI
	
	/**
	 * Admin home.
	 *
	 * @param frame the frame
	 */
	public void adminHome(JFrame frame) {
		adminHome  = new AdminHome();
		frame.setContentPane(adminHome);
		frame.validate();
	}
	
	/**
	 * Admin competitions.
	 *
	 * @param frame the frame
	 */
	public void adminCompetitions(JFrame frame) {
		adminCompetitions  = new AdminCompetitions();
		frame.setContentPane(adminCompetitions);
		frame.validate();
	}
	
	/**
	 * Admin optionals.
	 *
	 * @param frame the frame
	 */
	public void adminOptionals(JFrame frame) {
		adminOptionals  = new AdminOptionals();
		frame.setContentPane(adminOptionals);
		frame.validate();
	}
	
	/**
	 * Admin types.
	 *
	 * @param frame the frame
	 */
	public void adminTypes(JFrame frame) {
		adminTypes  = new AdminTypes();
		frame.setContentPane(adminTypes);
		frame.validate();
	}
	
	/**
	 * Admin managers.
	 *
	 * @param frame the frame
	 */
	public void adminManagers(JFrame frame) {
		adminManagers  = new AdminManagers();
		frame.setContentPane(adminManagers);
		frame.validate();
	}
	
	//MANAGER UI
	
	/**
	 * Manager home.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void managerHome(JFrame frame, String username) {
		managerHome  = new ManagerHome(username);
		frame.setContentPane(managerHome);
		frame.validate();
	}
	
	/**
	 * Manager create competition.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void managerCreateCompetition(JFrame frame, String username) {
		managerCreateCompetition  = new ManagerCreateCompetition(username);
		frame.setContentPane(managerCreateCompetition);
		frame.validate();
	}
	
	/**
	 * Manager competitions.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void managerCompetitions(JFrame frame, String username) {
		managerCompetitions  = new ManagerCompetitions(username);
		frame.setContentPane(managerCompetitions);
		frame.validate();
	}
	
	/**
	 * Manager participation list.
	 *
	 * @param frame the frame
	 * @param array the array
	 */
	public void managerParticipationList(JFrame frame, ArrayList<String> array) {
		managerParticipationList  = new ManagerParticipationList(array);
		frame.setContentPane(managerParticipationList);
		frame.validate();
	}
	
	//USER UI
	
	/**
	 * User home.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void userHome(JFrame frame, String username) {
		userHome  = new UserHome(username);
		frame.setContentPane(userHome);
		frame.validate();
	}
	
	/**
	 * User registration.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void userRegistration(JFrame frame, String username) {
		userRegistration = new UserRegistration(username);
		frame.setContentPane(userRegistration);
		frame.validate();
	}
	
	/**
	 * User sign competition.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void userSignCompetition(JFrame frame, String username) {
		userCompetition = new UserSignCompetition(username);
		frame.setContentPane(userCompetition);
		frame.validate();
	}
	
	/**
	 * User data view.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void userDataView(JFrame frame, String username) {
		userDataView = new UserDataView(username);
		frame.setContentPane(userDataView);
		frame.validate();
	}
	
	/**
	 * User competitions.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void userCompetitions(JFrame frame, String username) {
		userCompetitions = new UserCompetitions(username);
		frame.setContentPane(userCompetitions);
		frame.validate();
	}
	
	//GUEST UI
	
	/**
	 * Guest data view.
	 *
	 * @param frame the frame
	 * @param arr the arr
	 */
	public void dataView(JFrame frame, ArrayList<String> arr) {
		dataView = new DataView(arr);
		frame.setContentPane(dataView);
		frame.validate();
	}
	
	/**
	 * Guest home.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void guestHome(JFrame frame, String username) {
		guestHome  = new GuestHome(username);
		frame.setContentPane(guestHome);
		frame.validate();
	}

	/**
	 * Guest competitions.
	 *
	 * @param frame the frame
	 * @param username the username
	 */
	public void guestCompetitions(JFrame frame, String username) {
		guestCompetitions  = new GuestCompetitions(username);
		frame.setContentPane(guestCompetitions);
		frame.validate();
	}
	
}

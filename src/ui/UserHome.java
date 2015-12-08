/*
 * 
 */
package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import presentation.FrontController;

// TODO: Auto-generated Javadoc
/**
 * The Class UserHome.
 */
public class UserHome extends JPanel {
	
	/** The username user. */
	private String usernameUser;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The btn new competition. */
	private JButton btnNewCompetition;
	
	/** The button comp management. */
	private JButton buttonCompManagement;
	
	/** The button data management. */
	private JButton buttonDataManagement;
	
	/** The button log out. */
	private JButton buttonLogOut;
	
	/** The btn gestisci i dati. */
	private JButton btnGestisciIDati;
	
	/** The btn esci. */
	private JButton btnEsci;
	
	/**
	 * Create the panel.
	 *
	 * @param username the username
	 */
	public UserHome(String username) {
		
		usernameUser = username;
		frontController = new FrontController();
		
		JLabel label = new JLabel("MENU UTENTE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		btnNewCompetition = new JButton("Iscriviti ad una competizione");
		btnNewCompetition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonCompManagement = new JButton("Gestisci le tue iscrizioni");
		buttonCompManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonDataManagement = new JButton("Gestisci i dati personali");
		buttonDataManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonLogOut = new JButton("Logout");
		buttonLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnGestisciIDati = new JButton("Gestisci i dati d'accesso");
		btnGestisciIDati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnEsci = new JButton("Esci");
		btnEsci.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnEsci.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(217)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(24))
						.addComponent(btnGestisciIDati, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewCompetition, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonCompManagement, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDataManagement, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonLogOut, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEsci, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(96)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(btnNewCompetition, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonCompManagement, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonDataManagement, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGestisciIDati, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonLogOut, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEsci, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		buttonLogOut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadLoginFrame();
				
			}
			
		});
		
		btnNewCompetition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadUserSignCompetitionFrame();
			}
			
		});
		
		buttonCompManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadUserCompetitionsFrame();
			}
			
		});
		
		buttonDataManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadDataViewFrame();
			}
			
		});
		
		btnGestisciIDati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadGuestDataViewFrame();
			}
			
		});
		
	}
	
	/**
	 * Load login frame.
	 */
	private void loadLoginFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("login", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Load guest data view frame.
	 */
	private void loadGuestDataViewFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("userHome");
		arr.add(usernameUser);
		
		try {
			frontController.processRequest("dataView", frame, arr);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Load user competitions frame.
	 */
	private void loadUserCompetitionsFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		
		try {
			frontController.processRequest("userCompetitions", frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Load user sign competition frame.
	 */
	private void loadUserSignCompetitionFrame() {
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("userSignCompetition", frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Load data view frame.
	 */
	private void loadDataViewFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		
		try {
			frontController.processRequest("userDataView", frame,
					usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

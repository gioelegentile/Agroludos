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
 * The Class GuestHome.
 */
public class GuestHome extends JPanel {
	
	/** The username user. */
	private String usernameUser;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The btn new competition. */
	private JButton btnNewCompetition;
	
	/** The button data management. */
	private JButton buttonDataManagement;
	
	/** The button log out. */
	private JButton buttonLogOut;
	
	/** The btn esci. */
	private JButton btnEsci;
	
	/**
	 * Create the panel.
	 *
	 * @param username the username
	 */
	public GuestHome(String username) {
		
		usernameUser = username;
		frontController = new FrontController();
		
		JLabel label = new JLabel("MENU OSPITE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		btnNewCompetition = new JButton("Vedi Competizioni");
		btnNewCompetition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonDataManagement = new JButton("Gestisci dati d'accesso");
		buttonDataManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonLogOut = new JButton("Logout");
		buttonLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCompletaRegistrazione = new JButton("Completa Registrazione");
		btnCompletaRegistrazione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewCompetition, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDataManagement, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCompletaRegistrazione, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonLogOut, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(100)
					.addComponent(btnNewCompetition, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonDataManagement, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCompletaRegistrazione, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(112)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonLogOut, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEsci, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(89, Short.MAX_VALUE))
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
				loadCompetitionsFrame();
			}
			
		});
		
		buttonDataManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadDataViewFrame();
			}
			
		});
		
		btnCompletaRegistrazione.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadUserRegistrationFrame();
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
	 * Load user registration frame.
	 */
	private void loadUserRegistrationFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("userRegistration", frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Load competitions frame.
	 */
	private void loadCompetitionsFrame() {
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("guestCompetitions", frame, usernameUser);
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
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("guestHome");
		arr.add(usernameUser);
		
		try {
			frontController.processRequest("dataView", frame,
					arr);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

/*
 * 
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import presentation.FrontController;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerHome.
 */
public class ManagerHome extends JPanel {
	
	/** The btn create. */
	private JButton btnCreate;
	
	/** The button management. */
	private JButton buttonManagement;
	
	/** The data view. */
	private JButton dataView;
	
	/** The btn logout. */
	private JButton btnLogout;
	
	/** The username manager. */
	private String usernameManager;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The btn esci. */
	private JButton btnEsci;

	/**
	 * Create the panel.
	 *
	 * @param username the username
	 */
	public ManagerHome(String username) {
		
		usernameManager = username;
		frontController = new FrontController();
		
		JLabel lblNewLabel = new JLabel("MENU MANAGER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		
		btnCreate = new JButton("Crea Competizione");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		buttonManagement = new JButton("Gestisci Competizioni");
		buttonManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dataView = new JButton("Gestisci i dati d'accesso");
		dataView.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
						.addComponent(dataView, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonManagement, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEsci, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(216, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel)
					.addGap(86)
					.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonManagement, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dataView, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(92)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEsci, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadLoginFrame();
			}
			
		});
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadManagerCreateCompetitionFrame();
			}
			
		});
		
		dataView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadGuestDataViewFrame();
			}
			
		});
		
		buttonManagement.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadManagerCompetitionsFrame();
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
		arr.add("managerHome");
		arr.add(usernameManager);
		
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
	 * Load manager create competition frame.
	 */
	private void loadManagerCreateCompetitionFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerCreateCompetition", frame, usernameManager);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Load manager competitions frame.
	 */
	private void loadManagerCompetitionsFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerCompetitions", frame, usernameManager);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

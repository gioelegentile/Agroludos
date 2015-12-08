/*
 * 
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.BusinessDelegate;

import javax.swing.JTextPane;

import utility.ConvertIdOptional;
import utility.ConvertTypeCompetition;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import presentation.FrontController;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestCompetitions.
 */
public class GuestCompetitions extends JPanel {

	/** The business. */
	private BusinessDelegate business;
	
	/** The list. */
	private JList list;
	
	/** The list model. */
	private DefaultListModel listModel;
	
	/** The competitions info. */
	private ArrayList<ArrayList<String>> competitionsInfo;
	
	/** The competitions list. */
	private ArrayList<ArrayList<String>> competitionsList;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The text pane. */
	private JTextPane textPane;
	
	/** The lbl new label. */
	private JLabel lblNewLabel;
	
	/** The btn new button. */
	private JButton btnNewButton;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The guest username. */
	private String guestUsername = "";

	/**
	 * Instantiates a new guest competitions.
	 *
	 * @param username the username
	 */
	public GuestCompetitions(String username) {
		guestUsername = username;
		
		frontController = new FrontController();
		business = new BusinessDelegate();
		competitionsInfo = new ArrayList<ArrayList<String>>();
		competitionsList = new ArrayList<ArrayList<String>>();

		try {
			competitionsList = (ArrayList<ArrayList<String>>) business.execute(
					"getActiveCompetitions", null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (ArrayList<String> array : competitionsList) {

			ArrayList<String> temp = new ArrayList<String>();
			temp.add(array.get(0));
			temp.add(array.get(4));
			try {
				temp.add(ConvertTypeCompetition.convert(array.get(1)));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
			competitionsInfo.add(temp);

		}

		listModel = new DefaultListModel();
		for (int i = 0; i < competitionsInfo.size(); i++) {
			listModel.addElement(competitionsInfo.get(i).toString());
		}

		textPane = new JTextPane();
		textPane.setEditable(false);

		scrollPane = new JScrollPane();

		lblNewLabel = new JLabel("LISTA COMPETIZIONI");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadGuestFrame();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(125)
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.PREFERRED_SIZE,
																				450,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(31)
																		.addComponent(
																				scrollPane,
																				GroupLayout.PREFERRED_SIZE,
																				216,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(30)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								textPane,
																								GroupLayout.PREFERRED_SIZE,
																								392,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnNewButton,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(219, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(23)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE,
								53, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING,
												false)
										.addComponent(textPane)
										.addComponent(scrollPane,
												GroupLayout.DEFAULT_SIZE, 449,
												Short.MAX_VALUE))
						.addGap(34)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE,
								37, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE)));

		list = new JList(listModel);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				String prova = (String) list.getSelectedValue();
				int index = 0;
				boolean found = false;
				for (; index < prova.length() && !found; index++) {
					if (prova.charAt(index) == ',') {
						found = true;
					}
				}

				ArrayList<ArrayList<String>> comp = new ArrayList<ArrayList<String>>();
				ArrayList<ArrayList<String>> opt = new ArrayList<ArrayList<String>>();

				try {
					comp = (ArrayList<ArrayList<String>>) business.execute(
							"getCompetitionData", prova.substring(1, index - 1));
					opt = (ArrayList<ArrayList<String>>) business.execute(
							"getCompetitionOptionals",
							prova.substring(1, index - 1));
				} catch (SecurityException | NoSuchMethodException
						| ClassNotFoundException | InstantiationException
						| IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String optionals = "";

				for (ArrayList<String> arr : opt) {
					try {
						optionals += ConvertIdOptional.convert(arr.get(0)) + ", ";
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					}
				}

				textPane.removeAll();
				try {
					textPane.setText("ID Competizione: \t" + comp.get(0).get(0)
							+ "\nOptional disponibili: \t"
							+ optionals.substring(0, optionals.length() - 2)
							+ "\nTipo: \t\t"
							+ ConvertTypeCompetition.convert(comp.get(0).get(1))
							+ "\nManager: \t\t" + comp.get(0).get(2)
							+ "\nEmail: \t\t" + comp.get(0).get(3) + "\nData: \t\t"
							+ comp.get(0).get(4) + "\nOrario: \t\t"
							+ comp.get(0).get(5) + "\nIscrizioni minime: \t"
							+ comp.get(0).get(6) + "\nIscrizioni massime: \t"
							+ comp.get(0).get(7) + "\nPrezzo: \t\t"
							+ comp.get(0).get(8));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
				}

			}

		});

		setLayout(groupLayout);

	}

	/**
	 * Load guest frame.
	 */
	private void loadGuestFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("guestHome", frame, guestUsername);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
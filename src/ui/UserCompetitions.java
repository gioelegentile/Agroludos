/*
 * 
 */
package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import email.*;
import presentation.FrontController;
import utility.ConvertIdOptional;
import utility.ConvertTypeCompetition;
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCompetitions.
 */
public class UserCompetitions extends JPanel {

	/** The user username. */
	private String userUsername;

	/** The panel. */
	private JPanel panel;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The btn back. */
	private JButton btnBack;
	
	/** The text pane. */
	private JTextPane textPane;
	
	/** The rdbtn optional. */
	private JRadioButton rdbtnOptional;
	
	/** The scroll pane_1. */
	private JScrollPane scrollPane_1;
	
	/** The lbl prezzo totale competizione. */
	private JLabel lblPrezzoTotaleCompetizione;
	
	/** The lbl price. */
	private JLabel lblPrice;
	
	/** The btn modify. */
	private JButton btnModify;
	
	/** The button delete. */
	private JButton buttonDelete;
	
	/** The competition list model. */
	private DefaultListModel competitionListModel;
	
	/** The optional list model. */
	private DefaultListModel optionalListModel;
	
	/** The competition list. */
	private JList competitionList;
	
	/** The optional list. */
	private JList optionalList;
	
	/** The optional names. */
	private List optionalNames;

	/** The business. */
	private BusinessDelegate business;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The email. */
	private AbstractEmail email;

	/** The competitions info. */
	private ArrayList<ArrayList<String>> competitionsInfo;
	
	/** The competitions. */
	private ArrayList<ArrayList<String>> competitions;
	
	/** The all optionals. */
	private ArrayList<ArrayList<String>> allOptionals;
	
	/** The competition optional. */
	private ArrayList<ArrayList<String>> competitionOptional;
	
	/** The player optional. */
	private ArrayList<ArrayList<String>> playerOptional;
	
	/** The player competition data. */
	private ArrayList<ArrayList<String>> playerCompetitionData;
	
	/** The player competition optionals. */
	private ArrayList<ArrayList<String>> playerCompetitionOptionals;
	
	/** The id comp. */
	private String idComp;
	
	/** The price. */
	private float price;
	
	/** The temp. */
	private float temp;

	/**
	 * Create the panel.
	 *
	 * @param username the username
	 */
	public UserCompetitions(String username) {

		userUsername = username;
		business = new BusinessDelegate();
		frontController = new FrontController();

		JLabel label = new JLabel("GESTISCI ISCRIZIONI");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));

		scrollPane = new JScrollPane();

		panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadUserFrame();
			}

		});

		competitionsInfo = new ArrayList<ArrayList<String>>();
		competitions = new ArrayList<ArrayList<String>>();

		try {
			competitions = (ArrayList<ArrayList<String>>) business.execute(
					"getCompetitionsAsPlayer", userUsername);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (ArrayList<String> array : competitions) {

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

		competitionListModel = new DefaultListModel();

		for (int i = 0; i < competitionsInfo.size(); i++) {
			competitionListModel.addElement(competitionsInfo.get(i).toString());
		}

		competitionList = new JList(competitionListModel);
		scrollPane.setViewportView(competitionList);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(125)
										.addComponent(label,
												GroupLayout.PREFERRED_SIZE,
												450, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(125, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addContainerGap(44, Short.MAX_VALUE)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												216, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																btnBack,
																GroupLayout.PREFERRED_SIZE,
																145,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																382,
																GroupLayout.PREFERRED_SIZE))
										.addGap(40)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(27)
										.addComponent(label,
												GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(27)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																437,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																panel,
																GroupLayout.PREFERRED_SIZE,
																437,
																GroupLayout.PREFERRED_SIZE))
										.addGap(29)
										.addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(31, Short.MAX_VALUE)));

		textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

		rdbtnOptional = new JRadioButton("Optional");
		rdbtnOptional.setEnabled(false);

		scrollPane_1 = new JScrollPane();

		lblPrezzoTotaleCompetizione = new JLabel("Nuovo prezzo totale: ");
		lblPrezzoTotaleCompetizione.setEnabled(false);

		lblPrice = new JLabel("");
		lblPrice.setEnabled(false);
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);

		btnModify = new JButton("Modifica");
		btnModify.setEnabled(false);

		buttonDelete = new JButton("Disiscriviti");
		buttonDelete.setEnabled(false);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.TRAILING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(textPane,
										GroupLayout.DEFAULT_SIZE, 360,
										Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.TRAILING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		lblPrezzoTotaleCompetizione)
																.addPreferredGap(
																		ComponentPlacement.UNRELATED)
																.addComponent(
																		lblPrice,
																		GroupLayout.PREFERRED_SIZE,
																		88,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(
														Alignment.LEADING,
														gl_panel.createSequentialGroup()
																.addGap(52)
																.addGroup(
																		gl_panel.createParallelGroup(
																				Alignment.LEADING)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										btnModify,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED,
																										56,
																										Short.MAX_VALUE)
																								.addComponent(
																										buttonDelete,
																										GroupLayout.PREFERRED_SIZE,
																										108,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										rdbtnOptional,
																										GroupLayout.PREFERRED_SIZE,
																										80,
																										GroupLayout.PREFERRED_SIZE)
																								.addGap(18)
																								.addComponent(
																										scrollPane_1,
																										GroupLayout.DEFAULT_SIZE,
																										174,
																										Short.MAX_VALUE)))))
								.addGap(56)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE,
								223, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnOptional)
										.addComponent(scrollPane_1,
												GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE))
						.addGap(13)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(
												lblPrezzoTotaleCompetizione,
												GroupLayout.DEFAULT_SIZE, 34,
												Short.MAX_VALUE)
										.addComponent(lblPrice,
												GroupLayout.DEFAULT_SIZE, 34,
												Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnModify,
												GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(buttonDelete,
												GroupLayout.PREFERRED_SIZE, 42,
												GroupLayout.PREFERRED_SIZE))
						.addGap(22)));

		optionalList = new JList();
		optionalList.setEnabled(false);
		scrollPane_1.setViewportView(optionalList);
		panel.setLayout(gl_panel);

		competitionList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				playerCompetitionData = new ArrayList<ArrayList<String>>();
				playerCompetitionOptionals = new ArrayList<ArrayList<String>>();
				price = 0;
				textPane.setEnabled(true);
				lblPrezzoTotaleCompetizione.setEnabled(true);
				lblPrice.setEnabled(true);
				btnModify.setEnabled(true);
				optionalList.setEnabled(true);
				buttonDelete.setEnabled(true);
				optionalList.revalidate();
				rdbtnOptional.setSelected(false);

				idComp = (String) competitionList.getSelectedValue();

				if (idComp != null) {
					int index = 0;
					boolean found = false;
					for (; index < idComp.length() && !found; index++) {
						if (idComp.charAt(index) == ',') {
							found = true;
						}
					}

					idComp = idComp.substring(1, index - 1);

					ArrayList<ArrayList<String>> comp = new ArrayList<ArrayList<String>>();
					ArrayList<ArrayList<String>> opt = new ArrayList<ArrayList<String>>();
					ArrayList<String> dataParticipation = new ArrayList<String>();
					dataParticipation.add(idComp);
					dataParticipation.add(userUsername);

					try {
						comp = (ArrayList<ArrayList<String>>) business.execute(
								"getCompetitionData", idComp);
						opt = (ArrayList<ArrayList<String>>) business.execute(
								"getCompetitionOptionals", idComp);
						playerCompetitionData = (ArrayList<ArrayList<String>>) business
								.execute("getParticipationData",
										dataParticipation);
						playerCompetitionOptionals = (ArrayList<ArrayList<String>>) business
								.execute("getParticipationOptionals",
										dataParticipation);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String optionalPlayer = "";
					String optionalAvailable = "";

					for (ArrayList<String> arr : opt) {
						try {
							optionalAvailable += ConvertIdOptional.convert(arr
									.get(0)) + ", ";
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						}
					}
					for (ArrayList<String> arr : playerCompetitionOptionals) {
						try {
							optionalPlayer += ConvertIdOptional.convert(arr
									.get(0)) + ", ";
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						}
					}

					textPane.removeAll();
					price = Float.parseFloat(comp.get(0).get(8));
					temp = price;

					try {
						textPane.setText("\n   ID Competizione: \t"
								+ comp.get(0).get(0)
								+ "\n   Optional disponibili: \t"
								+ optionalAvailable.substring(0,
										optionalAvailable.length() - 2)
								+ "\n   Optional scelti: \t"
								+ optionalPlayer.substring(0,
										optionalPlayer.length() - 2)
								+ "\n   Tipo: \t\t"
								+ ConvertTypeCompetition.convert(comp.get(0)
										.get(1)) + "\n   Manager: \t\t"
								+ comp.get(0).get(2) + "\n   Email: \t\t"
								+ comp.get(0).get(3) + "\n   Data: \t\t"
								+ comp.get(0).get(4) + "\n   Orario: \t\t"
								+ comp.get(0).get(5)
								+ "\n   Iscrizioni minime: \t"
								+ comp.get(0).get(6)
								+ "\n   Iscrizioni massime: \t"
								+ comp.get(0).get(7) + "\n   Prezzo Totale: \t"
								+ playerCompetitionData.get(0).get(3)
								+ "\n   Data di iscrizione: \t"
								+ playerCompetitionData.get(0).get(1)
								+ "\n   Orario di iscrizione: \t"
								+ playerCompetitionData.get(0).get(2));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					}

					lblPrice.setText("" + price);
					competitionOptional = new ArrayList<ArrayList<String>>();
					playerOptional = new ArrayList<ArrayList<String>>();
					ArrayList<String> idNone = new ArrayList<String>();
					ArrayList<String> typeNone = new ArrayList<String>();
					ArrayList<String> priceNone = new ArrayList<String>();
					idNone.add("0");
					typeNone.add("None");
					priceNone.add("0.00");
					playerOptional.add(idNone);
					playerOptional.add(typeNone);
					playerOptional.add(priceNone);

					if (!opt.get(0).get(0).equals("0")) {
						rdbtnOptional.setEnabled(true);
						allOptionals = new ArrayList<ArrayList<String>>();

						try {
							allOptionals = (ArrayList<ArrayList<String>>) business
									.execute("getOptionals", null);
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException
								| InstantiationException
								| IllegalAccessException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						boolean check = false;
						for (int i = 1; i < allOptionals.size(); i++) {
							check = false;
							for (int j = 0; j < opt.size() && !check; j++) {
								if (allOptionals.get(i).get(0)
										.equals(opt.get(j).get(0))) {
									competitionOptional.add(allOptionals.get(i));
									check = true;
								}
							}
						}
						optionalListModel = new DefaultListModel();
						for (int i = 0; i < competitionOptional.size(); i++) {
							if (!competitionOptional.get(i).get(1)
									.equals("None"))
								optionalListModel
										.addElement(competitionOptional.get(i)
												.get(1));
						}

						optionalList.setModel(optionalListModel);
						optionalList
								.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
						optionalList
								.setToolTipText("Tieni premuto \"CTRL\" per selezionare più di un optional.");
						optionalList.setVisible(false);

						rdbtnOptional.addChangeListener(new ChangeListener() {

							@Override
							public void stateChanged(ChangeEvent arg0) {
								if (rdbtnOptional.isSelected()) {
									optionalList.setVisible(true);
								}
								if (!rdbtnOptional.isSelected()) {
									optionalList.setVisible(false);

								}
							}

						});
						optionalList
								.addListSelectionListener(new ListSelectionListener() {

									@Override
									public void valueChanged(
											ListSelectionEvent e) {
										playerOptional = new ArrayList<ArrayList<String>>();
										price = temp;
										optionalNames = optionalList
												.getSelectedValuesList();
										boolean found = false;
										for (int i = 0; i < competitionOptional
												.size(); i++) {
											found = false;
											for (int j = 0; j < optionalNames
													.size() && !found; j++) {
												if (optionalNames
														.get(j)
														.equals(competitionOptional
																.get(i).get(1))) {
													price += Float
															.parseFloat(competitionOptional
																	.get(i)
																	.get(2));
													playerOptional
															.add(competitionOptional
																	.get(i));
												}
											}
										}
										lblPrice.setText("" + price);
									}

								});

					} else {
						rdbtnOptional.setEnabled(false);
					}
				}

			}

		});

		buttonDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane
						.showConfirmDialog(
								null,
								"Sicuro di voler eliminare l'iscrizione a questa competizione?",
								"Conferma", 0) == 0) {
					int selectedIndex = competitionList.getSelectedIndex();
					ArrayList<String> data = new ArrayList<String>();
					data.add(idComp);
					data.add(userUsername);
					boolean deleted = false;
					try {
						deleted = (boolean) business.execute(
								"deleteParticipation", data);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						e.printStackTrace();
					}
					if (deleted) {

						email = new DeleteParticipationByUser(
								userUsername, idComp, competitions.get(
										competitionList.getSelectedIndex())
										.get(2));
						email.start();

						JOptionPane
								.showMessageDialog(
										null,
										"Cancellazione dell'iscrizione avvenuta con successo",
										"Successo", 1);

						competitionListModel.remove(selectedIndex);
						competitionList.setModel(competitionListModel);
						textPane.setEnabled(false);
						lblPrezzoTotaleCompetizione.setEnabled(false);
						lblPrice.setEnabled(false);
						btnModify.setEnabled(false);
						optionalList.setEnabled(false);
						buttonDelete.setEnabled(false);
						rdbtnOptional.setEnabled(false);
						rdbtnOptional.setSelected(false);
						competitionList.clearSelection();
						price = 0;
						textPane.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "ERRORE",
								"Attenzione", 0);
					}

				}
			}

		});

		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
				ArrayList<String> idArray = new ArrayList<String>();
				ArrayList<String> optionalArray = new ArrayList<String>();
				ArrayList<String> usernameArray = new ArrayList<String>();
				ArrayList<String> dateArray = new ArrayList<String>();
				ArrayList<String> timeArray = new ArrayList<String>();

				idArray.add(idComp);
				if (!playerOptional.get(0).get(0).equals("0")) {
					for (int i = 0; i < playerOptional.size(); i++) {
						optionalArray.add(playerOptional.get(i).get(0));
					}
				} else {
					optionalArray.add("0");
				}
				usernameArray.add(userUsername);
				String TIME_FORMAT = "HH:mm:ss";
				String DATE_FORMAT = "yyyy-MM-dd";
				final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				final SimpleDateFormat sdf1 = new SimpleDateFormat(TIME_FORMAT);
				dateArray.add(sdf.format(System.currentTimeMillis()));
				timeArray.add(sdf1.format(System.currentTimeMillis()));

				data.add(idArray);
				data.add(optionalArray);
				data.add(usernameArray);
				data.add(dateArray);
				data.add(timeArray);

				if (JOptionPane.showConfirmDialog(null,
						"Confermare la modifica dell'iscrizione?", "Conferma",
						0) == 0) {
					boolean added = false;
					try {
						added = (boolean) business.execute(
								"updateParticipation", data);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (added) {
						
						email = new UpdateParticipationByUser(
								userUsername, idComp, competitions.get(
										competitionList.getSelectedIndex())
										.get(2), optionalArray);
						email.start();
						
						JOptionPane
								.showMessageDialog(
										null,
										"Modifica dell'iscrizione avvenuta con successo",
										"Successo", 1);
						
						competitionList.clearSelection();
						textPane.setEnabled(false);
						lblPrezzoTotaleCompetizione.setEnabled(false);
						lblPrice.setEnabled(false);
						btnModify.setEnabled(false);
						optionalList.setEnabled(false);
						buttonDelete.setEnabled(false);
						rdbtnOptional.setEnabled(false);
						rdbtnOptional.setSelected(false);
						price = 0;
						textPane.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Errore",
								"Attenzione", 0);
					}
				}
			}

		});

		setLayout(groupLayout);

	}

	/**
	 * Load user frame.
	 */
	private void loadUserFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("userHome", frame, userUsername);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
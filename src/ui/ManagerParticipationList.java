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
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerParticipationList.
 */
public class ManagerParticipationList extends JPanel {
	
	/** The id competition. */
	private String idCompetition;
	
	/** The manager. */
	private String manager;
	
	/** The selected username. */
	private String selectedUsername;

	/** The panel. */
	private JPanel panel;
	
	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The btn back. */
	private JButton btnBack;
	
	/** The button delete. */
	private JButton buttonDelete;
	
	/** The text pane. */
	private JTextPane textPane;
	
	/** The rdbtn optional. */
	private JRadioButton rdbtnOptional;
	
	/** The scroll pane_1. */
	private JScrollPane scrollPane_1;
	
	/** The btn modify. */
	private JButton btnModify;
	
	/** The participation list model. */
	private DefaultListModel participationListModel;
	
	/** The optional list model. */
	private DefaultListModel optionalListModel;
	
	/** The participation list. */
	private JList participationList;
	
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

	/** The participation info. */
	private ArrayList<ArrayList<String>> participationInfo;
	
	/** The participations. */
	private ArrayList<ArrayList<String>> participations;
	
	/** The all optionals. */
	private ArrayList<ArrayList<String>> allOptionals;
	
	/** The competition optional. */
	private ArrayList<ArrayList<String>> competitionOptional;
	
	/** The player optional. */
	private ArrayList<ArrayList<String>> playerOptional;
	
	/** The player data. */
	private ArrayList<ArrayList<String>> playerData;
	
	
	/**
	 * Instantiates a new manager participation list.
	 *
	 * @param param the param
	 */
	public ManagerParticipationList(ArrayList<String> param) {

			idCompetition = param.get(0);
			manager = param.get(1);
		
			business = new BusinessDelegate();
			frontController = new FrontController();

			JLabel label = new JLabel("LISTA PARTECIPANTI");
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
					loadManagerCompetitionsFrame();

				}

			});

			participationInfo = new ArrayList<ArrayList<String>>();
			participations = new ArrayList<ArrayList<String>>();

			try {
				participations = (ArrayList<ArrayList<String>>) business.execute(
						"getParticipations", idCompetition);
				competitionOptional = (ArrayList<ArrayList<String>>) business.execute("getCompetitionOptionals", idCompetition);
			} catch (SecurityException | NoSuchMethodException
					| ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (ArrayList<String> array : participations) {

				ArrayList<String> temp = new ArrayList<String>();
				temp.add(array.get(0));
				temp.add(array.get(1));
				temp.add(array.get(2));
				participationInfo.add(temp);
			}

			participationListModel = new DefaultListModel();

			for (int i = 0; i < participationInfo.size(); i++) {
				participationListModel.addElement(participationInfo.get(i).toString());
			}

			participationList = new JList(participationListModel);
			scrollPane.setViewportView(participationList);

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

			btnModify = new JButton("Modifica");
			btnModify.setEnabled(false);
			
			buttonDelete = new JButton("Cancella");
			buttonDelete.setEnabled(false);

			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(18))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(52)
								.addComponent(rdbtnOptional, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE)))
						.addGap(28))
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addGap(49)
						.addComponent(btnModify, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
						.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(47))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(rdbtnOptional)
								.addGap(30)))
						.addGap(13)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnModify, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGap(22))
			);

			optionalList = new JList();
			optionalList.setEnabled(false);
			scrollPane_1.setViewportView(optionalList);
			panel.setLayout(gl_panel);

			participationList.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					textPane.setEnabled(true);
					btnModify.setEnabled(true);
					buttonDelete.setEnabled(true);
					optionalList.setEnabled(true);
					optionalList.revalidate();
					rdbtnOptional.setSelected(false);

					selectedUsername = (String) participationList.getSelectedValue();

					if (selectedUsername != null) {
						int index = 0;
						boolean found = false;
						for (; index < selectedUsername.length() && !found; index++) {
							if (selectedUsername.charAt(index) == ',') {
								found = true;
							}
						}

						selectedUsername = selectedUsername.substring(1, index - 1);

						playerData = new ArrayList<ArrayList<String>>();
						ArrayList<ArrayList<String>> opt = new ArrayList<ArrayList<String>>();
						ArrayList<String> param = new ArrayList<String>();
						param.add(idCompetition);
						param.add(selectedUsername);

						try {
							playerData = (ArrayList<ArrayList<String>>) business.execute(
									"getParticipationData", param);
							opt = (ArrayList<ArrayList<String>>) business.execute(
									"getParticipationOptionals", param);
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException | InstantiationException
								| IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						String optional = "";

						for (ArrayList<String> arr : opt) {
							try {
								optional += ConvertIdOptional.convert(arr.get(0))
										+ ", ";
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
							}
						}

						textPane.removeAll();
						textPane.setText("\n   Data di Iscrizione: \t"
								+ playerData.get(0).get(1)
								+ "\n   Orario di Iscrizione: \t"
								+ playerData.get(0).get(2)
								+ "\n   Prezzo totale: \t"
								+ playerData.get(0).get(3)
								+ "\n   Optional Scelti: \t"
								+ optional.substring(0, optional.length() - 2));
						
						playerOptional = new ArrayList<ArrayList<String>>();
						ArrayList<String> none = new ArrayList<String>();
						none.add("0");
						playerOptional.add(none);

						if (!competitionOptional.get(0).get(0).equals("0")) {
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

							optionalListModel = new DefaultListModel();
							for (int i = 0; i < competitionOptional.size(); i++) {
									try {
										optionalListModel
												.addElement(ConvertIdOptional.convert(competitionOptional.get(i).get(0)));
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
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
										optionalList.clearSelection();
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
											optionalNames = optionalList
													.getSelectedValuesList();
											if(optionalNames.size() != 0) {
												boolean check = false;
												for (int i = 1; i < allOptionals.size(); i++) {
													check = false;
													for (int j = 0; j < optionalNames.size() && !check; j++) {
														if (allOptionals.get(i).get(1)
																.equals(optionalNames.get(j))) {
															playerOptional.add(allOptionals.get(i));
															check = true;
														}
													}
												}
											} else {
												playerOptional = new ArrayList<ArrayList<String>>();
												ArrayList<String> none = new ArrayList<String>();
												none.add("0");
												playerOptional.add(none);
											}
										}

									});

						} else {
							rdbtnOptional.setEnabled(false);
						}
					}
				}

			});

			btnModify.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ArrayList<String> optionalArray = new ArrayList<String>();
					ArrayList<String> idArray = new ArrayList<String>();
					ArrayList<String> usernameArray = new ArrayList<String>();
					ArrayList<String> dateArray = new ArrayList<String>();
					ArrayList<String> timeArray = new ArrayList<String>();
					ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
					idArray.add(idCompetition);
					usernameArray.add(selectedUsername);
					data.add(idArray);
					if (!playerOptional.get(0).get(0).equals("0")) {
						for(int i = 0; i < playerOptional.size(); i++) {
							optionalArray.add(playerOptional.get(i).get(0));
						}
					} else {
						optionalArray.add("0");
					}
					data.add(optionalArray);
					data.add(usernameArray);
					for (int i = 0; i < playerData.size(); i++) {
						dateArray.add(playerData.get(i).get(1));
						timeArray.add(playerData.get(i).get(2));
					}
					data.add(dateArray);
					data.add(timeArray);
					if (JOptionPane
							.showConfirmDialog(
									null,
									"Sei sicuro di voler modificare gli optional di questo partecipante?",
									"Conferma", 0) == 0) {

						String motivation = JOptionPane
								.showInputDialog("Inserisci le motivazioni di tale modifica da comunicare al partecipante:");

						boolean mod = false;

						try {
							mod = (boolean) business.execute(
									"updateParticipation", data);
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException
								| InstantiationException
								| IllegalAccessException | SQLException e1) {
							e1.printStackTrace();
						}

						if (mod) {

							email = new UpdateParticipationByManager(
									manager, selectedUsername,
									idCompetition, optionalArray, motivation);
							email.start();

							JOptionPane
									.showMessageDialog(
											null,
											"Modifica partecipazione avvenuta con successo",
											"Successo", 1);
							textPane.setEnabled(false);
							textPane.setText("");
							participationList.clearSelection();
							btnModify.setEnabled(false);
							buttonDelete.setEnabled(false);
							optionalList.setEnabled(false);
							optionalList.revalidate();
							rdbtnOptional.setSelected(false);
							rdbtnOptional.setEnabled(false);
							
						} else {
							JOptionPane.showMessageDialog(null, "Errore",
									"Attenzione", 0);
						}
					}
				}

			});
			
			buttonDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ArrayList<String> array = new ArrayList<String>();
					array.add(idCompetition);
					array.add(selectedUsername);

					if (JOptionPane
							.showConfirmDialog(
									null,
									"Sei sicuro di voler cancellare questo partecipante?",
									"Conferma", 0) == 0) {

						String motivation = JOptionPane
								.showInputDialog("Inserisci le motivazioni di tale modifica da comunicare al partecipante:");
						
						int index0 = participationList.getSelectedIndex();
						boolean done = false;

						try {
							done = (boolean) business.execute(
									"deleteParticipation", array);
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException
								| InstantiationException
								| IllegalAccessException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (done) {
							
							email = new DeleteParticipationByManager(selectedUsername,
									idCompetition, manager, motivation);
							email.start();
							
							JOptionPane
									.showMessageDialog(
											null,
											"Partecipante eleminato correttamente!",
											"Successo", 1);
							textPane.setText("");
							participationListModel.remove(index0);
							participationList
									.setModel(participationListModel);
							participationList.clearSelection();
							textPane.setEnabled(false);
							textPane.setText("");
							btnModify.setEnabled(false);
							buttonDelete.setEnabled(false);
							optionalList.setEnabled(false);
							optionalList.revalidate();
							rdbtnOptional.setSelected(false);
							rdbtnOptional.setEnabled(false);

						} else {
							JOptionPane.showMessageDialog(null, "ERRORE!",
									"Attenzione", 0);
						}

					}
					
				}
				
			});

			setLayout(groupLayout);

		}

		/**
		 * Load manager competitions frame.
		 */
		private void loadManagerCompetitionsFrame() {

			JFrame frame = (JFrame) SwingUtilities.getRoot(this);
			try {
				frontController.processRequest("managerCompetitions", frame, manager);
			} catch (SecurityException | NoSuchMethodException
					| ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}

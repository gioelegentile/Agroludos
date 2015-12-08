/*
 * 
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.BusinessDelegate;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

import utility.Check;
import utility.ConvertIdOptional;
import utility.ConvertTypeCompetition;
import utility.PersonalizedJTextField;
import email.*;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import presentation.FrontController;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerCompetitions.
 */
public class ManagerCompetitions extends JPanel {

	/** The email. */
	private AbstractEmail email;

	/** The business. */
	private BusinessDelegate business;

	/** The competitions list. */
	private JList competitionsList;

	/** The participations list. */
	private JList participationsList;

	/** The competitions list model. */
	private DefaultListModel competitionsListModel;
	
	/** The participations list model. */
	private DefaultListModel participationsListModel;

	/** The optional list model. */
	private DefaultListModel optionalListModel;

	/** The competitions info. */
	private ArrayList<ArrayList<String>> competitionsInfo;

	/** The competitions. */
	private ArrayList<ArrayList<String>> competitions;

	/** The competition. */
	private ArrayList<ArrayList<String>> competition;

	/** The optional list. */
	private ArrayList<ArrayList<String>> optionalList;

	/** The all optional. */
	private ArrayList<ArrayList<String>> allOptional;

	/** The players data. */
	private ArrayList<ArrayList<String>> playersData;

	/** The scroll pane. */
	private JScrollPane scrollPane;
	
	/** The scroll pane_2. */
	private JScrollPane scrollPane_2;

	/** The text pane. */
	private JTextPane textPane;

	/** The lbl title. */
	private JLabel lblTitle;

	/** The btn back. */
	private JButton btnBack;

	/** The btn partecipanti. */
	private JButton btnPartecipanti;

	/** The btn modify. */
	private JButton btnModify;

	/** The btn new button. */
	private JButton btnNewButton;

	/** The btn dispose competition. */
	private JButton btnDisposeCompetition;

	/** The panel_1. */
	private JPanel panel_1;

	/** The id comp. */
	private String idComp = "";

	/** The selected username. */
	private String selectedUsername = "";

	/** The front controller. */
	private FrontController frontController;

	/** The manager username. */
	private String managerUsername;

	/** The lbl new label_1. */
	private JLabel lblNewLabel_1;

	/** The lbl data. */
	private JLabel lblData;

	/** The lbl ora. */
	private JLabel lblOra;

	/** The lbl prezzo. */
	private JLabel lblPrezzo;

	/** The lbl min. */
	private JLabel lblMin;

	/** The text field price. */
	private JTextField textFieldPrice;

	/** The lbl max. */
	private JLabel lblMax;

	/** The text field min. */
	private JTextField textFieldMin;

	/** The text field max. */
	private JTextField textFieldMax;

	/** The optionals radio button. */
	private JRadioButton optionalsRadioButton;

	/** The type list. */
	private ArrayList<ArrayList<String>> typeList;

	/** The opt list. */
	private JList optList;

	/** The combo box types. */
	private JComboBox comboBoxTypes;

	/** The combo box days. */
	private JComboBox comboBoxDays;

	/** The combo box months. */
	private JComboBox comboBoxMonths;

	/** The combo box years. */
	private JComboBox comboBoxYears;

	/** The combo box hours. */
	private JComboBox comboBoxHours;

	/** The combo box minutes. */
	private JComboBox comboBoxMinutes;

	/** The btn delete player. */
	private JButton btnDeletePlayer;

	/** The button mod optional. */
	private JButton buttonModOptional;

	/** The giorni. */
	private String[] giorni = { "GG", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31" };

	/** The mesi. */
	private String[] mesi = { "MM", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12" };

	/** The anni. */
	private String[] anni = { "AAAA", "2015", "2016", "2017", "2018", "2019",
			"2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027",
			"2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035",
			"2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043",
			"2044", "2045", "2046", "2047", "2048", "2049", "2050" };

	/** The hours array. */
	private String[] hoursArray = { "HH", "00", "01", "02", "03", "04", "05",
			"06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", };

	/** The minutes array. */
	private String[] minutesArray = { "MM", "00", "15", "30", "45" };

	/**
	 * Instantiates a new manager competitions.
	 * 
	 * @param manager
	 *            the manager
	 */
	public ManagerCompetitions(String manager) {
		managerUsername = manager;

		frontController = new FrontController();
		business = new BusinessDelegate();
		competitionsInfo = new ArrayList<ArrayList<String>>();
		competitions = new ArrayList<ArrayList<String>>();

		try {
			competitions = (ArrayList<ArrayList<String>>) business.execute(
					"getCompetitionsAsManager", managerUsername);
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

		competitionsListModel = new DefaultListModel();
		competitionsList = new JList();

		for (int i = 0; i < competitionsInfo.size(); i++) {
			competitionsListModel
					.addElement(competitionsInfo.get(i).toString());
		}

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setEnabled(false);
		textPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

		scrollPane = new JScrollPane();

		lblTitle = new JLabel("GESTISCI COMPETIZIONI");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadManagerHomeFrame();
			}
		});

		btnModify = new JButton("Modifica");
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnModify.setEnabled(false);

		btnPartecipanti = new JButton("Partecipanti");
		btnPartecipanti.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnPartecipanti.setToolTipText("Visualizza partecipanti");
		btnPartecipanti.setEnabled(false);

		panel_1 = new JPanel();
		panel_1.setEnabled(false);
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		btnDisposeCompetition = new JButton("Annulla");
		btnDisposeCompetition.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnDisposeCompetition.setEnabled(false);

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
																				lblTitle,
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
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								Alignment.LEADING,
																								groupLayout
																										.createSequentialGroup()
																										.addGap(30)
																										.addComponent(
																												btnBack,
																												GroupLayout.PREFERRED_SIZE,
																												142,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								Alignment.LEADING,
																								groupLayout
																										.createSequentialGroup()
																										.addGap(18)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				btnDisposeCompetition,
																																				GroupLayout.PREFERRED_SIZE,
																																				132,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				btnModify,
																																				GroupLayout.PREFERRED_SIZE,
																																				130,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				btnPartecipanti,
																																				GroupLayout.DEFAULT_SIZE,
																																				130,
																																				Short.MAX_VALUE))
																														.addComponent(
																																textPane,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																404,
																																Short.MAX_VALUE)
																														.addComponent(
																																panel_1,
																																Alignment.TRAILING,
																																GroupLayout.DEFAULT_SIZE,
																																404,
																																Short.MAX_VALUE))))))
										.addGap(31)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(23)
										.addComponent(lblTitle,
												GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.TRAILING,
																false)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																449,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				textPane,
																				GroupLayout.PREFERRED_SIZE,
																				182,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(11)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnPartecipanti,
																								GroupLayout.PREFERRED_SIZE,
																								33,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnDisposeCompetition,
																								GroupLayout.PREFERRED_SIZE,
																								33,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnModify,
																								GroupLayout.PREFERRED_SIZE,
																								33,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				panel_1,
																				GroupLayout.PREFERRED_SIZE,
																				212,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(34)
										.addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE, 37,
												GroupLayout.PREFERRED_SIZE)
										.addGap(36)));

		competitionsList.setModel(competitionsListModel);
		scrollPane.setViewportView(competitionsList);
		competitionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		competitionsList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				textPane.setEnabled(true);
				btnPartecipanti.setEnabled(true);
				btnModify.setEnabled(true);
				btnDisposeCompetition.setEnabled(true);
//				panel_1.removeAll();
//				panel_1.revalidate();
//				panel_1.repaint();
				
				setPanelDisabled();
				
				idComp = (String) competitionsList.getSelectedValue();
				if (idComp != null) {
					String temp = idComp;

					int index = 0;
					boolean found = false;
					for (; index < temp.length() && !found; index++) {
						if (temp.charAt(index) == ',') {
							found = true;
						}
					}

					temp = temp.substring(1, index - 1);
					idComp = temp;

					ArrayList<ArrayList<String>> comp = new ArrayList<ArrayList<String>>();
					ArrayList<ArrayList<String>> opt = new ArrayList<ArrayList<String>>();

					try {
						comp = (ArrayList<ArrayList<String>>) business.execute(
								"getCompetitionData", idComp);
						opt = (ArrayList<ArrayList<String>>) business.execute(
								"getCompetitionOptionals", idComp);
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
							optionals += ConvertIdOptional.convert(arr.get(0))
									+ ", ";
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
						}
					}

					textPane.removeAll();

					try {
						textPane.setText("\n   ID Competizione: \t"
								+ comp.get(0).get(0)
								+ "\n   Optional disponibili: \t"
								+ optionals.substring(0, optionals.length() - 2)
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
								+ comp.get(0).get(7) + "\n   Prezzo: \t\t"
								+ comp.get(0).get(8));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
					}
				} else {
					competitionsList.clearSelection();
				}
			}

		});

		btnDisposeCompetition.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int index0 = competitionsList.getSelectedIndex();
				boolean done = false;

				if (JOptionPane.showConfirmDialog(null,
						"Sei sicuro di voler annullare questa competizione?",
						"Conferma", 0) == 0) {

					ArrayList<ArrayList<String>> players = new ArrayList<ArrayList<String>>();

					try {

						players = (ArrayList<ArrayList<String>>) business
								.execute("getParticipations", idComp);

						done = (boolean) business.execute("disposeCompetition",
								idComp);

					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						e.printStackTrace();
					}

					if (done) {

						email = new DisposeCompetition(players, idComp,
								managerUsername);
						email.start();

						JOptionPane.showMessageDialog(null,
								"Competizione annullata correttamente!",
								"Successo", 1);

						textPane.setText("");
						competitionsListModel.remove(index0);
						competitionsList.setModel(competitionsListModel);
						textPane.setEnabled(false);
						btnPartecipanti.setEnabled(false);
						btnModify.setEnabled(false);
						btnDisposeCompetition.setEnabled(false);
						competitionsList.clearSelection();

					} else {
						JOptionPane.showMessageDialog(null, "ERRORE!",
								"Attenzione", 0);
					}

				}

			}

		});

		btnPartecipanti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadManagerParticipationListFrame();
			}

		});

		lblNewLabel_1 = new JLabel("Tipo");
		lblData = new JLabel("Data");
		lblOra = new JLabel("Ora");
		lblPrezzo = new JLabel("Prezzo");
		lblMin = new JLabel("Min");

		comboBoxTypes = new JComboBox();
		comboBoxDays = new JComboBox(giorni);
		comboBoxMonths = new JComboBox(mesi);
		comboBoxYears = new JComboBox(anni);
		comboBoxHours = new JComboBox(hoursArray);
		comboBoxMinutes = new JComboBox(minutesArray);

		textFieldPrice = new JTextField();
		textFieldPrice.setDocument(new PersonalizedJTextField(10));
		textFieldPrice.setToolTipText("Esempio: 60.00");
		textFieldPrice.setColumns(10);

		lblMax = new JLabel("Max");

		textFieldMin = new JTextField();
		textFieldMin.setDocument(new PersonalizedJTextField(4));
		textFieldMin
				.setToolTipText("Il numero minimo dev'essere minore di quello massimo.");
		textFieldMin.setColumns(10);

		textFieldMax = new JTextField();
		textFieldMax.setDocument(new PersonalizedJTextField(4));
		textFieldMax
				.setToolTipText("Il numero massimo dev'essere maggiore di quello minimo.");
		textFieldMax.setColumns(10);

		optionalsRadioButton = new JRadioButton("Optionals");
		btnNewButton = new JButton("Conferma");

		setPanelDisabled();

		scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(lblData)
														.addComponent(lblOra)
														.addComponent(
																lblNewLabel_1)
														.addComponent(lblPrezzo)
														.addComponent(lblMin)
														.addComponent(lblMax)
														.addComponent(
																optionalsRadioButton))
										.addGap(12)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																textFieldMin,
																GroupLayout.DEFAULT_SIZE,
																299,
																Short.MAX_VALUE)
														.addComponent(
																textFieldPrice,
																GroupLayout.DEFAULT_SIZE,
																299,
																Short.MAX_VALUE)
														.addComponent(
																comboBoxTypes,
																0, 299,
																Short.MAX_VALUE)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				comboBoxDays,
																				GroupLayout.PREFERRED_SIZE,
																				63,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				comboBoxMonths,
																				0,
																				162,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				comboBoxYears,
																				GroupLayout.PREFERRED_SIZE,
																				62,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				comboBoxHours,
																				GroupLayout.PREFERRED_SIZE,
																				93,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				comboBoxMinutes,
																				0,
																				200,
																				Short.MAX_VALUE))
														.addComponent(
																textFieldMax,
																GroupLayout.DEFAULT_SIZE,
																299,
																Short.MAX_VALUE)
														.addGroup(
																Alignment.TRAILING,
																gl_panel_1
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPane_2,
																				GroupLayout.DEFAULT_SIZE,
																				144,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnNewButton,
																				GroupLayout.PREFERRED_SIZE,
																				149,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(13)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																comboBoxTypes,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBoxDays,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxYears,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblData)
														.addComponent(
																comboBoxMonths,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBoxHours,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxMinutes,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblOra))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldPrice,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrezzo))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMin,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMin))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMax,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMax))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				optionalsRadioButton)
																		.addGap(27))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(
																								btnNewButton,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								scrollPane_2,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								31,
																								Short.MAX_VALUE))
																		.addContainerGap()))));

		scrollPane_2.setViewportView(optList);
		panel_1.setLayout(gl_panel_1);

		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				competition = new ArrayList<ArrayList<String>>();

				try {
					competition = (ArrayList<ArrayList<String>>) business
							.execute("getCompetitionData", idComp);
				} catch (SecurityException | NoSuchMethodException
						| ClassNotFoundException | InstantiationException
						| IllegalAccessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				String competitionDate = competition.get(0).get(4) + " "
						+ competition.get(0).get(5);

				if (Check.isTwoDaysBefore(competitionDate)) {

					setPanelEnabled();

					typeList = new ArrayList<ArrayList<String>>();

					try {
						typeList = (ArrayList<ArrayList<String>>) business
								.execute("getTypes", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						e.printStackTrace();
					}

					for (int i = 0; i < typeList.size(); i++) {
						comboBoxTypes.addItem(typeList.get(i).get(1));
					}

					optionalList = new ArrayList<ArrayList<String>>();
					DefaultListModel listModel = new DefaultListModel();
					optList = new JList();

					try {
						optionalList = (ArrayList<ArrayList<String>>) business
								.execute("getOptionals", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (int i = 0; i < optionalList.size(); i++) {
						if (!optionalList.get(i).get(1).equals("None"))
							listModel.addElement(optionalList.get(i).get(1));
					}

					optList.setModel(listModel);
					optList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					scrollPane_2.setViewportView(optList);
					optList.setVisible(false);

					comboBoxTypes.setSelectedIndex(Integer.parseInt(competition
							.get(0).get(1)) - 1);
					comboBoxDays.setSelectedIndex(Integer.parseInt(competition
							.get(0).get(4).substring(8, 10)));
					comboBoxMonths.setSelectedIndex(Integer
							.parseInt(competition.get(0).get(4).substring(5, 7)));
					comboBoxYears.setSelectedIndex(Integer.parseInt(competition
							.get(0).get(4).substring(0, 4)) - 2014);
					comboBoxHours.setSelectedIndex(Integer.parseInt(competition
							.get(0).get(5).substring(0, 2)) + 1);
					comboBoxMinutes.setSelectedIndex((Integer
							.parseInt(competition.get(0).get(5).substring(3, 5)) / 15) + 1);

					textFieldPrice.setText(competition.get(0).get(8));
					textFieldMin.setText(competition.get(0).get(6));
					textFieldMax.setText(competition.get(0).get(7));

					optionalsRadioButton
							.addChangeListener(new ChangeListener() {

								@Override
								public void stateChanged(ChangeEvent arg0) {
									if (optionalsRadioButton.isSelected()) {
										optList.setVisible(true);
									} else {
										optList.setVisible(false);
									}
								}

							});

					btnNewButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							if (!comboBoxDays.getSelectedItem().equals("GG")
									&& !comboBoxMonths.getSelectedItem()
											.equals("MM")
									&& !comboBoxYears.getSelectedItem().equals(
											"AAAA")
									&& !comboBoxHours.getSelectedItem().equals(
											"HH")
									&& !comboBoxMinutes.getSelectedItem()
											.equals("MM")
									&& !textFieldMin.getText().isEmpty()
									&& !textFieldMax.getText().isEmpty()
									&& !textFieldPrice.getText().isEmpty()
									&& Integer.parseInt(textFieldMin.getText()) <= Integer
											.parseInt(textFieldMax.getText())) {

								ArrayList<ArrayList<String>> arrayData = new ArrayList<ArrayList<String>>();
								ArrayList<String> id = new ArrayList<String>();
								id.add(idComp);
								ArrayList<String> typeArray = new ArrayList<String>();
								ArrayList<String> dataArray = new ArrayList<String>();
								ArrayList<String> timeArray = new ArrayList<String>();
								ArrayList<String> optionalArray = new ArrayList<String>();
								ArrayList<String> priceArray = new ArrayList<String>();
								ArrayList<String> minArray = new ArrayList<String>();
								ArrayList<String> maxArray = new ArrayList<String>();
								ArrayList<String> managerArray = new ArrayList<String>();

								String typeName = (String) comboBoxTypes
										.getSelectedItem();
								boolean found = false;

								for (int i = 0; i < typeList.size() && !found; i++) {
									if (typeName.equals(typeList.get(i).get(1))) {
										typeArray.add(typeList.get(i).get(0));
										found = true;
									}
								}

								List optionalNames = optList
										.getSelectedValuesList();
								found = false;
								if (optionalNames.size() != 0) {
									for (int i = 0; i < optionalList.size(); i++) {
										found = false;
										for (int j = 0; j < optionalNames
												.size() && !found; j++) {
											if (optionalNames.get(j).equals(
													optionalList.get(i).get(1))) {
												optionalArray.add(optionalList
														.get(i).get(0));
												found = true;
											}
										}
									}
								} else {
									optionalArray.add("0");
								}

								dataArray.add(comboBoxYears.getSelectedItem()
										+ "-"
										+ comboBoxMonths.getSelectedItem()
										+ "-" + comboBoxDays.getSelectedItem());
								timeArray.add(comboBoxHours.getSelectedItem()
										+ ":"
										+ comboBoxMinutes.getSelectedItem()
										+ ":00");
								managerArray.add(managerUsername);
								priceArray.add(textFieldPrice.getText());
								minArray.add(textFieldMin.getText());
								maxArray.add(textFieldMax.getText());

								arrayData.add(id);
								arrayData.add(typeArray);
								arrayData.add(dataArray);
								arrayData.add(timeArray);
								arrayData.add(managerArray);
								arrayData.add(priceArray);
								arrayData.add(minArray);
								arrayData.add(maxArray);
								arrayData.add(optionalArray);

								if (JOptionPane.showConfirmDialog(null,
										"Confermi tutti i dati inseriti?",
										"Conferma", 0) == 0) {
									boolean edit = false;

									try {
										edit = (boolean) business.execute(
												"updateCompetition", arrayData);
									} catch (SecurityException
											| NoSuchMethodException
											| ClassNotFoundException
											| InstantiationException
											| IllegalAccessException
											| SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if (edit) {

										ArrayList<ArrayList<String>> players = new ArrayList<ArrayList<String>>();

										try {
											players = (ArrayList<ArrayList<String>>) business
													.execute(
															"getParticipations",
															idComp);
										} catch (SecurityException
												| NoSuchMethodException
												| ClassNotFoundException
												| InstantiationException
												| IllegalAccessException
												| SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

										email = new UpdateCompetition(players,
												idComp, managerUsername);
										email.start();

										JOptionPane
												.showMessageDialog(
														null,
														"Competizione modificata correttamente",
														"Successo", 1);

										removeAll();
										reloadFrame();

									} else {
										JOptionPane
												.showMessageDialog(
														null,
														"Errore. Assicurati di aver inserito i dati correttamente.",
														"Attenzione", 0);
									}

								}

							} else {

								if (Integer.parseInt(textFieldMin.getText()) > Integer
										.parseInt(textFieldMax.getText())) {
									JOptionPane
											.showMessageDialog(
													null,
													"Modifica annullata, il numero minimo di partecipanti deve essere minore del massimo",
													"Attenzione", 0);
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"Modifica annullata, assicurarsi di aver inserito tutti i dati richiesti",
													"Attenzione", 0);
								}

							}

						}

					});

				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Sei fuori tempo massimo per modificare questa competizione!",
									"Attenzione", 0);
				}
			}

		});

		setLayout(groupLayout);

	}

	/**
	 * Load manager home frame.
	 */
	private void loadManagerHomeFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerHome", frame,
					managerUsername);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Reload frame.
	 */
	private void reloadFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerCompetitions", frame,
					managerUsername);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Load manager participation list frame.
	 */
	private void loadManagerParticipationListFrame() {

		ArrayList<String> param = new ArrayList<String>();
		param.add(idComp);
		param.add(managerUsername);
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerParticipationList", frame,
					param);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Sets the panel disabled.
	 */
	private void setPanelDisabled() {
		lblNewLabel_1.setEnabled(false);
		comboBoxTypes.setEnabled(false);
		comboBoxTypes.setSelectedIndex(-1);
		lblData.setEnabled(false);
		comboBoxDays.setEnabled(false);
		comboBoxDays.setSelectedIndex(-1);
		comboBoxMonths.setEnabled(false);
		comboBoxMonths.setSelectedIndex(-1);
		comboBoxYears.setEnabled(false);
		comboBoxYears.setSelectedIndex(-1);
		lblOra.setEnabled(false);
		comboBoxHours.setEnabled(false);
		comboBoxHours.setSelectedIndex(-1);
		comboBoxMinutes.setEnabled(false);
		comboBoxMinutes.setSelectedIndex(-1);
		lblPrezzo.setEnabled(false);
		textFieldPrice.setEnabled(false);
		textFieldPrice.setText("");
		lblMin.setEnabled(false);
		textFieldMin.setEnabled(false);
		textFieldMin.setText("");
		lblMax.setEnabled(false);
		textFieldMax.setEnabled(false);
		textFieldMax.setText("");
		optionalsRadioButton.setEnabled(false);
		btnNewButton.setEnabled(false);
	}
	
	/**
	 * Sets the panel enabled.
	 */
	private void setPanelEnabled() {
		lblNewLabel_1.setEnabled(true);
		lblData.setEnabled(true);
		lblOra.setEnabled(true);
		lblPrezzo.setEnabled(true);
		lblMin.setEnabled(true);
		lblMax.setEnabled(true);
		comboBoxTypes.setEnabled(true);
		comboBoxDays.setEnabled(true);
		comboBoxMonths.setEnabled(true);
		comboBoxYears.setEnabled(true);
		comboBoxHours.setEnabled(true);
		comboBoxMinutes.setEnabled(true);
		textFieldPrice.setEnabled(true);
		textFieldMin.setEnabled(true);
		textFieldMax.setEnabled(true);
		optionalsRadioButton.setEnabled(true);
		btnNewButton.setEnabled(true);
	}

}

/*
 * 
 */
package ui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import presentation.FrontController;
import utility.Check;
import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerCreateCompetition.
 */
public class ManagerCreateCompetition extends JPanel {

	/** The username manager. */
	private String usernameManager;

	/** The front controller. */
	private FrontController frontController;

	/** The optional list. */
	private ArrayList<ArrayList<String>> optionalList;

	/** The type list. */
	private ArrayList<ArrayList<String>> typeList;

	/** The list model. */
	private DefaultListModel listModel;

	/** The list. */
	private JList list;

	/** The minutes. */
	private JComboBox minutes;

	/** The hour. */
	private JComboBox hour;

	/** The year. */
	private JComboBox year;

	/** The month. */
	private JComboBox month;

	/** The day. */
	private JComboBox day;

	/** The type. */
	private JComboBox type;

	/** The min. */
	private JTextField min;

	/** The max. */
	private JTextField max;

	/** The price. */
	private JTextField price;

	/** The rdbtn optional. */
	private JRadioButton rdbtnOptional;

	/** The scroll pane. */
	private JScrollPane scrollPane;

	/** The btn create. */
	private JButton btnCreate;

	/** The button back. */
	private JButton buttonBack;

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

	/** The business. */
	private BusinessDelegate business;

	/**
	 * Create the panel.
	 * 
	 * @param username
	 *            the username
	 */
	public ManagerCreateCompetition(String username) {

		usernameManager = username;
		frontController = new FrontController();
		business = new BusinessDelegate();

		JLabel lblNewLabel = new JLabel("CREA COMPETIZIONE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));

		JLabel lblTipoDiCompetizione = new JLabel("Tipo di Competizione:");
		lblTipoDiCompetizione.setFont(new Font("Tahoma", Font.BOLD, 11));

		type = new JComboBox();

		JLabel lblNewLabel_1 = new JLabel("Data:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		day = new JComboBox(giorni);

		month = new JComboBox(mesi);

		year = new JComboBox(anni);

		JLabel lblOrario = new JLabel("Orario: ");
		lblOrario.setFont(new Font("Tahoma", Font.BOLD, 11));

		hour = new JComboBox(hoursArray);

		minutes = new JComboBox(minutesArray);

		min = new JTextField();
		min.setColumns(10);

		JLabel lblNumeroMinimoDi = new JLabel("Numero minimo di Partecipanti:");
		lblNumeroMinimoDi.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNumeroMassimoDi = new JLabel(
				"Numero massimo di Partecipanti:");
		lblNumeroMassimoDi.setFont(new Font("Tahoma", Font.BOLD, 11));

		max = new JTextField();
		max.setColumns(10);

		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 11));

		price = new JTextField();
		price.setColumns(10);

		scrollPane = new JScrollPane();
		list = new JList();

		rdbtnOptional = new JRadioButton("Optional");
		rdbtnOptional.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnCreate = new JButton("Crea");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		buttonBack = new JButton("Indietro");
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup().addGap(191)
										.addComponent(lblNewLabel)
										.addContainerGap(190, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(159)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				btnCreate,
																				GroupLayout.PREFERRED_SIZE,
																				144,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				91,
																				Short.MAX_VALUE)
																		.addComponent(
																				buttonBack,
																				GroupLayout.PREFERRED_SIZE,
																				143,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblNewLabel_1,
																								GroupLayout.PREFERRED_SIZE,
																								38,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblTipoDiCompetizione,
																								GroupLayout.PREFERRED_SIZE,
																								140,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblOrario)
																						.addComponent(
																								lblNumeroMinimoDi,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblNumeroMassimoDi,
																								Alignment.TRAILING,
																								GroupLayout.PREFERRED_SIZE,
																								200,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								rdbtnOptional)
																						.addComponent(
																								lblCosto,
																								GroupLayout.PREFERRED_SIZE,
																								42,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								scrollPane,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								price,
																								GroupLayout.DEFAULT_SIZE,
																								174,
																								Short.MAX_VALUE)
																						.addComponent(
																								max,
																								GroupLayout.DEFAULT_SIZE,
																								174,
																								Short.MAX_VALUE)
																						.addComponent(
																								min,
																								174,
																								174,
																								174)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addComponent(
																																type,
																																Alignment.LEADING,
																																0,
																																174,
																																Short.MAX_VALUE)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addGroup(
																																				groupLayout
																																						.createParallelGroup(
																																								Alignment.TRAILING)
																																						.addComponent(
																																								hour,
																																								Alignment.LEADING,
																																								0,
																																								52,
																																								Short.MAX_VALUE)
																																						.addComponent(
																																								day,
																																								Alignment.LEADING,
																																								0,
																																								52,
																																								Short.MAX_VALUE))
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addGroup(
																																				groupLayout
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								minutes,
																																								0,
																																								52,
																																								Short.MAX_VALUE)
																																						.addComponent(
																																								month,
																																								0,
																																								52,
																																								Short.MAX_VALUE))
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addComponent(
																																				year,
																																				GroupLayout.PREFERRED_SIZE,
																																				54,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))))
										.addGap(167)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(61)
										.addComponent(lblNewLabel)
										.addGap(78)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																type,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblTipoDiCompetizione))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																day,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																month,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																year,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																hour,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																minutes,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblOrario))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																min,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNumeroMinimoDi))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																max,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNumeroMassimoDi))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																price,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblCosto))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																67,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																rdbtnOptional))
										.addGap(78)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																buttonBack,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																btnCreate,
																GroupLayout.PREFERRED_SIZE,
																55,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(73, Short.MAX_VALUE)));

		setLayout(groupLayout);

		typeList = new ArrayList<ArrayList<String>>();

		try {
			typeList = (ArrayList<ArrayList<String>>) business.execute(
					"getTypes", null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < typeList.size(); i++) {
			type.addItem(typeList.get(i).get(1));
		}

		optionalList = new ArrayList<ArrayList<String>>();
		listModel = new DefaultListModel();
		try {
			optionalList = (ArrayList<ArrayList<String>>) business.execute(
					"getOptionals", null);
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

		list.setModel(listModel);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(list);
		list.setVisible(false);

		rdbtnOptional.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnOptional.isSelected()) {
					list.setVisible(true);
				}
				if (!rdbtnOptional.isSelected()) {
					list.setVisible(false);

				}
			}

		});

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!day.getSelectedItem().equals("GG")
						&& !month.getSelectedItem().equals("MM")
						&& !year.getSelectedItem().equals("AAAA")
						&& !hour.getSelectedItem().equals("HH")
						&& !minutes.getSelectedItem().equals("MM")
						&& !min.getText().isEmpty() && !max.getText().isEmpty()
						&& !price.getText().isEmpty()) {
					if (Integer.parseInt(min.getText()) <= Integer.parseInt(max
							.getText())) {

						ArrayList<ArrayList<String>> arrayData = new ArrayList<ArrayList<String>>();
						ArrayList<String> optionalArray = new ArrayList<String>();
						ArrayList<String> typeArray = new ArrayList<String>();
						ArrayList<String> dataArray = new ArrayList<String>();
						ArrayList<String> timeArray = new ArrayList<String>();
						ArrayList<String> managerArray = new ArrayList<String>();
						ArrayList<String> priceArray = new ArrayList<String>();
						ArrayList<String> minArray = new ArrayList<String>();
						ArrayList<String> maxArray = new ArrayList<String>();

						List optionalNames = list.getSelectedValuesList();
						boolean found = false;
						if (optionalNames.size() != 0) {
							for (int i = 0; i < optionalList.size(); i++) {
								found = false;
								for (int j = 0; j < optionalNames.size()
										&& !found; j++) {
									if (optionalNames.get(j).equals(
											optionalList.get(i).get(1))) {
										optionalArray.add(optionalList.get(i)
												.get(0));
										found = true;
									}
								}
							}
						} else {
							optionalArray.add("0");
						}

						String typeName = (String) type.getSelectedItem();
						found = false;
						for (int i = 0; i < typeList.size() && !found; i++) {
							if (typeName.equals(typeList.get(i).get(1))) {
								typeArray.add(typeList.get(i).get(0));
								found = true;
							}
						}

						dataArray.add(year.getSelectedItem() + "-"
								+ month.getSelectedItem() + "-"
								+ day.getSelectedItem());
						timeArray.add(hour.getSelectedItem() + ":"
								+ minutes.getSelectedItem() + ":00");

						if (Check.isTwelveHoursAfter(dataArray.get(0) + " "
								+ timeArray.get(0))) {

							managerArray.add(usernameManager);
							priceArray.add(price.getText());
							minArray.add(min.getText());
							maxArray.add(max.getText());

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
								boolean created = false;
								try {
									created = (boolean) business.execute(
											"createCompetition", arrayData);
								} catch (SecurityException
										| NoSuchMethodException
										| ClassNotFoundException
										| InstantiationException
										| IllegalAccessException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								if (created) {
									JOptionPane
											.showMessageDialog(
													null,
													"Competizione creata correttamente",
													"Successo", 1);
									loadManagerFrame();
								} else {
									JOptionPane
											.showMessageDialog(
													null,
													"Errore, assicurarsi di aver inserito correttamente tutti i dati",
													"Attenzione", 0);
								}
							}
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"Creazione annullata, non puoi creare una competizione che dovrebbe cominciare tra meno di 12 ore.",
											"Attenzione", 0);
						}
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"Creazione annullata, il numero minimo di partecipanti non deve essere maggiore del massimo",
										"Attenzione", 0);
					}
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Creazione annullata, assicurarsi di aver inserito tutti i dati richiesti",
									"Attenzione", 0);
				}
			}

		});

		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadManagerFrame();
			}

		});

	}

	/**
	 * Load manager frame.
	 */
	private void loadManagerFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("managerHome", frame,
					usernameManager);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

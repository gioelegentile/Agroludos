/*
 * 
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.LoadCertificate;
import utility.PersonalizedJTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import presentation.FrontController;
import business.BusinessDelegate;

import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDataView.
 */
public class UserDataView extends JPanel {

	/** The nome. */
	private JTextField nome;

	/** The cognome. */
	private JTextField cognome;

	/** The codice fiscale. */
	private JTextField codiceFiscale;

	/** The indirizzo. */
	private JTextField indirizzo;

	/** The lbl numero tessera sanitaria. */
	private JLabel lblNumeroTesseraSanitaria;

	/** The numero tessera sanitaria. */
	private JTextField numeroTesseraSanitaria;

	/** The birth day. */
	private JComboBox birthDay;

	/** The birth month. */
	private JComboBox birthMonth;

	/** The birth year. */
	private JComboBox birthYear;

	/** The combo box. */
	private JComboBox comboBox;

	/** The combo box_1. */
	private JComboBox comboBox_1;

	/** The combo box_2. */
	private JComboBox comboBox_2;

	/** The btn browse. */
	private JButton btnBrowse;

	/** The data nascita. */
	private String dataNascita;

	/** The data src. */
	private String dataSrc;

	/** The sesso. */
	private String sesso;

	/** The file to load. */
	private LoadCertificate fileToLoad;

	/** The button group. */
	private ButtonGroup buttonGroup;

	/** The giorni. */
	private String[] giorni = { "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31" };

	/** The mesi. */
	private String[] mesi = { "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12" };

	/** The anni. */
	private String[] anni = { "1900", "1901", "1902", "1903", "1904",
			"1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912",
			"1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920",
			"1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928",
			"1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936",
			"1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944",
			"1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952",
			"1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960",
			"1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968",
			"1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976",
			"1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984",
			"1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992",
			"1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000" };

	/** The anni c. */
	private String[] anniC = { "2000", "2001", "2002", "2003", "2004",
			"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
			"2013", "2014", "2015" };

	/** The btn sign up. */
	private JButton btnSignUp;

	/** The btn back. */
	private JButton btnBack;

	/** The rdbtn sex male. */
	private JRadioButton rdbtnSexMale;

	/** The rdbtn sex female. */
	private JRadioButton rdbtnSexFemale;

	/** The business. */
	private BusinessDelegate business;

	/** The front controller. */
	private FrontController frontController;

	/** The username user. */
	private String usernameUser;

	/** The text field. */
	private JTextField textField;

	/** The user data. */
	private ArrayList<String> userData;

	/**
	 * Crea l'interfaccia.
	 * 
	 * @param username
	 *            the username
	 */
	public UserDataView(String username) {

		usernameUser = username;
		business = new BusinessDelegate();
		frontController = new FrontController();

		userData = new ArrayList<String>();
		try {
			userData = (ArrayList<String>) business.execute("getUserData",
					usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblName = new JLabel("Nome:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setToolTipText("");

		nome = new JTextField("");
		nome.setToolTipText("Inserisci il tuo nome. Non sono ammessi numeri.");
		nome.setDocument(new PersonalizedJTextField(40));
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cognome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		cognome = new JTextField("");
		cognome.setToolTipText("Inserisci il tuo cognome. Non sono ammessi numeri.");
		cognome.setDocument(new PersonalizedJTextField(40));
		cognome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Codice Fiscale:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		codiceFiscale = new JTextField("");
		codiceFiscale
				.setToolTipText("Inserisci il tuo codice fiscale. Esso dev'esser formato da sole lettere maiuscole e numeri per una lunghezza di 16 caratteri.");
		codiceFiscale.setDocument(new PersonalizedJTextField(16));
		codiceFiscale.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Indirizzo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		indirizzo = new JTextField("");
		indirizzo.setToolTipText("Inserisci il tuo indirizzo di casa.");
		indirizzo.setDocument(new PersonalizedJTextField(50));
		indirizzo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Data di nascita:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel_4 = new JLabel("Sesso:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNumeroTesseraSanitaria = new JLabel("Numero tessera sanitaria:");
		lblNumeroTesseraSanitaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroTesseraSanitaria.setToolTipText("");

		numeroTesseraSanitaria = new JTextField("");
		numeroTesseraSanitaria
				.setToolTipText("Inserisci il tuo numero di tessera sanitaria. Esso dev'esser formato da soli numeri per una lunghezza di 20 caratteri.");
		numeroTesseraSanitaria.setDocument(new PersonalizedJTextField(20));
		numeroTesseraSanitaria.setColumns(10);

		birthDay = new JComboBox(new Object[] {});
		birthDay.setModel(new DefaultComboBoxModel(giorni));

		birthMonth = new JComboBox(new Object[] {});
		birthMonth.setModel(new DefaultComboBoxModel(mesi));

		birthYear = new JComboBox(new Object[] {});
		birthYear.setModel(new DefaultComboBoxModel(anni));

		rdbtnSexMale = new JRadioButton("Maschio");
		rdbtnSexMale.setSelected(true);
		rdbtnSexMale.setMnemonic('M');

		rdbtnSexFemale = new JRadioButton("Femmina");
		rdbtnSexFemale.setMnemonic('F');

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSexMale);
		buttonGroup.add(rdbtnSexFemale);

		btnSignUp = new JButton("Conferma");

		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDatiPersonali = new JLabel("DATI PERSONALI - " + usernameUser);
		lblDatiPersonali.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiPersonali.setFont(new Font("Tahoma", Font.PLAIN, 33));

		JLabel lblDataCertificato = new JLabel("Data certificato:");
		lblDataCertificato.setFont(new Font("Tahoma", Font.BOLD, 11));

		comboBox = new JComboBox(new Object[] {});
		comboBox.setModel(new DefaultComboBoxModel(giorni));
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(mesi));
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(anniC));

		JLabel lblInserisciCertificato = new JLabel("Inserisci certificato:");
		lblInserisciCertificato.setFont(new Font("Tahoma", Font.BOLD, 11));

		textField = new JTextField();
		textField.setToolTipText("Percorso locale del file.");
		textField.setEditable(false);
		textField.setColumns(10);

		btnBrowse = new JButton("Sfoglia...");
		btnBrowse
				.setToolTipText("Clicca per cercare il certificato medico nel tuo sistema.");

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(5)
										.addComponent(lblDatiPersonali,
												GroupLayout.DEFAULT_SIZE, 699,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(187)
										.addComponent(btnSignUp,
												GroupLayout.PREFERRED_SIZE,
												126, GroupLayout.PREFERRED_SIZE)
										.addGap(74)
										.addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE,
												127, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(186, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(170)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addComponent(
																				lblNewLabel_3,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblNewLabel_2,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblNewLabel_1,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblDataCertificato,
																				GroupLayout.DEFAULT_SIZE,
																				97,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblName))
														.addComponent(
																lblInserisciCertificato)
														.addComponent(
																lblNumeroTesseraSanitaria)
														.addComponent(
																lblNewLabel_4,
																GroupLayout.PREFERRED_SIZE,
																74,
																GroupLayout.PREFERRED_SIZE))
										.addGap(33)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																numeroTesseraSanitaria,
																GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addComponent(
																cognome,
																GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addComponent(
																codiceFiscale,
																GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addComponent(
																indirizzo,
																GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addComponent(
																nome,
																GroupLayout.DEFAULT_SIZE,
																181,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								comboBox,
																								Alignment.LEADING,
																								0,
																								59,
																								Short.MAX_VALUE)
																						.addComponent(
																								birthDay,
																								Alignment.LEADING,
																								0,
																								59,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								comboBox_1,
																								0,
																								57,
																								Short.MAX_VALUE)
																						.addComponent(
																								birthMonth,
																								0,
																								57,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								comboBox_2,
																								0,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								birthYear,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
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
																										.addGap(21)
																										.addComponent(
																												rdbtnSexMale,
																												GroupLayout.PREFERRED_SIZE,
																												65,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												textField,
																												GroupLayout.PREFERRED_SIZE,
																												98,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								rdbtnSexFemale,
																								GroupLayout.PREFERRED_SIZE,
																								80,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnBrowse,
																								GroupLayout.DEFAULT_SIZE,
																								89,
																								Short.MAX_VALUE))))
										.addGap(184)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(87)
										.addComponent(lblDatiPersonali)
										.addGap(63)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(lblName)
														.addComponent(
																nome,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel)
														.addComponent(
																cognome,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																codiceFiscale,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_2)
														.addComponent(
																indirizzo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_3)
														.addComponent(
																birthDay,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																birthMonth,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																birthYear,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED,
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblDataCertificato)
														.addComponent(
																comboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblInserisciCertificato)
														.addComponent(
																textField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnBrowse,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				lblNewLabel_4))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								rdbtnSexMale)
																						.addComponent(
																								rdbtnSexFemale))))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNumeroTesseraSanitaria)
														.addComponent(
																numeroTesseraSanitaria,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(65)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnSignUp,
																GroupLayout.PREFERRED_SIZE,
																45,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnBack,
																GroupLayout.PREFERRED_SIZE,
																45,
																GroupLayout.PREFERRED_SIZE))
										.addGap(102)));
		setLayout(groupLayout);

		nome.setText(userData.get(1));
		cognome.setText(userData.get(2));
		codiceFiscale.setText(userData.get(3));
		indirizzo.setText(userData.get(8));
		numeroTesseraSanitaria.setText(userData.get(6));
		birthDay.setSelectedIndex(Integer.parseInt(userData.get(5).substring(8,
				10)) - 1);
		birthMonth.setSelectedIndex(Integer.parseInt(userData.get(5).substring(
				5, 7)) - 1);
		birthYear.setSelectedIndex(Integer.parseInt(userData.get(5).substring(
				0, 4)) - 1900);
		comboBox.setSelectedIndex(Integer.parseInt(userData.get(7).substring(8,
				10)) - 1);
		comboBox_1.setSelectedIndex(Integer.parseInt(userData.get(7).substring(
				5, 7)) - 1);
		comboBox_2.setSelectedIndex(Integer.parseInt(userData.get(7).substring(
				0, 4)) - 2000);
		if (userData.get(4).equals("M"))
			rdbtnSexMale.setSelected(true);
		else
			rdbtnSexFemale.setSelected(true);

		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				fileToLoad = new LoadCertificate(usernameUser);

				int loaded = 0;

				try {
					loaded = fileToLoad.selectFile();
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}

				if (loaded == 1) {
					textField.setText(fileToLoad.getPath());
					textField.setEnabled(true);
					textField.setEditable(false);
				} else if (loaded == 0) {
					JOptionPane.showMessageDialog(null,
							"Errore, il file è vuoto!", "Attenzione", 0);
				}

			}

		});

		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!nome.getText().isEmpty() && !cognome.getText().isEmpty()
						&& !codiceFiscale.getText().isEmpty()
						&& !numeroTesseraSanitaria.getText().isEmpty()
						&& !indirizzo.getText().isEmpty()) {
					
					boolean isCertificateLoaded = false;
					boolean ok = true;
					
					if (!comboBox.getSelectedItem().equals(
							userData.get(7).substring(8, 10))
							|| !comboBox_1.getSelectedItem().equals(
									userData.get(7).substring(5, 7))
							|| !comboBox_2.getSelectedItem().equals(
									userData.get(7).substring(0, 4))) {
						isCertificateLoaded = textField.getText().isEmpty()? false : true;
						ok = isCertificateLoaded;
					} 
					
					if (ok) {
						ArrayList<String> arrayData = new ArrayList<String>();
						arrayData.add(usernameUser);
						arrayData.add(nome.getText());
						arrayData.add(cognome.getText());
						arrayData.add(codiceFiscale.getText().toUpperCase());

						if (rdbtnSexFemale.isSelected()) {
							arrayData.add("F");
						} else {
							arrayData.add("M");
						}

						arrayData.add(birthYear.getSelectedItem() + "-"
								+ birthMonth.getSelectedItem() + "-"
								+ birthDay.getSelectedItem());

						arrayData.add(numeroTesseraSanitaria.getText());

						arrayData.add(comboBox_2.getSelectedItem() + "-"
								+ comboBox_1.getSelectedItem() + "-"
								+ comboBox.getSelectedItem());

						arrayData.add(indirizzo.getText());

						if (JOptionPane.showConfirmDialog(null,
								"Confermi tutti i dati inseriti?", "Conferma",
								0) == 0) {
							boolean created = false;
							try {

								if (isCertificateLoaded) {
									fileToLoad.load();
								}

								created = (boolean) business.execute(
										"updateUserData", arrayData);
							} catch (SecurityException | NoSuchMethodException
									| ClassNotFoundException
									| InstantiationException
									| IllegalAccessException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if (created) {
								JOptionPane.showMessageDialog(null,
										"Dati modificati correttamente.",
										"Successo", 1);
								loadUserFrame();
							} else {
								JOptionPane
										.showMessageDialog(
												null,
												"Errore: assicurati di aver inserito correttamente tutti i dati.\nControlla i suggerimenti nei campi di testo.",
												"Attenzione", 0);
							}
						}
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"La data di rilascio del certificato SRC è stata modificata, carica il nuovo certificato nel sistema.",
										"Attenzione", 0);
					}
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Assicurarsi di aver inserito tutti i dati richiesti.",
									"Attenzione", 0);
				}
			}

		});

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadUserFrame();
			}

		});

	}

	/**
	 * Load user frame.
	 */
	private void loadUserFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("userHome", frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

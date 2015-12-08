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

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistration.
 */
public class UserRegistration extends JPanel {

	/** The file to load. */
	private LoadCertificate fileToLoad;
	
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

	/** The lbl new label_5. */
	private JLabel lblNewLabel_5;

	/** The numero tessera sanitaria. */
	private JTextField numeroTesseraSanitaria;

	/** The birth day. */
	private JComboBox birthDay;

	/** The birth month. */
	private JComboBox birthMonth;

	/** The birth year. */
	private JComboBox birthYear;

	/** The c day. */
	private JComboBox cDay;

	/** The c month. */
	private JComboBox cMonth;

	/** The c year. */
	private JComboBox cYear;

	/** The button group. */
	private ButtonGroup buttonGroup;

	/** The giorni. */
	private String[] giorni = { "GG", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18",
			"19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
			"30", "31" };

	/** The mesi. */
	private String[] mesi = { "MM", "01", "02", "03", "04", "05", "06", "07",
			"08", "09", "10", "11", "12" };

	/** The anni. */
	private String[] anni = { "AAAA", "1900", "1901", "1902", "1903", "1904",
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
	private String[] anniC = { "AAAA", "2014", "2015" };

	/** The lbl carica certificato. */
	private JLabel lblCaricaCertificato;

	/** The btn sfoglia. */
	private JButton btnSfoglia;

	/** The text field path. */
	private JTextField textFieldPath;

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

	/**
	 * Crea l'interfaccia.
	 * 
	 * @param username
	 *            the username
	 */
	public UserRegistration(String username) {

		usernameUser = username;
		business = new BusinessDelegate();
		frontController = new FrontController();

		JLabel lblName = new JLabel("Nome:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setToolTipText("");

		nome = new JTextField();
		nome.setToolTipText("Inserisci il tuo nome.");
		nome.setDocument(new PersonalizedJTextField(40));
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Cognome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		cognome = new JTextField();
		cognome.setToolTipText("Inserisci il tuo cognome.");
		cognome.setDocument(new PersonalizedJTextField(40));
		cognome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Codice Fiscale:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));

		codiceFiscale = new JTextField();
		codiceFiscale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		codiceFiscale.setToolTipText("Inserisci il tuo codice fiscale.");
		codiceFiscale.setDocument(new PersonalizedJTextField(16));
		codiceFiscale.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Indirizzo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));

		indirizzo = new JTextField();
		indirizzo.setToolTipText("Inserisci il tuo indirizzo di casa.");
		indirizzo.setDocument(new PersonalizedJTextField(50));
		indirizzo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Data di nascita");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblNewLabel_4 = new JLabel("Sesso");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNumeroTesseraSanitaria = new JLabel("Numero tessera sanitaria:");
		lblNumeroTesseraSanitaria.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumeroTesseraSanitaria.setToolTipText("");

		numeroTesseraSanitaria = new JTextField();
		numeroTesseraSanitaria
				.setToolTipText("Inserisci il tuo numero di tessera sanitaria.");
		numeroTesseraSanitaria.setDocument(new PersonalizedJTextField(20));
		numeroTesseraSanitaria.setColumns(10);

		lblNewLabel_5 = new JLabel("Data rilascio certificato");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setToolTipText("");

		birthDay = new JComboBox(new Object[] {});
		birthDay.setModel(new DefaultComboBoxModel(giorni));

		birthMonth = new JComboBox(new Object[] {});
		birthMonth.setModel(new DefaultComboBoxModel(mesi));

		birthYear = new JComboBox(new Object[] {});
		birthYear.setModel(new DefaultComboBoxModel(anni));

		cDay = new JComboBox(new Object[] {});
		cDay.setModel(new DefaultComboBoxModel(giorni));

		cMonth = new JComboBox(new Object[] {});
		cMonth.setModel(new DefaultComboBoxModel(mesi));

		cYear = new JComboBox(new Object[] {});
		cYear.setModel(new DefaultComboBoxModel(anniC));

		rdbtnSexMale = new JRadioButton("Maschio");
		rdbtnSexMale.setSelected(true);
		rdbtnSexMale.setMnemonic('M');

		rdbtnSexFemale = new JRadioButton("Femmina");
		rdbtnSexFemale.setMnemonic('F');

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnSexMale);
		buttonGroup.add(rdbtnSexFemale);

		btnSignUp = new JButton("Registrati");

		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblCaricaCertificato = new JLabel("Carica Certificato");
		lblCaricaCertificato.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnSfoglia = new JButton("Sfoglia...");

		textFieldPath = new JTextField();
		textFieldPath.setEnabled(false);
		textFieldPath.setColumns(10);

		JLabel label = new JLabel("REGISTRAZIONE");
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup().addGap(228)
										.addComponent(label)
										.addContainerGap(228, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(145)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblCaricaCertificato,
																				GroupLayout.PREFERRED_SIZE,
																				122,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap())
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
																										.addComponent(
																												lblNewLabel_5)
																										.addPreferredGap(
																												ComponentPlacement.RELATED))
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
																																		.addComponent(
																																				lblName,
																																				GroupLayout.PREFERRED_SIZE,
																																				97,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(54))
																														.addComponent(
																																lblNewLabel,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblNewLabel_1,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblNewLabel_2,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblNewLabel_3,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblNewLabel_4,
																																GroupLayout.PREFERRED_SIZE,
																																97,
																																GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																lblNumeroTesseraSanitaria,
																																GroupLayout.DEFAULT_SIZE,
																																151,
																																Short.MAX_VALUE))
																										.addGap(79)))
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								nome,
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
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												birthDay,
																												GroupLayout.PREFERRED_SIZE,
																												47,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.UNRELATED)
																										.addComponent(
																												birthMonth,
																												GroupLayout.PREFERRED_SIZE,
																												50,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												birthYear,
																												0,
																												68,
																												Short.MAX_VALUE))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				textFieldPath,
																																				GroupLayout.PREFERRED_SIZE,
																																				86,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				btnSfoglia,
																																				GroupLayout.DEFAULT_SIZE,
																																				89,
																																				Short.MAX_VALUE))
																														.addGroup(
																																groupLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				cDay,
																																				GroupLayout.PREFERRED_SIZE,
																																				54,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				cMonth,
																																				GroupLayout.PREFERRED_SIZE,
																																				54,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				cYear,
																																				0,
																																				61,
																																				Short.MAX_VALUE))
																														.addComponent(
																																numeroTesseraSanitaria,
																																GroupLayout.DEFAULT_SIZE,
																																181,
																																Short.MAX_VALUE)))
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												rdbtnSexMale,
																												GroupLayout.PREFERRED_SIZE,
																												83,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												rdbtnSexFemale,
																												GroupLayout.PREFERRED_SIZE,
																												80,
																												GroupLayout.PREFERRED_SIZE)))
																		.addGap(167))))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(178)
										.addComponent(btnSignUp,
												GroupLayout.PREFERRED_SIZE,
												120, GroupLayout.PREFERRED_SIZE)
										.addGap(104)
										.addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE,
												120, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(201, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(79)
										.addComponent(label)
										.addGap(66)
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
										.addGap(15)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																cognome,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel))
										.addGap(15)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																codiceFiscale,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_1))
										.addGap(15)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																indirizzo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNewLabel_2))
										.addGap(12)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																birthYear,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
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
																GroupLayout.PREFERRED_SIZE))
										.addGap(8)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_4)
														.addComponent(
																rdbtnSexMale)
														.addComponent(
																rdbtnSexFemale))
										.addGap(7)
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
										.addGap(14)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_5)
														.addComponent(
																cDay,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cMonth,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cYear,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblCaricaCertificato)
														.addComponent(
																textFieldPath,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnSfoglia,
																GroupLayout.PREFERRED_SIZE,
																20,
																Short.MAX_VALUE))
										.addGap(62)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																btnBack,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																btnSignUp,
																GroupLayout.PREFERRED_SIZE,
																45,
																GroupLayout.PREFERRED_SIZE))
										.addGap(71)));
		setLayout(groupLayout);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadGuestFrame();
			}

		});

		btnSfoglia.addActionListener(new ActionListener() {

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
					JOptionPane.showMessageDialog(null,
							"Certificato SRC valido!", "Successo", 1);
					textFieldPath.setText(fileToLoad.getPath());
					textFieldPath.setEnabled(true);
					textFieldPath.setEditable(false);
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
						&& !birthDay.getSelectedItem().equals("GG")
						&& !birthMonth.getSelectedItem().equals("MM")
						&& !birthYear.getSelectedItem().equals("AAAA")
						&& !cDay.getSelectedItem().equals("GG")
						&& !cMonth.getSelectedItem().equals("MM")
						&& !cYear.getSelectedItem().equals("AAAA")
						&& !indirizzo.getText().isEmpty()
						&& !textFieldPath.getText().isEmpty()) {
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
					arrayData.add(cYear.getSelectedItem() + "-"
							+ cMonth.getSelectedItem() + "-"
							+ cDay.getSelectedItem());
					arrayData.add(indirizzo.getText());
					if (JOptionPane.showConfirmDialog(null,
							"Confermi tutti i dati inseriti?", "Conferma", 0) == 0) {
						boolean created = false;
						try {
							created = (boolean) business.execute("addUser",
									arrayData);
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException
								| InstantiationException
								| IllegalAccessException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (created) {
							JOptionPane.showMessageDialog(null,
									"Dati registrati correttamente",
									"Successo", 1);
							loadUserFrame();
						} else {
							JOptionPane.showMessageDialog(null, "Errore. Assicurati di aver inserito correttamente i dati.",
									"Attenzione", 0);
						}
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

	/**
	 * Load guest frame.
	 */
	private void loadGuestFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("guestHome", frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

/*
 * 
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.PersonalizedJTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import presentation.FrontController;
import business.BusinessDelegate;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestDataView.
 */
public class DataView extends JPanel {

	/** The password. */
	private JPasswordField password;
	
	/** The email. */
	private JTextField email;

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

	/** The btn sign up. */
	private JButton btnSignUp;
	
	/** The btn back. */
	private JButton btnBack;

	/** The business. */
	private BusinessDelegate business;
	
	/** The front controller. */
	private FrontController frontController;

	/** The username user. */
	private String usernameUser;
	
	/** The back. */
	private String back;
	
	/** The password field. */
	private JPasswordField passwordField;
	
	/** The text field. */
	private JTextField textField;

	/**
	 * Crea l'interfaccia.
	 *
	 * @param arr the arr
	 */
	public DataView(ArrayList<String> arr) {

		back = arr.get(0);
		usernameUser = arr.get(1);
		business = new BusinessDelegate();
		frontController = new FrontController();

		ArrayList<String> guestData = new ArrayList<String>();
		try {
			guestData = (ArrayList<String>) business.execute("getGuest",
					usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null,
					"Non hai ancora completato la registrazione!",
					"Attenzione", 0);
			loadUserFrame();
		}

		JLabel lblName = new JLabel("Nuova password:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setToolTipText("");

		password = new JPasswordField("");
		password.setToolTipText("La password dev'essere lunga dai 6 ai 40 caratteri. Sono ammesse lettere maiuscole e minuscole, numeri ed i simboli \"-\" e \"_\".");
		password.setDocument(new PersonalizedJTextField(40));
		password.setColumns(10);

		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

		email = new JTextField(guestData.get(2));
		email.setToolTipText("L'email dev'essere lunga massimo 80 caratteri, e dev'essere scritta nella forma \"username@domain.com\".");
		email.setDocument(new PersonalizedJTextField(40));
		email.setColumns(10);

		btnSignUp = new JButton("Conferma");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDatiPersonali = new JLabel("DATI DI ACCESSO - " + usernameUser);
		lblDatiPersonali.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatiPersonali.setFont(new Font("Tahoma", Font.PLAIN, 33));

		JLabel lblReinserisciPassword = new JLabel("Reinserisci password:");
		lblReinserisciPassword.setToolTipText("");
		lblReinserisciPassword.setFont(new Font("Tahoma", Font.BOLD, 11));

		passwordField = new JPasswordField((String) null);
		passwordField.setToolTipText("Reinserisci la nuova password.");
		passwordField.setColumns(10);

		JLabel lblReinseriscila = new JLabel("Reinserisci e-mail:");
		lblReinseriscila.setFont(new Font("Tahoma", Font.BOLD, 11));

		textField = new JTextField((String) null);
		textField.setToolTipText("Reinserisci la nuova e-mail.");
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(161)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblReinseriscila, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
									.addGap(86)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(email)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblReinserisciPassword)
									.addGap(78)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator))
							.addPreferredGap(ComponentPlacement.RELATED, 161, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDatiPersonali, GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(112)
					.addComponent(lblDatiPersonali)
					.addGap(112)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblReinserisciPassword)))
					.addGap(18)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblReinseriscila)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(120)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addGap(108))
		);
		setLayout(groupLayout);

		email.setText(guestData.get(2));

		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String password1 = new String(password.getPassword());
				String password2 = new String(passwordField.getPassword());

				if (JOptionPane.showConfirmDialog(null,
						"Confermi i dati inseriti?", "Conferma", 0) == 0) {
					if (password1.equals(password2)) {
						if (email.getText().equals(textField.getText())) {

							ArrayList<String> arr = new ArrayList<String>();
							arr.add(usernameUser);
							arr.add(password1);
							arr.add(email.getText());

							boolean done = false;

							try {
								done = (boolean) business.execute(
										"updateGuestData", arr);
							} catch (SecurityException | NoSuchMethodException
									| ClassNotFoundException
									| InstantiationException
									| IllegalAccessException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							if (done) {
								JOptionPane.showMessageDialog(null,
										"Dati modificati correttamente!",
										"Successo", 1);
								loadUserFrame();
							} else {
								JOptionPane.showMessageDialog(null, "Errore. Assicurati di aver inserito correttamente i dati.",
										"Attenzione", 0);
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Le due email non corrispondono!",
									"Attenzione", 0);
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Le due password non corrispondono!",
								"Attenzione", 0);
					}
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
			frontController.processRequest(back, frame, usernameUser);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
/*
 * 
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import business.BusinessDelegate;
import presentation.FrontController;
import utility.PersonalizedJTextField;

import javax.swing.LayoutStyle.ComponentPlacement;

// TODO: Auto-generated Javadoc
/**
 * The Class Registration.
 */
public class Registration extends JPanel {

	/** The username. */
	private JTextField username;
	
	/** The password. */
	private JPasswordField password;
	
	/** The email. */
	private JTextField email;
	
	/** The btn sign up. */
	private JButton btnSignUp;
	
	/** The btn back. */
	private JButton btnBack;
	
	/** The front controller. */
	private FrontController frontController;
	
	/** The business. */
	private BusinessDelegate business;
	
	/** The lbl new label. */
	private JLabel lblNewLabel;

	/**
	 * Create the application.
	 */
	public Registration() {

		frontController = new FrontController();
		business = new BusinessDelegate();

		username = new JTextField();
		username.setToolTipText("L'username dev'essere lungo dai 6 ai 40 caratteri. Sono ammesse lettere maiuscole e minuscole, numeri ed i simboli \"-\" e \"_\".");
		username.setHorizontalAlignment(SwingConstants.LEFT);
		username.setFont(new Font("Tahoma", Font.PLAIN, 17));
		username.setDocument(new PersonalizedJTextField(40));
		username.setColumns(10);

		password = new JPasswordField();
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setToolTipText("La password dev'essere lunga dai 6 ai 40 caratteri. Sono ammesse lettere maiuscole e minuscole, numeri ed i simboli \"-\" e \"_\".");
		password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		password.setDocument(new PersonalizedJTextField(40));

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);

		btnBack = new JButton("Indietro");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnSignUp = new JButton("Registrati");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);

		email = new JTextField();
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setToolTipText("L'email dev'essere lunga massimo 80 caratteri, e dev'essere scritta nella forma \"username@domain.com\".");
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setDocument(new PersonalizedJTextField(80));
		email.setColumns(10);

		lblNewLabel = new JLabel("REGISTRAZIONE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup().addGap(228)
										.addComponent(lblNewLabel).addGap(228))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(172)
										.addComponent(btnSignUp,
												GroupLayout.PREFERRED_SIZE,
												150, GroupLayout.PREFERRED_SIZE)
										.addGap(53)
										.addComponent(btnBack,
												GroupLayout.PREFERRED_SIZE,
												153, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(172, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(171)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblPassword,
																								GroupLayout.DEFAULT_SIZE,
																								121,
																								Short.MAX_VALUE)
																						.addComponent(
																								lblUsername,
																								Alignment.LEADING,
																								GroupLayout.PREFERRED_SIZE,
																								109,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				lblEmail)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)))
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(email)
														.addComponent(password)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				username,
																				GroupLayout.PREFERRED_SIZE,
																				231,
																				GroupLayout.PREFERRED_SIZE)))
										.addGap(171)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(96)
										.addComponent(lblNewLabel)
										.addGap(109)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																username,
																GroupLayout.PREFERRED_SIZE,
																27,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblUsername))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																password,
																GroupLayout.PREFERRED_SIZE,
																27,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblPassword))
										.addGap(18)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																email,
																GroupLayout.PREFERRED_SIZE,
																27,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblEmail))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												137, Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnSignUp,
																GroupLayout.PREFERRED_SIZE,
																55,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																btnBack,
																GroupLayout.PREFERRED_SIZE,
																55,
																GroupLayout.PREFERRED_SIZE))
										.addGap(96)));

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadLoginFrame();
			}

		});

		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userPassword = new String(password.getPassword());

				if (!username.getText().isEmpty() && !userPassword.isEmpty()
						&& !email.getText().isEmpty()) {
					
					boolean loginAdded = false;
					ArrayList<String> data = new ArrayList<String>();
					data.add(username.getText());
					data.add(userPassword);
					data.add(email.getText());

					if (JOptionPane.showConfirmDialog(null,
							"Confermi tutti i dati inseriti?", "Conferma", 0) == 0) {

						try {
							loginAdded = (boolean) business.execute("addGuest",
									data);
							if (loginAdded) {
								JOptionPane
										.showMessageDialog(
												null,
												"Dati registrati correttamente, ora è possibile accedere al Sistema.",
												"Successo", 1);
								loadLoginFrame();
							} else {
								JOptionPane
								.showMessageDialog(
										null,
										"Errore. Assicurati di aver inserito correttamente i dati.",
										"Attenzione", 0);
							}
							
						} catch (SecurityException | NoSuchMethodException
								| ClassNotFoundException
								| InstantiationException
								| IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(null,
									"Username o Email già registrate!",
									"Attenzione", 0);
							username.setText("");
							password.setText("");
							email.setText("");
						}
						
					} else {
						username.setText("");
						password.setText("");
						email.setText("");
					}

				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"Registrazione annullata, assicurarsi di aver inserito tutti i dati richiesti.",
									"Attenzione", 0);
				}
			}

		});

		setLayout(groupLayout);
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

}

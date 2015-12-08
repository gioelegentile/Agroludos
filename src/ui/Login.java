/*
 * 
 */
package ui;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.Font;

import javax.swing.SwingConstants;

import presentation.FrontController;
import utility.Crypt;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

// TODO: Auto-generated Javadoc
/**
 * The Class Login.
 */
public class Login extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text field. */
	private JTextField textField;
	
	/** The password field. */
	private JPasswordField passwordField;
	
	/** The front controller. */
	private FrontController frontController;

	/**
	 * Create the application.
	 */
	public Login() {

		frontController = new FrontController();
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));

		final JButton btnRegistrati = new JButton("Registrati");
		btnRegistrati.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadLoginRegistrationFrame();
			}
		});
		
		

		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setFont(new Font("Tahoma", Font.PLAIN, 14));

		AbstractAction buttonPressed = new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
            	if (!dispatch()) {
					JOptionPane.showMessageDialog(null,
							"Nome utente o password errati", "Attenzione", 0);
					btnRegistrati.setFont(new Font("Tahoma", Font.BOLD, 14));
				} else {
					JOptionPane.showMessageDialog(null, "Bentornato " + textField.getText() + "!");
				}
            }
        };
		
        btnAccedi.addActionListener(buttonPressed);
        btnAccedi.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
                put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0), 0);
        
        btnAccedi.getActionMap().put(0, buttonPressed);

		JLabel lblAgroludos = new JLabel("AGROLUDOS");
		lblAgroludos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgroludos.setFont(new Font("Tahoma", Font.PLAIN, 66));

		JLabel lblNewLabel = new JLabel("Benvenuto in");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(123)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(144)
							.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
							.addGap(145))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(185)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
							.addGap(186))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordField, Alignment.LEADING, 261, 261, 261)
								.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
							.addGap(97))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAccedi, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
									.addComponent(btnRegistrati, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblAgroludos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
							.addGap(16)))
					.addGap(202))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(108)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAgroludos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrati, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAccedi, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addGap(108))
		);
		setLayout(groupLayout);

	}

	/**
	 * Load login registration frame.
	 */
	private void loadLoginRegistrationFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("loginRegistration", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Dispatch.
	 *
	 * @return true, if successful
	 */
	private boolean dispatch() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		char[] pass = passwordField.getPassword();
		String userPassword = new String(pass);

		try {
			ArrayList<String> data = new ArrayList<String>();
			data.add(textField.getText());
			data.add(Crypt.encrypt(userPassword));
			return (boolean) frontController.processRequest("dispatch", frame, data);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
}

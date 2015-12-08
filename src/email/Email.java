/*
 * 
 */
package email;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

// TODO: Auto-generated Javadoc

/**
 * The Class Email.
 */
public class Email {

	/**
	 * The Enum Choise.
	 */
	public enum Choise {

		/** The new player. */
		NEW_PLAYER, /** The update participation by user. */
		UPDATE_PARTICIPATION_BY_USER, /** The update participation by manager. */
		UPDATE_PARTICIPATION_BY_MANAGER, /** The delete participation by manager. */
		DELETE_PARTICIPATION_BY_MANAGER, /** The delete participation by user. */
		DELETE_PARTICIPATION_BY_USER, /** The dispose competition. */
		DISPOSE_COMPETITION, /** The update competition. */
		UPDATE_COMPETITION

	}

	/**
	 * Invia email.
	 * 
	 * @param receiver
	 *            the destinatario
	 * @param choise
	 *            the choise
	 * @param details
	 *            dell'email
	 */
	public static void send(String receiver, Choise choise, Object details) {

		String from = "agroludosgentilemenga@gmail.com";
		final String username = "agroludosgentilemenga";
		final String password = "agroludos";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));

			switch (choise) {
			case NEW_PLAYER:
				message.setSubject("Utente registrato");
				message.setText("L'utente \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" si e' appena registrato alla competizione ID: \""
						+ ((ArrayList<String>) details).get(1)
						+ "\", con i seguenti optional: \""
						+ ((ArrayList<String>) details).get(2) + "\".");
				break;
			case UPDATE_PARTICIPATION_BY_MANAGER:
				message.setSubject("Modifica partecipazione");
				message.setText("Il manager \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" della competizione \""
						+ ((ArrayList<String>) details).get(1)
						+ "\" ha appena modificato la sua partecipazione, modificando gli optionals in: \""
						+ ((ArrayList<String>) details).get(2)
						+ "\", per le seguenti motivazioni: \""
						+ ((ArrayList<String>) details).get(3) + "\".");
				break;
			case UPDATE_PARTICIPATION_BY_USER:
				message.setSubject("Modifica partecipazione");
				message.setText("L'utente \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" ha appena modificato la partecipazione alla competizione ID: \""
						+ ((ArrayList<String>) details).get(1)
						+ "\", modificando gli optionals in: \""
						+ ((ArrayList<String>) details).get(2) + "\".");
				break;
			case DELETE_PARTICIPATION_BY_MANAGER:
				message.setSubject("Partecipazione annullata");
				message.setText("Il manager \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" della competizione ID: \""
						+ ((ArrayList<String>) details).get(1)
						+ "\" ha appena cancellato la tua partecipazione per il seguente motivo: \""
						+ ((ArrayList<String>) details).get(2) + "\".");
				break;
			case DELETE_PARTICIPATION_BY_USER:
				message.setSubject("Partecipazione annullata");
				message.setText("L' Utente \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" ha appena cancellato la sua partecipazione alla competizione ID: \""
						+ ((ArrayList<String>) details).get(1) + "\".");
				break;
			case UPDATE_COMPETITION:
				message.setSubject("Partecipazione modificata");
				message.setText("Il manager \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" della competizione ID: \""
						+ ((ArrayList<String>) details).get(1)
						+ "\" ha appena modificato la competizione.");
				break;
			case DISPOSE_COMPETITION:
				message.setSubject("Partecipazione annullata");
				message.setText("Siamo spiacenti, il manager \""
						+ ((ArrayList<String>) details).get(0)
						+ "\" della competizione ID: \""
						+ ((ArrayList<String>) details).get(1)
						+ "\" ha appena annullato la competizione.");
				break;
			}

			Transport.send(message);

		} catch (MessagingException e) {
			return;
		}
	}

}
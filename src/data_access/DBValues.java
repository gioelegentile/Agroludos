/*
 * 
 */
package data_access;

// TODO: Auto-generated Javadoc
/**
 * Definisce i nomi di tabelle e campi dello schema del database Agroludos.
 *
 * @author Davide
 */

class DBValues {

	// Tabella Login
	/** The Constant GST_TAB. */
	final static String GST_TAB = "login";
	
	/** The Constant GST_USERNAME. */
	final static String GST_USERNAME = "user_login";
	
	/** The Constant GST_PASSWORD. */
	final static String GST_PASSWORD = "password";
	
	/** The Constant GST_EMAIL. */
	final static String GST_EMAIL = "email";
	
	// Tabella Utenti
	/** The Constant USR_TAB. */
	final static String USR_TAB = "users";
	
	/** The Constant USR_FISCALCODE. */
	final static String USR_FISCALCODE = "fiscal_code";
	
	/** The Constant USR_NAME. */
	final static String USR_NAME = "name";
	
	/** The Constant USR_SURNAME. */
	final static String USR_SURNAME = "surname";
	
	/** The Constant USR_ADDRESS. */
	final static String USR_ADDRESS = "address";
	
	/** The Constant USR_BIRTHDATE. */
	final static String USR_BIRTHDATE = "birth_date";
	
	/** The Constant USR_SEX. */
	final static String USR_SEX = "sex";
	
	/** The Constant USR_HEALTHCARDNUMBER. */
	final static String USR_HEALTHCARDNUMBER = "health_card_number";
	
	/** The Constant USR_CERTIFICATEDATE. */
	final static String USR_CERTIFICATEDATE = "certificate_date";
	
	/** The Constant USR_USERNAME. */
	final static String USR_USERNAME = "username";

	// Tabella Partecipanti
	/** The Constant PLY_TAB. */
	final static String PLY_TAB = "players";
	
	/** The Constant PLY_ID. */
	final static String PLY_ID = "id_competition";
	
	/** The Constant PLY_OPTIONAL. */
	final static String PLY_OPTIONAL = "id_optional";
	
	/** The Constant PLY_USERNAME. */
	final static String PLY_USERNAME = "user_player";
	
	/** The Constant PLY_SIGNUPDATE. */
	final static String PLY_SIGNUPDATE = "signup_date";
	
	/** The Constant PLY_SIGNUPTIME. */
	final static String PLY_SIGNUPTIME = "signup_time";
	
	/** The Constant PLY_PRICE. */
	final static String PLY_PRICE = "total_price";

	// Tabella Competizione
	/** The Constant CPT_TAB. */
	final static String CPT_TAB = "competitions";
	
	/** The Constant CPT_ID. */
	final static String CPT_ID = "id_competition";
	
	/** The Constant CPT_OPTIONAL. */
	final static String CPT_OPTIONAL = "id_optional";
	
	/** The Constant CPT_MANAGER. */
	final static String CPT_MANAGER = "manager";
	
	/** The Constant CPT_EMAIL. */
	final static String CPT_EMAIL = "email";
	
	/** The Constant CPT_TYPE. */
	final static String CPT_TYPE = "type";
	
	/** The Constant CPT_DATE. */
	final static String CPT_DATE = "date";
	
	/** The Constant CPT_TIME. */
	final static String CPT_TIME = "time";
	
	/** The Constant CPT_PRICE. */
	final static String CPT_PRICE = "price";
	
	/** The Constant CPT_MIN. */
	final static String CPT_MIN = "min";
	
	/** The Constant CPT_MAX. */
	final static String CPT_MAX = "max";
	
	/** The Constant CPT_ACTIVE. */
	final static String CPT_ACTIVE = "active";

	// Tabella Optional
	/** The Constant OPT_TAB. */
	final static String OPT_TAB = "optionals";
	
	/** The Constant OPT_ID. */
	final static String OPT_ID = "id_optional";
	
	/** The Constant OPT_NAME. */
	final static String OPT_NAME = "name";
	
	/** The Constant OPT_PRICE. */
	final static String OPT_PRICE = "price";

	// Tabella Manager
	/** The Constant MNG_TAB. */
	final static String MNG_TAB = "managers";
	
	/** The Constant MNG_USERNAME. */
	final static String MNG_USERNAME = "user_manager";

	// Tabella Tipi di optional
	/** The Constant TYP_TAB. */
	final static String TYP_TAB = "types";
	
	/** The Constant TYP_ID. */
	final static String TYP_ID = "id_type";
	
	/** The Constant TYP_TYPE. */
	final static String TYP_TYPE = "type";

}

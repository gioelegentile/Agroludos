/*
 * 
 */
package utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Check.
 */
public class Check {

	/**
	 * Controlla che la stringa sia composta da sole cifre.
	 *
	 * @param str the str
	 * @return True=la stringa ט composta da sole cifre. False=la stringa non ט
	 *         composta da sole cifre.
	 */
	public static boolean isNumeric(String str) {
		return str.matches("[0-9]{1,20}");
	}

	/**
	 * Checks if is health card.
	 *
	 * @param str the str
	 * @return true, if is health card
	 */
	public static boolean isHealthCard(String str) {
		boolean check = str.length() == 20;
		for (int i = 0; i < str.length() && check; i++) {
			check = Character.isDigit(str.charAt(i));
		}
		return check;
	}

	/**
	 * Checks if is fiscal code.
	 *
	 * @param str the str
	 * @return true, if is fiscal code
	 */
	public static boolean isFiscalCode(String str) {
		boolean check = str.length() == 16;
		for (int i = 0; i < str.length() && check; i++) {
			check = Character.isLetter(str.charAt(i)) ? Character
					.isUpperCase(str.charAt(i)) : Character.isDigit(str
					.charAt(i));
		}
		return check;
	}
	
	/**
	 * Convert to float.
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String convertToFloat(String str) {
		if (str.contains(",")) {
			return str.replaceAll(",", ".");
		} else {
			return str;
		}
	}

	/**
	 * Checks if is float.
	 *
	 * @param str the str
	 * @return true, if is float
	 */
	public static boolean isFloat(String str) {

		boolean check = str.length() > 0;
		for (int i = 0; i < str.length() && check; i++) {
			if (str.charAt(i) != '.')
				check = Character.isDigit(str.charAt(i));
		}
		return check;

	}

	/**
	 * Are numerics.
	 *
	 * @param arrayList the array list
	 * @return true, if successful
	 */
	public static boolean areNumerics(ArrayList<String> arrayList) {
		boolean check = true;

		for (int i = 0; i < arrayList.size() && check; i++) {
			check = arrayList.get(i).matches("[0-9]{1,20}");
		}

		return check;
	}

	/**
	 * Checks if is name.
	 *
	 * @param str the str
	 * @return true, if is name
	 */
	public static boolean isName(String str) {
		return str.matches("[a-zA-Z 'טעאשל]{1,40}");
	}

	/**
	 * Checks if is username.
	 *
	 * @param str the str
	 * @return true, if is username
	 */
	public static boolean isUsername(String str) {
		return str.matches("[a-zA-Z0-9-_]{4,40}");
	}

	/**
	 * Checks if is sex.
	 *
	 * @param str the str
	 * @return true, if is sex
	 */
	public static boolean isSex(String str) {

		return str.matches("[MF]");

	}

	/**
	 * Checks if is date.
	 *
	 * @param str the str
	 * @return true, if is date
	 */
	public static boolean isDate(String str) {

		if (str.matches("^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$")) {
			int giorno = Integer.parseInt(str.substring(8, 10));
			int mese = Integer.parseInt(str.substring(5, 7));
			int anno = Integer.parseInt(str.substring(0, 4));

			if ((bissextile(anno)) && (mese == 02) && (giorno > 29)) {
				return false;
			}
			if ((!bissextile(anno)) && (mese == 02) && (giorno > 28)) {
				return false;
			}
			if ((giorno > 30)
					&& ((mese == 04) || (mese == 06) || (mese == 9) || (mese == 11))) {
				return false;
			} else
				return true;
		} else
			return false;

	}

	/**
	 * Checks if is time.
	 *
	 * @param str the str
	 * @return true, if is time
	 */
	public static boolean isTime(String str) {
		String ore, min, sec;
		if (str.matches("[\\d]{2}:[\\d]{2}:[\\d]{2}")) {
			ore = str.substring(0, 2);
			min = str.substring(3, 5);
			sec = str.substring(6);

			if (((ore.matches("[0|1][0-9]")) || (ore.matches("2[0-3]")))
					&& (min.matches("[0-5][0-9]") && (sec.matches("[0-5][0-9]")))) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	/**
	 * Checks if is address.
	 *
	 * @param str the str
	 * @return true, if is address
	 */
	public static boolean isAddress(String str) {

		return str.matches("[a-zA-Z0-9 ]{2,80}");

	}

	/**
	 * Checks if is password.
	 *
	 * @param str the str
	 * @return true, if is password
	 */
	public static boolean isPassword(String str) {

		return str.matches("[a-zA-Z0-9-_]{6,40}");

	}

	/**
	 * Checks if is email.
	 *
	 * @param str the str
	 * @return true, if is email
	 */
	public static boolean isEmail(String str) {

		return str.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	}

	/**
	 * Checks if is two days before.
	 *
	 * @param data the data
	 * @return true, if is two days before
	 */
	public static boolean isTwoDaysBefore(String data) {
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		String oggi = sdf.format(System.currentTimeMillis());

		try {

			Date d1 = sdf.parse(data);
			Date d2 = sdf.parse(oggi);
			if ((d1.getTime() - d2.getTime()) > 172800000) {
				return true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Checks for passed.
	 *
	 * @param data the data
	 * @return true, if successful
	 */
	public static boolean hasPassed(String data) {
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		String oggi = sdf.format(System.currentTimeMillis());

		try {

			Date d1 = sdf.parse(data);
			Date d2 = sdf.parse(oggi);
			if ((d1.getTime() < d2.getTime())) {
				return true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;

	}
	
	/**
	 * Checks if is twelve hours after.
	 *
	 * @param data the data
	 * @return true, if is twelve hours after
	 */
	public static boolean isTwelveHoursAfter(String data) {
		String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		String oggi = sdf.format(System.currentTimeMillis());

		try {

			Date d1 = sdf.parse(data);
			Date d2 = sdf.parse(oggi);
			if ((d1.getTime() > (d2.getTime()) + 43200000)) {
				return true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Checks if is src valid.
	 *
	 * @param date the date
	 * @param dateCompetition the date competition
	 * @return true, if is src valid
	 */
	public static boolean isSrcValid(String date, String dateCompetition) {
		String DATE_FORMAT = "yyyy-MM-dd";
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		double limit = 31536000000.0;

		try {

			Date d1 = sdf.parse(date);
			Date d2 = sdf.parse(dateCompetition);
			if ((d2.getTime() - d1.getTime()) < limit) {
				return true;
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Bissextile.
	 *
	 * @param year the year
	 * @return true, if successful
	 */
	private static boolean bissextile(int year) {
		if (((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0))) {
			return true;
		} else {
			return false;
		}
	}

}

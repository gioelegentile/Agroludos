/*
 * 
 */
package utility;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class ConvertIdOptional.
 */
public class ConvertIdOptional {

	/**
	 * Convert.
	 *
	 * @param id the id
	 * @return the string
	 * @throws SQLException the SQL exception
	 */
	public static String convert(String id) throws SQLException {

		if (id.equals("0")) {
			return "Nessuno";
		} else {
			ArrayList<ArrayList<String>> optionals = new ArrayList<ArrayList<String>>();
			BusinessDelegate business = new BusinessDelegate();

			try {
				optionals = (ArrayList<ArrayList<String>>) business.execute(
						"getOptionals", null);
			} catch (SecurityException | NoSuchMethodException
					| ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				throw new SQLException(e);
			}

			for (int i = 0; i < optionals.size(); i++) {
				if (id.equals(optionals.get(i).get(0))) {
					return optionals.get(i).get(1);
				}
			}
		}
		return null;

	}

}

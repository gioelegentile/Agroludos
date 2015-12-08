/*
 * 
 */
package utility;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class ConvertTypeCompetition.
 */
public class ConvertTypeCompetition {
	
	/**
	 * Convert.
	 *
	 * @param id the id
	 * @return the string
	 * @throws SQLException the SQL exception
	 */
	public static String convert(String id) throws SQLException {
		
		ArrayList<ArrayList<String>> types = new ArrayList<ArrayList<String>>();
		BusinessDelegate business = new BusinessDelegate();
		
		try {
			types = (ArrayList<ArrayList<String>>) business.execute("getTypes", null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		for(int i = 0; i < types.size(); i++) {
			if(id.equals(types.get(i).get(0))) {
				return types.get(i).get(1);
			}
		}
		return null;
	}

}

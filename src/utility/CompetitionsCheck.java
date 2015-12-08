/*
 * 
 */
package utility;

import java.sql.SQLException;
import java.util.ArrayList;

import business.BusinessDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class CompetitionsCheck.
 */
public class CompetitionsCheck {
	
	/**
	 * Check.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void check() throws SQLException {
		
		BusinessDelegate business = new BusinessDelegate();
		ArrayList<ArrayList<String>> competitionsList = new ArrayList<ArrayList<String>>();
		
		try {
			competitionsList = (ArrayList<ArrayList<String>>) business.execute("getActiveCompetitions", null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		for (int i = 0; i < competitionsList.size(); i++) {
			
			String date = competitionsList.get(i).get(4) + " " +competitionsList.get(i).get(5);
			if (Check.hasPassed(date)) {
				try {
					business.execute("disposeCompetition", competitionsList.get(i).get(0));
				} catch (SecurityException | NoSuchMethodException
						| ClassNotFoundException | InstantiationException
						| IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}

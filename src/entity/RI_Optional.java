package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Optional.
 */
public interface RI_Optional {

	/**
	 * Gets the optionals.
	 *
	 * @return the optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getOptionals() throws SQLException;
	
}

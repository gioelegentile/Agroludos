package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface RI_Type.
 */
public interface RI_Type {

	/**
	 * Gets the types.
	 *
	 * @return the types
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getTypes() throws SQLException;
	
}

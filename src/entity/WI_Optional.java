package entity;

import java.sql.SQLException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Optional.
 */
public interface WI_Optional {

	/**
	 * Sets the optional data.
	 *
	 * @param data the data
	 * @return true, if successful
	 */
	public boolean setOptionalData(ArrayList<String> data);

	/**
	 * Adds the optional.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addOptional() throws SQLException;

	/**
	 * Delete optional.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteOptional(String id) throws SQLException;

}

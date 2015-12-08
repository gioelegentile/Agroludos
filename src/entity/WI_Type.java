package entity;

import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Interface WI_Type.
 */
public interface WI_Type {

	/**
	 * Sets the type data.
	 *
	 * @param type the type
	 * @return true, if successful
	 */
	public boolean setTypeData(String type);
	
	/**
	 * Adds the type.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void addType() throws SQLException;

	/**
	 * Delete type.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteType(String id) throws SQLException;

}

package business;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.I_Type;
import entity.RI_Type;
import entity.WI_Type;

// TODO: Auto-generated Javadoc
/**
 * The Class TypesManagement.
 */
public class TypesManagement {
	
	/** The type read. */
	static RI_Type typeRead = I_Type.getTypeRead();
	
	/** The type write. */
	static WI_Type typeWrite = I_Type.getTypeWrite();

	/**
	 * Adds the type.
	 *
	 * @param type the type
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addType(String type) throws SQLException {

		if (typeWrite.setTypeData(type)) {
			typeWrite.addType();
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Delete type.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteType(String id) throws SQLException {

		return typeWrite.deleteType(id);

	}
	
	/**
	 * Gets the types.
	 *
	 * @return the types
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getTypes() throws SQLException {

		return typeRead.getTypes();

	}
	
}

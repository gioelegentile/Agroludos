package business;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.I_Optional;
import entity.RI_Optional;
import entity.WI_Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class OptionalsManagement.
 */
public class OptionalsManagement {
	
	/** The optional read. */
	static RI_Optional optionalRead = I_Optional.getOptionalRead();
	
	/** The optional write. */
	static WI_Optional optionalWrite = I_Optional.getOptionalWrite();
	
	/**
	 * Adds the optional.
	 *
	 * @param data the data
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addOptional(ArrayList<String> data) throws SQLException {

		if (optionalWrite.setOptionalData(data)) {
			optionalWrite.addOptional();
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * Delete optional.
	 *
	 * @param id the id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteOptional(String id) throws SQLException {

		return optionalWrite.deleteOptional(id);

	}
	
	/**
	 * Gets the optionals.
	 *
	 * @return the optionals
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ArrayList<String>> getOptionals() throws SQLException {

		return optionalRead.getOptionals();

	}

}

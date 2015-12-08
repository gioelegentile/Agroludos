package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.Check;
import data_access.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Type.
 */
public class Type implements RI_Type, WI_Type {

	/** The type. */
	private String type;

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#setTypeData(java.lang.String)
	 */
	@Override
	public boolean setTypeData(String type) {

		if (Check.isName(type)) {
			this.type = type;
			return true;
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#addType()
	 */
	@Override
	public void addType() throws SQLException {

		DAO dao = new DAO();
		dao.addType(type);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#deleteType(java.lang.String)
	 */
	@Override
	public boolean deleteType(String id) throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.deleteType(id);
		else
			return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.RI_Admin#getTypes()
	 */
	@Override
	public ArrayList<ArrayList<String>> getTypes() throws SQLException {

		DAO dao = new DAO();
		return dao.getTypes();

	}
}

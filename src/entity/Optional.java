package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.Check;
import data_access.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Optional.
 */
public class Optional implements RI_Optional, WI_Optional {

	/** The type. */
	private String name, price;

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#setOptionalData(java.util.ArrayList)
	 */
	@Override
	public boolean setOptionalData(ArrayList<String> data) {

		if (Check.isName(data.get(0)) && Check.isFloat(data.get(1))) {

			this.name = data.get(0);
			this.price = data.get(1);

			return true;
		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#addOptional()
	 */
	@Override
	public void addOptional() throws SQLException {

		DAO dao = new DAO();
		dao.addOptional(name, price);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.WI_Admin#deleteOptional(java.lang.String)
	 */
	@Override
	public boolean deleteOptional(String id) throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.deleteOptional(id);
		else
			return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see entity.RI_Admin#getOptionals()
	 */
	@Override
	public ArrayList<ArrayList<String>> getOptionals() throws SQLException {

		DAO dao = new DAO();
		return dao.getOptionals();

	}

}

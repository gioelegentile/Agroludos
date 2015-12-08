/*
 * 
 */
package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.Check;
import data_access.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager implements RI_Manager, WI_Manager {

	/** The username. */
	private String username;

	/* (non-Javadoc)
	 * @see entity.WI_Manager#setData(java.lang.String)
	 */
	@Override
	public boolean setData(String username) {

		if (Check.isUsername(username)) {
			this.username = username;
			return true;
		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_Manager#addManager()
	 */
	@Override
	public void addManager() throws SQLException {
		
		DAO dao = new DAO();
		dao.addManager(username);
		
	}

	/* (non-Javadoc)
	 * @see entity.WI_Manager#deleteManager()
	 */
	@Override
	public boolean deleteManager() throws SQLException {
		
		DAO dao = new DAO();
		return dao.deleteManager(username);
		
	}

	/* (non-Javadoc)
	 * @see entity.WI_Manager#deleteAllManagers()
	 */
	@Override
	public boolean deleteAllManagers() throws SQLException {

		DAO dao = new DAO();
		return dao.deleteAllManagers();
		
	}

	/* (non-Javadoc)
	 * @see entity.RI_Manager#getManagers()
	 */
	@Override
	public ArrayList<String> getManagers() throws SQLException {

		DAO dao = new DAO();

		ArrayList<ArrayList<String>> managersInput = dao.getManagers();
		ArrayList<String> managersOutput = new ArrayList<String>();
		
		for (ArrayList<String> arr : managersInput) {
			managersOutput.add(arr.get(0));
		}
		
		return managersOutput;
		
	}
	
	/* (non-Javadoc)
	 * @see entity.RI_Manager#getManagerEmail(java.lang.String)
	 */
	@Override
	public ArrayList<String> getManagerEmail(String username) throws SQLException {
		
		DAO dao = new DAO();
		return dao.getManagerEmail(username).get(0);
		
	}

	/* (non-Javadoc)
	 * @see entity.RI_Manager#getUsersNotManager()
	 */
	@Override
	public ArrayList<ArrayList<String>> getUsersNotManager() throws SQLException {
		
		DAO dao = new DAO();
		return dao.getUsersNotManager();
		
	}
	
}

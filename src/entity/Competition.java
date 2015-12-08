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
 * The Class Competitions.
 */
public class Competition implements RI_Competition, WI_Competition {

	/** The max. */
	private String id, type, date, time, manager, price, min, max;
	
	/** The optionals. */
	private ArrayList<String> optionals;

	/* (non-Javadoc)
	 * @see entity.WI_Competitions#setData(java.util.ArrayList)
	 */
	@Override
	public boolean setData(ArrayList<ArrayList<String>> arrayList) {

		if (Check.isNumeric(arrayList.get(0).get(0))
				&& Check.isDate(arrayList.get(1).get(0))
				&& Check.isTime(arrayList.get(2).get(0))
				&& Check.isUsername(arrayList.get(3).get(0))
				&& Check.isFloat(arrayList.get(4).get(0))
				&& Check.isNumeric(arrayList.get(5).get(0))
				&& Check.isNumeric(arrayList.get(6).get(0))
				&& Check.areNumerics(arrayList.get(7))) {

			this.type = arrayList.get(0).get(0);
			this.date = arrayList.get(1).get(0);
			this.time = arrayList.get(2).get(0);
			this.manager = arrayList.get(3).get(0);
			this.price = arrayList.get(4).get(0);
			this.min = arrayList.get(5).get(0);
			this.max = arrayList.get(6).get(0);
			this.optionals = arrayList.get(7);

			return true;

		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_Competitions#setUpdateData(java.util.ArrayList)
	 */
	@Override
	public boolean setUpdateData(ArrayList<ArrayList<String>> arrayList) {

		if (Check.isNumeric(arrayList.get(0).get(0))
				&& Check.isNumeric(arrayList.get(1).get(0))
				&& Check.isDate(arrayList.get(2).get(0))
				&& Check.isTime(arrayList.get(3).get(0))
				&& Check.isUsername(arrayList.get(4).get(0))
				&& Check.isFloat(arrayList.get(5).get(0))
				&& Check.isNumeric(arrayList.get(6).get(0))
				&& Check.isNumeric(arrayList.get(7).get(0))
				&& Check.areNumerics(arrayList.get(8))) {

			this.id = arrayList.get(0).get(0);
			this.type = arrayList.get(1).get(0);
			this.date = arrayList.get(2).get(0);
			this.time = arrayList.get(3).get(0);
			this.manager = arrayList.get(4).get(0);
			this.price = arrayList.get(5).get(0);
			this.min = arrayList.get(6).get(0);
			this.max = arrayList.get(7).get(0);
			this.optionals = arrayList.get(8);

			return true;

		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_Competitions#createCompetition()
	 */
	@Override
	public void createCompetition() throws SQLException {

		DAO dao = new DAO();
		dao.createCompetition(type, date, time, manager, price, min, max,
				optionals);

	}

	/* (non-Javadoc)
	 * @see entity.WI_Competitions#disposeCompetition(java.lang.String)
	 */
	@Override
	public boolean disposeCompetition(String id) throws SQLException {

		DAO dao = new DAO();
		return dao.disposeCompetition(id);

	}

	/* (non-Javadoc)
	 * @see entity.WI_Competitions#updateCompetition()
	 */
	@Override
	public void updateCompetition() throws SQLException {

		DAO dao = new DAO();
		dao.updateCompetition(id, type, date, time, manager, price, min, max,
				optionals);

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionsAsAdmin()
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionsAsAdmin()
			throws SQLException {

		DAO dao = new DAO();
		return dao.getCompetitionsAsAdmin();

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionsAsManager(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionsAsManager(String username)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isUsername(username))
			return dao.getCompetitionsAsManager(username);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionsAsPlayer(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionsAsPlayer(String username)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isUsername(username))
			return dao.getCompetitionsAsPlayer(username);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionsAsUser()
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionsAsUser()
			throws SQLException {

		DAO dao = new DAO();
		return dao.getCompetitionsAsUser();

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getActiveCompetitions()
	 */
	@Override
	public ArrayList<ArrayList<String>> getActiveCompetitions()
			throws SQLException {

		DAO dao = new DAO();
		return dao.getActiveCompetitions();

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionData(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionData(String id)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.getCompetitionData(id);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Competitions#getCompetitionOptionals(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getCompetitionOptionals(String id)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.getCompetitionOptionals(id);
		else
			return null;

	}

}

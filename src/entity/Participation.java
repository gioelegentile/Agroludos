package entity;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.Check;
import data_access.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Participations.
 */
public class Participation implements RI_Participation, WI_Participation {

	/** The id. */
	private String id;
	
	/** The optionals. */
	private ArrayList<String> optionals;
	
	/** The username. */
	private String username;
	
	/** The date. */
	private String date;
	
	/** The time. */
	private String time;

	/* (non-Javadoc)
	 * @see entity.WI_Participations#setData(java.util.ArrayList)
	 */
	@Override
	public boolean setData(ArrayList<ArrayList<String>> arrayList) {

		if (Check.isNumeric(arrayList.get(0).get(0))
				&& Check.areNumerics(arrayList.get(1))
				&& Check.isUsername(arrayList.get(2).get(0))
				&& Check.isDate(arrayList.get(3).get(0))
				&& Check.isTime(arrayList.get(4).get(0))) {

			this.id = arrayList.get(0).get(0);
			this.optionals = arrayList.get(1);
			this.username = arrayList.get(2).get(0);
			this.date = arrayList.get(3).get(0);
			this.time = arrayList.get(4).get(0);

			return true;
		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_Participations#setOptionals(java.util.ArrayList)
	 */
	@Override
	public boolean setOptionals(ArrayList<String> arrayList) {

		if (Check.areNumerics(arrayList)) {
			this.optionals = arrayList;
			return true;
		} else {
			return false;
		}

	}

	/* (non-Javadoc)
	 * @see entity.WI_Participations#addParticipation()
	 */
	@Override
	public void addParticipation() throws SQLException {

		DAO dao = new DAO();
		dao.addParticipation(id, optionals, username, date, time);

	}

	/* (non-Javadoc)
	 * @see entity.WI_Participations#deleteParticipation(java.util.ArrayList)
	 */
	@Override
	public boolean deleteParticipation(ArrayList<String> arrayList)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(arrayList.get(0)) && Check.isUsername(arrayList.get(1)))
			return dao.deleteParticipation(arrayList.get(0), arrayList.get(1));
		else
			return false;

	}

	/* (non-Javadoc)
	 * @see entity.WI_Participations#updateParticipation()
	 */
	@Override
	public void updateParticipation() throws SQLException {

		DAO dao = new DAO();
		dao.updateParticipationOptionals(id, username, optionals);

	}

	/* (non-Javadoc)
	 * @see entity.RI_Participations#getParticipations(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getParticipations(String id)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.getParticipations(id);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Participations#getParticipationsData(java.lang.String)
	 */
	@Override
	public ArrayList<ArrayList<String>> getParticipationsData(String id)
			throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(id))
			return dao.getParticipationsData(id);
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Participations#getParticipationData(java.util.ArrayList)
	 */
	@Override
	public ArrayList<ArrayList<String>> getParticipationData(
			ArrayList<String> data) throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(data.get(0)) && Check.isUsername(data.get(1)))
			return dao.getParticipationData(data.get(0), data.get(1));
		else
			return null;

	}

	/* (non-Javadoc)
	 * @see entity.RI_Participations#getParticipationOptionals(java.util.ArrayList)
	 */
	@Override
	public ArrayList<ArrayList<String>> getParticipationOptionals(
			ArrayList<String> data) throws SQLException {

		DAO dao = new DAO();
		if (Check.isNumeric(data.get(0)) && Check.isUsername(data.get(1)))
			return dao.getParticipationOptionals(data.get(0), data.get(1));
		else
			return null;

	}

}

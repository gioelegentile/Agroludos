package test;

import java.util.ArrayList;

import entity.Competition;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class CompetitionTest.
 */
public class CompetitionTest extends TestCase {

	/** The competitions cases. */
	ArrayList<ArrayList<ArrayList<String>>> competitionsCases = new ArrayList<ArrayList<ArrayList<String>>>();
	
	/** The update cases. */
	ArrayList<ArrayList<ArrayList<String>>> updateCases = new ArrayList<ArrayList<ArrayList<String>>>();
	
	/** The values. */
	String[][][] values = {
			{ {""}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {""}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {""}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {""}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {""}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {""}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {""}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {""} },
			{ {"abc"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"abc"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"abc"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"usr"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"abc"}, {"10"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"abc"}, {"40"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"abc"}, {"1", "2", "3"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"abc"} },
			{ {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2", "3"} }
	};
	
	/** The update values. */
	String[][][] updateValues = {
			{ {""}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {""}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {""}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {""}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {""}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {""}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {""}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {""}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {""} },
			{ {"abc"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"abc"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"abc"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"abc"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"usr"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"abc"}, {"10"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"abc"}, {"40"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"abc"}, {"1", "2"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"abc"} },
			{ {"1"}, {"1"}, {"2015-02-25"}, {"16:45:00"}, {"manager"}, {"50.00"}, {"10"}, {"40"}, {"1", "2"} }
	};
	
	/** The competitions expected. */
	boolean[] competitionsExpected = { false, false, false, false, false, false, false, false, false, 
			false, false, false, false, false, false, false, true };
	
	/** The update expected. */
	boolean[] updateExpected = { false, false, false, false, false, false, false, false, false, false, false, 
			false, false, false, false, false, false, false, true };
	
	/** The competition. */
	private Competition competition;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		competition = new Competition();
		
		ArrayList<ArrayList<String>> case0 = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {

			for (int j = 0; j < values[i].length; j++) {
				for (int h = 0; h < values[i][j].length; h++) 
					temp.add(values[i][j][h]);
				case0.add(temp);
				temp = new ArrayList<String>();
			}

			competitionsCases.add(case0);
			case0 = new ArrayList<ArrayList<String>>();

		}
		
		for (int i = 0; i < updateValues.length; i++) {

			for (int j = 0; j < updateValues[i].length; j++) {
				for (int h = 0; h < updateValues[i][j].length; h++) 
					temp.add(updateValues[i][j][h]);
				case0.add(temp);
				temp = new ArrayList<String>();
			}

			updateCases.add(case0);
			case0 = new ArrayList<ArrayList<String>>();

		}
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		competition = null;
	}

	/**
	 * Test set data.
	 */
	public void testSetData() {
		
		for (int i = 0; i < competitionsCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ competitionsCases.get(i).toString() + ".",
					competitionsExpected[i],
					competition.setData(competitionsCases.get(i)));
		}
		
	}

	/**
	 * Test set update data.
	 */
	public void testSetUpdateData() {
		
		for (int i = 0; i < updateCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ updateCases.get(i).toString() + ".",
					updateExpected[i],
					competition.setUpdateData(updateCases.get(i)));
		}
		
	}

}

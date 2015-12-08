package test;

import java.util.ArrayList;

import entity.Participation;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticipationTest.
 */
public class ParticipationTest extends TestCase {

	/** The participations cases. */
	ArrayList<ArrayList<ArrayList<String>>> participationsCases = new ArrayList<ArrayList<ArrayList<String>>>();
	
	/** The optionals cases. */
	ArrayList<ArrayList<String>> optionalsCases = new ArrayList<ArrayList<String>>();
	
	/** The values. */
	String[][][] values = {
			{ {""}, {"1", "2", "3"}, {"username"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {""}, {"username"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {""}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {"username"}, {""}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {"username"}, {"2015-02-25"}, {""} },
			{ {"abc"}, {"1", "2", "3"}, {"username"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"a", "b", "c"}, {"username"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {"use"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {"username"}, {"abc"}, {"16:45:00"} },
			{ {"1"}, {"1", "2", "3"}, {"username"}, {"2015-02-25"}, {"abc"} },
			{ {"1"}, {"1", "2", "3"}, {"username"}, {"2015-02-25"}, {"16:45:00"} },
			{ {"1"}, {"0"}, {"username"}, {"2015-02-25"}, {"16:45:00"} }
	};
	
	/** The opt values. */
	String[][] optValues = {
			{"abc", "2"},
			{"", "2"},
			{"1 2 3"},
			{"1", "2", "3"},
			{"0"}
	};
	
	/** The participations expected. */
	boolean[] participationsExpected = { false, false, false, false, false, false, false, false, false, false, true, true };
	
	/** The optionals expected. */
	boolean[] optionalsExpected = { false, false, false, true, true };
	
	/** The participation. */
	private Participation participation;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		participation = new Participation();
		
		ArrayList<ArrayList<String>> case0 = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp = new ArrayList<String>();

		for (int i = 0; i < values.length; i++) {

			for (int j = 0; j < values[i].length; j++) {
				
				for (int h = 0; h < values[i][j].length; h++) 
					temp.add(values[i][j][h]);
				
				case0.add(temp);
				temp = new ArrayList<String>();
			}

			participationsCases.add(case0);
			case0 = new ArrayList<ArrayList<String>>();

		}
		
		for (int i = 0; i < optValues.length; i++) {
			
			for (int h = 0; h < optValues[i].length; h++)
				temp.add(optValues[i][h]);
			optionalsCases.add(temp);
			temp = new ArrayList<String>();
			
		}

	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		participation = null;
	}

	/**
	 * Test set data.
	 */
	public void testSetData() {
		for (int i = 0; i < participationsCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ participationsCases.get(i).toString() + ".",
					participationsExpected[i],
					participation.setData(participationsCases.get(i)));
		}
	}

	/**
	 * Test set optionals.
	 */
	public void testSetOptionals() {
		for (int i = 0; i < optionalsCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ optionalsCases.get(i).toString() + ".",
					optionalsExpected[i],
					participation.setOptionals(optionalsCases.get(i)));
		}
	}

}

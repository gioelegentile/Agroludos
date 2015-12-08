package test;

import java.util.ArrayList;

import entity.Guest;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class GuestTest.
 */
public class GuestTest extends TestCase {

	/** The guest cases. */
	ArrayList<ArrayList<String>> guestCases = new ArrayList<ArrayList<String>>();
	
	/** The guest values. */
	String[][] guestValues = {
			{ "", "pass_word", "email@email.it" },
			{ "username", "", "email@email.it" },
			{ "username", "pass_word", "" },
			{ "usr", "pass_word", "email@email.it" },
			{ "username", "pass word", "email@email.it" },
			{ "username", "pass_word", "email@email" },
			{ "username", "pass_word", "email#email.it" },
			{ "username", "pass_word", "email@email.it" }
	};
	
	/** The guests expected. */
	boolean[] guestsExpected = { false, false, false, false, false, false, false, true };
	
	/** The guest. */
	private Guest guest;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		guest = new Guest();
		
		ArrayList<String> temp = new ArrayList<String>();
		
		for (int i = 0; i < guestValues.length; i++) {

			for (int h = 0; h < guestValues[i].length; h++) {
				temp.add(guestValues[i][h]);
			}

			guestCases.add(temp);
			temp = new ArrayList<String>();
			
		}
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		guest = null;
	}

	/**
	 * Test set guest data.
	 */
	public void testSetGuestData() {
		for (int i = 0; i < guestCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ guestCases.get(i).toString() + ".",
					guestsExpected[i],
					guest.setGuestData(guestCases.get(i)));
		}
	}

}

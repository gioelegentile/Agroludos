package test;

import java.util.ArrayList;

import entity.User;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTest.
 */
public class UserTest extends TestCase {

	/** The user cases. */
	ArrayList<ArrayList<String>> userCases = new ArrayList<ArrayList<String>>();
	
	/** The user values. */
	String[][] userValues = {
			{ "", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "" },
			{ "usr", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo1", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi1", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "G", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "abc", "12345678901234567890", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "1234567890123456789a", "2015-01-01", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "abc", "Via Roma 12" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12$" },
			{ "username", "Paolo", "Rossi", "GNTGLI92L02E205K", "M", "1990-02-25", "12345678901234567890", "2015-01-01", "Via Roma 12" }
	};
	
	/** The users expected. */
	boolean[] usersExpected = { false, false, false, false, false, false, false, 
			false, false, false, false, false, false, false, false, false, false, false, true };
	
	/** The user. */
	private User user;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		
		ArrayList<String> temp = new ArrayList<String>();

		for (int i = 0; i < userValues.length; i++) {

			for (int h = 0; h < userValues[i].length; h++) {
				temp.add(userValues[i][h]);
			}
			
			userCases.add(temp);
			temp = new ArrayList<String>();

		}
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		user = null;
	}

	/**
	 * Test set data.
	 */
	public void testSetData() {
		for (int i = 0; i < userCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ userCases.get(i).toString() + ".",
					usersExpected[i],
					user.setData(userCases.get(i)));
		}
	}

}

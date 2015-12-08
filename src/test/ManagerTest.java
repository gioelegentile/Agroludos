package test;

import java.util.ArrayList;

import entity.Manager;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class ManagerTest.
 */
public class ManagerTest extends TestCase {
	
	/** The manager cases. */
	ArrayList<String> managerCases = new ArrayList<String>();
	
	/** The values. */
	String[] values = {
		"",
		"user name",
		"use",
		"username&$",
		"username"
	};
	
	/** The manager expected. */
	boolean[] managerExpected = { false, false, false, false, true };

	/** The manager. */
	private Manager manager;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		manager = new Manager();
		
		for (int i = 0; i < values.length; i++)
			managerCases.add(values[i]);
		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		manager = null;
	}

	/**
	 * Test set data.
	 */
	public void testSetData() {
		for (int i = 0; i < managerCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ managerCases.get(i).toString() + ".", managerExpected[i],
					manager.setData(managerCases.get(i)));
		}
	}

}

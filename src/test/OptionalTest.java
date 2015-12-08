package test;

import java.util.ArrayList;

import entity.Optional;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class OptionalTest.
 */
public class OptionalTest extends TestCase {

	/** The optionals cases. */
	ArrayList<ArrayList<String>> optionalsCases = new ArrayList<ArrayList<String>>();

	/** The optionals values. */
	String[][] optionalsValues = { { "abc123", "50.00" }, { "", "50.00" },
			{ "Pranzo", "" }, { "Pranzo", "abc123" }, { "abc123", "abc123" },
			{ "Merenda", "50,00" }, { "Pernotto", "50.00" } };

	/** The optionals expected. */
	boolean[] optionalsExpected = { false, false, false, false, false, false,
			true };

	/** The optional. */
	private Optional optional;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		optional = new Optional();
		ArrayList<String> case0 = new ArrayList<String>();

		for (int i = 0; i < optionalsValues.length; i++) {
			for (int j = 0; j < optionalsValues[i].length; j++)
				case0.add(optionalsValues[i][j]);
			optionalsCases.add(case0);
			case0 = new ArrayList<String>();
		}

	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		optional = null;
	}

	/**
	 * Test set optional data.
	 */
	public void testSetOptionalData() {
		for (int i = 0; i < optionalsCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ optionalsCases.get(i).toString() + ".",
					optionalsExpected[i],
					optional.setOptionalData(optionalsCases.get(i)));
		}
	}

}

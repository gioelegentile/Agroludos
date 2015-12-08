package test;

import java.util.ArrayList;

import entity.Type;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class TypeTest.
 */
public class TypeTest extends TestCase {

	/** The types cases. */
	ArrayList<String> typesCases = new ArrayList<String>();
	
	/** The types values. */
	String[] typesValues = {
		"",
		"asd123",
		"Tiro_con l'arco",
		"Tiro con l'arco"
	};
	
	/** The types expected. */
	boolean[] typesExpected = { false, false, false, true };

	/** The type. */
	private Type type;

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		type = new Type();
		
		for (int i = 0; i < typesExpected.length; i++)
			typesCases.add(typesValues[i]);

	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		type = null;
	}

	/**
	 * Test set type data.
	 */
	public void testSetTypeData() {
		for (int i = 0; i < typesCases.size(); i++) {
			assertEquals("Case: " + (i + 1) + ", Element: "
					+ typesCases.get(i).toString() + ".", typesExpected[i],
					type.setTypeData(typesCases.get(i)));
		}
	}

}

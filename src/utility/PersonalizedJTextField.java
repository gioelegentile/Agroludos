/*
 * 
 */
package utility;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonalizedJTextField.
 */
public class PersonalizedJTextField extends PlainDocument {

	/** The cache. */
	private StringBuffer cache = new StringBuffer();
	
	/** The max length. */
	int maxLength;

	/**
	 * Instantiates a new personalized j text field.
	 *
	 * @param maxLength the max length
	 */
	public PersonalizedJTextField(int maxLength) {
		this.maxLength = maxLength;
	}

	/* (non-Javadoc)
	 * @see javax.swing.text.PlainDocument#insertString(int, java.lang.String, javax.swing.text.AttributeSet)
	 */
	public void insertString(int off, String s, AttributeSet aset)
			throws BadLocationException {
		int len = getLength();
		if (len >= this.maxLength) {
			return;
		} // MAX CARATTERI

		cache.setLength(0);
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			cache.append(c);
			if (cache.length() >= maxLength - len) {
				break;
			}
		}
		if (cache.length() > 0) {
			super.insertString(off, cache.toString(), aset);
		}
	}
}
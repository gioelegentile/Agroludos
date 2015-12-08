/*
 * 
 */
package utility;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadXML.
 */
public class ReadXML {

	/** The doc. */
	private Document doc;

	/**
	 * Instantiates a new read xml.
	 *
	 * @param percorsoFile the percorso file
	 */
	public ReadXML(String percorsoFile) {
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(percorsoFile));
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Leggi parametri.
	 *
	 * @param key the key
	 * @return the array list
	 */
	public ArrayList<String> leggiParametri(String key) {

		ArrayList<String> elementi = new ArrayList<String>();
		try {
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("action");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (eElement.getAttribute("value").matches(key)) {
						elementi.add(getTagValue("class", eElement));
						elementi.add(getTagValue("method", eElement));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return elementi;
	}

	/**
	 * Gets the tag value.
	 *
	 * @param sTag the s tag
	 * @param eElement the e element
	 * @return the tag value
	 */
	private static String getTagValue(String sTag, Element eElement) { 
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
}

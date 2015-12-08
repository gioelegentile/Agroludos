/*
 * 
 */
package presentation;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.JFrame;

import utility.ReadXML;

// TODO: Auto-generated Javadoc
/**
 * The Class FrontController.
 */
public class FrontController {

	/** The xml. */
	private ReadXML xml;

	/**
	 * Process request.
	 *
	 * @param key the key
	 * @param p the p
	 * @param par the par
	 * @return the object
	 * @throws SecurityException the security exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 */
	public Object processRequest(String key, JFrame p, Object par)
			throws SecurityException, NoSuchMethodException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		
		xml = new ReadXML("presentation/AC.xml");
		ArrayList<String> parametri = xml.leggiParametri(key);
		String metodo;
		String classe;

		if (p != null)  {
			
			classe = parametri.get(0).toString();
			metodo = parametri.get(1).toString();
			Class<?> c = Class.forName(classe);
			Object o = c.newInstance();
			
			if (par != null) {
				
				Method m = c.getDeclaredMethod(metodo, p.getClass(),
						par.getClass());
				Class<?> tipoRitorno = m.getReturnType();
				m.setAccessible(true);

				try {
					
					if (tipoRitorno.toString().equals("boolean")) {
						
						boolean risultato;
						risultato = (boolean) m.invoke(o, p, par);
						return risultato;
						
					} else {
						
						Object risultato = null;
						if (tipoRitorno != Void.TYPE) {
							risultato = tipoRitorno.newInstance();
						}
						
						risultato = m.invoke(o, p, par);
						return risultato;
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else if (par == null) {
				
				Method m = c.getDeclaredMethod(metodo, p.getClass());
				Class<?> tipoRitorno = m.getReturnType();
				m.setAccessible(true);

				try {
					
					Object risultato;

					if (tipoRitorno != Void.TYPE) {
						risultato = tipoRitorno.newInstance();
					}
					
					risultato = m.invoke(o, p);
					return risultato;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

}

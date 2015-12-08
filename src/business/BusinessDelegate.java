/*
 * 
 */
package business;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.ReadXML;

// TODO: Auto-generated Javadoc
/**
 * The Class BusinessDelegate.
 */
public class BusinessDelegate {

	/** The xml. */
	private ReadXML xml;

	/**
	 * Execute.
	 *
	 * @param key the key
	 * @param p the p
	 * @return the object
	 * @throws SecurityException the security exception
	 * @throws NoSuchMethodException the no such method exception
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws SQLException the SQL exception
	 */
	public Object execute(String key, Object p) throws SecurityException,
			NoSuchMethodException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException {

		xml = new ReadXML("business/BD.xml");
		ArrayList<String> parametri = xml.leggiParametri(key);
		String metodo;
		String classe;

		classe = parametri.get(0).toString();
		metodo = parametri.get(1).toString();
		Class<?> c = Class.forName(classe);
		Object o = c.newInstance();
		
		if (p != null) {
			Method m = c.getDeclaredMethod(metodo, p.getClass());

			Class<?> tipoRitorno = m.getReturnType();
			m.setAccessible(true);

			try {
				if (tipoRitorno.toString().equals("boolean")) {
					boolean risultato;
					risultato = (boolean) m.invoke(o, p);
					return risultato;
				} else {
					Object risultato = null;
					if (tipoRitorno != Void.TYPE) {
						risultato = tipoRitorno.newInstance();
					}
					risultato = m.invoke(o, p);
					return risultato;
				}

			} catch (Exception e) {
				throw new SQLException(e);
			}

		}

		else {
			Method m = c.getDeclaredMethod(metodo, (Class[]) null);
			Class<?> tipoRitorno = m.getReturnType();
			m.setAccessible(true);

			try {
				Object risultato;
				if (tipoRitorno != Void.TYPE)
					risultato = tipoRitorno.newInstance();
				risultato = m.invoke(o);
				return risultato;
			} catch (Exception e) {
				throw new SQLException(e);
			}
		}
	}
	
}
